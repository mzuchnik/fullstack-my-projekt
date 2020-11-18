let showAddBookFormButton = document.getElementById("add-book-button");
let addBookForm = document.getElementById("add-book-form");



showAddBookFormButton.onclick = function (){
    addBookForm.classList.toggle("hidden");
}