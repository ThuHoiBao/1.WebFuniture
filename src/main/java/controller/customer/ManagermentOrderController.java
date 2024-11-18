package controller.customer;

import model.requestDTO.CustomerRequestDTO;
import model.responseDTO.CustomerResponseDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/admin/customer-order/*"})
public class ManagermentOrderController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Lấy customerId từ URL
        String pathInfo = req.getPathInfo(); // /{id}
        if (pathInfo == null || pathInfo.equals("/")) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Customer ID is missing");
            return;
        }

        // Lấy ID khách hàng
        String customerId = pathInfo.substring(1); // Bỏ dấu "/"

        // Truy vấn danh sách đơn hàng của khách hàng (giả sử sử dụng DAO)
        //List<Order> orders = OrderDAO.getOrdersByCustomerId(Integer.parseInt(customerId));

        // Lưu danh sách đơn hàng vào request attribute
        req.setAttribute("orders", "thu");

        // Chuyển tiếp đến trang listOrder.jsp
        req.getRequestDispatcher("/listOrder.jsp").forward(req, resp);
    }



}