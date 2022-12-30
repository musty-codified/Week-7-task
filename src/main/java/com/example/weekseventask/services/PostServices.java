package com.example.weekseventask.services;

import com.example.weekseventask.models.Post;
import com.example.weekseventask.models.PostLikes;
import com.example.weekseventask.models.User;
import com.example.weekseventask.pojos.PostDTO;
import com.example.weekseventask.pojos.response.CommentResponseDTO;
import com.example.weekseventask.pojos.response.PostResponseDTO;
import com.example.weekseventask.repository.PostLikeRepository;
import com.example.weekseventask.repository.PostRepository;
import com.example.weekseventask.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.springframework.beans.BeanUtils.copyProperties;

@Service
@AllArgsConstructor
public class PostServices {

    private final PostRepository postRepository;
    private final PostLikeRepository postLikeRepository;
    private final UserRepository userRepository;

    public PostResponseDTO create(PostDTO postDTO) {

        User user = userRepository.findById(postDTO.getUser_id()).get();
        Post post = new Post();
        PostResponseDTO postResponse = new PostResponseDTO();
        copyProperties(postDTO,post);
        post.setUser(user);
        post = postRepository.save(post);
        copyProperties(post,postResponse);
        postResponse.setUser_id(user.getId());

        return postResponse;
    }

    public PostResponseDTO update(PostResponseDTO postResponseDTO) {

        Post post = new Post();
        PostResponseDTO postResponse = new PostResponseDTO();
        copyProperties(postResponseDTO,post);
        post = postRepository.save(post);
        copyProperties(post,postResponse);

        return postResponse;
    }

    public void delete(Long id) {
        postRepository.deleteById(id);
    }

    public void likeUnlikePost(Long postId, Long userId) {
        PostLikes postLikes = null;
        if ((postLikes = postLikeRepository.findPostLikesByPostIdAndUserId(postId,userId)) == null) {

            PostLikes plikes = new PostLikes();
            plikes.setUser(userRepository.findById(userId).get());
            plikes.setPost(postRepository.findById(postId).get());
            postLikeRepository.save(plikes);
        } else {
            postLikeRepository.deleteById(postLikes.getId());
        }
    }

    /**
     * Gets a post Data Transfer Object with all the comments and likes of the post for any user
     * @param userId
     * @return: list of posts(with comments and likes) made by the user
     */
    public List<PostResponseDTO> getAllPostsByUserId(Long userId) {
        List<PostResponseDTO> postByUser;

        Set<Post> posts = userRepository.findById(userId).get().getPosts();
        postByUser = posts.stream()
                .map(post -> {
                    PostResponseDTO postResponseDTO = new PostResponseDTO();
                    copyProperties(post,postResponseDTO);
                    //Give post a poster id
                    postResponseDTO.setUser_id(userId);
                    //Get all the comments of this post
                    postResponseDTO.setPostComments(getListOfPostComments(post));
                    //Get all the likes for this post
                    postResponseDTO.setPostLikes(getListOfPostLikers(post));
                    return postResponseDTO;
                })
                .collect(Collectors.toList());

        return postByUser;
    }

    public List<CommentResponseDTO> getListOfPostComments(Post post) {
        List<CommentResponseDTO> commentResponseDTOS;

        commentResponseDTOS = post.getPostComments().stream()
                .map(comment -> {
                    CommentResponseDTO commentResponseDTO = new CommentResponseDTO();
                    copyProperties(comment,commentResponseDTO);

                    //Add commenter id to commentResponseDto
                    commentResponseDTO.setCommenterId(comment.getUser().getId());
                    //Add the post id
                    commentResponseDTO.setPostId(comment.getPost().getId());

                    //Populate comment with its likes
                    commentResponseDTO.setCommentLikes(comment.getCommentLikes().stream()
                            .map(likes -> likes.getUser().getId())
                            .collect(Collectors.toList()));
                    return commentResponseDTO;
                })
                .collect(Collectors.toList());

        return commentResponseDTOS;
    }

    public List<Long> getListOfPostLikers(Post post) {
        return post.getPostLikes().stream()
                .map(likes -> likes.getUser().getId())
                .collect(Collectors.toList());
    }



    public static void main(String[] args) {
    }
}
