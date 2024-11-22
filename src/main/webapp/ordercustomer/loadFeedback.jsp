<%--
  Created by IntelliJ IDEA.
  User: ANH THU
  Date: 11/22/2024
  Time: 12:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
    function viewFeedbackCustomer(orderID) {
        loadFeedback(orderID);
    }
    function loadFeedback(orderID) {
        $.ajax({
            url: "/admin/customer-order/" + orderID,
            type: "POST",
            // data: JSON.stringify(json),
            // contentType: "application/json",
            dataType:"json",
            success: function(response) {
                $('#feedback-description').text(response.description || 'Không có phản hồi.');

                // Hiển thị số sao đánh giá
                let rateStars = '';
                for (let i = 0; i < response.rate; i++) {
                    rateStars += '<span style="color: gold;">&#9733;</span>';
                }
                for (let i = response.rate; i < 5; i++) {
                    rateStars += '<span style="color: lightgray;">&#9733;</span>';
                }


                $('#feedback-rate').html('Rate: ' + rateStars);


                $('#feedback-image').html('Rate: ' + rateStars);

                if (response.imageFeedbacks && response.imageFeedbacks.length > 0) {
                    var imageHtml = ''; // HTML cho danh sách ảnh
                    response.imageFeedbacks.forEach(function(imageBase64, index) {
                        imageHtml += '<a style="display: inline-block; margin: 5px; cursor: pointer;" onclick="showLargeImage(\'' + imageBase64 + '\')">' +
                            '<img src="data:image/jpeg;base64,' + imageBase64 + '" ' +
                            'alt="Feedback Image ' + (index + 1) + '" ' +
                            'style="max-width: 100px; max-height: 100px; border: 1px solid #ccc; "/>' +
                            '</a>';
                    });
                    $('#imageFeedback').html(imageHtml).show(); // Hiển thị danh sách ảnh trong container
                } else {
                    $('#imageFeedback').html('<p>Không có ảnh phản hồi.</p>').show(); // Hiển thị thông báo nếu không có ảnh
                }

                // Hàm để hiển thị ảnh lớn trong modal
                $('#feedback').modal('show');
                //alert(response.message);
            },
            error: function (result) {
                console.log("error");
                //alert(result.message);
            }
        });
    }
    function showLargeImage(imageBase64) {
        // Đặt ảnh trong modal
        $('#largeImage').attr('src', 'data:image/jpeg;base64,' + imageBase64);
        // Hiển thị modal
        $('#imageModal').modal('show');
    }
</script>