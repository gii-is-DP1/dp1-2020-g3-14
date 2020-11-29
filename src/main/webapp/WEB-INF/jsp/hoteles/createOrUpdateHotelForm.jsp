<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="hoteles">
    <h2>
        <c:if test="${hotel['new']}">Añadir </c:if> Hotel
    </h2>
    <form:form modelAttribute="hoteles" class="form-horizontal" id="add-hotel-form">
        <div class="form-group has-feedback">
            <petclinic:inputField label="Direccion" name="direccion"/>
            <petclinic:inputField label="Estrellas" name="estrellas"/>
            <petclinic:inputField label="Nombre" name="nombre"/>
            <petclinic:inputField label="Precio" name="precio"/>
            <petclinic:inputField label="Provincia" name="provincia"/>     
            <petclinic:inputField label="Telefono" name="telefono"/>

        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <c:choose>
                    <c:when test="${hotel['new']}">
                        <button class="btn btn-default" type="submit">Añadir Hotel</button>
                    </c:when>
                    <c:otherwise>
                        <button class="btn btn-default" type="submit">Guardar Hotel</button>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </form:form>
</petclinic:layout>
