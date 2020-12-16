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
            <td><c:out value="${user.telefono}"/></td>
        </tr>
        <tr>
            <th>DNI</th>
            <td><c:out value="${user.dni}"/></td>
        </tr>
        </table>
        <table class="table table-striped">
  		<h3>Actividades</h3>
        <c:forEach var="actividad" items="${user.actividades}">
            <tr>
                <td valign="top">
                    <dl class="dl-horizontal">
                        <dt>Nombre</dt>
                        <dd><c:out value="${actividad.nombre}"/></dd>
                        <dt>Opinion</dt>
                        <dd><c:out value="${actividad.opinion}"/></dd>
                        <dt>Valoracion</dt>
                        <dd><c:out value="${actividad.valoracion}"/></dd>
                        <dt>Direccion</dt>
                        <dd><c:out value="${actividad.direccion}"/></dd>
                        <dt>Precio</dt>
                        <dd><c:out value="${actividad.precio}"/></dd>
                    </dl>
                </td>
          </c:forEach>
    </table>
    <a href="${fn:escapeXml(editUrl)}" class="btn btn-default">Editar Usuario</a>
    <br/>
    <br/>


</petclinic:layout>