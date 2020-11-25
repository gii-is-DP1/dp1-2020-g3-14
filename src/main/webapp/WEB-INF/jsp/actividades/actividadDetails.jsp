<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<petclinic:layout pageName="actividades">

    <h2>Información de la Actividad</h2>

	<spring:url value="/actividades/{actividadId}/edit" var="editUrl">
        <spring:param name="actividadId" value="${actividades.id}"/>
    </spring:url>
    <table class="table table-striped">
        <tr>
            <th>Nombre</th>
            <td><b><c:out value="${actividades.nombre}"/></b></td>
        </tr>
        <tr>
            <th>Opinión</th>
            <td><c:out value="${actividades.opinion}"/></td>
        </tr>
        <tr>
            <th>Valoración</th>
            <td><c:out value="${actividades.valoracion}"/></td>
        </tr>
        <tr>
            <th>Dirección</th>
            <td><c:out value="${actividades.direccion}"/></td>
        </tr>
        <tr>
            <th>Precio</th>
            <td><c:out value="${actividades.precio}"/></td>
        </tr>
        <tr>
        	<th>Agencia</th>
        	<td><c:out value="${actividades.agenact.nombre}"/></td>
        </tr>
    </table>
    <sec:authorize access="hasAuthority('admin')">
		<a class="btn btn-default" href='<spring:url value="/actividades/${actividades.id}/edit" htmlEscape="true"/>'>Editar Actividad</a>
	</sec:authorize>
    <br/>
    <br/>
    <br/>

</petclinic:layout>
