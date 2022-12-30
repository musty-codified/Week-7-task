// //Open the Edit post section
// for (const openEdit of document.querySelectorAll(".post-edit")) {
//
//     openEdit.addEventListener('click', (e) => {
//         console.log(openEdit.classList[2])
//         document.getElementById(openEdit.classList[2]).style.display = "block";
//
//         console.log("Post Edit fired!")
//     })
// }
//
// for (const closeEdit of document.querySelectorAll(".update-post-btn")) {
//     closeEdit.addEventListener('click', () => {
//         document.getElementById(openEdit.classList[2]).style.display = "none";
//         // closeEdit.classList.remove("edit_post_open");
//         console.log("Post Edit closed")
//     })
// }

// class Edit {
//     constructor() {
//         this.open = document.querySelectorAll(".post-edit");
//         this.close = document.querySelectorAll(".update-post-btn");
//         this.event();
//     }
//
//     event() {
//         for (const formToOpen of this.open) {
//             formToOpen.addEventListener('click', () => this.openForm(formToOpen));
//         }
//
//         for (const formToClose of this.close) {
//             formToClose.addEventListener('click', () => this.closeForm(formToClose));
//         }
//     }
//
//     openForm(formToOpen) {
//
//         document.getElementById(formToOpen.classList[2]).style.display = "block";
//         console.log("Post Edit fired!")
//     }
//
//     closeForm(formToClose) {
//         document.getElementById(formToClose.classList[2]).style.display = "none";
//         console.log("Post Edit closed")
//     }
// }
//
// export default Edit;