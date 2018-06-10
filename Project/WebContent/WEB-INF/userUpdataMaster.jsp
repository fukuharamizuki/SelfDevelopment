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
	 <title>マスター用ユーザ情報更新</title>

</head>
<body>
<div class="container">
	<c:if test="${errMsg != null}" >
	    <div class="alert alert-danger" role="alert">
		  ${errMsg}
		</div>
	</c:if>

	<br>
	<br>
	<p><center><font size="6">ユーザ情報更新</font></center></p>


 	<div class="input-area2">
		<form method="post" action="userUpdataMaster">
			<div class="form-group row">
				<label for="Id" class="col-sm-4 col-form-label">ユーザID</label>
				<div class="col-sm-8">
					<input type="text" readonly class="form-control-plaintext" name="loginId" id="Id" value="${userData.loginId}">
				</div>
			</div>
			<div class="form-group row">
				<label for="inputPassword" class="col-sm-4 col-form-label">パスワード</label>
				<div class="col-sm-8">
					<input type="password" class="form-control" name="password1" id="inputPassword" placeholder="">
				</div>
			</div>
			<div class="form-group row">
				<label for="inputPassword" class="col-sm-4 col-form-label">パスワード(確認)</label>
				<div class="col-sm-8">
					<input type="password" class="form-control" name="password2" id="inputPassword" placeholder="">
				</div>
			</div>
			<div class="form-group row">
				<label for="inputName" class="col-sm-4 col-form-label">ユーザ名</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" name="name" id="inputName" value="${userData.name}">
				</div>
 			</div>
 			<div class="form-group row">
				<label for="inputBirthDate" class="col-sm-4 col-form-label">生年月日</label>
				<div class="col-sm-8">
					<input type="date" class="form-control" name="birthDate" id="inputBirthDate" value="${userData.birthDate}">
				</div>
			</div>
			<div class="form-group row">
				<label for="inputaddress" class="col-sm-4 col-form-label">住所</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" name="address" id="inputaddress" value="${userData.address}">
				</div>
			</div>
			<div class="form-group row">
				<label for="inputtel" class="col-sm-4 col-form-label">電話番号</label>
				<div class="col-sm-8">
					<input type="tel" class="form-control" name="tel" id="inputtel" value="${userData.tel}">
				</div>
			</div>
			<div class="form-group row">
				<label for="inputtel" class="col-sm-4 col-form-label">購入者選択</label>
				<div class="col-sm-6">
					<input type="text" required name="usertype" list="usertype">
					<datalist id="usertype">
						<option value="講師"></option>
						<option value="一般"></option>
					</datalist>
				</div>
			</div>
			<br>
			<center><button type="submit" class="btn btn-info btn-lg">更新</button></center>
		</form>
	</div>

	<br>
	<br>
	<div align="right"><a href="userData" class="btn btn-outline-info">戻る</a></div>
	<br>
	<br>

</div>
</body>
</html>
