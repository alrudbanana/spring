<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 창</title>
<style> 
 * {
            font-family: 'Noto Sans KR', sans-serif;
        }

        body {
            background-color: #1BBC9B;
        }

        div {
            margin: auto;
            width: 300px;
            background-color: #EEEFF1;
            border-radius: 5px;
            text-align: center;
            padding: 20px;
        }

        input {
            width: 100%;
            padding: 10px;
            box-sizing: border-box;
            border-radius: 5px;
            border: none;
        }

        .in {
            margin-bottom: 10px;
        }

        .btn {
            background-color: #1BBC9B;
            margin-bottom: 30px;
            color: white;
        }

        a {
            text-decoration: none;
            color: #9B9B9B;
            font-size: 12px;
        }
</style>

</head>
<body>
   
   <h2 style="text-align:center">로그인 창</h2>
   <div>
        <form action = "login.do" method="post">
            <input type="text" placeholder="아이디" class="in" name="id">
            <input type="password" placeholder="비밀번호" class="in" name="pass">
            <input type="submit" class="btn" value="로그인"><br>
        </form>
        <a href="insertMember.jsp"><input type="button" class="btn" value="회원가입" >회원가입</a>
        <br>
        <a href="#none">비밀번호를 잊어버리셨나요?</a>
    </div>
</body>
</html>