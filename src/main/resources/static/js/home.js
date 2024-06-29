document.addEventListener("DOMContentLoaded", function() {
    const dropdownButton = document.querySelectorAll(".menuBUTTON");

    dropdownButton.forEach(button => {
        button.addEventListener("click", function(event) {
            event.preventDefault(); // Prevent default action if the button is a link
            const dropdownMenu = button.parentElement.nextElementSibling;
            dropdownMenu.classList.toggle("dropdownButton-clicked");
        });
    });
});
