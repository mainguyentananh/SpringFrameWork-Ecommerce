<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description">
<meta name="author">
<title>Nội Bộ-SunShop</title>
<link rel="icon" href='<c:url value="/resources/images/logo.jpg"/>'/>
<link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">
	
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/ft/css/all.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/sb-admin-2.min.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/ft/css/fontawesome.css"/>">
</head>
<body id="page-top">

	<div id="wrapper">
		<ul
			class="navbar-nav  bg-gradient-primary sidebar sidebar-dark accordion"
			id="accordionSidebar">
			<a
				class="sidebar-brand d-flex align-items-center justify-content-center"
				href="<c:url value="/noibo/trangchu" />">
				<div class="sidebar-brand-icon">	
					<i class="fas fa-sun"></i>
					<div class="sidebar-brand-text">SunShop</div>
				</div>

			</a>

			<hr class="sidebar-divider my-0">
			<div class="mt-5">
				<li class="nav-item active"><a class="nav-link"
					href="<c:url value="/trangchu" />"> <i class="fas fa-home"></i> <span>SunShop</span></a>
				</li>
				
				<li class="nav-item "><a class="nav-link"
					href="<c:url value="/noibo/quanlydonhang" />"> <i class="fas fa-dolly-flatbed"></i> <span>Quản Lý Đơn Hàng</span></a>
				</li>
				
				<li class="nav-item "><a class="nav-link"
					href="<c:url value="/noibo/quanlysach" />"> <i class="fas fa-book"></i> <span>Quản Lý Sách</span></a>
				</li>
				
				<li class="nav-item "><a class="nav-link"
					href="<c:url value="/noibo/quanlytheloaihang" />"> <i class="fas fa-pen"></i> <span>Quản Lý Thể Loại Sách</span></a>
				</li>
				
				<sec:authorize access="hasRole('ROLE_ADMIN')">
				<li class="nav-item "><a class="nav-link"
					href="<c:url value="/admin/thongkedoanhthu" />"> <i class="fas fa-chart-bar"></i> <span>Thống Kê Doanh Thu</span></a>
				</li>
		
				<li class="nav-item "><a class="nav-link"
					href="<c:url value="/admin/quanlynhanvien" />"> <i class="fas fa-users"></i> <span>Quản Lý Nhân Viên</span></a>
				</li>
				</sec:authorize>
				<hr class="sidebar-divider my-0" />
				<li class="nav-item "><a class="nav-link"
					href="<c:url value="/dangxuat" />"> <i
						class="fas fa-sign-out-alt"></i> <span>Đăng Xuất</span>
				</a></li>
			</div>
		</ul>
		<div id="content-wrapper" class="d-flex flex-column">
			<div id="content">
				<nav
					class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
					<ul class="navbar-nav ml-auto">
						<div class="topbar-divider d-none d-sm-block"></div>
						<!-- Nav Item - User Information -->
						<li class="nav-item dropdown no-arrow"><a
							class="nav-link dropdown-toggle" href="#" id="userDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <span
								class="mr-2 d-none d-lg-inline text-gray-600 small">${pageContext.request.userPrincipal.name}</span>
						</a></li>
						
					</ul>
				</nav>
				<div class="container">
					<tiles:insertAttribute name="content" />
				</div>
				<footer class="sticky-footer bg-white ">
					<div class="container my-auto">
						<div class="copyright text-center my-auto">
							<span>Copyright &copy; MNTA</span>
						</div>
					</div>
				</footer>
			</div>
		</div>
		<a class="scroll-to-top rounded" href="#page-top"> <i
			class="fas fa-angle-up"></i>
		</a>

		<script type="text/javascript"
			src="<c:url value="/resources/js/jquery-3.5.1.js" />"></script>

		<script type="text/javascript"
			src="<c:url value="/resources/js/sb-admin-2.min.js" />"></script>
</body>
</html>

