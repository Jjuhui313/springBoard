# Spring 게시판 구현 과제
(과제 설명)

JPA를 사용하여 게시판을 구현합니다.

게시판에는 게시글과 댓글이 있습니다.

●	게시글: 제목과 본문이 있으며, 제목과 본문 모두 Text 만 지원합니다.

●	댓글: 게시글에 댓글을 달 수 있으며, 대댓글은 고려하지 않습니다.


## 필수 요구사항
- [X] 1. 게시글 등록
  - 단 건의 게시글을 등록 할 수 있어야 합니다.

- [X] 2. 게시글 삭제
  - 단 건의 게시글을 삭제 할 수 있어야 합니다.
  - 게시글의 삭제 방법은 soft delete 로 진행합니다.
  - 게시글 삭제시 댓글도 삭제가 되어야 합니다.

- [X] 3. 게시글 수정
  - 단 건의 게시글을 수정 할 수 있어야 합니다.
  - 삭제된 게시글은 수정 할 수 없습니다.

- [X] 4. 게시글 목록 조회
  - 등록된 게시글의 목록을 조회합니다.
  - 응답에는 본문이 포함되지 않습니다.
  - 페이징이 가능해야 합니다.
  - 페이징의 방식은 offset 기반 페이징과 cursor 기반 페이징이 존재하는데 각 구현방식의 차이점을 학습하고, 비교, 선택하여 구현합니다.
  - 정렬 순서는, 최신 글이 우선순위가 가장 높습니다.

- [X] 5. 댓글 등록
  - 게시글에 댓글을 등록합니다.

- [X] 6. 댓글 수정
  - 게시글에 댓글을 수정합니다.

- [X] 7. 댓글 삭제
  - 게시글에 댓글을 삭제 합니다.
  - 삭제는 soft delete 로 진행합니다.

- [X] 8. 게시글 단 건 조회
  - 게시글의 단 건을 조회합니다.
  - 게시글의 제목과 본문 모두 응답에 포함되어야 합니다.
  - 해당 게시 글에 등록된 댓글 리스트도 같이 응답에 포함되어야 합니다.
  - 댓글 중에 삭제된 댓글은 포함하지 않습니다.
  - 댓글리스트도 페이징이 필요하나, 해당 과제에서는 무시합니다.


## 선택 요구사항
- [X] N + 1 문제가 무엇인지 학습하고, 해당 문제가 일어나고 있으면 개선합니다.
- [ ] 조회에서 성능 개선을 하기위해서 DB 인덱스를 추가해 봅니다.견될 경우 개선해보도록 합시다.


# 결과

1. 게시글 등록 API
<img width="610" alt="스크린샷 2024-02-20 오후 10 00 02" src="https://github.com/Jjuhui313/springBoard/assets/94800969/556206cf-96f7-410c-b2b6-fb91c03b5af0">
<br><br>

2. 게시글 삭제 API
<img width="618" alt="스크린샷 2024-02-20 오후 10 51 17" src="https://github.com/Jjuhui313/springBoard/assets/94800969/bfce39a5-f781-435d-8703-501e0075e095">
<br><br>

3. 게시글 수정 API
<img width="596" alt="스크린샷 2024-02-20 오후 10 01 18" src="https://github.com/Jjuhui313/springBoard/assets/94800969/64f456b9-e656-44ca-be50-f6bd9027f139">
<br><br>

4. 게시글 목록 조회 API
<img width="614" alt="스크린샷 2024-02-20 오후 10 59 19" src="https://github.com/Jjuhui313/springBoard/assets/94800969/fba7a1a4-fd7b-4c70-a08a-4f9dbe02d010">
<img width="594" alt="스크린샷 2024-02-20 오후 10 59 44" src="https://github.com/Jjuhui313/springBoard/assets/94800969/09d78fc7-75ad-4507-926b-e882f4b965a5">
<br><br>

5. 댓글 등록 API
<img width="606" alt="스크린샷 2024-02-20 오후 10 44 46" src="https://github.com/Jjuhui313/springBoard/assets/94800969/dbd15fa4-cdd5-4cf0-8ca4-e249affc3ae4">
<br><br>

6. 댓글 수정 API
<img width="626" alt="스크린샷 2024-02-20 오후 10 46 30" src="https://github.com/Jjuhui313/springBoard/assets/94800969/f71ca6f1-3553-4d8d-93d3-84e2a25e8a43">
<br><br>

7. 댓글 삭제 API
<img width="607" alt="스크린샷 2024-02-20 오후 10 47 47" src="https://github.com/Jjuhui313/springBoard/assets/94800969/32152fab-25f2-43a5-a162-354196ac32d5">
<br><br>

8. 게시글 단 건 조회 API
<img width="613" alt="스크린샷 2024-02-20 오후 10 54 37" src="https://github.com/Jjuhui313/springBoard/assets/94800969/ab9a277e-5248-4288-9532-3be6158c1d5b">
<br><br>




