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

                // load ảnh
                if (response.feedbackImage !== null) {
                    $('#feedback-image').attr('src', 'data:image/jpeg;base64,' + response.feedbackImage).show();
                } else {
                    // Ẩn ảnh nếu không có
                }

                $('#feedback').modal('show');
                //alert(response.message);
            },

            error: function (result) {
                console.log("error");
                //alert(result.message);
            }
        });
    }
</script>