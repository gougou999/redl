<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=request.getContextPath()%>/context/public/jquery-2.1.1.min.js"></script>
<title>Insert title here</title>
</head>
<body >
	<div id="changkou">
	<span>City:</span>
	<input id="city" type="text">
	<button onclick="query();">查询</button>
	</div>
	
	<table id="tab" border="1">
		<tr>
			<td>日期</td>
			<td>城市</td>
			<td>全站PV</td>
			<td>首页PV</td>
			<td>景区频道</td>
			<td>游记频道</td>
			<td>评测频道</td>
			<td>文章频道</td>
			<td>预定频道</td>
			<td>文章频道</td>
			<td>足迹频道</td>
		</tr>
	</table>
	<script type="text/javascript">
	var message = ${message};
	console.log(message);
	console.log(message != null);
	if(message != null){
		$("#changkou").hide();
		for(var i = 0; i < message.length; i ++){
    		addLine(i+1, message[i]);
    	}
	}else{
		$("#changkou").show();
		show();
	}
	
	function query(){
		var city = $("#city").val();
		window.location = "./census/city?city="+city;
	}
	function show(){
		console.log("XXXXXXXX");
			$.ajax({
		        type: "GET",
		        url: "./census/list",
		        data:{time: new Date()},
		        success: function(data) {
		        	for(var i = 0; i < data.length; i ++){
		        		addLine(i+1, data[i]);
		        	}
		        },
		        dataType: "json"
		    });
	}
	
	
	
	function addLine(id, obj){
		console.log(obj);
		var line = "<tr>"+
		"<td>" + obj.date + "</td>" +
		"<td>" + obj.chName + "</td>" +
		"<td>" + obj.total + "</td>" +
		"<td>" + obj.shouYe + "</td>" +
		"<td>" + obj.jingQu + "</td>" +
		"<td>" + obj.lvYouYouJi + "</td>" +
		"<td>" + obj.pingCe + "</td>" +
		"<td>" + obj.news + "</td>" 
		+"</tr>";
		$("#tab").append(line);
	}
	</script>
</body>
</html>