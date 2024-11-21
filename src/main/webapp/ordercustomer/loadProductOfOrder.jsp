<%--
  Created by IntelliJ IDEA.
  User: ANH THU
  Date: 11/22/2024
  Time: 12:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
    function viewListProduct(orderID) {
        // $('#feedback').modal();
        loadListProduct(orderID);
    }
    function loadListProduct(orderID) {
        $.ajax({
            url: "/admin/customer-order/" + orderID,
            type: "PUT",
            dataType: "json",
            success: function(response) {
                // Làm sạch bảng trước khi thêm dữ liệu mới
                $('#productOrderTableBody').empty();

                if (response.length > 0) {
                    let productRows = '';
                    // Duyệt qua từng sản phẩm và tạo HTML
                    response.forEach(function (product, index) {
                        // Xác định lớp màu dựa trên trạng thái
                        let statusClass = '';
                        if (product.furnitureStatus === 'ON_SALE') {
                            statusClass = 'bg-success text-white'; // Xanh lá cây
                        } else if (product.furnitureStatus === 'OUT_OF_STOCK') {
                            statusClass = 'bg-danger text-white'; // Đỏ
                        } else if (product.furnitureStatus === 'STOP_SELLING') {
                            statusClass = 'bg-warning text-dark'; // Vàng
                        }

                        productRows +=
                            '<tr>' +
                            '<td>' + (index + 1) + '</td>' +
                            '<td>' + product.categoryName + '</td>' +
                            '<td>' + product.categoryDescription + '</td>' +
                            '<td>' + product.furniturePrice + '</td>' +
                            '<td><span class="badge ' + statusClass + '">' + product.furnitureStatus + '</span></td>' +
                            '<td>' + product.quantity + '</td>' +
                            '<td>' + product.totalPrice + '</td>' +
                            '</tr>';
                    });

                    // Thêm tất cả các dòng vào bảng
                    $('#productOrderTableBody').append(productRows);

                    // Hiển thị modal
                    $('#productOfOrderList').modal('show');
                } else {
                    // Nếu không có dữ liệu
                    $('#productOrderTableBody').append(
                        '<tr>' +
                        '<td colspan="7" class="text-center">Không có sản phẩm nào</td>' +
                        '</tr>'
                    );
                    $('#productOfOrderList').modal('show');
                }
            },
            error: function (result) {
                console.log("Error: ", result);
                alert("Đã xảy ra lỗi khi tải danh sách sản phẩm.");
            }
        });
    }
</script>