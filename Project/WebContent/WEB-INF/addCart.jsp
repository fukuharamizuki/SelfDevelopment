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

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Myカート</title>
	<jsp:include page="/baselayout/header.jsp" />
</head>

<body>
<div class="container">
	<br>
	<br>
	<center><h2>MY カート</h1></center>
	<br>
	<br>

	<table class="table table-bordered">
		<thead>
			<tr class="bg-info text-white" align="center">
				<th>商品名</th>
				<th>値段</th>
				<th>サイズ</th>
				<th>個数</th>
				<th>　　　　</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="add" items="${cart}" >
				<tr align="center">
					<th>${add.name}</th>
					<td>${add.buyTypePrice}</td>
					<td>${add.size}</td>
					<td>${add.count}</td>
					<td>
						<a href="addCartDelete?id=${add.id}" class="btn btn-outline-info">削除</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>
	<br>
	<div class="row">
		<div class="col-md-6" align="center">
			<a href="index" class="btn btn-outline-info">戻　る</a>
		</div>
		<div class="col-md-6" align="center">
			<c:if test="${userInfo.name==null}">
				<a href="login" class="btn btn-outline-info">レジへ</a>
			</c:if>
			<c:if test="${userInfo.name!=null}">
				<a href="buyItem" class="btn btn-outline-info">レジへ</a>
			</c:if>
		</div>
	</div>

</div>
</body>
</html>
