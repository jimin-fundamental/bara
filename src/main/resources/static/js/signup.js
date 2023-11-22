    //이메일 입력하기(이미 있는 이메일이면 경고창) -> 인증요청 버튼 누르기 -> 인증번호 입력하면 맞는지 체크
    // -> 인증확인 버튼 누르면 넘어가기
    document.getElementById('emailVerify').addEventListener('click', function(event) {
        event.preventDefault();
        var email = document.getElementById('inputEmail').value;

        // 이메일 형식 검증
        if (!validateEmail(email)) {
            alert('유효하지 않은 이메일 형식입니다.');
            return;
        }

        // 이메일 중복 확인 및 인증 코드 요청
        fetch('http://localhost:8080/members/emails/verification-requests', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ email: email })
        })
            .then(response => {
                if (response.ok) {
                    alert('인증 코드가 이메일로 발송되었습니다. 확인해주세요.');
                    // signupPopup(); // 인증번호 입력 팝업 띄우기
                } else {
                    response.json().then(data => alert(data.error));
                }
            })
            .catch((error) => {
                console.error('Error:', error);
            });
    });

    document.getElementById('verifyCheck').addEventListener('click', function(event) {
        event.preventDefault(); // 기본 이벤트 방지
        var email = document.getElementById('inputEmail').value;
        var authCode = document.getElementById('inputAuthCode').value;

        fetch('http://localhost:8080/members/emails/verifications', {
            method: 'POST', // 요청 방식을 POST로 변경
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ email: email, authCode: authCode }) // 요청 본문에 이메일과 인증 코드 포함
        })
            .then(response => response.json())
            .then(data => {
                if (data.message === 'Email verification successful') {
                    console.log('Verification successful');
                    window.location.href = '/signup2'; // 인증 성공 시 다음 페이지로 이동
                } else {
                    alert(data.error);
                }
            })
            .catch((error) => {
                console.error('Error:', error);
            });
    });


    // 이메일 형식 검증 함수
    function validateEmail(email) {
        var pattern = /^[A-Za-z0-9._%+-]+@ewhain\.net$/;
        return pattern.test(email);
    }

    // 팝업 관련 함수
    // window.onload = function signupPopup() {
    //     var popup = document.getElementById("signup__bg");
    //     popup.classList.add("show");
    // }
    //
    // window.onload = function signupPopdown() {
    //     var popup = document.getElementById("signup__bg");
    //     popup.classList.remove("show");
    // }

