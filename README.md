# todo2
Lv1\
API명세서

| **기능**           | **설명**       | **HTTP Method** | **Endpoint**                                 | **body**                       |
|------------------|--------------|-----------------|----------------------------------------------|--------------------------------|
| **일정 생성**        | 일정 생성        | POST            | `/todos`                                     |                                |    
| **전체 일정 조회**     | 전체 일정 조회     | GET             | `/todos`                                     |                                |
| **일정 단건 조회**     | 일정 단건 조회     | GET             | `/todos/{id}`                                |                                |
| **일정 및 작성자명 수정** | 일정 및 작성자명 수정 | PATCH           | `/todos/{id}`                                |"title": "제목", "contents": "할일"  |
| **일정 삭제**        | 일정 삭제        | DELETE          | `/todos/{id}`                                |                                |


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
    <th></th>
    <th>username</th>
    <th>Field</th>
    <th>VARCHAR</th>
  </tr>
  <tr>
    <th></th>
    <th>todo</th>
    <th>Field</th>
    <th>VARCHAR</th>
  </tr>
<tr>
    <th></th>
    <th>creat_at</th>
    <th>Field</th>
    <th>DATETIME</th>
  </tr>
<tr>
    <th></th>
    <th>update_at</th>
    <th>Field</th>
    <th>DATETIME</th>
  </tr>
</table>