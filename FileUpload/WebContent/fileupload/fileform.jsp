<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="adduser.jsp" enctype="multipart/form-data"></form>
	<div class="form-group row">
	    <label class="col-form-label col-sm-2" for="file">File name</label>
	    <div class="col-sm-7">
	      <input type="text" name="image" value=""/><br>
	    </div>
	</div>
	<div class="form-group row">
		<label class="col-form-label col-sm-2" for="file">Photo</label>
	    <div class="col-sm-7">
	      <input type="file" name="photo"/><br>
	    </div>
	</div>
</form>

</body>
</html>

