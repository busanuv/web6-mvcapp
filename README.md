# FrontController 고쳐보기
1. 비지니스 로직 가져와서 request에 저장해서 sendRedirect 해보고 RequestDispatcher로 변경해보기 (302 안됨)
2. WEB-INF/views로 경로 이동 시켜서 - 직접 요청해보기 (요청불가)
3. RequestDispatcher로 요청해보기 (요청가능) - request도 유지가능