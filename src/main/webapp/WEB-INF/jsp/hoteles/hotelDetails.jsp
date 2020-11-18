<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<petclinic:layout pageName="hoteles">

    <h2>Información sobre Hotel</h2>

	<spring:url value="/hoteles/{hotelId}/edit" var="editUrl">
        <spring:param name="hotelId" value="${hotel.id}"/>
    </spring:url>
    <table class="table table-striped">
        <tr>
            <th>Nombre</th>
            <td><b><c:out value="${hotel.nombre}"/></b></td>
        </tr>
        <tr>
            <th>Direccion</th>
            <td><c:out value="${hotel.direccion}"/></td>
        </tr>
        <tr>
            <th>Provincia</th>
            <td><c:out value="${hotel.provincia}"/></td>
        </tr>
        <tr>
            <th>Estrellas</th>
            <td><c:out value="${hotel.estrellas}"/></td>
        </tr>
        <tr>
            <th>Telefono</th>
            <td><c:out value="${hotel.telefono}"/></td>
        </tr>
    </table>
  
    <sec:authorize access="hasAuthority('admin')">
		<a class="btn btn-default" href='<spring:url value="/hoteles/${hotel.id}/edit" htmlEscape="true"/>'>Editar hotel</a>
	</sec:authorize>
  
    <br/>
    <br/>
    <br/>

</petclinic:layout>
