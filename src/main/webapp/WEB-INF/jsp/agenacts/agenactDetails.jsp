<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="agenacts">

    <h2>Información de Agencia de Actividades</h2>

	<spring:url value="/agenacts/{agenactId}/edit" var="editUrl">
        <spring:param name="agenactId" value="${agenact.id}"/>
    </spring:url>
    <table class="table table-striped">
        <tr>
            <th>Nombre</th>
            <td><b><c:out value="${agenact.nombre}"/></b></td>
        </tr>
        <tr>
            <th>Sede</th>
            <td><c:out value="${agenact.sede}"/></td>
        </tr>
        <tr>
            <th>Telefono</th>
            <td><c:out value="${agenact.telefono}"/></td>
        </tr>
    </table>
    <a href="${fn:escapeXml(editUrl)}" class="btn btn-default">Editar Agencia</a>
    <br/>
    <br/>
    <br/>
<table class="table table-striped">
   <h3>Actividades</h3>
        <c:forEach var="actividades" items="${agenact.actividades}">

            <tr>
                <td valign="top">
                    <dl class="dl-horizontal">
                        <dt>Nombre</dt>
                        <dd><c:out value="${actividades.nombre}"/></dd>
                        <dt>Direccion</dt>
                        <dd><c:out value="${actividades.direccion}"/></dd>
                        <dt>Precio</dt>
                        <dd><c:out value="${actividades.precio}"/></dd>
                    </dl>
                </td>
          </c:forEach>
  </table>



</petclinic:layout>
