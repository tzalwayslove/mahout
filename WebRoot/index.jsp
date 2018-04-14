<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>电影个性化推荐系统</title>
  </head>
  
  <body>
    <center>
    <form action="RecomendServlet" method="post">
    <table border="0">
    <tr><td align="right">请输入用户ID：</td><td align="left"><input type="text" name="userID"></td></tr>
    <tr><td align="right">请输入推荐的电影数量</td><td align="left"><input type="text" name="size" value="25"></td></tr>
    <tr><td colspan="2" align="center">
    <input type="radio" name="recommendType" checked="checked" value="itemBased">基于物品
    <input type="radio" name="recommendType" value="slopeOne">随机
    <input type="radio" name="recommendType" value="userBased">基于用户
    </td></tr>
    <tr><td colspan="2" align="center"><input type="submit" value="提交"></td></tr>
    </table>
    </form>
    </center>
  </body>
</html>
