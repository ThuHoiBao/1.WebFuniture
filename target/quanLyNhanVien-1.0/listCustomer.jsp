<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Định nghĩa mã hóa ký tự và thông tin meta cho trang web -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="POS - Bootstrap Admin Template">
    <meta name="keywords"
          content="admin, estimates, bootstrap, business, corporate, creative, invoice, html5, responsive, Projects">
    <meta name="author" content="Dreamguys - Bootstrap Admin Template">
    <meta name="robots" content="noindex, nofollow">

    <!-- Đường dẫn tới favicon và các tệp CSS cần thiết, thêm `${pageContext.request.contextPath}` để đảm bảo đường dẫn đúng -->
    <link rel="shortcut icon" type="image/x-icon"
          href="${pageContext.request.contextPath}/assets/img/favicon.jpg">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/animate.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/assets/plugins/select2/css/select2.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/assets/css/dataTables.bootstrap4.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/assets/plugins/fontawesome/css/fontawesome.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/assets/plugins/fontawesome/css/all.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css">

    <title>Quản Lý Khách Hàng</title>
</head>

<body>
<%--<div id="global-loader">--%>
<%--    <div class="whirly-loader"> </div>--%>
<%--</div>--%>

<div class="main-wrapper">

    <div class="header">

        <div class="header-left active">
            <a href="${pageContext.request.contextPath}/index.html" class="logo">
                <img src="${pageContext.request.contextPath}/assets/img/logo.png" alt="">
            </a>
            <a href="${pageContext.request.contextPath}/index.html" class="logo-small">
                <img src="${pageContext.request.contextPath}/assets/img/logo-small.png" alt="">
            </a>
            <a id="toggle_btn" href="javascript:void(0);"></a>
        </div>

        <a id="mobile_btn" class="mobile_btn" href="#sidebar">
                                <span class="bar-icon">
                                    <span></span>
                                    <span></span>
                                    <span></span>
                                </span> <!-- Đóng thẻ <span> này -->
        </a>


        <ul class="nav user-menu">

            <li class="nav-item">
                <div class="top-nav-search">
                    <a href="javascript:void(0);" class="responsive-search">
                        <i class="fa fa-search"></i>
                    </a>
                    <form action="#">
                        <div class="searchinputs">
                            <input type="text" placeholder="Search Here ...">
                            <div class="search-addon">
                                                    <span><img
                                                            src="${pageContext.request.contextPath}/assets/img/icons/closes.svg"
                                                            alt="img"></span>
                            </div>
                        </div>
                        <a class="btn" id="searchdiv"><img
                                src="${pageContext.request.contextPath}/assets/img/icons/search.svg"
                                alt="img"></a>
                    </form>
                </div>
            </li>


            <li class="nav-item dropdown has-arrow flag-nav">
                <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown"
                   href="javascript:void(0);" role="button">
                    <img src="${pageContext.request.contextPath}/assets/img/flags/us1.png" alt=""
                         height="20">
                </a>
                <div class="dropdown-menu dropdown-menu-right">
                    <a href="javascript:void(0);" class="dropdown-item">
                        <img src="${pageContext.request.contextPath}/assets/img/flags/us.png" alt=""
                             height="16"> English
                    </a>
                    <a href="javascript:void(0);" class="dropdown-item">
                        <img src="${pageContext.request.contextPath}/assets/img/flags/fr.png" alt=""
                             height="16"> French
                    </a>
                    <a href="javascript:void(0);" class="dropdown-item">
                        <img src="${pageContext.request.contextPath}/assets/img/flags/es.png" alt=""
                             height="16"> Spanish
                    </a>
                    <a href="javascript:void(0);" class="dropdown-item">
                        <img src="${pageContext.request.contextPath}/assets/img/flags/de.png" alt=""
                             height="16"> German
                    </a>
                </div>
            </li>


            <li class="nav-item dropdown">
                <a href="javascript:void(0);" class="dropdown-toggle nav-link"
                   data-bs-toggle="dropdown">
                    <img src="${pageContext.request.contextPath}/assets/img/icons/notification-bing.svg"
                         alt="img"> <span class="badge rounded-pill">4</span>
                </a>
                <div class="dropdown-menu notifications">
                    <div class="topnav-dropdown-header">
                        <span class="notification-title">Notifications</span>
                        <a href="javascript:void(0)" class="clear-noti"> Clear All </a>
                    </div>
                    <div class="noti-content">
                        <ul class="notification-list">
                            <li class="notification-message">
                                <a href="activities.html">
                                    <div class="media d-flex">
                                                            <span class="avatar flex-shrink-0">
                                                                <img alt=""
                                                                     src="${pageContext.request.contextPath}/assets/img/profiles/avatar-02.jpg">
                                                            </span>
                                        <div class="media-body flex-grow-1">
                                            <p class="noti-details"><span class="noti-title">John
                                                                        Doe</span> added new task <span
                                                    class="noti-title">Patient appointment
                                                                        booking</span></p>
                                            <p class="noti-time"><span class="notification-time">4
                                                                        mins ago</span></p>
                                        </div>
                                    </div>
                                </a>
                            </li>

                            <li class="notification-message">
                                <a href="activities.html">
                                    <div class="media d-flex">
                                                            <span class="avatar flex-shrink-0">
                                                                <img alt=""
                                                                     src="${pageContext.request.contextPath}/assets/img/profiles/avatar-03.jpg">
                                                            </span>
                                        <div class="media-body flex-grow-1">
                                            <p class="noti-details"><span class="noti-title">Tarah
                                                                        Shropshire</span> changed the task name <span
                                                    class="noti-title">Appointment booking with
                                                                        payment gateway</span></p>
                                            <p class="noti-time"><span class="notification-time">6
                                                                        mins ago</span></p>
                                        </div>
                                    </div>
                                </a>
                            </li>

                            <li class="notification-message">
                                <a href="activities.html">
                                    <div class="media d-flex">
                                                            <span class="avatar flex-shrink-0">
                                                                <img alt=""
                                                                     src="${pageContext.request.contextPath}/assets/img/profiles/avatar-06.jpg">
                                                            </span>
                                        <div class="media-body flex-grow-1">
                                            <p class="noti-details"><span class="noti-title">Misty
                                                                        Tison</span> added <span
                                                    class="noti-title">Domenic Houston</span> and
                                                <span class="noti-title">Claire Mapes</span> to
                                                project <span class="noti-title">Doctor available
                                                                        module</span></p>
                                            <p class="noti-time"><span class="notification-time">8
                                                                        mins ago</span></p>
                                        </div>
                                    </div>
                                </a>
                            </li>

                            <li class="notification-message">
                                <a href="activities.html">
                                    <div class="media d-flex">
                                                            <span class="avatar flex-shrink-0">
                                                                <img alt=""
                                                                     src="${pageContext.request.contextPath}/assets/img/profiles/avatar-17.jpg">
                                                            </span>
                                        <div class="media-body flex-grow-1">
                                            <p class="noti-details"><span class="noti-title">Rolland
                                                                        Webber</span> completed task <span
                                                    class="noti-title">Patient and Doctor video
                                                                        conferencing</span></p>
                                            <p class="noti-time"><span class="notification-time">12
                                                                        mins ago</span></p>
                                        </div>
                                    </div>
                                </a>
                            </li>

                            <li class="notification-message">
                                <a href="activities.html">
                                    <div class="media d-flex">
                                                            <span class="avatar flex-shrink-0">
                                                                <img alt=""
                                                                     src="${pageContext.request.contextPath}/assets/img/profiles/avatar-13.jpg">
                                                            </span>
                                        <div class="media-body flex-grow-1">
                                            <p class="noti-details"><span
                                                    class="noti-title">Bernardo Galaviz</span> added
                                                new task <span class="noti-title">Private chat
                                                                        module</span></p>
                                            <p class="noti-time"><span class="notification-time">2
                                                                        days ago</span></p>
                                        </div>
                                    </div>
                                </a>
                            </li>

                        </ul>
                    </div>
                    <div class="topnav-dropdown-footer">
                        <a href="activities.html">View all Notifications</a>
                    </div>
                </div>
            </li>

            <li class="nav-item dropdown has-arrow main-drop">
                <a href="javascript:void(0);" class="dropdown-toggle nav-link userset"
                   data-bs-toggle="dropdown">
                                        <span class="user-img"><img
                                                src="${pageContext.request.contextPath}/assets/img/profiles/avator1.jpg"
                                                alt="">
                                            <span class="status online"></span></span>
                </a>
                <div class="dropdown-menu menu-drop-user">
                    <div class="profilename">
                        <div class="profileset">
                                                <span class="user-img"><img
                                                        src="${pageContext.request.contextPath}/assets/img/profiles/avator1.jpg"
                                                        alt="">
                                                    <span class="status online"></span></span>
                            <div class="profilesets">
                                <h6>John Doe</h6>
                                <h5>Admin</h5>
                            </div>
                        </div>
                        <hr class="m-0">
                        <a class="dropdown-item" href="profile.html"> <i class="me-2"
                                                                         data-feather="user"></i> My Profile</a>
                        <a class="dropdown-item" href="generalsettings.html"><i class="me-2"
                                                                                data-feather="settings"></i>Settings</a>
                        <hr class="m-0">
                        <a class="dropdown-item logout pb-0" href="signin.html"><img
                                src="${pageContext.request.contextPath}/assets/img/icons/log-out.svg"
                                class="me-2" alt="img">Logout</a>
                    </div>
                </div>
            </li>

        </ul>

        <div class="dropdown mobile-user-menu">
            <a href="javascript:void(0);" class="nav-link dropdown-toggle" data-bs-toggle="dropdown"
               aria-expanded="false"><i class="fa fa-ellipsis-v"></i></a>
            <div class="dropdown-menu dropdown-menu-right">
                <a class="dropdown-item" href="profile.html">My Profile</a>
                <a class="dropdown-item" href="generalsettings.html">Settings</a>
                <a class="dropdown-item" href="signin.html">Logout</a>
            </div>
        </div>

    </div>
    <form action="${pageContext.request.contextPath}/admin/customer-list" method="get"
          id="listForm">
        <div class="sidebar" id="sidebar">
            <div class="sidebar-inner slimscroll">
                <div id="sidebar-menu" class="sidebar-menu">
                    <ul>
                        <li class="submenu">
                            <a href="javascript:void(0);"><img
                                    src="${pageContext.request.contextPath}/assets/img/icons/dashboard.svg"
                                    alt="img"><span> Thống Kê</span> <span
                                    class="menu-arrow"></span> </a>
                            <ul>
                                <li><a href="index1.jsp">Doanh Thu</a></li>
                                <li><a href="index2.jsp">Sản Phẩm Bán Chạy</a></li>
                                <li><a href="index3.jsp">Trạng Thái Đơn Hàng</a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="coupon.jsp"><img
                                    src="${pageContext.request.contextPath}/assets/img/icons/coupon.svg"
                                    alt="img"><span> Tạo Mã Khuyến Mãi</span> </a>
                        </li>
                    </ul>
                    <ul>
                        <li>
                            <a href="listNV.jsp"><img
                                    src="${pageContext.request.contextPath}/assets/img/icons/dashboard.svg"
                                    alt="img" class="active"><span> Quản lý nhân viên</span> </a>
                        </li>
                    </ul>
                    <ul>
                        <li class="active">
                            <a href="listCustomer.jsp"><img
                                    src="${pageContext.request.contextPath}/assets/img/icons/dashboard.svg"
                                    alt="img"><span> Quản lý Khách Hàng </span> </a>
                        </li>
                    </ul>
                    <ul>
                        <li>
                            <a href="phanca.jsp"><img
                                    src="${pageContext.request.contextPath}/assets/img/icons/dashboard.svg"
                                    alt="img" class=""><span>Phân ca làm việc</span> </a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>

        <div class="page-wrapper">
            <div class="content">

                <div class="page-header">
                    <div class="page-title">
                        <h4>Quản Lý Khách Hàng</h4>
                        <h6>Tìm kiếm/xem chi tiết khách hàng </h6>

                    </div>
                    <div class="page-btn" id="btnDeleteCustomers">
                        <a  class="btn btn-added"><img src="${pageContext.request.contextPath}/assets/img/icons/delete.svg" alt="img">Xóa Khách Hàng</a>
                    </div>
                </div>

                <div class="card">
                    <div class="card-body">
                        <%-- <div class="table-top">--%>
                        <%--&lt;%&ndash; <div class="search-set">&ndash;%&gt;--%>
                        <%--&lt;%&ndash; <div class="search-path">&ndash;%&gt;--%>
                        <%--&lt;%&ndash; <a class="btn btn-filter"
                            id="filter_search">&ndash;%&gt;--%>
                        <%--&lt;%&ndash; <img
                            src="${pageContext.request.contextPath}/assets/img/icons/filter.svg"
                            alt="img">&ndash;%&gt;--%>
                        <%--&lt;%&ndash; <span><img
                                src="${pageContext.request.contextPath}/assets/img/icons/closes.svg"
                                alt="img"></span>&ndash;%&gt;--%>
                        <%--&lt;%&ndash; </a>&ndash;%&gt;--%>
                        <%--&lt;%&ndash; </div>&ndash;%&gt;--%>
                        <%--&lt;%&ndash; </div>&ndash;%&gt;--%>
                        <%-- </div>--%>
                        <div class="search-header"
                             style="text-align: left; margin-bottom: 15px; padding: 10px; border-left: 5px solid #28a745; border-radius: 5px;">
                            <h6 class="search-title"
                                style="font-size: 1.3em; font-weight: 500; color: #1a1e21; font-family: 'Poppins', sans-serif; margin: 0; padding-left: 10px; display: flex; align-items: center; text-shadow: 1px 1px 2px rgba(0, 0, 0, 0.1);">
                                🔍 Tìm Kiếm Khách Hàng
                            </h6>
                        </div>

                        <div class="card-body pb-0">

                            <div class="row">
                                <div
                                        class="col-lg-2 col-sm-6 col-12">
                                    <div class="form-group">
                                        <input type="text"
                                               name="phone"
                                               value="${customerSearch.phone}"
                                               placeholder="Nhập số điện thoại...">
                                    </div>
                                </div>
                                <div
                                        class="col-lg-2 col-sm-6 col-12">
                                    <div class="form-group">
                                        <input type="text"
                                               name="name"
                                               value="${customerSearch.name}"
                                               placeholder="Nhập tên... ">
                                    </div>
                                </div>
                                <div
                                        class="col-lg-3 col-sm-6 col-12">
                                    <div class="form-group">
                                        <input type="text"
                                               name="email"
                                               value="${customerSearch.email}"
                                               placeholder="Nhập email...">
                                    </div>
                                </div>
                                <div
                                        class="col-lg-2 col-sm-6 col-12 ms-auto">
                                    <button type="button"
                                            class="btn btn-success"
                                            id="btnSearchCustomer">
                                        <svg xmlns="http://www.w3.org/2000/svg"
                                             width="16"
                                             height="16"
                                             fill="currentColor"
                                             class="bi bi-search"
                                             viewBox="0 0 16 16">
                                            <path
                                                    d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001q.044.06.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1 1 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0">
                                            </path>
                                        </svg>
                                        Tìm Kiếm
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <br>
                    <div class="table-responsive">
                        <table class="table" id="customerList">
                            <thead>
                            <tr>
                                <th>
                                    <label class="checkboxs">
                                        <input type="checkbox" id="select-all">
                                        <span class="checkmarks"></span>
                                    </label>
                                </th>
                                <th>Tên Khách Hàng</th>
                                <%-- <th>Ngày Sinh</th>--%>
                                <th>Số Điện Thoại</th>
                                <th>Email</th>
                                <th>Địa Chỉ</th>
                                <th>Trạng Thái</th>
                                <th>Hành Động</th>
                            </tr>
                            </thead>
                            <tbody>
                            <!-- Duyệt qua danh sách customerList và hiển thị dữ liệu -->
                            <c:forEach var="customer" items="${customerList}">
                                <tr>
                                    <td>
                                        <label class="checkboxs">
                                            <input type="checkbox" value="${customer.personID}">
                                            <span class="checkmarks"></span>
                                        </label>
                                    </td>
                                    <td class="productimgname">
                                        <a href="javascript:void(0);" class="product-img">
                                            <img src="${pageContext.request.contextPath}/assets/img/profiles/avator1.jpg"
                                                 alt="Avatar" />
                                        </a>
                                        <a href="javascript:void(0);">${customer.name}</a>

                                    </td>
                                    <td>${customer.phone}</td>
                                    <td>${customer.email}</td>
                                    <td>${customer.address}</td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${customer.status == 'Active'}">
                                                <span class="badges bg-lightgreen">Active</span>
                                            </c:when>
                                            <c:otherwise>
                                                <span class="badges bg-lightred">In Active</span>
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                    <td>
                                        <a class="me-3" href="${pageContext.request.contextPath}/admin/customer-order/${customer.personID}">
                                            <img src="${pageContext.request.contextPath}/assets/img/icons/product.svg" alt="order">
                                        </a>
                                        <a class="me-3" href="javascript:void(0);" onclick="deleteCustomer('${customer.personID}', '${customer.status}')">
                                            <img src="${pageContext.request.contextPath}/assets/img/icons/delete.svg" alt="delete">
                                        </a>
                                        <a class="me-3" href="javascript:void(0);" onclick="unlockCustomer('${customer.personID}', '${customer.status}')">
                                            <img src="${pageContext.request.contextPath}/assets/img/icons/edit.svg" alt="edit">
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>

                    </div>
                    <div class="container mt-5">
                        <div class="d-flex justify-content-center pagination">
                            <button id="prev-page" class="btn btn-primary me-2"
                                    disabled>&lt;</button>
                            <span id="page-info" class="align-self-center">Page 1 of X</span>
                            <button id="next-page" class="btn btn-primary ms-2">&gt;</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </form>
