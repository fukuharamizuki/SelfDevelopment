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
	<title>ログイン画面</title>
	<jsp:include page="/baselayout/header.jsp" />
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
  <p><center><font size="7">Sign in</font></center></p>

  <div class="input-area2">
  <center>
  <form method="post" action="login">
    <div class="form-group">
      <label class="col-sm-4 col-form-label" for="formGroupExampleInput">ID</label>
      <div class="col-sm-8">
        <input type="text" class="form-control" name="loginId" id="formGroupExampleInput" placeholder="">
      </div>
    </div>
    <div class="form-group">
      <label class="col-sm-4 col-form-label" for="formGroupExampleInput2">PASSWORD</label>
      <div class="col-sm-8">
      <input type="password" class="form-control" name="password" id="formGroupExampleInput2" placeholder="">
      </div>
    </div>
    <center><button type="submit" class="btn btn-outline-info">LogIn</button></center>
  </form>
  </center>
  </div>
</div>
</body>
</html>
