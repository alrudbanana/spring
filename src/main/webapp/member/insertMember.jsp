<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 창</title>
<style> 

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
   
   <h2 style="text-align:center">회원가입 창</h2>
   <div>
        <form action = "insert.do" method="post">
            아이디<input type="text" placeholder="아이디" class="in" name="id">
            비밀번호<input type="password" placeholder="비밀번호" class="in" name="pass">
            이름<input type="text" placeholder="아이디" class="in"  name="name">
            이메일<input type="text" placeholder="이메일" class="in" name="email">
            나이<input type="text" placeholder="나이" class="in"  name="age">
            몸무게<input type="text" placeholder="몸무게" class="in"  name="weight">
            
            회원가입<input type="submit" class="btn" value="회원가입"><br>
        </form>
        
       
        
    </div>
</body>
</html>