</div>
<!-- Modal Xác nhận Xóa -->
<div class="modal fade" id="confirmDeleteModal" tabindex="-1" role="dialog" aria-labelledby="confirmDeleteModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="confirmDeleteModalLabel">Xác nhận xóa</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="$('#confirmDeleteModal').modal('hide')">
                    <span aria-hidden="true">&times; </span>
                </button>
            </div>
            <div class="modal-body">
                <h6>Bạn có chắc chắn muốn xóa khách hàng này không?</h6>
                <br>
                <div class="form-group">
                    <label for="deleteReason">Chọn lý do xóa:</label>
                    <select id="deleteReason" class="form-control">
                        <option value="">-- Chọn lý do --</option>
                        <option value="Thông tin không chính xác">Thông tin không chính xác</option>
                        <option value="Tài khoản bị nghi ngờ lừa đảo">Tài khoản bị nghi ngờ lừa đảo</option>
                        <option value="Yêu cầu của khách hàng">Yêu cầu của khách hàng</option>
                        <option value="Khác">Khác</option>
                    </select>
                </div>
                <div class="form-group">
                    <textarea id="deleteReasonText" class="form-control" placeholder="Nhập lý do khác (nếu có)" style="display: none;"></textarea>
                </div>
            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" onclick="$('#confirmDeleteModal').modal('hide')">Hủy</button>
                <button type="button" class="btn btn-danger" id="confirmDeleteButton">Xóa</button>
            </div>

        </div>
    </div>
