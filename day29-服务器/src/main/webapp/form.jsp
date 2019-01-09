<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/8 0008
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
        function unmatch() {
            var pattern=/^[a-zA-Z0-9]{4,14}$/;
            var username=document.getElementById("na").value;
            if(pattern.test(username)){
                console.log("用户名输入正确");
                document.getElementById("s").innerText="用户名输入正确";
            }else{
                console.log("用户名输入不正确");
                document.getElementById("s").innerText="用户名输入不正确";
            }
        }
        function phmatch() {
            var pattern=/^[1-9](3|5|7|8|9)[0-9]{9}$/;
            var phonenum=document.getElementById("ph").value;
            if(pattern.test(phonenum)){
                console.log("手机号码输入正确");
                document.getElementById("s1").innerText="手机号码输入正确";
            }else{
                console.log("手机号码输入不正确");
                document.getElementById("s1").innerText="手机号码输入不正确";
            }
        }
        function pamatch() {
            var pattern=/^[a-zA-Z0-9\.\*\$]{6,15}$/;
            var password=document.getElementById("pa").value;
            if(pattern.test(password)){
                console.log("密码格式输入正确");
                document.getElementById("s2").innerText="密码格式输入正确";
            }else{
                console.log("密码格式输入不正确");
                document.getElementById("s2").innerText="密码格式输入不正确";
            }
        }
    </script>
    <style>
        #logo {font-size: 25px;font-family: 楷体;color:black;}
    </style>
</head>
<body>
<div id="logo">
    <form action="/form" method="post">
        <p>用户名 <input type="text" name="username" id="na" onblur=unmatch()></p>
        <span id="s" style="font-size: 15px;font-family:宋体;color:grey;"></span>
        <p>性别
            <span><input type="radio" name="sex" value="male" checked>男</span>
            <span><input type="radio" name="sex" value="female">女</span>
        </p>
        <p>手机号<input type="text" name="phonenum" id="ph" onblur=phmatch()></p>
        <span id="s1" style="font-size: 13px;font-family:宋体;color:grey;"></span>
        <p>密码 <input type="password" name="password" id="pa" onblur=pamatch()></p>
        <span id="s2" style="font-size: 13px;font-family:宋体;color:grey;"></span>
        <p><input type="submit" value="提交"></p>
    </form>
</div>
</body>
</html>
