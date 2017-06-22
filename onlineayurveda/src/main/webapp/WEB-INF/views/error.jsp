<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />

<c:set var="contextRoot" value="${pageContext.request.contextPath }" />

<!DOCTYPE html>
<html>
<head>
<title>E-Ayurveda - ${title }</title>

<link href="${css }/myapp.css" rel="stylesheet" type="text/css"
	media="all" />

<link href="${css }/bootstrap.min.css" rel="stylesheet" type="text/css"
	media="all" />

<link href="${css }/bootstrap-readable-theme.css" rel="stylesheet"
	type="text/css" media="all" />

</head>

<body>

	<div class="wrapper">

		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<div class="container">
				<div class="navbar-header">
					<a class="navbar-band" href="${contextRoot }/home">HOME</a>
				</div>
				<br />
			</div>
		</nav>

		<div class="content">

			<div class="container">

				<div class="row">

					<div class="col-xs-12">

						<div class="jumbotron">

							<h1>${errorTitle }</h1>
							<hr />

							<blockquote style="word-wrap:break-word">${errorDescription }</blockquote>

						</div>

					</div>

				</div>

			</div>

		</div>


	</div>

</body>
</html>