<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Welcome</title>
</head>

<body>
<h3>Options</h3>

<s:form action="SaveReceta">
    <s:textfield key="nombre"/>
    <s:textfield key="dificultad"/>
    <s:textfield key="elaboracion"/>
    <s:submit id="save"/>
</s:form>


</body>
</html>
