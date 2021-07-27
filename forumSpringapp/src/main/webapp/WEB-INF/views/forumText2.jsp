<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="fbs1" scope="request" class="com.petpet.model.ForumBean" />
<div align='center'>
<h2>選取文章</h2>
<hr>
<form>
<div>
<input type="text" id="create_time" name="create_time" 
                    value="${fbs1.create_time}">
</div>    
<div>   
<input type="text" id="title" name="title" 
                    value="${fbs1.title}">
</div>
<div>                                                     
<input type="text" id="text" name="text" 
                    value="${fbs1.text}">
</div>
<div>

<input type="submit" value="修改" />


<input type="submit" value="刪除" />
  			                
</div>
<div align='center'>
<a href="<c:url value='/' />">回首頁</a>
</div>
</form>
<hr>
</div>
</body>
</html>