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
	 <title>ユーザ情報詳細</title>
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
        ${userInfo.loginId}
      </div>
    </div>
    <div class="form-group row">
      <label for="inputName" class="col-sm-4 col-form-label">ユーザ名</label>
      <div class="col-sm-8 form-control-plaintext">
        ${userInfo.name}
      </div>
    </div>
    <div class="form-group row">
      <label for="inputDate" class="col-sm-4 col-form-label">生年月日</label>
      <div class="col-sm-8 form-control-plaintext">
        ${userInfo.birthDate}
      </div>
    </div>
    <div class="form-group row">
      <label for="inputCreatetime" class="col-sm-4 col-form-label">住所</label>
      <div class="col-sm-8 form-control-plaintext">
        ${userInfo.address}
      </div>
    </div>
    <div class="form-group row">
      <label for="inputUpdatetime" class="col-sm-4 col-form-label">電話番号</label>
      <div class="col-sm-8 form-control-plaintext">
        ${userInfo.tel}
      </div>
    </div>
    <br>
  </div>
  <!-- 管理者表示 -->
  <c:if test="${userInfo.loginId=='admin'}">
  <div class="row">
    <div class="col-md-6" align="center">
      <a href="userList" class="btn btn-outline-info">ユーザ一覧へ</a>
    </div>
    <div class="col-md-6" align="center">
      <a href="masterItemList" class="btn btn-outline-info">商品一覧へ</a>
    </div>
  </div>
  </c:if>
  <!-- ユーザ表示 -->
  <c:if test="${userInfo.loginId!='admin'}">
    <div align="center"><a href="userUpdata?id=${userInfo.id}" class="btn btn-info btn-lg">更新</a></div>
  </c:if>
  <!-- 全員表示 -->
  <br>
  <p><center><font size="5">購入履歴</font></center></p>
  <br>
  <table class="table table-bordered">
    <thead>
      <tr class="bg-info text-white" align="center">
        <th>購入日時</th>
        <th>値段</th>
        <th></th>
      </tr>
    </thead>
    <tbody>
    <c:forEach var="add" items="${buyItemList}">
      <tr align="center">
        <th>${add.buyDate}</th>
        <td>${add.totalPrice}円</td>
        <td>
          <a href="buyItemData?id=${add.id}" class="btn btn-outline-info">詳細</a>
        </td>
      </tr>
      </c:forEach>
    </tbody>
  </table>

    <div align="right"><a href="index" class="btn btn-outline-info">戻る</a></div>


</div>
</body>
</html>
