<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="hotelSolicitud">

    <h2>Su solicitud de inscripci�n se ha mandado correctamente</h2>
    
    
<form:form  modelAttribute="hoteles" action="/" method="get" class="form-horizontal"
               id="search-hoteles-form" >
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">Volver</button>
            </div>
        </div>
</form:form>    
</petclinic:layout>
