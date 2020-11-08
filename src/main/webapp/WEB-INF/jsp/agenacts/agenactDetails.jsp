<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="agenact">

    <h2>Informaci�n de Agencia de Actividades</h2>


    <table class="table table-striped">
        <tr>
            <th>Nombre</th>
            <td><b><c:out value="${agenacts.nombre}"/></b></td>
        </tr>
        <tr>
            <th>Sede</th>
            <td><c:out value="${agenacts.sede}"/></td>
        </tr>
        <tr>
            <th>Telefono</th>
            <td><c:out value="${agenacts.telefono}"/></td>
        </tr>
    </table>

    <spring:url value="/agenacts/{agenactId}/edit" var="editUrl">
        <spring:param name="agenactId" value="${agenacts.id}"/>
    </spring:url>
    <a href="${fn:escapeXml(editUrl)}" class="btn btn-default">Editar Agencia</a>

    <br/>
    <br/>
    <br/>

</petclinic:layout>