</div>
<div class="modal fade" id="deleteCustomer" tabindex="-1" role="dialog" aria-labelledby="confirmDeleteModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="t">Xác nhận xóa</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="$('#deleteCustomer').modal('hide')">
                    <span aria-hidden="true">&times; </span>
                </button>
            </div>
            <div class="modal-body">
               <h6>Bạn chưa chọn khách hàng trong danh sách ? </h6>
                <br>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" onclick="$('#deleteCustomer').modal('hide')">Đóng</button>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="deleteCustomerSuccess" tabindex="-1" role="dialog" aria-labelledby="confirmDeleteModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="thu">Xác nhận xóa</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="$('#deleteCustomerSuccess').modal('hide')">
                    <span aria-hidden="true">&times; </span>
                </button>
            </div>
            <div class="modal-body">
                <h6>Khách hàng đã được xóa thành công ? </h6>
                <br>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" onclick="$('#deleteCustomerSuccess').modal('hide')">Đóng</button>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="unlockCustomerSuccess" tabindex="-1" role="dialog" aria-labelledby="confirmDeleteModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="thu1">Xác nhận mở khóa</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="$('#unlockCustomerSuccess').modal('hide')">
                    <span aria-hidden="true">&times; </span>
                </button>
            </div>
            <div class="modal-body">
                <h6>Khách hàng đã được mở khóa thành công ? </h6>
                <br>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" onclick="$('#unlockCustomerSuccess').modal('hide')">Đóng</button>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="errorModal" tabindex="-1" role="dialog" aria-labelledby="errorModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="errorModalLabel">Thông Báo Lỗi</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="$('#errorModal').modal('hide')">
                    <span aria-hidden="true">&times; </span>
                </button>
            </div>
            <div class="modal-body">
                <h6 id="errorMessage"></h6>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" onclick="$('#errorModal').modal('hide')">Đóng</button>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="customerStatus" tabindex="-1" role="dialog" aria-labelledby="confirmDeleteModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="status">Xác nhận xóa</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="$('#customerStatus').modal('hide')">
                    <span aria-hidden="true">&times; </span>
                </button>
            </div>
            <div class="modal-body">
                <h6>Khách hàng này đã được xóa thành công trước đây. </h6>
                <br>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" onclick="$('#customerStatus').modal('hide')">Đóng</button>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="unlockCustomerStatus" tabindex="-1" role="dialog" aria-labelledby="confirmDeleteModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="unlockStatus">Xác nhận xóa</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="$('#unlockCustomerStatus').modal('hide')">
                    <span aria-hidden="true">&times; </span>
                </button>
            </div>
            <div class="modal-body">
                <h6>Khách hàng này đang hoạt động . </h6>
                <br>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" onclick="$('#unlockCustomerStatus').modal('hide')">Đóng</button>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="customerStatusList" tabindex="-1" role="dialog" aria-labelledby="confirmDeleteModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="statusList">Xác nhận xóa</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="$('#customerStatusList').modal('hide')">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-success" id="btnUncheckCustomers" >Bỏ chọn</button>
                <button type="button" class="btn btn-danger" onclick="$('#customerStatusList').modal('hide')">Đóng</button>
            </div>
        </div>
    </div>
