<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/pages/layout/head.jsp"%>


<form:form class="form-horizontal" method="post" action="${contextPath}/product/new"
	modelAttribute="product">
	<form:hidden path="id"/>
	<spring:bind path="name">
	
	<div class="form-group ${status.error ? 'has-error' : ''}">
		<label class="control-label">Name</label>
		<form:input path="name" class="form-control"/>
		<form:errors path="name" class="control-label"/>
	</div>
	</spring:bind>
	<spring:bind path="description">
	<div class="form-group ${status.error ? 'has-error' : ''}">
		<label class="control-label">Description</label>
		<form:textarea path="description"  class="form-control"/>
		<form:errors path="description" class="control-label"/>
	</div>
	</spring:bind>
	<spring:bind path="quantity">
	<div class="form-group ${status.error ? 'has-error' : ''}">
		<label class="control-label">Quantity</label>
		<form:input path="quantity" class="form-control"/>
		<form:errors path="quantity" class="control-label"/>
	</div>
	</spring:bind>
	<spring:bind path="price">
	<div class="form-group ${status.error ? 'has-error' : ''}">
		<label class="control-label">Price</label>
		<form:input path="price"  class="form-control"/>
		<form:errors path="price" class="control-label"/>
	</div>
	</spring:bind>
	<button type="submit" class="btn btn-primary pull-right">
		<i class=" glyphicon glyphicon-plus"></i> Save
	</button>
</form:form>

<%@ include file="/WEB-INF/pages/layout/footer.jsp"%>

