<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="users">

    <h2>Informacion de Usuario</h2>

	<spring:url value="/users/{username}/edit" var="editUrl">
        <spring:param name="username" value="${user.username}"/>
    </spring:url>
    <table class="table table-striped">
        <tr>
            <th>Usuario</th>
            <td><b><c:out value="${user.username}"/></b></td>
        </tr>
        <tr>
            <th>Contraseña</th>
            <td><c:out value="${user.password}"/></td>
        </tr>
        <tr>
        <tr>
            <th>Telefono</th>
            <td><b><c:out value="${user.telefono}"/></b></td>
        </tr>
        <tr>
            <th>DNI</th>
            <td><c:out value="${user.dni}"/></td>
        </tr>
  		<h3>Actividades</h3>
        <c:forEach var="actividad" items="${user.actividades}">

            <tr>
                <td valign="top">
                    <dl class="dl-horizontal">
                        <dt>Nombre</dt>
                        <dd><c:out value="${actividad.nombre}"/></dd>
                    </dl>
                </td>
          </c:forEach>
    </table>
    <a href="${fn:escapeXml(editUrl)}" class="btn btn-default">Editar Usuario</a>
    <br/>
    <br/>
    <br/>

</petclinic:layout>