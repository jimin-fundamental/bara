//닉네임 중복확인 -> 비밀번호 입력
document.getElementById('signupForm').addEventListener('submit', function(event) {
    event.preventDefault();

    var nickname = document.getElementById('nickname').value;
    var password = document.getElementById('inputPw').value;
    var passwordCheck = document.getElementById('inputPwCheck').value;

    // 비밀번호와 비밀번호 확인이 일치하는지 검사
    if (password !== passwordCheck) {
        alert('비밀번호가 일치하지 않습니다.');
        return;
    }

    let user = {
        name: nickname,
        password: password
    };

    fetch('http://localhost:8080/api/users/signup', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(user)
    })
        .then(response => response.json())
        .then(data => {
            if (data.error) {
                alert(data.error);
            } else {
                console.log('Signup successful');
                console.log(JSON.stringify(user));
                alert(data.message);
                window.location.href = '/login';
            }
        })
        .catch((error) => {
            console.error('Error:', error);
        });
});

function signupPopup() {
    var popup = document.getElementById("signup__bg");
    popup.classList.add("show");
}

function signupPopdown() {
    var popup = document.getElementById("signup__bg");
    popup.classList.remove("show");
}
