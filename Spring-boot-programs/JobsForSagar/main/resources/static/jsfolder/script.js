
function getCheckPassword() {
    const pass1 = document.getElementById('password').value;
    const pass2 = document.getElementById('confirm-password').value;
    const err= document.getElementById('err_confirmpassword');
    console.log("Password 1: " + pass1);
    console.log("Password 2: " + pass2);
//
//    if (!pass1 || !pass2) {
//        alert("Password fields cannot be empty!");
//        return false;
//    }

    if (pass1 === pass2) {
        console.log("Passwords match.");
        return true;
    } else {
        console.log("Passwords do not match.");
//        alert("Passwords do not match!");
           err.innerHTML="Passwords do not match.";
        return false;
    }
}

