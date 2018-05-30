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
   <link rel="stylesheet" href="./css/original/common3.css">
   <link rel="stylesheet" href="./css/original/common-imageTitle.css">

   <meta charset="UTF-8">
	 <title>TOP</title>

	 <jsp:include page="/baselayout/header.jsp" />

</head>
<body>
<div class="container">

<center><p><font size="7">Costumes</font></p></center>

  <div class="input-area3">
    <div style="float:left; margin: 30px;">
      <a href="itemTypeList?id=1"><img src="img/classicTutu-1.jpg"></a>
      <p>ClassicTutu</p>
    </div>
    <div style="float:left; margin: 30px;">
      <a href="itemTypeList?id=2"><img src="img/operaTutu-1.jpg"></a>
      <p>Opera Tutu</p>
    </div>
    <br clear="both"/>

    <div style="float:left; margin: 30px;">
      <a href="itemTypeList?id=3"><img src="img/romanticTutu-1.jpg"></a>
      <p>Romantic Tutu</p>
    </div>
    <div style="float:left; margin: 30px;">
      <a href="itemTypeList?id=4"><img src="img/georgette-1.jpg"></a>
      <p>Georgette</p>
    </div>
    <br clear="both"/>
  </div>

</div>
</body>
</html>
