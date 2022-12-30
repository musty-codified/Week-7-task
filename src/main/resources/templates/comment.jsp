

    <div class="container mt-5 mb-5" id="cmt-1">
        <div class="d-flex justify-content-center row">
            <div class="d-flex flex-column col-md-8">
                <div class="d-flex flex-row align-items-center text-left comment-top p-2 bg-white border-bottom px-4"></div>
                <div class="comment-bottom bg-white p-2 px-4">
                    <form action="CommentServlet" method="post">
                        <div class="d-flex flex-row add-comment-section mt-4 mb-4">
                            <img class="img-fluid img-responsive rounded-circle mr-2" src="https://i.imgur.com/qdiP4DB.jpg" width="38">
                            <input type="text" name="comment" class="form-control mr-3" placeholder="Add comment">
                            <input type="hidden" name="postID" class="form-control mr-3" value="<%=post.getId()%>" placeholder="Add comment">
                            <input type="hidden" name="commenterID" class="form-control mr-3" value="<%=session.getAttribute("userID")%>" placeholder="Add comment">
                            <button class="btn btn-primary" type="submit">Comment</button>
                        </div>
                    </form>
                    <% for (PostComment comment : post.getPostComments()) {
                        int commentLikes = GetLikes.getAllUsersThatLikedAComment(comment.getCommentId()).size();
                    %>
                    <div class="commented-section mt-2 border-bottom" style="padding-top: 20px;">
                        <div class="d-flex flex-row align-items-center commented-user">
                            <h5 class="mr-2"><%=comment.getCommenterName()%></h5><span class="dot mb-1"></span>
                            <span class="mb-1 ml-2"><%=comment.getTimeStamp()%></span>
                        </div>
                        <div class="comment-text-sm">
                            <span><%=comment.getCommentContent()%></span>
                        </div>


                        <div class="reply-section" id="comment-custom">
                            <div class="d-flex flex-row align-items-center voting-icons" style="justify-content: space-evenly; padding: 10px 0; color: gray;">
                                <span class="like-click commentLikes-<%=comment.getCommentId()%> post__option" style="display: flex">
                                    <span class="material-icons" <%=session.getAttribute("userID")%>> thumb_up </span>
                                    <span class="ml-2" <%=comment.getCommenterId()%>><%=commentLikes%></span>
                                </span>
                                <%--                        Ensure that only owners of comments can edit and delete--%>
                                <% if (Integer.valueOf(comment.getCommenterId()).equals(session.getAttribute("userID"))) { %>
<%--                                <span class="material-icons post-edit post__option"> edit </span>--%>
                                <div class="post-delete comments__options-<%=comment.getCommentId()%> post__option">
                                    <span class="material-icons"> delete </span>
                                </div>
                                <% } %>
                            </div>
                        </div>

<%--                        <div class="edit_post" id="edit_comment-<%=comment.getCommentId()%>">--%>
<%--                            <%@include file="edit_comment.jsp"%>--%>
<%--                        </div>--%>
                    </div>
                    <% } %>



<%--                    <div class="commented-section mt-2">--%>
<%--                        <div class="d-flex flex-row align-items-center commented-user">--%>
<%--                            <h5 class="mr-2">Samoya Johns</h5><span class="dot mb-1"></span><span class="mb-1 ml-2">5 hours ago</span></div>--%>
<%--                        <div class="comment-text-sm"><span>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua..</span></div>--%>
<%--                        <div class="reply-section">--%>
<%--                            <div class="d-flex flex-row align-items-center voting-icons"><i class="fa fa-sort-up fa-2x mt-3 hit-voting"></i><i class="fa fa-sort-down fa-2x mb-3 hit-voting"></i><span class="ml-2">15</span><span class="dot ml-2"></span>--%>
<%--                                <h6 class="ml-2 mt-1">Reply</h6>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <div class="commented-section mt-2">--%>
<%--                        <div class="d-flex flex-row align-items-center commented-user">--%>
<%--                            <h5 class="mr-2">Makhaya andrew</h5><span class="dot mb-1"></span><span class="mb-1 ml-2">10 hours ago</span></div>--%>
<%--                        <div class="comment-text-sm"><span>Nunc sed id semper risus in hendrerit gravida rutrum. Non odio euismod lacinia at quis risus sed. Commodo ullamcorper a lacus vestibulum sed arcu non odio euismod. Enim facilisis gravida neque convallis a. In mollis nunc sed id. Adipiscing elit pellentesque habitant morbi tristique senectus et netus. Ultrices mi tempus imperdiet nulla malesuada pellentesque.</span></div>--%>
<%--                        <div--%>
<%--                                class="reply-section">--%>
<%--                            <div class="d-flex flex-row align-items-center voting-icons"><i class="fa fa-sort-up fa-2x mt-3 hit-voting"></i><i class="fa fa-sort-down fa-2x mb-3 hit-voting"></i><span class="ml-2">25</span><span class="dot ml-2"></span>--%>
<%--                                <h6 class="ml-2 mt-1">Reply</h6>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
                </div>
            </div>
        </div>
    </div>


