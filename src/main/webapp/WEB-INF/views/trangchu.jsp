<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f"%>


<!--Start Slide -->
<div id="carouselExampleIndicators" class="carousel slide mt-1"
	data-ride="carousel">
	<ol class="carousel-indicators">
		<li data-target="#carouselExampleIndicators" data-slide-to="0"
			class="active"></li>
		<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
		<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
	</ol>

	<div class="carousel-inner">
		<div class="carousel-item active">
			<img src="<c:url value="/resources/images/slide1.jpg"/>"
				class="d-block w-100" alt="..." />
		</div>
		<div class="carousel-item">
			<img src="<c:url value="/resources/images/slide2.jpg"/>"
				class="d-block w-100" alt="..." />
		</div>
		<div class="carousel-item">
			<img src="<c:url value="/resources/images/slide3.jpg"/>"
				class="d-block w-100" alt="..." />
		</div>
	</div>
	<a class="carousel-control-prev" href="#carouselExampleIndicators"
		role="button" data-slide="prev"> <span
		class="carousel-control-prev-icon" aria-hidden="true"></span> <span
		class="sr-only">Previous</span>
	</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
		role="button" data-slide="next"> <span
		class="carousel-control-next-icon" aria-hidden="true"></span> <span
		class="sr-only">Next</span>
	</a>
</div>

<!--End Slide -->
<div class="container space-s">
	<div class="d-sm-flex align-items-center justify-content-between mb-4">
		<h1 class="h3 mb-0 text-gray-800">Trang Chủ</h1>
	</div>

	<div class="row mt-4">
		<h3 class="list-product-title font-weight-bold">Danh Sách Sản
			Phẩm</h3>
		<div>
			<p class="list-product-subtitle h5 ">Tất Cả Các Sách
				${tenDanhMuc}</p>
		</div>
	</div>
	<div class="group-product">
		<div class="row">
			<c:forEach items="${list_product}" var="lp">
				<div class="col-md-3 col-sm-6 col-12  ">
					<div class="card product-card card-s border border-light">
						<a href="<c:url value="/chitietsach/${lp.id}"/>"
							class="border-light"> <img
							src="<c:url value="/resources/images/product/${lp.hinh}"/>"
							class="card-img-top" alt="${lp.tenHangHoa}" />
						</a>
						<div class="card-body  font-weight-bold">
							<span class="card-title ">${lp.tenHangHoa}</span>
							<div class="card-text product-price">
								<div class="nd-product">

									<c:if test="${lp.giamGia > 0 }">
										<span class="text-dark"><f:formatNumber
												value="${lp.gia * (1 - lp.giamGia)}" pattern="#,### VNĐ" /></span>
										<br />
										<small class="text-dark">-<f:formatNumber pattern="#"
												value="${lp.giamGia * 100}" />%
										</small>
									</c:if>

									<c:if test="${lp.giamGia == 0 }">
										<span class="text-dark"><f:formatNumber
												value="${lp.gia}" pattern="#,### VNĐ" /></span>
									</c:if>
								</div>
								<button data-id="${lp.id}"
									class="btn btn-info btn-add-to-card add-card">
									<i class="fas fa-shopping-cart"></i>
								</button>
								<a href="<c:url value="/chitietsach/${lp.id}"/>"
									class="btn btn-outline-info xct">Xem chi tiết</a>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	<nav aria-label="Page navigation example">
		<ul class="pagination  justify-content-center">
			<c:if test="${param.page >= 2 and param.page != null}">
				<li class="page-item"><a class="page-link" href="<c:url value="/trangchu?page=${param.page-1}"/>">Previous</a></li>
			</c:if>
			
			<c:forEach items="${total}" var="test">
				<li class="page-item"><a class="page-link" href="<c:url value="/trangchu?page=${test}"/>">${test}</a></li>
			</c:forEach>
			
			<c:if test="${param.page < total.size() or param.page == null and total.size() != null }">
				<li class="page-item"><a class="page-link" href="<c:url value="/trangchu?page=${param.page+1}"/>">Next</a></li>
			</c:if>
		</ul>
	</nav>
</div>

