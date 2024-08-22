# 📱 BARA - 이화여자대학교 캠퍼스 내 음식 주문 웹 애플리케이션

### 이화여대 중앙 실전 창업 학회 UNIS에서 팀 "이글이글"에 의해 제작된 프로젝트입니다.

---

## 프로젝트 소개

**BARA**는 이화여자대학교 캠퍼스 내에서 음식을 함께 주문할 수 있도록 도와주는 웹 애플리케이션입니다. BARA를 통해 사용자는 간편하게 음식을 주문하고, 함께 주문할 멤버를 모집하며, 멤버들과 소통할 수 있습니다. 이 프로젝트는 현재 진행 중이며, 지속적인 업데이트가 예정되어 있습니다.

---

### 주요 기능

- **회원가입 및 로그인**: 사용자 인증 및 보안 강화를 위해 학교 이메일을 통해 회원가입 및 로그인을 진행합니다.
- **음식 주문 참여**: 대기 중인 음식 주문을 확인하고, 함께 주문할 멤버를 모집할 수 있습니다.
- **검색 기능**: 특정 음식이나 장소를 검색하여 빠르게 접근할 수 있습니다.
- **포스트 업로드**: 다른 멤버들과 함께 음식을 주문할 수 있도록 포스트를 작성하고 업로드할 수 있습니다.
- **채팅 기능**: 주문을 함께하는 멤버들 간에 실시간으로 채팅할 수 있습니다.

---

### 프로젝트 상태

프로젝트는 현재 **진행 중**이며, 기능이 계속 추가되고 있습니다. 자세한 내용은 아래의 IR 피칭 문서를 통해 확인할 수 있습니다.

[바라 IR 피칭 자료.pdf](https://github.com/user-attachments/files/16322955/ir.2.pptx)

---

### User Flow

![User Flow](data:"C:\Users\mingk\OneDrive\바탕 화면\1.png")
![User Flow](data:"C:\Users\mingk\OneDrive\바탕 화면\2.png")
![Business Model](data:"C:\Users\mingk\OneDrive\바탕 화면\3.png")
![Market Size](data:"C:\Users\mingk\OneDrive\바탕 화면\4.png")

---

### 🛠️ 기술 스택

- **프론트엔드**: HTML, CSS (Figma 디자인 변환)
- **백엔드**: Java, Spring Boot
- **데이터베이스**: MySQL
- **기타 도구**: IntelliJ IDEA, Gradle, Lombok

---

### 💻 프로젝트 빌드

1. **환경 설정**: IntelliJ IDEA에서 Gradle을 사용해 프로젝트를 빌드합니다.
2. **프론트엔드 개발**: Figma 디자인을 바탕으로 HTML 및 CSS로 구현되었습니다. Locofy를 사용해 디자인을 변환했습니다.
3. **데이터베이스 연결**: MySQL 데이터베이스에 "bara"라는 이름의 스키마를 생성하고 연결합니다.

---

### 🗂️ 프로젝트 구조

```bash
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── com
│   │   │   │   └── bara
│   │   │   │       ├── controller
│   │   │   │       ├── domain
│   │   │   │       ├── repository
│   │   │   │       └── service
│   │   └── resources
│   │       ├── static
│   │       └── templates
└── build.gradle
```

---

### 📝 기여 방법

현재 이 프로젝트는 개인 학습 및 개발을 위한 프로젝트로, 외부 기여는 받지 않습니다. 하지만 프로젝트에 대한 피드백은 언제든지 환영합니다!

---

### 📋 라이선스

이 프로젝트는 [MIT 라이선스](LICENSE) 하에 배포됩니다.

---

## 📱 BARA - A Web Application for Ordering Food on Campus at Ewha Womans University

### This project was created by team "Igloo" from the 23-2 UNIS practical entrepreneurship club at Ewha Womans University.

---

### Project Introduction

**BARA** is a web application designed to facilitate food orders on the Ewha Womans University campus. Users can easily place food orders, recruit members to join their orders, and communicate with other members through the platform. The project is still in progress, with continuous updates planned.

---

### Key Features

- **Sign Up & Login**: User authentication and security are enhanced through school email verification.
- **Food Order Participation**: View pending food orders and recruit members to join.
- **Search Function**: Quickly find specific foods or places.
- **Post Uploading**: Create and upload posts to recruit members for food orders.
- **Chat Functionality**: Real-time chat between members involved in the same order.

---

### Project Status

The project is currently **in progress**, with ongoing feature additions. For more details, refer to the IR pitching document below.

[바라 IR 피칭 자료.pdf](https://github.com/user-attachments/files/16322955/ir.2.pptx)

---

### User Flow

![User Flow](data:"C:\Users\mingk\OneDrive\바탕 화면\1.png")
![User Flow](data:"C:\Users\mingk\OneDrive\바탕 화면\2.png")
![Business Model](data:"C:\Users\mingk\OneDrive\바탕 화면\3.png")
![Market Size](data:"C:\Users\mingk\OneDrive\바탕 화면\4.png")


---

### 🛠️ Tech Stack

- **Frontend**: HTML, CSS (converted from Figma design)
- **Backend**: Java, Spring Boot
- **Database**: MySQL
- **Tools**: IntelliJ IDEA, Gradle, Lombok

---

### 💻 Project Build

1. **Environment Setup**: Build the project using Gradle in IntelliJ IDEA.
2. **Frontend Development**: The frontend was implemented using HTML and CSS based on Figma designs, with conversion done using Locofy.
3. **Database Connection**: Connect to a MySQL database with a schema named "bara."

---

### 🗂️ Project Structure

```bash
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── com
│   │   │   │   └── bara
│   │   │   │       ├── controller
│   │   │   │       ├── domain
│   │   │   │       ├── repository
│   │   │   │       └── service
│   │   └── resources
│   │       ├── static
│   │       └── templates
└── build.gradle
```

---

### 📝 Contribution Guidelines

Currently, this project is for personal learning and development, so external contributions are not accepted. However, feedback on the project is always welcome!

---

### 📋 License

This project is licensed under the [MIT License](LICENSE).

---

이 README 파일은 프로젝트의 공식성과 시각적 요소를 강조하여 구성되었습니다. 추가된 이미지와 함께 이 프로젝트의 목적과 기능을 더욱 명확하게 전달할 수 있습니다.
