<%--
  Created by IntelliJ IDEA.
  User: decagon
  Date: 01/11/2022
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<div class="messageSender">
  <div class="">
    <form class="messageSender__top" method="post" action="PostServlet">
      <textarea class="messageSender__input" name="messageSender__input" id="" cols="30" rows="10" placeholder="What's on your mind?" required></textarea>
      <div class="messageSender__bottom">
        <div class="btn">
          <input type="submit" class="btn--blue submit" name="submit" value="Create post">
        </div>
      </div>
    </form>
  </div>
</div>
