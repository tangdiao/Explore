<%@page contentType="text/html;charset=GBK"%>
<html>
<head>
<title>��������Ϸ</title>
</head>

<!-- �����Ự�������JavaBean������һ��1��100��ĳ�ʼ����� -->
<jsp:useBean id="cr" scope="session" class="exec.CRandom">
	<jsp:setProperty name="cr" property="maxNumber" value="100" />
</jsp:useBean>

<!-- �����Ự����ʾ��ϢJavaBean����ʼ��ʾ��ϢΪ"��ӭ��!" -->
<jsp:useBean id="ci" scope="session" class="exec.CInfo">
	<jsp:setProperty name="ci" property="info" value="��ӭ��!" />
</jsp:useBean>


<body>
<!-- ��ʾ��ʾ��Ϣ -->
<jsp:getProperty name="ci" property="info" />
<br>
<!-- ��������ı����� -->
<form method="POST" action="Action">
<p>�����֣�<input type="text" name="guessNumber" size="20"></p>
<input type="submit" value="��¼" name="B1"></form>
</body>
</html>
