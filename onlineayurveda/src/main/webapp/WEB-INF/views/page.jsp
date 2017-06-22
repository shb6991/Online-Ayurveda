<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!-- stack overflow -->

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath }" />

<!--
author: W3layouts
author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html>
<head>
<title>E-Ayurveda - ${title }</title>



<script>
	window.menu = '${title }';
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
<link href="${css }/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />

<link href="${css }/bootstrap.min.css" rel="stylesheet" type="text/css"
	media="all" />

<link href="${css }/bootstrap-readable-theme.css" rel="stylesheet"
	type="text/css" media="all" />



<!-- dataTable Bootstrap -->
<link href="${css }/dataTable.bootstrap.css" rel="stylesheet"
	type="text/css" media="all" />

<link href="${css }/myapp.css" rel="stylesheet" type="text/css"
	media="all" />
<!-- font-awesome icons -->
<link href="${css }/font-awesome.css" rel="stylesheet" type="text/css"
	media="all" />
<!-- //font-awesome icons -->
<!-- js -->
<script src="${js }/jquery-1.11.1.min.js"></script>
<!-- //js -->
<link
	href='//fonts.googleapis.com/css?family=Ubuntu:400,300,300italic,400italic,500,500italic,700,700italic'
	rel='stylesheet' type='text/css'>
<link
	href='//fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic'
	rel='stylesheet' type='text/css'>
<!-- start-smoth-scrolling -->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
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
	<!-- header and navbar is loading -->
	<%@include file="./shared/navbar.jsp"%>
	<!-- //header and navbar -->

	<!-- page content -->


	<!-- home page loading -->
	<c:if test="${userClickHome==true }">
		<%@include file="home.jsp"%>
	</c:if>
	<!-- //home -->

	<!-- this will work when about us page will click -->
	<c:if test="${userClickAbout==true }">
		<%@include file="about.jsp"%>
	</c:if>
	<!-- //about -->

	<!-- this will work when contact us page will click -->
	<c:if test="${userClickContact==true }">
		<%@include file="contact.jsp"%>
	</c:if>
	<!-- //contact -->

	<!-- this will work when list product page will click contact-->
	<c:if
		test="${userClickAllProducts==true or userClickCategoryProducts==true}">
		<%@include file="listProducts.jsp"%>
	</c:if>
	<!-- //contact -->


	<!-- this will work when user will click show products-->
	<c:if test="${userClickShowProduct==true}">
		<%@include file="singleProduct.jsp"%>
	</c:if>
	<!-- //contact -->



	<!-- footer comes here-->
	<%@include file="./shared/footer.jsp"%>
	<!-- //footer -->

	<!-- jquery -->

	<script src="${js}/jquery.js" type="text/javascript"></script>


	<!-- Bootstrap Core JavaScript -->
	<script src="${js }/bootstrap.min.js"></script>

	<!-- DataTable Plugin -->
	<script src="${js}/jquery.dataTables.js" type="text/javascript"></script>

	<!-- DataTable bootstrap -->
	<script src="${js}/dataTables.bootstrap.js" type="text/javascript"></script>

	<!-- self created js file  -->
	<script src="${js }/myapp.js"></script>


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
	<script src="js/minicart.min.js"></script>
	<script>
		// Mini Cart
		paypal.minicart.render({
			action : '#'
		});

		if (~window.location.search.indexOf('reset=true')) {
			paypal.minicart.reset();
		}
	</script>

</body>
</html>