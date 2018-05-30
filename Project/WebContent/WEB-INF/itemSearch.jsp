<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
   <!-- Required meta tags -->
   <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

   <!-- Bootstrap CSS -->
   <link rel="stylesheet" href="./css/bootstrap.min.css">
   <link rel="stylesheet" href="./css/original/common4.css">

   <meta charset="UTF-8">
	 <title>検索結果</title>
	 <jsp:include page="/baselayout/header.jsp" />

</head>
<body>
<div class="container">
  <br>
  <br>
  <center><p><font size="6">検索結果</font></p></center>
  <div class="input-area4">
	<c:forEach var="add" items="${searchList}">
		<div style="float:left; margin: 35px;">
			<a href="itemData?id=${add.id}"><img src="img/${add.fileName}"></a>
			<p>${add.name}</p>
		</div>
	</c:forEach>
  </div>

</div>
</body>
</html>
