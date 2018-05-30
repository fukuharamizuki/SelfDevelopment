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
    <form method="post" action="masterCreateItem">
      <div class="form-group row">
        <label for="inputItem" class="col-sm-4 col-form-label">商品名</label>
        <div class="col-sm-6">
          <input type="text" class="form-control" name="itemname" id="inputItem" placeholder="">
        </div>
      </div>
    <div class="form-group row">
      <label for="inputPrice1" class="col-sm-4 col-form-label">価格(レンタル)</label>
      <div class="col-sm-6">
        <input type="text" class="form-control" name="rPrice" id="inputPrice1" placeholder="">
      </div>
    </div>
    <div class="form-group row">
      <label for="inputPrice2" class="col-sm-4 col-form-label">価格(購入)</label>
      <div class="col-sm-6">
        <input type="text" class="form-control" name="price" id="inputPrice2" placeholder="">
      </div>
    </div>
    <div class="form-group row">
      <label for="inputData" class="col-sm-4 col-form-label">詳細</label>
      <div class="col-sm-6">
        <input type="text" class="form-control" name="detail" id="inputData" placeholder="">
      </div>
    </div>
    <div class="form-group row">
      <label for="inputData" class="col-sm-4 col-form-label">タイプ</label>
      <div class="col-sm-6">
        <input type="text" class="form-control" name="type" id="inputData" placeholder="">
      </div>
    </div>
    <br>
    <center><button type="submit" class="btn btn-warning">登録</button></center>
    </form>
  </div>
  </center>

  <br>
  <br>
  <div align="right"><a href="masterItemList" class="btn btn-outline-warning">戻る</a></div>

</div>
</body>
</html>
