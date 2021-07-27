<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<meta charset="UTF-8">
<title>Insert title here</title>
<script>

</script>
</head>
<body>
	<jsp:useBean id="fbs1" scope="request"
		class="com.petpet.model.ForumBean" />
	<div align='center'>
		<h2>選取文章</h2>
		<hr>
		<form action="<c:url value='/update' />" method="post">
		<input type="hidden" name="textId" value="${fbs1.textId}" />
			<div>			  		
				<select name="text_sub">
					<option value="${fbs1.text_sub}" selected >${fbs1.text_sub}</option>
					<option value="貓咪">貓咪</option>
					<option value="狗狗">狗狗</option>
					<option value="其他">其他</option>
					<option value="PET">PET</option>
				</select> 
				<select name="text_type">
					<option value="${fbs1.text_type}" selected >${fbs1.text_type}</option>
					<option value="問題">問題</option>
					<option value="情報">情報</option>
					<option value="心得">心得</option>
					<option value="討論">討論</option>
				</select>
			</div>
			<div>
				<input type="text" id="create_time" name="create_time"
					value="${fbs1.create_time}">
			</div>
			<div>
				<input type="text" id="title" name="title" value="${fbs1.title}">
			</div>
			<div>
				<input type="text" id="text" name="text" value="${fbs1.text}">
			</div>
			<div>
				<button type="submit" onclick="updateText(${fbs1.textId})" >更新</button>
				<input type="button" value="刪除" name="delete" onclick="deleteText(${fbs1.textId})">
			</div>
			<div align='center'>
				<a href="<c:url value='/' />">回首頁</a>
			</div>
		</form>
		<hr>
	</div>
</body>
<script>
 
function deleteText(textId) {
    if (confirm("これが我が『キング・クリムゾン』の能力！")) {
    	let  web="delete?textId="+textId;
    	window.location.href=web;
    	
    }
    return false;
}
function updateText(textId) {
    if (confirm("コレが………『レクイエム』……………ダ！！")) {
    	    	
    }
    return false;
}

</script>
</html>