<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="users">
<head>        
    <title>validate password</title> 
    <script type="text/javascript"> 
        function test_str() { 
            var res; 
            var str = 
            	document.getElementById("pass").value; 
            var str2 = 
            	document.getElementById("password").value; 
            if (str.match(str2)) 
                res = "TRUE";
            else 
                res = "FALSE"; 
            	
        }
    </script> 
</head>

<body> 
    <h2>
        Darse de baja
    </h2>
    <form:form modelAttribute="user" class="form-horizontal" id="delete-user-form">
        <div class="form-group has-feedback">
     <input type="submit"
            value="Introduzca contraseña"
            onclick="test_str()" /> 
            <input type="text" id="password" value="${user.password}" readonly/>
			<input type="text" id="pass"/>
        </div>
    </form:form>
</body>
</petclinic:layout>
