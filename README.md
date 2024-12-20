# todo2
API명세서

| **기능**           | **설명**       | **HTTP Method** | **Endpoint**                     | **body**                                                              |
|------------------|--------------|-----------------|----------------------------------|-----------------------------------------------------------------------|
| **일정 생성**        | 일정 생성        | POST            | `/todos`                         |                                                                       |    
| **전체 일정 조회**     | 전체 일정 조회     | GET             | `/todos`                         |                                                                       |
| **일정 단건 조회**     | 일정 단건 조회     | GET             | `/todos/{id}`                    |                                                                       |
| **일정 및 작성자명 수정** | 제목 및 일정 수정   | PATCH           | `/todos/{id}`                    | "title": "제목", "contents": "할일"                                       |
| **일정 삭제**        | 일정 삭제        | DELETE          | `/todos/{id}`                    |                                                                       |
| **회원가입**         | 회원가입         | POST            | `/users`                         |                                                                       |    
| **로그인**          | 로그인          | POST            | `/users/login`                   | "email": "xxx@xxx.com", "password": "1111"                            |    
| **로그아웃**         | 로그아웃         | POST            | `/users/logout`                  |                                                                       |    
| **유저 일정 조회**     | 유저 일정 조회     | GET             | `/users`                         |                                                                       |
| **유저 단건 조회**     | 유저 단건 조회     | GET             | `/users/{id}`                    |                                                                       |
| **유저 및 작성자명 수정** | 유저 및 이메일 수정  | PATCH           | `/users/{id}`                    | "username": "test", "email": "xxx@xxx.com"                            |
| **유저 비밀번호 수정**   | 비밀번호 수정      | PATCH           | `/users/password/{id}`           | "oldPassword": "1234", "newPassword": "1111"                          |
| **유저 삭제**        | 유저 삭제        | DELETE          | `/users/{id}`                    |                                                                       |
| **댓글 생성**        | 일정 댓글 생성     | POST            | `/comments`                      | "comment": "댓글 작성", "todoId": {댓글 달릴 일정 id}, "userId": {댓글 작성할 유저 id} |
| **댓글 조회**        | 일정별 댓글 조회    | GET             | `/comments/todos/{id}`           |                                                                       |
| **댓글 수정**        | 댓글 수정        | PATCH           | `/comment/{id}`                  |                                                                       |
| **댓글 삭제**        | 댓글 삭제        | DELETE          | `/comment/{id}`                  |                                                                       |
| **일정 페이징 조회**    | 일정 전체 페이징 조회 | GET             | `/todos/gettodos?page=0&size=10` | page = {페이지 위치할 숫자}, size={일정 표시 갯수}                                  |


ERD

<table>
  <tr>
    <th colspan="4">todo</th></th>
  </tr>
  <tr>
    <th>🔑</th>
    <th>id</th>
    <th>Key</th>
    <th>BIGINT</th>
  </tr>
  <tr>
    <th>🔒(FK)</th>
    <th>user_id</th>
    <th>Field</th>
    <th>BIGINT</th>
  </tr>
  <tr>
    <th></th>
    <th>title</th>
    <th>Field</th>
    <th>VARCHAR(50)</th>
  </tr>
<tr>
    <th></th>
    <th>contents</th>
    <th>Field</th>
    <th>VARCHAR(100)</th>
  </tr>
<tr>
    <th></th>
    <th>created_at</th>
    <th>Field</th>
    <th>DATETIME</th>
  </tr>
<tr>
    <th></th>
    <th>updated_at</th>
    <th>Field</th>
    <th>DATETIME</th>
  </tr>
</table>

<table>
  <tr>
    <th colspan="4">user</th></th>
  </tr>
  <tr>
    <th>🔑</th>
    <th>id</th>
    <th>Key</th>
    <th>BIGINT</th>
  </tr>
  <tr>
    <th></th>
    <th>username</th>
    <th>Field</th>
    <th>VARCHAR(30)</th>
  </tr>
<tr>
    <th></th>
    <th>password</th>
    <th>Field</th>
    <th>VARCHAR(200)</th>
  </tr>
  <tr>
    <th></th>
    <th>email</th>
    <th>Field</th>
    <th>VARCHAR(50)</th>
  </tr>
<tr>
    <th></th>
    <th>created_at</th>
    <th>Field</th>
    <th>DATETIME</th>
  </tr>
<tr>
    <th></th>
    <th>updated_at</th>
    <th>Field</th>
    <th>DATETIME</th>
  </tr>
</table>

<table>
  <tr>
    <th colspan="4">comment</th></th>
  </tr>
  <tr>
    <th>🔑</th>
    <th>id</th>
    <th>Key</th>
    <th>BIGINT</th>
  </tr>
  <tr>
    <th>🔒(FK)</th>
    <th>user_id</th>
    <th>Field</th>
    <th>BIGINT</th>
  </tr>
<tr>
    <th>🔒(FK)</th>
    <th>todo_id</th>
    <th>Field</th>
    <th>BIGINT</th>
  </tr>
  <tr>
    <th></th>
    <th>comment</th>
    <th>Field</th>
    <th>VARCHAR(40)</th>
  </tr>
<tr>
    <th></th>
    <th>created_at</th>
    <th>Field</th>
    <th>DATETIME</th>
  </tr>
<tr>
    <th></th>
    <th>updated_at</th>
    <th>Field</th>
    <th>DATETIME</th>
  </tr>
</table>
