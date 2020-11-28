<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>
<petclinic:layout pageName="vuelos">
    
    <jsp:body>
    <h2>
        <c:if test="${actividades['new']}">A�adir </c:if> Actividad
    </h2>
    <form:form modelAttribute="actividades" class="form-horizontal" id="add-actividad-form">
        <div class="form-group has-feedback">
        	<petclinic:inputField label="Nombre de la actividad" name="nombre"/>
        	<petclinic:inputField label="Opini�n" name="opinion"/>
        	<petclinic:inputField label="Valoraci�n" name="valoracion"/>
        	<petclinic:inputField label="Direcci�n" name="direccion"/>
            <petclinic:inputField label="Precio" name="precio"/>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <c:choose>
                    <c:when test="${actividades['new']}">
                        <button class="btn btn-default" type="submit">A�adir Actividad</button>
                    </c:when>
                    <c:otherwise>
                        <button class="btn btn-default" type="submit">Editar Actividad</button>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </form:form>
    </jsp:body>
</petclinic:layout>