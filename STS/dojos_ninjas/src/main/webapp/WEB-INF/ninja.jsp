<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Ninja</title>
</head>
<body>

    <h1>New Ninja</h1>
        <form:form action="/ninjas/new" method="POST" modelAttribute="newNinja">
        
        <div>
        <form:label path="dojo">Dojo:</form:label>
       <form:select path="dojo">
         <c:forEach var="eachDojo" items="${dojoList}">
             <form:option value="${eachDojo.id}">${eachDojo.name}</form:option>
         </c:forEach>
       </form:select> 
        <form:errors path="dojo"/>     
    	</div>
            	
    	<div>
       <form:label path="firstName">firstName:</form:label>
       <form:errors path="firstName"/>
       <form:input path="firstName"/>
        
    	</div>
    	
        <div>
       <form:label path="lastName">lastName:</form:label>
       <form:errors path="lastName"/>
       <form:input path="lastName"/>
        
    	</div>
    	
    	<div>
       <form:label path="age">Age:</form:label>
       <form:errors path="age"/>
       <form:input path="age"/>
        
    	</div>

           
       <button type="submit">Create</button>
 
        </form:form>

</body>
</html>