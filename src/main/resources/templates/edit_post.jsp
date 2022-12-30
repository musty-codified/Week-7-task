<div class="messageSender">
  <div class="">
    <form class="messageSender__top" method="post" action="EditPostServlet">
      <textarea class="messageSender__input" name="post_content" id="" cols="30" rows="10" required><%= post.getPostContent() %></textarea>
      <input type="hidden" name="edit_post_id" value="<%=post.getId()%>">
      <div class="messageSender__bottom">
        <div class="btn">
          <input type="submit" class="btn--blue update-post-btn submit" value="Update post">
        </div>
      </div>
    </form>
  </div>
</div>
