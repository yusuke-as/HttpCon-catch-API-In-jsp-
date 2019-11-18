<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.BMI"%>
<%
BMI bmi=(BMI)request.getAttribute("bmi");
String height=bmi==null ? "":bmi.getHeight()+"";
String weight=bmi==null ? "":bmi.getWeight()+"";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/httpJsonBMI/Calc" method="post">
		height(cm):<input type="number" step="0.1" name="height" placeholder="enter height(cm)..." value=<%=height %>><br>
		weight(kg):<input type="number" step="0.1" name="weight" placeholder="enter weight(kg)..." value=<%=weight %>><br>
		<button type="submit">send</button>
 	</form>
 	<p>
	<%if(bmi !=null){ %>
		Height:<%=bmi.getHeight() %><br>
		<%=bmi.getWeight() %><br>
		<%=bmi.getBmi() %><br>
	</p>
		<img src="<%=bmi.getResult() %>" height=300>
	<%} %>
</body>
</html>