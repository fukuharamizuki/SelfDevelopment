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
	<title>購入完了</title>
</head>

<body>
<div class="container">

	<br>
	<br>
	<center><h3>購入しました</h3></center>
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
    								<th>購入日時</th>
    								<th>合計</th>
    							</tr>
						</thead>
						<tbody>
							<tr align="center">
								<th>${resultBDB.formatDate}</th>
								<th>${resultBDB.totalPrice}円</th>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
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
  					<tr align="center">
  					<c:forEach var="add" items="${buyIDBList}" >
						<th>${add.name}</th>
						<th>${add.size}</th>
						<th>${add.count}</th>
						<th>${add.subTotal}円</th>
					</c:forEach>
					</tr>
					<tr align="center">
					<c:if test="${userInfo.userType=='講師'}" var="flg"/>
  					<c:if test="${flg}">
						<th>講師特別20％割引</th>
						<th></th>
						<th></th>
						<th>-${idb.waribiki}円</th>
					</c:if>
					</tr>
					<tr align="center">
						<th>${resultBDB.deliveryName}</th>
						<th></th>
						<th></th>
						<th>${resultBDB.deliveryPrice}円</th>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<br>
	</div>
	</div>
	<br>
	<div class="row">
	<div class="col-md-6" align="center">
		<a href="index" class="btn btn-outline-info">買い物へ戻る</a>
	</div>
	<div class="col-md-6" align="center">
		<a href="userData" class="btn btn-outline-info">ユーザ情報へ</a>
	</div>
</div>

</body>
</html>
