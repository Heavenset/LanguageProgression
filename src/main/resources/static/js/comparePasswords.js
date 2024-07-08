function checkPasswordEquality() {
    var password = document.getElementById("password").value;
    var repeatedPassword = document.getElementById("repeatPassword").value;
    var message = document.getElementById("message");

    if (password === repeatedPassword) {
        message.style.color = "green";
        console.log("yes")
    } else {
        message.style.color = "red";
        console.log("no")
    }
}