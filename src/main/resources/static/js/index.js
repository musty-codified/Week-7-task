
//Sends an Ajax request to LikedUnlikeServlet API to either like or unlike a post
for (const likes of document.querySelectorAll('.like-click')) {
    likes.addEventListener('click', (e) => {
        console.log(e);
        console.log(likes.classList[1].split("-")[1])
        let userId = document.getElementById("userLikedId").value;
        let postId = likes.classList[1].split("-")[1];
        let tableName = likes.classList[1].split("-")[0];
        console.log(userId)
        console.log(postId)
        console.log(tableName)
        $.post( "LikeUnlikeServlet",
            {
                userLikedId: userId,
                postLikedId: postId,
                tableName: tableName
            }, function () {
                console.log("Yeah!");
                location.reload();
            }

        );
    });
}

//Sends an Ajax request to the PostDeleteServlet API to delete a post
for (const deletep of document.querySelectorAll('.post-delete')) {
    deletep.addEventListener('click', (e) => {
        console.log(e);
        console.log(deletep.classList[1].split("-")[1])
        let id = deletep.classList[1].split("-")[1];
        let tableName = deletep.classList[1].split("__")[0]
        console.log(tableName)
        $.post( "DeleteServlet",
            {
                postdeleteId: id,
                tableName: tableName
            }, function () {
                console.log("Post deleted successfully");
                location.reload();
            }

        );
    });
}

//Open the Edit post section
for (const openEdit of document.querySelectorAll(".post-edit")) {

    openEdit.addEventListener('click', (e) => {
        console.log(openEdit.classList[2])
        document.getElementById(openEdit.classList[2]).style.display = "block";

        console.log("Post Edit fired!")
    })
}

for (const closeEdit of document.querySelectorAll(".update-post-btn")) {
    closeEdit.addEventListener('click', () => {
        document.getElementById(openEdit.classList[2]).style.display = "none";
        // closeEdit.classList.remove("edit_post_open");
        console.log("Post Edit closed")
    })
}

