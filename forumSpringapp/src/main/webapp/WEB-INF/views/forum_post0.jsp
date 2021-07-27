<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>發文</title>
</head>
<body>
	<div>
	<h3>發表新文章</h3>
	<form action="/petpet/forum/post" method="post">
		<div>
			<select name="text_sub">
				<option value="1">貓咪</option>
				<option value="2">狗狗</option>
				<option value="3">其他</option>
				<option value="4">PET</option>
			</select>
			<select name="text_type">
				<option selected="selected" value="1">問題</option>
				<option value="2">情報</option>
				<option value="3">心得</option>
				<option value="4">討論</option>
			</select>
		</div>
		<div>
			<input type="text" name="title" placeholder="請輸入文章標題"/>
		</div>
		<div>
			<textarea id="text" name="text" placeholder="それは、未来を取り戻す物語"></textarea>
		</div>
		<div>
			<input type="submit" value="發文" />
		</div>
	</form>
	</div>
</body>
</html>