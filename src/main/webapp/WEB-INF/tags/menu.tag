<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!--  >%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%-->
<%@ attribute name="name" required="true" rtexprvalue="true"
	description="Name of the active menu: home, owners, vets or error"%>

<nav class="navbar navbar-default" role="navigation">
	<div class="container">
		<div class="navbar-collapse collapse" id="main-navbar">
			<ul class="nav navbar-nav">

				<petclinic:menuItem active="${name eq 'home'}" url="/"
					title="home page">
					<span class="glyphicon glyphicon-home" aria-hidden="true"></span>
					<span>Home</span>
				</petclinic:menuItem>

				<petclinic:menuItem active="${name eq 'compvuelos'}" url="/compvuelos/find"
					title="find compvuelos">
					<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
					<span>Compañia de Vuelos</span>
				</petclinic:menuItem>
				
				<petclinic:menuItem active="${name eq 'hoteles'}" url="/hoteles/find"
					title="find hoteles">
					<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
					<span>Hoteles</span>
				</petclinic:menuItem>
				
				<petclinic:menuItem active="${name eq 'agenacts'}" url="/agenacts/find"
					title="find agenacts">
					<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
					<span>Agencias de Eventos</span>
				</petclinic:menuItem>
				
				<petclinic:menuItem active="${name eq 'vuelos'}" url="/vuelos/find"
					title="vuelos">
					<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
					<span>Vuelos</span>
				</petclinic:menuItem>
				<petclinic:menuItem active="${name eq 'actividades'}" url="/actividades/find"
					title="actividades">
					<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
					<span>Actividades</span>
				</petclinic:menuItem>
			</ul>

			<ul class="nav navbar-nav navbar-right">
				<sec:authorize access="!isAuthenticated()">
					<li><a href="<c:url value="/login" />">Login</a></li>
					<li><a href="<c:url value="/users/new" />">Register</a></li>
				</sec:authorize>
				<sec:authorize access="isAuthenticated()">
					<li class="dropdown"><a href="#" class="dropdown-toggle"

						data-toggle="dropdown"> <span class="glyphicon glyphicon-user"></span>Â 
							<strong><sec:authentication property="name" /></strong> <span
							class="glyphicon glyphicon-chevron-down"></span>
					</a>
						<ul class="dropdown-menu">
							<li>
								<div class="navbar-login">
									<div class="row">
										<div class="col-lg-4">
											<p class="text-center">
												<span class="glyphicon glyphicon-user icon-size"></span>
											</p>
										</div>
										<div class="col-lg-8">
											<p class="text-left">
												<strong><sec:authentication property="name" /></strong>
											</p>
											<p class="text-left">
												<a href="<c:url value="/logout" />"
													class="btn btn-primary btn-block btn-sm">Logout</a>
											</p>
										</div>
									</div>
								</div>
							</li>
							<li class="divider"></li>
 							
                            <li> 
								<div class="navbar-login navbar-login-session">
									<div class="row">
										<div class="col-lg-12">
											<p>
												<a href="users/" class="btn btn-primary btn-block">My Profile</a>
												<a href="#" class="btn btn-danger btn-block">Change
													Password</a>
											</p>
										</div>
									</div>
								</div>
							</li>

						</ul></li>
				</sec:authorize>
			</ul>
		</div>
	</div>
</nav>