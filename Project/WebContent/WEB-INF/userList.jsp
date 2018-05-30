<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html　lang="ja">
<head>

	<!-- Required meta tags -->
   <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

   <!-- Bootstrap CSS -->
      <link rel="stylesheet" href="./css/bootstrap.min.css">
      <link rel="stylesheet" href="./css/original/common2.css">


	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>ユーザ一覧</title>

</head>

<body>
  <div class="container">

  <br>
  <br>
    <p><center><font size="6">ユーザー一覧</font></center></p>

  <div class="input-area2">
    <form method="post" action="userList">
      <div class="form-group row">
        <label for="inputLoginId" class="col-sm-4 col-form-label">ログインID</label>
        <div class="col-sm-8">
          <input type="text" class="form-control" name="loginId" id="inputLoginId" placeholder="">
        </div>
      </div>
      <div class="form-group row">
        <label for="inputUsername" class="col-sm-4 col-form-label">ユーザー名</label>
        <div class="col-sm-8">
          <input type="text" class="form-control" name="username" id="inputUsername" placeholder="">
        </div>
      </div>
      <div class="form-inline form-group">
        <div class="form-group">
          <label for="date1">生年月日&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;</label>
          <input id="date1" type="date" name="birthdate1" class="form-control"placeholder="年/月/日"/>
        </div>
        <div class="form-group">
          <label for="date2">　〜　</label>
          <input id="date2" type="date" name="birthdate2" class="form-control"placeholder="年/月/日" />
        </div>
      </div>
      <br>
      <center><button type="submit" class="btn btn-info btn-lg">　検索　</button></center>
　   </form>
    </div>

    <br>
    <br>
    <table class="table table-bordered">
    <thead>
      <tr class="bg-info text-white">
        <th><center>ログインID</center></th>
        <th><center>ユーザー名</center></th>
        <th><center>生年月日</center></th>
        <th><center>ユーザー区分</center></th>
        <th>　　　　</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach var="add" items="${userList}">
      <tr>
        <th><center>${add.loginId}</center></th>
        <td><center>${add.name}</center></td>
        <td><center>${add.birthDate}</center></td>
        <td><center>${add.userType}</center></center></td>
        <td><center>
          <a href="userDataMaster?id=${add.id}" class="btn btn-outline-info">詳細</a>
          <a href="userUpdataMaster?id=${add.id}" class="btn btn-outline-info">更新</a>
          <a href="userDelete?id=${add.id}" class="btn btn-outline-info">削除</a>
        </center></td>
      </tr>
      </c:forEach>

      </tr>
    </tbody>
  </table>
  <br>
  <div align="right"><a href="userData" class="btn btn-outline-info">戻る</a></div>
  <br><br>




</div>
</body>
</html>
