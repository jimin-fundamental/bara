//이메일 입력하기(이미 있는 이메일이면 경고창) -> 인증요청 버튼 누르기 -> 인증번호 입력하면 맞는지 체크
// -> 인증확인 버튼 누르면 넘어가기
document.getElementById('signupForm').addEventListener('submit', function(event) {
    event.preventDefault();

    var emailId = document.getElementById('inputEmail').value;
    var password = document.getElementById('inputPw').value;

    let user = {
        name: name,
        password: password
    };

    fetch('http://localhost:8080/users/signup', {
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
                window.location.href = '/signup2';
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
