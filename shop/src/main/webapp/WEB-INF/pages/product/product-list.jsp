<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/pages/layout/head.jsp"%>
<c:if test="${operationDone}">
	<div class="alert alert-success" role="alert">
		<button type="button" class="close" data-dismiss="alert"
			aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
		Operacja zakonczona sukcesem
	</div>
</c:if>
<a href="new" class="btn btn-primary "> <i
	class=" glyphicon glyphicon-plus"></i> Add new product
</a>
<div class="col-xs-4 pull-right">
	<form>
		<div class="input-group">
			<input type="text" name="query" class="form-control searcher"
				placeholder="Wyszukaj..."> <span class="input-group-btn">
				<button class="btn btn-default" type="button">
					<i class="glyphicon glyphicon-send" style="height: 20px"></i>
				</button>
			</span>
		</div>
	</form>
</div>




<table class="table table-striped table-hover">
	<thead>
		<tr>
			<td>Id</td>
			<td><spring:message code="product.name" /> </td>
			<td>Quantity</td>
			<td>Price</td>
			<td>Actions</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="product" items="${products}">
			<tr>
				<td>${product.id}</td>
				<td>${product.name}</td>
				<td>${product.quantity}</td>
				<td>${product.price}</td>
				<td><a href="${product.id}/delete"><i
						class="glyphicon glyphicon-remove-circle"></i></a> <a
					href="${product.id}/edit"><i class="glyphicon glyphicon-pencil"></i></a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<%@ include file="/WEB-INF/pages/layout/footer.jsp"%>

