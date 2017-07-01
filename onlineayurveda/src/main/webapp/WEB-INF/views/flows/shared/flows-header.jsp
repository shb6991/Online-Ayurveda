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

<%@include file="flows-navbar.jsp" %>
		