// //Sends an Ajax request to LikedUnlikeServlet API to either like or unlike a post
// for (const likes of document.querySelectorAll('.like-click')) {
//     likes.addEventListener('click', (e) => {
//         console.log(e);
//         console.log(likes.classList[1].split("-")[1])
//         let userId = document.getElementById("userLikedId").value;
//         let postId = likes.classList[1].split("-")[1];
//         let tableName = likes.classList[1].split("-")[0];
//         console.log(userId)
//         console.log(postId)
//         console.log(tableName)
//         $.post( "LikeUnlikeServlet",
//             {
//                 userLikedId: userId,
//                 postLikedId: postId,
//                 tableName: tableName
//             }, function () {
//                 console.log("Yeah!");
//                 location.reload();
//             }
//
//         );
//     });
// }

// class LikeUnlike {
//     constructor() {
//         this.allLikeables = document.querySelectorAll('.like-click');
//         this.event();
//     }
//
//     event() {
//         for (const elementToLikeOrUnlike of this.allLikeables) {
//             elementToLikeOrUnlike.addEventListener('click', () => this.likeOrUnlike(elementToLikeOrUnlike));
//         }
//     }
//
//     likeOrUnlike(elementToLikeOrUnlike) {
//         let userId = document.getElementById("userLikedId").value;
//         let postId = elementToLikeOrUnlike.classList[1].split("-")[1];
//         let tableName = elementToLikeOrUnlike.classList[1].split("-")[0];
//
//         $.post( "LikeUnlikeServlet",
//             {
//                 userLikedId: userId,
//                 postLikedId: postId,
//                 tableName: tableName
//             }, function () {
//                 console.log("Yeah!");
//                 location.reload();
//             }
//
//         );
//     }
// }
//
// export default LikeUnlike;