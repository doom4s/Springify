<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Measurements</title>
</head>
<body>
	<h3>
		Sensors for
		<c:out value="${sensorType}" />
		sensor on device
		<c:out value="${serialNo}" />
		are :
	</h3>
	<br>
	<c:forEach items="${measurements}" var="measurement">
		<c:out value="${measurement}" />
	</c:forEach>
</body>
</html>