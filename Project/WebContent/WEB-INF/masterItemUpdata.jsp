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
	 <title>商品情報更新</title>

</head>
<body>
<div class="container">

  <br>
  <br>
    <p><center><font size="6">商品情報更新</font></center></p>


  <div class="input-area2">
    <form method="post" action="masterItemUpdata">
    <input type="hidden" name="id" value="${idb.id}">
      <div class="form-group row">
        <label for="inputItem" class="col-sm-4 col-form-label">商品名</label>
        <div class="col-sm-8">
          <input type="text" readonly class="form-control-plaintext" id="inputItem" value="${idb.name}">
        </div>
      </div>
      <div class="form-group row">
        <label for="inputPrice1" class="col-sm-4 col-form-label">価格(レンタル)</label>
        <div class="col-sm-8">
          <input type="number" class="form-control" name="rPrice" id="inputPrice2" value="${idb.RPrice}円">
        </div>
      </div>
      <div class="form-group row">
        <label for="inputPrice" class="col-sm-4 col-form-label">価格(購入)</label>
        <div class="col-sm-8">
          <input type="number" class="form-control" name="price" id="inputPrice" value="${idb.price}円">
        </div>
      </div>
      <div class="form-group row">
        <label for="inputData" class="col-sm-4 col-form-label">詳細</label>
        <div class="col-sm-8">
          <input type="text" class="form-control" name="detail" id="inputData" value="${idb.detail}">
        </div>
      </div>
      <br>
      <center><button type="submit" class="btn btn-warning btn-lg">更新</button></center>
    </form>
  </div>

  <br>
  <br>
  <div align="right"><a href="masterItemList" class="btn btn-outline-warning">戻る</a></div>
  <br>
  <br>

</div>
</body>
</html>
