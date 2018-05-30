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
<title>商品リスト</title>
</head>
<body>
<div class="container">
  <br>
  <br>
    <p><center><font size="6">商品リスト</font></center></p>

  <br>
  <br>
  <div align="right"><a href="masterCreateItem" class="btn btn-outline-warning">商品登録</a></div>

  <div class="input-area2">
  <form method="post" action="masterItemList">
    <div class="form-group row">
      <label for="inputItem" class="col-sm-4 col-form-label">商品名</label>
      <div class="col-sm-8">
        <input type="text" class="form-control" name="name" id="inputEmail3" placeholder="">
      </div>
    </div>
    <div class="form-group row">
      <label for="inputData" class="col-sm-4 col-form-label">詳細</label>
      <div class="col-sm-8">
        <input type="text" class="form-control" name="detail" id="inputData" placeholder="">
      </div>
    </div>
    <br><br>
    <center><button type="action" class="btn btn-warning btn-lg">　検索　</button></center>
　</form>
  </div>
  <br>
  <br>
  <table class="table table-bordered">
    <thead>
        <tr class="bg-warning text-white">
            <th><center>商品名</center></th>
            <th><center>サイズ</center></th>
            <th><center>価格(レンタル)</center></th>
            <th><center>価格(購入)</center></th>
            <th>　　　　</th>
        </tr>
    </thead>
    <tbody>
    		<c:forEach var="item" items="${itemList}">
        <tr>
            <th>${item.name}</th>
            <td>S M L</td>
            <td>${item.RPrice}円</td>
            <td>${item.price}円</td>
            <td><center>
              <a href="masterItemData?id=${item.id}" class="btn btn-outline-warning">詳細</a>
              <a href="masterItemUpdata?id=${item.id}" class="btn btn-outline-warning">更新</a>
              <a href="masterItemDelete?id=${item.id}" class="btn btn-outline-warning">削除</a>
            </center></td>
        </tr>
        </c:forEach>
    </tbody>
</table>

<div align="right"><a href="userData" class="btn btn-outline-warning">戻る</a></div>


</div>
</body>
</html>
