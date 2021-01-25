<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<petclinic:layout pageName="reservaVuelos">

    <h2>Información sobre las reservas de tu vuelo</h2>

    <table class="table table-striped">
        <tr>
            <th>Fecha de la reserva</th>
            <td><b><c:out value="${reservaVuelo.fechaReserva}"/></b></td>
        </tr>
        <tr>
            <th>Fecha de entrada</th>
            <td><c:out value="${reservaVuelo.entrada}"/></td>
        </tr>
        <tr>
            <th>Fecha de salida</th>
            <td><c:out value="${reservaVuelo.salida}"/></td>
        </tr>
        <tr>
            <th>Precio de la reserva</th>
            <td><c:out value="${reservaVuelo.precioFinal}"/> euros</td>
        </tr>
	</table>
  <table class="table table-striped">
  <h3>Información del Vuelo</h3>
			<tr>
                <td valign="top">
                    <dl class="dl-horizontal">
                        <dt>Origen</dt>
                        <dd><c:out value="${reservaVuelo.vuelo.origen}"/></dd>
                        <dt>Destino</dt>
                        <dd><c:out value="${reservaVuelo.vuelo.destino}"/></dd>
                        <dt>Precio</dt>
                        <dd><c:out value="${reservaVuelo.vuelo.precio}"/></dd>
                        <dt>User</dt>
                        <dd><c:out value="${reservaVuelo.user.username}"/></dd>
                         <dt>Compañia Aerea</dt>
                        <dd><c:out value="${reservaVuelo.vuelo.compVuelo}"/></dd>
                        
                    </dl>
                </td>
			</tr>
  </table>
    <br/>
    <br/>
    <br/>
	<a class="btn btn-default" href='<spring:url value="/vuelos" htmlEscape="true"/>'>Volver a los vuelos</a>

</petclinic:layout>
