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
   <link rel="stylesheet" href="./css/original/common-userData.css">

   <meta charset="UTF-8">
	 <title>購入情報詳細</title>

</head>
<body>
	<div class="container">
	<br>
	<br>
	<p><center><font size="5">購入情報詳細</font></center></p>
	<br>
	<br>
	<table class="table table-bordered">
		<thead>
			<tr class="bg-info text-white" align="center">
				<th>商品</th>
				<th>サイズ</th>
				<th>個数</th>
				<th>値段</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="add" items="${itemdetailList}">
				<tr align="center">
					<th>${add.name}</th>
					<th>${add.size}</th>
					<td>${add.count}</td>
					<td>${add.subTotal}円</td>
				</tr>
			</c:forEach>
			<c:if test="${userInfo.userType=='講師'}" var="flg"/>
  			<c:if test="${flg}">
			<tr align="center">
				<th>講師割引20％</th>
				<th></th>
				<td></td>
				<td>${resultBDB.waribiki}円</td>
			</tr>
			</c:if>
			<tr align="center">
				<th>${resultBDB.deliveryName}</th>
				<th></th>
				<td></td>
				<td>${resultBDB.deliveryPrice}円</td>
			</tr>
		</tbody>
	</table>

</div>
</body>
</html>
