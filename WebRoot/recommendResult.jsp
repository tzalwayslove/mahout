<%@ page language="java" import="java.util.*,com.rcd.javabean.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>推荐结果</title>
  </head>
  <%
  	//接收电影信息
  	ArrayList<MovieInfo> ownMovieInfo = (ArrayList)request.getAttribute("ownMovieInfo");
  	ArrayList<MovieInfo> recommendMovieInfo = (ArrayList)request.getAttribute("recommendMovieInfo");
 // 	System.out.println("ownMovieInfo.size()"+ownMovieInfo.size());
 // 	System.out.println("recommendMovieInfo.size()"+recommendMovieInfo.size());
  %>
  <body>
    <center>
    <table width="90%" border="1" cellpadding="0" cellspacing="0">
    <tr>
    <!-- 自己的电影 -->
    <td width="50%" align="center" valign="top">
    <table border="0">
    <tr><td align="left" colspan="4"><font color="blue">该用户曾经看过的电影</font></td></tr>
    <tr><td>电影名称</td><td>上映时间</td><td>电影类型</td><td>用户打分</td></tr>
    <%
  		//定义一个颜色数组
 		String []color = {"white","white"};
    	for(int i=0;i<ownMovieInfo.size();i++){
    		MovieInfo ownInfo = ownMovieInfo.get(i);
    		%>
    		<tr bgcolor="<%=color[(i+1)%2] %>">
    		<td><%=ownInfo.getName() %></td>
    		<td><%=ownInfo.getPublishedYear() %></td>
    		<td><%=ownInfo.getType() %></td>
    		<td><%=ownInfo.getPreference() %></td>
    		</tr>
    		<%
    	}
    %>
    </table>
    </td>
    <!-- 推荐的电影 -->
    <td width="50%" align="center" valign="top">
    <table border="0">
    <tr><td align="left" colspan="4"><font color="blue">推荐的结果</font></td></tr>
    <!-- <tr><td>Movie Name</td><td>Published Year</td><td>Movie Type</td><td>Score</td></tr> -->
    <tr><td>电影名称</td><td>上映时间</td><td>电影类型</td><td>用户打分</td></tr>
    
    <%
    	for(int i=0;i<recommendMovieInfo.size();i++){
    		MovieInfo recommendInfo = recommendMovieInfo.get(i);
    		%>
    		<tr bgcolor="<%=color[(i+1)%2] %>">
    		<td><%=recommendInfo.getName() %></td>
    		<td><%=recommendInfo.getPublishedYear() %></td>
    		<td><%=recommendInfo.getType() %></td>
    		<td><%=recommendInfo.getPreference() %></td>
    		</tr>
    		<%
    	}
    %>
    </table>
    </td></tr>
    </table>
    </center>
  </body>
</html>
