// //Sends an Ajax request to the PostDeleteServlet API to delete a post
// for (const deletep of document.querySelectorAll('.post-delete')) {
//     deletep.addEventListener('click', (e) => {
//         console.log(e);
//         console.log(deletep.classList[1].split("-")[1])
//         let id = deletep.classList[1].split("-")[1];
//         let tableName = deletep.classList[1].split("__")[0]
//         console.log(tableName)
//         $.post( "DeleteServlet",
//             {
//                 postdeleteId: id,
//                 tableName: tableName
//             }, function () {
//                 console.log("Post deleted successfully");
//                 location.reload();
//             }
//
//         );
//     });
// }

// class DeletePost {
//     constructor() {
//         this.deleteSelector = document.querySelectorAll('.post-delete');
//         this.event();
//     }
//
//     event() {
//         for (const elementToDelete of this.deleteSelector) {
//             elementToDelete.addEventListener('click', () => this.deleteElement(elementToDelete));
//         }
//     }
//
//     deleteElement(elementToDelete) {
//         let id = elementToDelete.classList[1].split("-")[1];
//
//         $.post( "PostDeleteServlet",
//             {
//                 postdeleteId: id
//             }, function () {
//                 console.log("Delete was successful");
//                 location.reload();
//             }
//
//         );
//     }
// }
//
// export default DeletePost;