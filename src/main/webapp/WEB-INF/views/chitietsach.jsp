
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f"%>

<div class="container space-s">
	<div class="d-sm-flex align-items-center justify-content-between mb-4">
		<h1 class="h3 mb-0 text-gray-800">Chi Tiết Sách</h1>
	</div>

	<nav aria-label="breadcrumb">
			  <ol class="breadcrumb bg-white text-dark">
			     <li class="breadcrumb-item"><a href="<c:url value="/trangchu"/>">Trang Chủ</a></li>
	   			 <li class="breadcrumb-item active" aria-current="page">Chi Tiết Sách</li>
			  </ol>
	</nav>

	<div class="row">
		<div class="col">
			<div class="card mb-3">
				<div class="row no-gutters" >
					<div class="col-md-6">
						<img src="<c:url value="/resources/images/product/${chiTietSach.hinh}"/>" class="card-img " alt="Sách ${chiTietSach.tenHangHoa}"/>
					</div>
					<div class="col-md-6">
						<div class="card-body" >
							<h2 class="card-title font-weight-bold ">${chiTietSach.tenHangHoa}</h2>
							<br>
							<p class="card-text"><span class="font-weight-bold">Tác Giả:</span> ${chiTietSach.tacGia}</p>
							
							<c:if test="${chiTietSach.giamGia > 0 }">
                                    		<p class="card-text"><span class="font-weight-bold">Giá:</span> <f:formatNumber value="${chiTietSach.gia * (1 - chiTietSach.giamGia)}"  pattern="#,### VNĐ" />                     		
                                    		<span class="font-italic font-weight-light text-decoration-sunshop ml-2"><f:formatNumber value="${chiTietSach.gia}"  pattern="#,### VNĐ" /></span>
                                    		</p>			
                               			<p class="card-text"><span class="font-weight-bold">Khuyến Mãi: </span>Giảm <f:formatNumber pattern="#" value="${chiTietSach.giamGia * 100}"/>%</p>
                             </c:if>
                                                      	
                            <c:if test="${chiTietSach.giamGia == 0 }">
                                        	<p class="card-text font-weight-bold">Giá: <f:formatNumber value="${chiTietSach.gia}"  pattern="#,### VNĐ" /></p>
                            </c:if>
							<p class="card-text"><span class="font-weight-bold">Mô Tả:</span> ${chiTietSach.moTa}</p>
							<a href="<c:url value="/trangchu"/>" class="btn btn-outline-primary btn-lg add-card mr-2" data-id="${chiTietSach.id}"><i class="fas fa-shopping-cart"></i> Cho Vào Giỏ</a>	
							<button type="button" class="btn btn-outline-danger btn-lg add-card" id="thanhToan" data-id="${chiTietSach.id}"><i class="far fa-credit-card"></i> Thanh Toán</button>
						</div>		
					</div>		
				</div>	
			</div>					
		</div>
	</div>
<p class="d-flex justify-content-end"><small class="text-muted">Mong Khách Hàng Điền Thông Tin Chính Xác Để Đảm Bảo Giao Nhận Hàng. Xin Cảm Ơn!</small></p>
				
	<div class="row mt-4">
			<h3 class="list-product-title">Sách Tương Tự</h3>
			</div>
	<div class="row">
			<c:forEach items="${sachTuongTu}" var="lp">
     				 <div class="col-md-3 col-sm-6 col-12  ">
                        <div class="card product-card card-s border border-light">
                        <a href="<c:url value="/chitietsach/${lp.id}"/>"  class="border-light">
                            <img src="<c:url value="/resources/images/product/${lp.hinh}"/>" class="card-img-top" alt="${lp.tenHangHoa}" />
                            </a>
                            <div class="card-body  font-weight-bold">
                                <span class="card-title ">${lp.tenHangHoa}</span>
                                <div class="card-text product-price">
                                    <div class="nd-product">
                                    	
                                    	<c:if test="${lp.giamGia > 0 }">
                                    		<span><f:formatNumber value="${lp.gia * (1 - lp.giamGia)}"  pattern="#,### VNĐ" /></span><br/>
                               			<small class="text-dark">-<f:formatNumber pattern="#" value="${lp.giamGia * 100}"/>%</small>
                                    	</c:if>
                                    	
                                    	<c:if test="${lp.giamGia == 0 }">
                                        	<span class="text-dark"><f:formatNumber value="${lp.gia}"  pattern="#,### VNĐ" /></span>
                                        </c:if>
                                    </div>                                           
                                </div>
                            </div>
                        </div>
                    </div>
           </c:forEach>
		</div>
	</div>
