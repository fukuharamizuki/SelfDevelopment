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
	 <title>マスター用ユーザ情報詳細</title>
	 <jsp:include page="/baselayout/header.jsp" />

</head>
<body>
<div class="container">

  <br>
  <br>

  <p><center><font size="5">ユーザ情報詳細</font></center></p>

  <div class="input-area-userData">
    <div class="form-group row">
      <label for="inputID" class="col-sm-4 col-form-label">ログインID</label>
      <div class="col-sm-8 form-control-plaintext">
        ${userData.loginId}
      </div>
    </div>
    <div class="form-group row">
      <label for="inputName" class="col-sm-4 col-form-label">ユーザ名</label>
      <div class="col-sm-8 form-control-plaintext">
        ${userData.name}
      </div>
    </div>
    <div class="form-group row">
      <label for="inputDate" class="col-sm-4 col-form-label">生年月日</label>
      <div class="col-sm-8 form-control-plaintext">
        ${userData.birthDate}
      </div>
    </div>
    <div class="form-group row">
      <label for="inputCreatetime" class="col-sm-4 col-form-label">住所</label>
      <div class="col-sm-8 form-control-plaintext">
        ${userData.address}
      </div>
    </div>
    <div class="form-group row">
      <label for="inputUpdatetime" class="col-sm-4 col-form-label">電話番号</label>
      <div class="col-sm-8 form-control-plaintext">
        ${userData.tel}
      </div>
    </div>
    <br>
  </div>

    <div align="right"><a href="userList" class="btn btn-outline-info">戻る</a></div>
	<br>

</div>
</body>
</html>
