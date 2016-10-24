<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/pages/layout/head.jsp"%>
<form:form class="form-horizontal" method="post"
	modelAttribute="product">

	<spring:bind path="name">
		<div class="form-group ${status.error ? 'has-error' : ''}">
			<label class="col-sm-2 control-label">Name</label>
			<div class="col-sm-8">
				<form:input path="name" class="form-control" />
				<form:errors path="name" class="control-label" />
			</div>
		</div>
	</spring:bind>
	<button type="submit" class="btn btn-primary pull-right">
		<i class=" glyphicon glyphicon-plus"></i> Save
	</button>
</form:form>

<%@ include file="/WEB-INF/pages/layout/footer.jsp"%>

