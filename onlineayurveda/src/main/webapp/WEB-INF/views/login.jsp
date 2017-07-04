<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!-- stack overflow -->

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!--
author: W3layouts
author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html>


<head>
<title>E-Ayurveda - ${title}</title>


<style type="text/css">
/*custom css*/



.dataTableImg{

height: 100px;
width: 100px;

}

.adminDataTableImg {
	width: 50px;
	height: 50px;
}

.switch {
	width: 50px;
	height: 30px;
	position: relative;
	display: inline-block;
}

.switch input {
	display: none;
}

.slider {
	position: absolute;
	top: 0;
	bottom: 0;
	right: 0;
	left: 0;
	cursor: pointer;
	background-color: #ccc;
	border-radius: 30px;
	transition: .5s;
}

.slider:before {
	position: absolute;
	width: 20px;
	height: 20px;
	content: "";
	bottom: 5px;
	left: 5px;
	background-color: #fff;
	border-radius: 50%;
	transition: .5s;
}

input:checked+.slider {
	background-color: #1863E6;
}

input:checked+.slider:before {
	transform: translateX(20px);
}

.switch {
	width: 50px;
	height: 30px;
	position: relative;
	display: inline-block;
}


</style>




<script>
	window.menu = '${title}';
	window.contextRoot = '${contextRoot}'
</script>

<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Grocery Store Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript">
	

	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } 




</script>



<!-- //for-mobile-apps -->
<link href="${css}/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />

<link href="${css}/bootstrap.min.css" rel="stylesheet" type="text/css"
	media="all" />

<link href="${css}/bootstrap-theme.css" rel="stylesheet"
	type="text/css" media="all" />

<link href="${css}/bootstrap-theme.min.css" rel="stylesheet"
	type="text/css" media="all" />


<!-- font-awesome icons -->
<link href="${css}/font-awesome.css" rel="stylesheet" type="text/css"
	media="all" />
<!-- //font-awesome icons -->

<!-- myapp.css -->
<link href="${css}/myapp.css" rel="stylesheet" type="text/css" />

<!-- dataTable Bootstrap -->
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet"
	type="text/css" media="all" />
<!-- js -->
<script src="${js}/jquery-1.11.1.min.js"></script>
<!-- //js -->

<link
	href='//fonts.googleapis.com/css?family=Ubuntu:400,300,300italic,400italic,500,500italic,700,700italic'
	rel='stylesheet' type='text/css'/>

<link
	href='//fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic'
	rel='stylesheet' type='text/css'/>

<!-- start-smoth-scrolling -->
<script type="text/javascript" src="${js}/move-top.js"></script>

<script type="text/javascript" src="${js}/easing.js"></script>

<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event) {
			event.preventDefault();
			$('html,body').animate({
				scrollTop : $(this.hash).offset().top
			}, 1000);
		});
	});
</script>
<!-- start-smoth-scrolling -->



</head>



<body>

<div class="wrapper">

	<!-- header and navbar is loading -->
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<a class="navbar-brand" href="${contextRoot}/home">Online
					Ayurveda</a>
			</div>
		</div>
	</nav><br/><br/><br/>

		<div class="content">

			<div class="container">
			
				<c:if test="${not empty message}">
					<%-- this will be displayed if the credentials are wrong --%>

					<div class="row">

						<div class="col-md-offset-3 col-md-6">

							<div class="alert alert-danger">${message}</div>

						</div>
					</div>
				</c:if>


				<%-- this will be displayed only when user has logged out --%>

				<div class="row">

					<div class="col-md-offset-3 col-md-6">

						<div class="alert alert-success">${logout}</div>

					</div>
				</div>




				<div class="row">

					<div class="col-md-offset-3 col-md-6">

						<div class="panel panel-primary">

							<div class="panel-heading">
								<h4>Login</h4>
							</div>

							<div class="panel-body">
								<form action="${contextRoot}/login" method="POST"
									class="form-horizontal" id="loginForm">
									<div class="form-group">
										<label for="username" class="col-md-4 control-label">Email:
										</label>
										<div class="col-md-8">
											<input type="text" name="username" id="username"
												class="form-control" />
										</div>
									</div>
									<div class="form-group">
										<label for="password" class="col-md-4 control-label">Password:
										</label>
										<div class="col-md-8">
											<input type="password" name="password" id="password"
												class="form-control" />
										</div>
									</div>
									<div class="form-group">
										<div class="col-md-offset-4 col-md-8">
											<input type="submit" value="Login" class="btn btn-primary" />
											 <input type="hidden" name="${_csrf.parameterName}"
												value="${_csrf.token}" /> 
										</div>
									</div>
								</form>

							</div>
							<div class="panel-footer">
								<div class="text-right">
									New User - <a href="${contextRoot}/register">Register Here</a>
								</div>
							</div>
						</div>

					</div>

				</div>

			</div>

		</div>





	<!-- footer comes here-->
	<%@include file="./shared/footer.jsp"%>
	<!-- //footer -->

	<!-- jquery -->
	<script src="${js}/jquery.js" type="text/javascript"></script>
	
	<!-- JQuery validator -->
	<script src="${js}/jquery.validate.js" type="text/javascript"></script>


	<!-- Bootstrap Core JavaScript -->
	<script src="${js}/bootstrap.min.js"></script>


	<!-- self created js file  -->
	<script src="${js}/myapp.js"></script>


	<!-- script-for sticky-nav -->
	<script>
		$(document).ready(function() {
			var navoffeset = $(".agileits_header").offset().top;
			$(window).scroll(function() {
				var scrollpos = $(window).scrollTop();
				if (scrollpos >= navoffeset) {
					$(".agileits_header").addClass("fixed");
				} else {
					$(".agileits_header").removeClass("fixed");
				}
			});

		});
	</script>



	<!-- //script-for sticky-nav -->

	<script>
		$(document).ready(function() {
			$(".dropdown").hover(function() {
				$('.dropdown-menu', this).stop(true, true).slideDown("fast");
				$(this).toggleClass('open');
			}, function() {
				$('.dropdown-menu', this).stop(true, true).slideUp("fast");
				$(this).toggleClass('open');
			});
		});
	</script>


	<!-- here stars scrolling icon -->
	<script type="text/javascript">
		$(document).ready(function() {
			/*
				var defaults = {
				containerID: 'toTop', // fading element id
				containerHoverID: 'toTopHover', // fading element hover id
				scrollSpeed: 1200,
				easingType: 'linear' 
				};
			 */

			$().UItoTop({
				easingType : 'easeOutQuart'
			});

		});
	</script>
	<!-- //here ends scrolling icon -->
	<script src="${js}/minicart.min.js"></script>
	<script>
		// Mini Cart
		paypal.minicart.render({
			action : '#'
		});

		if (~window.location.search.indexOf('reset=true')) {
			paypal.minicart.reset();
		}
	</script>
	</div>

</body>
</html>