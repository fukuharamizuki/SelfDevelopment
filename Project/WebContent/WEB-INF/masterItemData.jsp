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
	 <title>商品詳細</title>

</head>
<body>
<div class="container">

  <br>
  <br>

  <p><center><font size="5">商品詳細</font></center></p>

  <div class="input-area-userData">
    <div class="form-group row">
      <label for="inputItem" class="col-sm-4 col-form-label">商品名</label>
      <div class="col-sm-8 form-control-plaintext">
        ${idb.name}
      </div>
    </div>
    <div class="form-group row">
      <label for="inputSize" class="col-sm-4 col-form-label">サイズ</label>
      <div class="col-sm-8 form-control-plaintext">
        S M L
      </div>
    </div>
    <div class="form-group row">
      <label for="inputPrice1" class="col-sm-4 col-form-label">価格(レンタル)</label>
      <div class="col-sm-8 form-control-plaintext">
        ${idb.RPrice}円
      </div>
    </div>
    <div class="form-group row">
      <label for="inputPrice2" class="col-sm-4 col-form-label">価格(購入)</label>
      <div class="col-sm-8 form-control-plaintext">
        ${idb.price}円
      </div>
    </div>
    <div class="form-group row">
      <label for="inputUpdatetime" class="col-sm-4 col-form-label">詳細</label>
      <div class="col-sm-8 form-control-plaintext">
        ${idb.detail}
      </div>
    </div>
    <br>
  </div>

    <div align="right"><a href="masterItemList" class="btn btn-outline-warning">戻る</a></div>


</div>
</body>
</html>
