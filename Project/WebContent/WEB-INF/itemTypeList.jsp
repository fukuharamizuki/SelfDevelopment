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
	 <title>種類別一覧</title>
	 <jsp:include page="/baselayout/header.jsp" />

</head>
<body>
<div class="container">
  <br>
  <br>
  <center><p><font size="6">ClassicTutu</font></p></center>
  <div class="input-area4">
  <c:forEach var="item" items="${itemList}" >
    <div style="float:left; margin: 35px;">
      <a href="itemData?id=${item.id}"><img src="img/${item.fileName}"></a>
      <p>${item.name}</p>
    </div>
    </c:forEach>
  </div>

</div>
</body>
</html>
