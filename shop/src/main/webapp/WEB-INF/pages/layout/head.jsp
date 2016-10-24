<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<html>
<head>
<link href="${contextPath}/public/assets/css/bootstrap.css" rel="stylesheet" />
<link href="${contextPath}/public/assets/css/style.css" rel="stylesheet" />
<link href="${contextPath}/public/assets/css/font-awesome.min.css" rel="stylesheet" />
<script type="text/javascript" src="${contextPath}/public/assets/js/jquery-2.2.4.js"></script>
<script type="text/javascript" src="${contextPath}/public/assets/auctions.js"></script>
</head>
<body>
	<div class="navbar navbar-default navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="${contextPath}"><i>Super - seller</i></a>
			</div>
			<div class="navbar-collapse collapse navbar-right">
				<ul class="nav navbar-nav">
					<li class="active"><a href="${contextPath}/product/list">Products list</a></li>
					<li><a href="${contextPath}/cart">Cart</a></li>
					<li><a href="">Logout</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
		</div>
			<br /> <br /> <br /> <br />
			<div class="container" >