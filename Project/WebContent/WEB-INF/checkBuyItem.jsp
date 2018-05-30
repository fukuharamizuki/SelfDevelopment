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
	<title>商品購入確認</title>
	<jsp:include page="/baselayout/header.jsp" />
</head>

<body>
<div class="container">
	<br>
	<br>
	<center><h2>購入</h1></center>
	<br>
	<br>
	<div class="card border-info">
    		<div class="class-body">
		<br>
		<br>
		<div class="row">
			<div class="col-md-12" align="center">
				<table class="table">
    					<thead>
    						<tr align="center">
	    						<th>商品名</th>
							 <th>サイズ</th>
	    						<th>数量</th>
	    						<th>小計</th>
    						</tr>
					</thead>
    				<tbody>
    				<c:forEach var="add" items="${cart}" >
					<tr align="center">
							<th>${add.name}</th>
							<th>${add.size}</th>
							<th>${add.count}</th>
							<th>${add.subTotal}円</th>
					</tr>
				</c:forEach>
					<tr align="center">
						<th>${idb.deliveryName}</th>
						<th></th>
						<th></th>
						<th>${idb.deliveryPrice}円</th>
					</tr>
					<c:if test="${userInfo.userType=='講師'}" var="flg"/>
					<c:if test="${flg}">
						<tr align="center">
							<th>講師特別20%割引</th>
							<th></th>
							<th></th>
							<th>-${idb.waribiki}円</th>
						</tr>
					</c:if>
					<tr align="center">
						<th>合計</th>
						<th></th>
						<th></th>
						<th>${idb.totalPrice}円</th>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<br>
	<br>
	<div align="center">
		<form method="post" action="comfirmBuyItem">
		<center><button type="submit" class="btn btn-outline-info">購　入</button></center>
		</form>
	</div>
	<br>
	<br>
    </div>
  </div>
</div>
</body>
</html>
