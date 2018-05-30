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
	<title>新規登録</title>
	<jsp:include page="/baselayout/header.jsp" />
</head>

<body>
<div class="container">
  <br>
  <br>
  <p><center><font size="6">新規登録</font></center></p>
  <br>
  <br>
  <center>
  <div class="input-area2">
    <form method="post" action="userCreate">
      <div class="form-group row">
        <label for="inputID" class="col-sm-4 col-form-label">ログインID</label>
        <div class="col-sm-6">
          <input type="text" class="form-control" name="Id" id="inputID" placeholder="">
        </div>
      </div>
      <div class="form-group row">
        <label for="inputPassword" class="col-sm-4 col-form-label">パスワード</label>
        <div class="col-sm-6">
          <input type="password" class="form-control" name="password" id="inputPassword" placeholder="">
        </div>
      </div>
    <div class="form-group row">
      <label for="inputPassword2" class="col-sm-4 col-form-label">パスワード(確認)</label>
      <div class="col-sm-6">
        <input type="password" class="form-control" name="password2" id="inputPassword2" placeholder="">
      </div>
    </div>
    <div class="form-group row">
      <label for="inputusername" class="col-sm-4 col-form-label">ユーザ名</label>
      <div class="col-sm-6">
        <input type="text" class="form-control" name="name" id="inputusername" placeholder="">
      </div>
    </div>
    <div class="form-group row">
      <label for="inputdate" class="col-sm-4 col-form-label">生年月日</label>
      <div class="col-sm-6">
        <input type="date" class="form-control" name="birthdate" id="inputdate" placeholder="">
      </div>
    </div>
    <div class="form-group row">
      <label for="inputaddress" class="col-sm-4 col-form-label">住所</label>
      <div class="col-sm-6">
        <input type="text" class="form-control" name="address" id="inputaddress" placeholder="">
      </div>
    </div>
    <div class="form-group row">
      <label for="inputtel" class="col-sm-4 col-form-label">電話番号</label>
      <div class="col-sm-6">
        <input type="tel" class="form-control" name="tel" id="inputtel" size="12" placeholder="電話番号は、市外局番からハイフン（-）を入れて記入してください。">
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
    <center><button type="submit" class="btn btn-info">登録</button></center>
    </form>
  </div>
  </center>

  <br>
  <br>
  <div align="right"><a href="userList.html" class="btn btn-outline-info">戻る</a></div>

</div>
</body>
</html>
