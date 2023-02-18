<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

    <h1>Edit expense</h1>
    <a href="/expenses">Go back</a>
        <form:form action="/expenses/edit/${expense.id}" method="POST" modelAttribute="expense">
        <input type="hidden" name="_method" value="PUT"/>
        
            	
    	<div>
       <form:label path="expenseName">Expense Name:</form:label>
       <form:errors path="expenseName"/>
       <form:input path="expenseName"/>
        
    	</div>
    	
        <div>
       <form:label path="vendor">Vendor:</form:label>
       <form:errors path="vendor"/>
       <form:input path="vendor"/>
        
    	</div>
    	
    	<div>
       <form:label path="amount">Amount:</form:label>
       <form:errors path="amount"/>
       <form:input type="number" path="amount"/>
        
    	</div>
    	
    	<div>
       <form:label path="description">Description:</form:label>
       <form:errors path="description"/>
       <form:textarea path="description"></form:textarea>
      
        
    	</div>
           
       <button type="submit">Submit</button>
 
        </form:form>

</body>
</html>