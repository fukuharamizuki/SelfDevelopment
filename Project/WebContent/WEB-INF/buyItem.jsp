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
	<title>購入画面</title>
	<jsp:include page="/baselayout/header.jsp" />
</head>

<body>
<div class="container">

	<br>
	<br>
	<center><h3>購入画面</h3></center>
	<br>
	<br>
	<form method="post" action="checkBuyItem">
	<table class="table table-bordered">
    <thead>
		<tr align="center">
			<th>商品名</th>
			<th>値段</th>
			<th>サイズ</th>
			<th>個数</th>
			<th>小計</th>
		</tr>
    </thead>
    <tbody>
		<c:forEach var="add" items="${cart}" >
			<tr align="center">
				<th>${add.name}</th>
				<td>${add.buyTypePrice}円</td>
				<td>${add.size}</td>
				<td>${add.count}</td>
				<td>${add.subTotal}円</td>
			</tr>
		</c:forEach>
		<tr align="center">
	        <th>配達方法</th>
	        <th></th>
	        <th></th>
	        <th></th>
			<th>
				<div class="btn-group">
					<select name="deliveryType">
					<c:forEach var="delivery" items="${dmdbList}">
						<option value="${delivery.id}">${delivery.deliveryName}</option>
					</c:forEach>
					</select>
          		</div>
        		</th>
	</tbody>
  </table>
  <br>
  <br>
    <div align="center">
      <button type="submit" name="action" class="btn btn-outline-info">お会計へ</button>
 	</div>
 	 </div>
 	</form>



</div>
</body>
</html>
