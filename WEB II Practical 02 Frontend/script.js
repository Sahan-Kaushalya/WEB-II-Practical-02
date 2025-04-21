function signUp() {

    var f = new FormData();
    f.append("fname", document.getElementById("fname").value);
    f.append("lname", document.getElementById("lname").value);
    f.append("mobile", document.getElementById("mobile").value);
    f.append("email", document.getElementById("email").value);
    f.append("password", document.getElementById("password").value);
    f.append("gender", document.querySelector('input[name="gender"]:checked').value);
    f.append("city", document.querySelector('select[name="city"]').value);

    var ajax = new XMLHttpRequest();
    ajax.onreadystatechange = function () {
        if (ajax.readyState == 4 && ajax.status == 200) {
            
            if (ajax.responseText == "success") {
                alert(ajax.responseText);
                window.location.href = "signin.html";
            } else {
                alert(ajax.responseText);              
            }
        }
    };

    ajax.open("POST", "http://localhost:8080/WEB_II_Practical_02_Backend/SignUp", true);
    ajax.send(f);
}

function signIn() {
    var f = new FormData();
    f.append("email", document.getElementById("email").value);
    f.append("password", document.getElementById("password").value);

    var ajax = new XMLHttpRequest();
    ajax.onreadystatechange = function () {
        if (ajax.readyState == 4 && ajax.status == 200) {

            if (ajax.responseText == "success") {
                alert(ajax.responseText);
                window.location.href = "home.html";
            } else {
                alert(ajax.responseText);
            }
        }
    };

    ajax.open("POST", "http://localhost:8080/WEB_II_Practical_02_Backend/SignIn", true);
    ajax.send(f);
}