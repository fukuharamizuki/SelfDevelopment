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
   <link rel="stylesheet" href="./css/original/common2.css">

   <meta charset="UTF-8">
	 <title>カート情報削除</title><jsp:include page="/baselayout/header.jsp" />


</head>
<body>
<div class="container">

	<br>
	<br>
    <p><center><font size="6">カートアイテム削除確認</font></center></p>

	<br>
	<br>
	<center><p>${deleteItem.name}を</p></center>
	<center><p>本当に削除してよろしいでしょうか。</p></center>

	<br>
	<br>
	<div class="row">
		<div class="col-md-6" align="center">
			<a href="addCart" class="btn btn-info btn-lg">CANCEL</a>
		</div>
	<div class="col-md-6" align="center">
		<form method="post" action="addCartDelete?id=${deleteItem.id}">
			<button type="submit" class="btn btn-info btn-lg">　OK　</button>
		</form>
	</div>
	</div>

</div>
</body>
</html>
