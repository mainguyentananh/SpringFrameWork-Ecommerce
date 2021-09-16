<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h1 class="h3 mb-0 text-gray-800">Thêm Thể Loại Sách</h1>
</div>
<nav aria-label="breadcrumb">
			  <ol class="breadcrumb bg-light text-dark">
			     <li class="breadcrumb-item"><a href="<c:url value="/noibo/theloaisach"/>">Quản Lý Thể Loại Sách</a></li>
	   			 <li class="breadcrumb-item active" aria-current="page">Thêm Thể Loại Sách</li>
			  </ol>
</nav>
<hr>
<div class="container">
	<c:url value="/noibo/luutheloai" var="save" />
	<form:form action="${save}" method="POST" modelAttribute="loaiSachMoi">

		<div class="col-md-6 col-sm-12">
			<label class="text-dark">Thể Loại</label>
			<form:input path="tenLoaiHang" class="form-control" />
		</div>

		<div class="col-md-6 col-sm-12 mt-3">
			<button type="submit" class="btn btn-primary rounded-0 ">Thêm Thể Loại</button>
		</div>
	</form:form>
</div>