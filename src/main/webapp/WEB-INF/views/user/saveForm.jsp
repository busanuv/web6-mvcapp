<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시판</title>
</head>
<body>
    <h1>회원가입</h1>
    <hr/>
    <form action="/user/save.do" method="post" enctype="application/x-www-form-urlencoded">
        <input type="text" name="username" placeholder="Enter username" /><br/>
        <input type="text" name="password" placeholder="Enter password" /><br/>
        <button type="submit">회원가입</button>
    </form>
</body>
</html>
