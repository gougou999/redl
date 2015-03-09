<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="./context/public/jquery-2.1.1.min.js"></script>
</head>
<body onload="show();">
<h2><a href="./census">统计查询</a></h2>

	<span>URL:</span>
	<input id="currentUrl" type="text">
	<span>日期:</span>
	<input id="date" type="date">
	
	<button onclick="query();">查询</button>
	<table id="tab" border='1'>
		<tr>
			<td>主键ID</td>
			<td>CookieId</td>
			<td>标题</td>
			<td>用户ID</td>
			<td>来源地址</td>
			<td>当前地址</td>
			<td>记录时间</td>
			<td>时间戳</td>
			<td>停留时间</td>
			<td>停留时间(关闭)</td>
			<td>浏览器</td>
			<td>分辨率</td>
			<td>IP地址</td>
			<td>操作系统</td>
			<td>URL来源</td>
			<td>IP地址地域编号</td>
			<td>频道ID</td>
			<td>时间串</td>
			<td>进入网页顺序</td>
			<td>进入网页前一个页面</td>
			<td>用户搜索关键字</td>
			<td>频道名称</td>
			<td>当前Url业务名称</td>
		</tr>
	</table>

</body>
	
<script type="text/javascript">
	function show() {
		$.ajax({
	        type: "GET",
	        url: "./cookieList",
	        data:{time: new Date()},
	        success: function(data) {
	        	console.log(data.length);
	        	console.log(data);
	        	for(var i = 0; i < data.length; i ++){
	        		addLine(i+1, data[i]);
	        	}
	        },
	        dataType: "json"
	    });
	}
	
	function query(){
		var current = $("#currentUrl").val();
		var date = $("#date").val().split("-");
		var simplDate = "";
		console.log(date);
		for(var i = 0; i < date.length; i ++){
			simplDate += date[i];
		}
		window.location = "./cookie/cookie-url-date?currentUrl="+ current+"&dateSeq="+simplDate;
	}
	
	function ttt(){
		onone();
	}
	
	function onone(){
		 var _len = $("#tab tr").length;
		 for(var i = 1; i < _len; i++){
			 $("tr[id="+i+"]").remove(); 
		 }
		 
	}
	
	function addLine(id, obj){
		
		var addtime = obj.addTime;
		var time = (1900 + addtime.year) + "-" + (1 + addtime.month) + "-" + addtime.date;
		
		var line = "<tr>"+
		"<td id="+id+">" + id + "</td>" +
		"<td><a href='./cookie/"+ obj.cookieId +"'>" + obj.cookieId + "</a></td>" +
		"<td>" + obj.title + "</td>" +
		"<td>" + obj.userId + "</td>" +
		"<td>" + obj.referer + "</td>" +
		"<td>" + obj.currentUrl + "</td>" +
		"<td>" + time + "</td>" +
		"<td>" + obj.timestamp + "</td>" +
		"<td>" + obj.duration + "</td>" +
		"<td>" + obj.duration2 + "</td>" +
		"<td>" + obj.brower + "</td>" +
		"<td>" + obj.resolution + "</td>" +
		"<td>" + obj.ip + "</td>" +
		"<td>" + obj.os + "</td>" +
		"<td>" + obj.accessClientType + "</td>" +
		"<td>" + obj.regionName + "</td>" +
		"<td>" + obj.channelId + "</td>" +
		"<td>" + obj.actionType + "</td>" +
		"<td>" + obj.dateSeq + "</td>" +
		"<td>" + obj.userViewSeq + "</td>" +
		"<td>" + obj.refererUrlType + "</td>" +
		"<td>" + obj.keyWords + "</td>" +
		"<td>" + obj.chName + "</td>" +
		"<td>" + obj.bizName + "</td>" +
		+"</tr>";
		$("#tab").append(line);
	}
	
</script>
</html>
