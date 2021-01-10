<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="comentariosactividad">
    <h2>
        Anadir Comentario
    </h2>
    <form:form modelAttribute="comentario" class="form-horizontal" id="add-comentarioActividad-form">
        <div class="form-group has-feedback">
            
            <petclinic:inputField label="Mensaje" name="mensaje"/>
            <petclinic:inputField label="Puntuacion" name="puntuacion"/>
           
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                        <button class="btn btn-default" type="submit">Anadir Comentario</button>        
            </div>
        </div>
    </form:form>
</petclinic:layout>
