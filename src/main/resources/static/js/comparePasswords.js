document.addEventListener("DOMContentLoaded", function() {
    const password = document.getElementById("password");
    const repeatedPasswordINPUT = document.getElementById("repeatedPasswordINPUT");
    const registerButton = document.getElementById("registerButton");

    registerButton.addEventListener("click", function(event) {
        if (password.value !== repeatedPasswordINPUT.value) {
            event.preventDefault(); // Prevent form submission
            
            alert("Passwords must match!");
        }
    });
});