document.getElementById('createRoom').addEventListener('click', function(event) {
    event.preventDefault();
    console.log('방 만들기 버튼 클릭!')

    var food = document.getElementById('inputFood').value;
    var minPeople = document.getElementById('inputminPeople').value;
    var place = document.getElementById('inputPlace').value;
    var accountNum = document.getElementById('inputBank').value;
    var description = document.getElementById('inputDescription').value;

    var memberEmail = localStorage.getItem('emailId');

    // hour과 minute을 localtime으로 변경
    var currentDate = new Date();

    // 입력된 시간을 현재 날짜에 설정
    var hour = document.getElementById('inputHour').value;
    var minute = document.getElementById('inputMinute').value;
    currentDate.setHours(hour);
    currentDate.setMinutes(minute);

    // "yyyy-MM-ddTHH:mm:ss" 형식으로 변환
    var isoString = currentDate.toISOString().slice(0, 19).replace("T", " ");

    // Create the room object with members information
    var roomObject = {
        food: food,
        minPeople: minPeople,
        place: place,
        timeLimit: isoString,
        accountNum: accountNum,
        description: description,
        members: [{ emailId: memberEmail }]
    };
    console.log(roomObject);

    fetch('http://localhost:8080/rooms/createRoom', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(roomObject)
    })
    .then(response => response.json())
    .then(data => {
        if (data.error) {
            alert(data.error);
        } else {
            console.log('방 생성 완료!');

            console.log(JSON.stringify(roomObject));
            alert(data.message);
            window.location.href = '/home';
        }
    })
    .catch((error) => {
        console.error('Error:', error);
    });
});