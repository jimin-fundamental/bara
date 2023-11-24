document.getElementById('loginbtn').addEventListener('click', function(event) {
    event.preventDefault();
    console.log('login 버튼이 클릭됨!')

    var emailId = document.getElementById('inputEmail').value;
    var password = document.getElementById('inputPw').value;


    fetch('http://localhost:8080/members/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({emailId: emailId, password: password})
    })
        .then(response => response.json())
        .then(data => {
            if (data.error) {
                alert(data.error);
            } else {
                console.log('Login Completed');
                // Save user id to local storage
                localStorage.setItem('emailId', emailId);

                console.log(JSON.stringify({emailId: emailId, password: password}));
                alert(data.message);
                window.location.href = '/home';
            }
        })
        .catch((error) => {
            console.error('Error:', error);
        });
});

// function loginPopup() {
//     var popup = document.getElementById("login__bg");
//     popup.classList.add("show");
// }
//
// function loginPopdown() {
//     var popup = document.getElementById("login__bg");
//     popup.classList.remove("show");
// }