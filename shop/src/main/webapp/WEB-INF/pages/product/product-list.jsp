<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/pages/layout/head.jsp"%>

	<h3>Product list</h3>
<spring:message code="some.code"/>

	<a href="new" class="btn btn-primary "> <i
		class=" glyphicon glyphicon-plus"></i> Add new product
	</a>
	<div class="col-xs-4 pull-right">
		<div class="input-group">
			<input type="text" class="form-control searcher"
				placeholder="Wyszukaj..."> <span class="input-group-btn">
				<button class="btn btn-default" type="button">
					<i class="glyphicon glyphicon-send" style="height:20px"></i>
				</button>
			</span>
		</div>
	</div>
	
<c:if test="${opDone!=null}">
		<div class="alert alert-success" role="alert" >
			<span class="glyphicon 	glyphicon glyphicon-ok" aria-hidden="true"></span>
			Operacja wykonana pomyślnie
		</div>
</c:if>
	<table class="table table-hover table-striped">
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Quantity</th>
				<th>Price</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<%@ include file="/WEB-INF/pages/product/product-table-rows.jsp"%>
		</tbody>
	</table>


<%@ include file="/WEB-INF/pages/layout/footer.jsp"%>

