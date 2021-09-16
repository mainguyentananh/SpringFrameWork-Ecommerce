<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h1 class="h3 mb-0 text-gray-800">Quản Lý Thể Loại Sách</h1>
</div>
<hr>
<div class=container>
	<div class="row mb-2">
		<div class="col">
				<a class="btn btn-primary btn rounded-0"
					href="<c:url value="/noibo/themtheloai"  />">Thêm Thể Loại Sách</a>
		</div>
	</div>
	<div class="row">
		<div class="col">
			<table class="table table-hover text-center">
				  <thead class="bg-dark text-white">
				    <tr>
				      <th scope="col">Mã Số</th>
				      <th scope="col">Thể Loại</th>
				      <th scope="col">Chỉnh Sửa</th>
				      <th scope="col">Xóa</th>
				    </tr>
				  </thead>
				  <tbody class="text-dark">
				    <c:forEach items="${l_theLoaiSach}" var="s">
				    <tr>
				     	 <td>${s.id}</td>
				     	 <td>${s.tenLoaiHang}</td>
				     	 <td><a href="<c:url value="/noibo/theloaisach/sua/${s.id}"/>" class="btn btn-outline-dark btn-sm" ><i class="fas fa-edit"></i></a></td>
				     	 <td><a href="<c:url value="/noibo/theloaisach/xoa/${s.id}"/>" class="btn btn-outline-danger btn-sm" ><i class="fas fa-trash-alt"></i></a></td>
					</tr>
					</c:forEach>
				    
				 
				  </tbody>
			</table>
		</div>
		</div>
</div>