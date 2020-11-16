<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="vuelos">
    <h2>
        <c:if test="${vuelo['new']}">Añadir </c:if> Vuelo
    </h2>
    <form:form modelAttribute="vuelos" class="form-horizontal" id="add-agenact-form">
        <div class="form-group has-feedback">
            <petclinic:inputField label="Origen" name="origen"/>
            <petclinic:inputField label="Destino" name="destino"/>
            <petclinic:inputField label="Precio" name="precio"/>
            <petclinic:inputField label="Fecha de ida" name="fechaIda"/>
            <petclinic:inputField label="Fecha de vuelta" name="fechaVuelta"/>
            <petclinic:inputField label="Número de billetes" name="billetes"/>

        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <c:choose>
                    <c:when test="${vuelo['new']}">
                        <button class="btn btn-default" type="submit">Añadir Vuelo</button>
                    </c:when>
                    <c:otherwise>
                        <button class="btn btn-default" type="submit">Editar Vuelo</button>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </form:form>
</petclinic:layout>
