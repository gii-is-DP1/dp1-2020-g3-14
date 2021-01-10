<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="reservasActividad">
    <h2>
        <c:if test="${reservasActividad['new']}">New </c:if> ReservaActividad
    </h2>
    <form:form modelAttribute="reservaActividad" class="form-horizontal" id="add-owner-form">
        <div class="form-group has-feedback">
            <petclinic:inputField label="fecha" name="fecha"/>
            <petclinic:inputField label="numeroTarjeta" name="numeroTarjeta"/>
            <petclinic:inputField label="cvc" name="cvc"/>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <c:choose>
                    <c:when test="${reservasActividad['new']}">
                        <button class="btn btn-default" type="submit">Add Reserva</button>
                    </c:when>
                </c:choose>
            </div>
        </div>
    </form:form>
</petclinic:layout>
