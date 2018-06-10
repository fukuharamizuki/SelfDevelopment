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

   <meta charset="UTF-8">
	 <title>商品詳細情報</title>
	 <jsp:include page="/baselayout/header.jsp" />

</head>
<body>
<div class="container">
	<br>
	<br>
	<div class="row">
    <div class="col-md-5">
		<img src="img/${idb.fileName}" width="90%" height="90%">
	</div>
	<div class="col-md-7">
		<p><font size="5">${idb.name}</font></p>
		<br>
		<p><font size="4">レンタル　${idb.RPrice}　　購入　${idb.price}</font></p>
		<br>
		<p><font size="4">サイズ　S・M・L</font></p>
		<br>
		<p><font size="4">${idb.detail}</font></p>
		<br>
		<p><font size="3">サイズ表</font></p>
		<table class="table table-sm">
			<thead>
				<tr>
					<th>サイズ</th>
					<th>身長</th>
					<th>バスト</th>
					<th>ウエスト</th>
					<th>ヒップ</th>
					<th>背丈</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th>S</th>
					<th>148-155</th>
					<th>80</th>
					<th>60</th>
					<th>83</th>
					<th>36</th>
				</tr>
				<tr>
					<th>M</th>
					<th>150-160</th>
					<th>83</th>
					<th>63</th>
					<th>87</th>
					<th>38</th>
				</tr>
				<tr>
					<th>L</th>
					<th>160-165</th>
					<th>85</th>
					<th>66</th>
					<th>90</th>
					<th>40</th>
				</tr>
			</tbody>
		</table>
			<form method="post" action="addCart">
				<input type="hidden" name="id" value="${idb.id}">
				<p>
					size　　<input type="text" required name="size" list="size">
						<datalist id="size">
							<option value="S"></option>
							<option value="M"></option>
							<option value="L"></option>
						</datalist>
					数量　　<input type="number" min="1" max="100" value="0" name="count">
					購入方法　　<input type="text" required name="buytype" list="buytype">
						<datalist id="buytype">
							<option value="レンタル"></option>
							<option value="購入"></option>
						</datalist>
				</p>
				<div align="right">
					<button type="submit" class="btn btn-info">カートへ</button>
				</div>
			</form>
		</div>
	</div>



</div>
</body>
</html>
