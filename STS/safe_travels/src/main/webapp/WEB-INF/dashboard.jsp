<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Insert title here</title>
</head>
<body>
    <h1>Save Travels</h1>

    <table class="table">
        <tr>
        	<th>Expense</th>
        	<th>Vendor</th> 
        	<th>Amount</th> 
        	<th>Action</th>      
        </tr>
        <c:forEach var="eachExpense" items="${allExpenses}">
        <tr>
        	<td><a href="expenses/${eachExpense.id}">${eachExpense.expenseName}</a></td>
        	<td>${eachExpense.vendor}</td>  
        	<td>${eachExpense.amount}</td> 
        	<td>
        	<a href="expenses/edit/${eachExpense.id}">Edit</a>
        	<form action="/expenses/delete/${eachExpense.id}" method="post">
        	<input type="hidden" name="_method" value="delete"/>
        	<button>Delete</button>
        	</form>
        	
        	</td>          
        </tr>
        </c:forEach>
    </table>
    
    <h1>Add an expense</h1>
        <form:form action="/expenses/new" method="POST" modelAttribute="newExpense">
        
            	
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