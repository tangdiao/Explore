<%@page contentType="text/html;charset=GBK"%>
<html>
<head>
<title>猜数字游戏</title>
</head>

<!-- 创建会话级随机数JavaBean，生成一个1到100间的初始随机数 -->
<jsp:useBean id="cr" scope="session" class="exec.CRandom">
	<jsp:setProperty name="cr" property="maxNumber" value="100" />
</jsp:useBean>

<!-- 创建会话级提示信息JavaBean，初始提示信息为"欢迎您!" -->
<jsp:useBean id="ci" scope="session" class="exec.CInfo">
	<jsp:setProperty name="ci" property="info" value="欢迎您!" />
</jsp:useBean>


<body>
<!-- 显示提示信息 -->
<jsp:getProperty name="ci" property="info" />
<br>
<!-- 输入猜数的表单界面 -->
<form method="POST" action="Action">
<p>猜数字：<input type="text" name="guessNumber" size="20"></p>
<input type="submit" value="登录" name="B1"></form>
</body>
</html>
