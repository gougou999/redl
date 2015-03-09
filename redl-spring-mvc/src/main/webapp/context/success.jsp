<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>成功！！！！！</h1>
	<h3>${user}</h3>
	<h3>用户名：${user.username}</h3>
	<h3>密码：${user.password}</h3>
	
	<c:forEach var="oneUser" items="${users}" begin="0">
		<h3>用户名：${oneUser.username}</h3>
		<h3>密码：${oneUser.password}</h3>
	</c:forEach>
	
	<%-- <h3>${users}</h3>
	
	<h3>${users[0].username}</h3>
	<h3>${users[0].password}</h3> --%>
	<script type="text/javascript">
		var users= ${users[0]};
		console.log(users);
		for(var i = 0; i < users.length; i ++){
			console.log("用户名：" + users[i].username + "；密码：" + users[i].password);
		}
	</script>
</body>
</html>