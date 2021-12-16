<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<base href="${pageContext.request.contextPath}/">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>会员注册</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script src="js/jquery.validate.min.js"></script>
<script src="js/additional-methods.min.js"></script>
<!-- 引入自定义css文件 style.css -->
<link rel="stylesheet" href="css/style.css" type="text/css" />
<!-- 引入自定义js文件 register.js -->
<script src="js/register.js"></script>
<style>
body {
	margin-top: 20px;
	margin: 0 auto;
}

.carousel-inner .item img {
	width: 100%;
	height: 300px;
}

font {
	color: #3164af;
	font-size: 18px;
	font-weight: normal;
	padding: 0 10px;
}

.error{
	color: #ff5555;
	font-size: 8px;
}
</style>
</head>
<body>

	<!-- 引入header.jsp -->
	<jsp:include page="/header.jsp"></jsp:include>

	<div class="container"
		style="width: 100%; background: url('image/regist_bg.jpg');">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8"
				style="background: #fff; padding: 40px 80px; margin: 30px; border: 7px solid #ccc;">
				<font>会员注册</font>USER REGISTER
				<form class="form-horizontal" style="margin-top: 5px;" id="regFrm" action="register.do">
					<div class="form-group">
						<label for="userName" class="col-sm-2 control-label">用户名</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="userName" name="userName"
								placeholder="请输入用户名">
						</div>
					</div>
					<div class="form-group">
						<label for="password" class="col-sm-2 control-label">密码</label>
						<div class="col-sm-6">
							<input type="password" class="form-control" id="password" name="password"
								placeholder="请输入密码">
						</div>
					</div>
					<div class="form-group">
						<label for="confirmpwd" class="col-sm-2 control-label">确认密码</label>
						<div class="col-sm-6">
							<input type="password" class="form-control" id="confirmpwd" name="confirmpwd"
								placeholder="请输入确认密码">
						</div>
					</div>
					<div class="form-group">
						<label for="email" class="col-sm-2 control-label">Email</label>
						<div class="col-sm-6">
							<input type="email" class="form-control" id="email" name="email"
								placeholder="Email">
						</div>
					</div>
					<div class="form-group">
						<label for="telephone" class="col-sm-2 control-label">tel</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="telephone" name="telephone"
								   placeholder="Telephone">
						</div>
					</div>
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">姓名</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="name" name="name"
								placeholder="请输入姓名">
						</div>
					</div>
					<div class="form-group opt">
						<label for="sex1" class="col-sm-2 control-label">性别</label>
						<div class="col-sm-6">
							<label class="radio-inline"> <input type="radio"
								name="sex" id="sex1" value="option1">
								男
							</label> <label class="radio-inline"> <input type="radio"
								name="sex" id="sex2" value="option2">
								女
							</label>
						</div>
					</div>
					<div class="form-group">
						<label for="birthday" class="col-sm-2 control-label">出生日期</label>
						<div class="col-sm-6">
							<input type="date" id="birthday" class="form-control" name="birthday">
						</div>
					</div>

					<div class="form-group">
						<label for="code" class="col-sm-2 control-label">验证码</label>
						<div class="col-sm-3">
							<input type="text" id="code" class="form-control">

						</div>
						<div class="col-sm-2">
							<img src="./image/captcha.jhtml" />
						</div>

					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<input type="submit" width="100" value="注册" name="submit"
								style="background: url('./images/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0); height: 35px; width: 100px; color: white;">
							<span style="color: #ff5555;font-size: 8px">${regErrMsg}</span>
						</div>
					</div>
				</form>
			</div>

			<div class="col-md-2"></div>

		</div>
	</div>

	<!-- 引入footer.jsp -->
	<jsp:include page="/footer.jsp"></jsp:include>

</body>
</html>




