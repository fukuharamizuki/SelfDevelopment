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
      <link rel="stylesheet" href="./css/original/a-fontsize/css">

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title></title>
</head>

<body>
  <div id="header">
    <div class="container">
      <header>
          <a href="index"><font size="8" color="black"> BALLET</font></a>
          <c:if test="${userInfo.name!=null}">
          	<p>こんにちは　${userInfo.name}さん</p>
          </c:if>
      </header>
    </div>

    <nav class="navbar navbar-light" style="background-color: #e3f2fd;">
      <div class="container">
		<c:if test="${userInfo.name!=null}">
			<a class="flex-sm-fill text-sm-center nav-link" href="userData">詳細</a>
			<a class="flex-sm-fill text-sm-center nav-link" href="addCart">カート</a>
			<a class="flex-sm-fill text-sm-center nav-link" href="logOut">LogOut</a>
		</c:if>
		<c:if test="${userInfo.name==null}">
			<a class="flex-sm-fill text-sm-center nav-link" href="http://localhost:5086/Ballet_EC/userCreate">新規</a>
			<a class="flex-sm-fill text-sm-center nav-link" href="http://localhost:5086/Ballet_EC/login">LogIn</a>
		</c:if>

        <form class="form-inline" method="post" action="itemSearch">
          <input class="form-control mr-sm-2" name="search" type="search" placeholder="Search" aria-label="Search">
          <button class="btn btn-outline-primary my-2 my-sm-0" type="submit">Search</button>
        </form>
      </div>
    </nav>
  </div>

</body>
</html>
