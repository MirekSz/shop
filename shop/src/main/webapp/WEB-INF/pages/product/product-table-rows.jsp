<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<c:forEach var="p" items="${products}">
				<tr>
					<td>${p.id}</td>
					<td>${p.name}</td>
					<td>${p.quantity}</td>
					<td>${p.price}</td>
					<td><a href="${p.id}/delete"> <i class=" glyphicon glyphicon-remove-circle"></i></a>
					<a href="${p.id}/edit"> <i class=" glyphicon glyphicon-pencil"></i></a>
					</td>
				</tr>
			</c:forEach>