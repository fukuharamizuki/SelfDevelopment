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
	 <title>商品情報削除</title>

</head>
<body>
<div class="container">

	<br>
	<br>
	<p><center><font size="6">商品削除確認</font></center></p>

	<br>
	<br>
	<center><p>商品名${idb.name}を</p></center>
	<center><p>本当に削除してよろしいでしょうか。</p></center>

	<br>
	<br>
	<div class="row">
		<div class="col-md-6" align="center">
			<a href="masterItemList" class="btn btn-warning btn-lg">CANCEL</a>
		</div>
		<div class="col-md-6" align="center">
			<form method="post" action="masterItemDelete">
				<input type="hidden" name="id" value="${idb.id}">
				<button type="submit" class="btn btn-warning btn-lg">　OK　</button>
			</form>
		</div>
	</div>

</div>
</body>
</html>