</div>

<!-- Modal Xác nhận Mở Khóa -->
<div class="modal fade" id="confirmUnlockModal" tabindex="-1" role="dialog" aria-labelledby="confirmUnlockModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="confirmUnlockModalLabel">Xác nhận mở khóa tài khoản</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="$('#confirmUnlockModal').modal('hide')">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <h6>Bạn có chắc chắn muốn mở khóa tài khoản của khách hàng này không?</h6>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" onclick="$('#confirmUnlockModal').modal('hide')">Hủy</button>
                <button type="button" class="btn btn-success" id="confirmUnlockButton">Mở Khóa</button>
            </div>
        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/assets/js/jquery-3.6.0.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<!-- Thêm SweetAlert CSS và JS từ CDN -->


<script>
    $(document).ready(function () {
        // Ẩn loader khi trang đã tải xong
        $('#global-loader').fadeOut('slow');
    });
    window.onload = function () {
        // Ẩn loader khi trang đã tải xong
        var loader = document.getElementById('global-loader');
        if (loader) {
            loader.style.display = 'none';
        }
    };
    $(document).ready(function () {
        $('#deleteReason').on('change', function () {
            if ($(this).val() === 'Khác') {
                $('#deleteReasonText').show();
            } else {
                $('#deleteReasonText').hide();
            }
        });
    });

    $('#btnSearchCustomer').click(function (e) {
        e.preventDefault();

        let phone = $("input[name='phone']").val();
        let name = $("input[name='name']").val();
        let email = $("input[name='email']").val();

        if (phone) {
            let phoneRegex = /^[0-9]+$/; // Đảm bảo chỉ chứa chữ số
            if (!phoneRegex.test(phone)) {
                $('#errorMessage').text("Số điện thoại chỉ được chứa chữ số.");
                $('#errorModal').modal('show');
                return;
            }
        }

        if (name) {
            let nameRegex = /^[a-zA-ZÀ-ỹ\s]+$/;  // Bao gồm cả tiếng Việt và dấu cách
            if (!nameRegex.test(name)) {
                $('#errorMessage').text("Tên không được chứa chữ số hoặc ký tự đặc biệt.");
                $('#errorModal').modal('show');
                return;
            }
        }

        // Kiểm tra email chỉ khi trường không rỗng
        if (email) {
            let emailRegex = /^[a-zA-Z0-9._%+-]+@([a-zA-Z0-9.-]+\.)+[a-zA-Z]{2,}$/;
            if (!emailRegex.test(email)) {
                $('#errorMessage').text("Email không hợp lệ. Đảm bảo có đuôi đúng như .com, .net, .org, v.v.");
                $('#errorModal').modal('show');
                return;
            }
        }

        $('#listForm').submit();
    });
    function deleteCustomer(customerId, status) {
        if (status !== 'Active') {
            $('#customerStatus').modal('show');
        } else {
            // Trạng thái là 'Active', thực hiện xóa ngay lập tức
            btnDeleteCustomer(customerId);
        }
    }
    function unlockCustomer(customerId, status) {
        if (status !== 'InActive') {
            $('#unlockCustomerStatus').modal('show');
        } else {
            unlockCustomers(customerId);
        }
    }
    var inactiveCustomers = [];
    var selectedCustomers = [];
    $('#btnDeleteCustomers').click(function (e) {
        e.preventDefault();
        // Đặt lại mảng khi nhấn nút
        selectedCustomers = [];
        inactiveCustomers = [];
        // Duyệt qua các checkbox được chọn trong bảng
        $('#customerList').find('tbody input[type=checkbox]:checked').each(function () {
            var customerId = $(this).val();
            var row = $(this).closest('tr');
            var customerName = row.find('td:nth-child(2) a').text().trim();
            var customerPhone = row.find('td:nth-child(3)').text().trim();
            var customerStatus = row.find('td:nth-child(6) .badges').text().trim();

            if (customerStatus.toLowerCase() !== 'active') {
                // Thêm thông tin khách hàng vào danh sách đã xóa
                inactiveCustomers.push({
                    id: customerId,
                    name: customerName || 'Không rõ',
                    phone: customerPhone || 'Không rõ'
                });
            } else {
                // Thêm ID khách hàng vào danh sách để xóa
                selectedCustomers.push(customerId);
            }
        });
        // Hiển thị danh sách khách hàng đã bị xóa nếu có
        if (inactiveCustomers.length > 0) {
            // Khởi tạo chuỗi HTML
            var htmlContent = '<h6>Những khách hàng sau đã bị xóa trước đó:</h6>';
            htmlContent += '<table class="table table-bordered">';
            htmlContent += '<thead><tr><th>STT</th><th>Tên Khách Hàng</th><th>Số Điện Thoại</th></tr></thead>';
            htmlContent += '<tbody>';

            // Duyệt qua danh sách khách hàng và tạo các hàng cho bảng
            for (var i = 0; i < inactiveCustomers.length; i++) {
                var customer = inactiveCustomers[i];
                htmlContent += '<tr>';
                htmlContent += '<td>' + (i + 1) + '</td>';
                htmlContent += '<td>' + (customer.name || 'Không rõ') + '</td>';
                htmlContent += '<td>' + (customer.phone || 'Không rõ') + '</td>';
                htmlContent += '</tr>';
            }
            htmlContent += '</tbody></table>';
            // Chèn chuỗi HTML vào modal
            $('#customerStatusList .modal-body').html(htmlContent);
            $('#customerStatusList').modal('show');
        } else if (selectedCustomers.length > 0) {
            btnDeleteCustomer(selectedCustomers);
        } else {
            $('#deleteCustomer').modal('show');
        }
    });
    // Xử lý sự kiện khi nhấn nút "Bỏ chọn"
    $('#btnUncheckCustomers').click(function () {
        // Bỏ chọn tất cả các checkbox tương ứng với khách hàng trong danh sách đã xóa
        $('#customerList').find('tbody input[type=checkbox]:checked').each(function () {
            var customerId = $(this).val();
            // Kiểm tra nếu ID của khách hàng nằm trong danh sách "inactiveCustomers"
            var isInactive = inactiveCustomers.some(function (customer) {
                return customer.id === customerId;
            });

            // Nếu có trong danh sách, bỏ chọn checkbox
            if (isInactive) {
                $(this).prop('checked', false);
            }
        });

        // Ẩn modal sau khi bỏ chọn
        $('#customerStatusList').modal('hide');
    });
    function btnDeleteCustomer(data) {
        $('#confirmDeleteModal').modal('show');

        $('#confirmDeleteButton').off('click').on('click', function () {
            const reason = $('#deleteReason').val();
            const additionalReason = $('#deleteReasonText').val();

            if (!reason) {
                alert("Vui lòng chọn lý do xóa.");
                return;
            }

            let deleteMessage = reason;
            if (reason === 'Khác') {
                deleteMessage = additionalReason || "Không có lý do cụ thể.";
            }

            $('#confirmDeleteModal').modal('hide');

            $.ajax({
                url: "${pageContext.request.contextPath}/admin/customer-list/" + data,
                type: "POST",
                data: {
                    reason: deleteMessage,
                    action: "lock"
                },
                success: function (result) {
                    $('#deleteCustomerSuccess').modal('show');
                    $('#deleteCustomerSuccess').on('hidden.bs.modal', function () {
                        location.reload();
                    });
                },
                error: function (result) {
                    console.log("error");
                    alert(result.message || "Có lỗi xảy ra, vui lòng thử lại.");
                }
            });
        });
    }
    function unlockCustomers(customerId) {
        $('#confirmUnlockModal').modal('show');

        $('#confirmUnlockButton').off('click').on('click', function () {
            $('#confirmUnlockModal').modal('hide');

            $.ajax({
                url: "${pageContext.request.contextPath}/admin/customer-list/" + customerId,
                type: "POST",
                data: {
                    action: "unlock"
                },
                success: function (result) {
                    $('#unlockCustomerSuccess').modal('show');
                    $('#unlockCustomerSuccess').on('hidden.bs.modal', function () {
                        location.reload();
                    });
                },
                error: function (result) {
                    console.log("error");
                    alert(result.message || "Có lỗi xảy ra, vui lòng thử lại.");
                }
            });
        });
    }

</script>
<!-- Chèn các tệp JavaScript với đường dẫn được điều chỉnh -->
<script src="${pageContext.request.contextPath}/scripts/pagination.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/jquery-3.6.0.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/feather.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/jquery.slimscroll.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/dataTables.bootstrap4.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/bootstrap.bundle.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/plugins/select2/js/select2.min.js"></script>
<script
        src="${pageContext.request.contextPath}/assets/plugins/sweetalert/sweetalert2.all.min.js"></script>
<script
        src="${pageContext.request.contextPath}/assets/plugins/sweetalert/sweetalerts.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/script.js"></script>

</body>

</html>