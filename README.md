# wanted-pre-onboarding-backend

<h1>박수연</h1>
<h2>애플리케이션의 실행 방법</h2>

<회원가입과 로그인을 제외한 api는 모두 헤더에 토큰을 넣어줘야 한다><br>
회원가입[Post] http://localhost:8080/api/v1/users/sign-up <br>
로그인 토큰 발급[Post] http://localhost:8080/api/v1/users/authenticate<br>
게시물 게시[Post] http://localhost:8080/api/v1/posts<br>
게시물 전체조회 [GET] http://localhost:8080/api/v1/posts<br>
아이디로 게시물 조회[GET] http://localhost:8080/api/v1/posts/{id}<br>
아이디로 게시물 수정[Post] http://localhost:8080/api/v1/posts/{id}<br>
아이디로 게시물 수정[DELETE] http://localhost:8080/api/v1/posts/{id}<br>

<h2>데이터베이스 테이블 구조</h2>

![image](https://github.com/PARK-Su-yeon/wanted-pre-onboarding-backend/assets/93627156/3a3cef15-51de-4e54-a03f-1a72aa8d23d3)

<h2>구현한 API의 동작을 촬영한 데모 영상 링크</h2>
https://www.youtube.com/watch?v=ilRRGCvnUrQ

<h2>구현 방법 및 이유에 대한 간략한 설명</h2>
springboot와 mysql를 사용해 프로젝트를 구성하였고 로그인단계에서 springsecurity가 사용되었고 jpa를 사용하여 구성했다.
로그인 토큰은 통해 받은 유저의 정보와 포스트아이디로 찾은 유저가 같은지 확인하는 작업을 거쳤다.

<h2>api명세</h2>
<h3>회원가입[Post] http://localhost:8080/api/v1/users/sign-up</h3>
<h3>request</h3>
{
    "email":"hsi@",
    "password":"hidddddddd"
  }
  
<h3>response</h3>

{
    "id": 3,
    "email": "hsi@"
}
##
<h3>로그인 토큰 발급[Post] http://localhost:8080/api/v1/users/authenticate</h3>

<h3>request</h3>
  {"email":"hi@",
    "password":"hidddddddd"}

<h3>response</h3>
 {  "jwtToken": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJoaUAiLCJpYXQiOjE2OTIxNzA2NDcsImV4cCI6MTY5MjE3MjQ0N30.K_l3U1femKuUlELekaM7T34CoOVDVHnjnX_x6gYRI0E"
}

<h3>게시물 게시[Post] http://localhost:8080/api/v1/posts</h3>

<h3>request</h3>


header[ key:Authorization  Value: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJoaUAiLCJpYXQiOjE2OTIxNzA2NDcsImV4cCI6MTY5MjE3MjQ0N30.K_l3U1femKuUlELekaM7T34CoOVDVHnjnX_x6gYRI0E]

body  
{

"title":"제목",
"content":"내용"

}

<h3>response</h3>


{
    "postId": 5,
    "title": "제목",
    "content": "내용",
    "user": {
        "id": 3,
        "email": "hsi@",
        "password": "$2a$10$cY4/6WvntqDgt03bb96bDeQI5ikcwgM6I3pXhdMhkgk6ybx5q/7qq"
    }
}


##
<h3>게시물 전체조회 [GET] http://localhost:8080/api/v1/</h3>
<h3>response</h3>

[{"title":"title1","content":"dfas2","postId":1},{"title":"title","content":"dfas","postId":2},{"title":"제목","content":"내용","postId":5}]

##
<h3>아이디로 게시물 조회[GET] http://localhost:8080/api/v1/posts/{id}</h3>
<h3>response</h3>

{
    "postId": 5,
    "title": "제목",
    "content": "내용",
    "user": {
        "id": 3,
        "email": "hsi@",
        "password": "$2a$10$cY4/6WvntqDgt03bb96bDeQI5ikcwgM6I3pXhdMhkgk6ybx5q/7qq"
    }
}
##
<h3>아이디로 게시물 수정[Post] http://localhost:8080/api/v1/posts/{id}</h3>
<h3>request</h3>

{

"title":"제목수정",
"content":"내용"

}

<h3>response</h3>

{
    "postId": 5,
    "title": "제목수정",
    "content": "내용",
    "user": {
        "id": 3,
        "email": "hsi@",
        "password": "$2a$10$cY4/6WvntqDgt03bb96bDeQI5ikcwgM6I3pXhdMhkgk6ybx5q/7qq"
    }
}

##
<h3>아이디로 게시물 삭제[DELETE] http://localhost:8080/api/v1/posts/{id}</h3>

<h3>response</h3>

삭제  성공했습니다
