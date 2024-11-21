package controller.customer;

import DTO.requestDTO.OrderRequestDTO;
import DTO.responseDTO.FeedbackResponseDTO;
import DTO.responseDTO.OrderResponseDTO;
import DTO.responseDTO.ProductOfOrderResponseDTO;
import business.Order;
import com.google.gson.Gson;
import service.IFeedbackService;
import service.IOrderService;
import service.IProductOfOrderService;
import service.Impl.FeedbackServiceImpl;
import service.Impl.OrderServiceImpl;
import service.Impl.ProductOfOrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@WebServlet(urlPatterns = {"/admin/customer-order/*"})
public class ManagermentOrderController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IOrderService orderService=new OrderServiceImpl();
    private IFeedbackService feedbackService=new FeedbackServiceImpl();
    private IProductOfOrderService productOfOrderService=new ProductOfOrderServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String customerId = req.getParameter("customerId");
        String orderId = req.getParameter("orderId");
        String orderDateParam = req.getParameter("orderDate");

        OrderRequestDTO searchOrder = new OrderRequestDTO();
        searchOrder.setCustomerId(customerId);

        if (orderId != null && !orderId.trim().isEmpty()) {
            try {
                searchOrder.setOrderID(Long.parseLong(orderId));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        if (orderDateParam != null && !orderDateParam.isEmpty()) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                searchOrder.setOrderDate(dateFormat.parse(orderDateParam));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        req.setAttribute("searchOrder", searchOrder);
        List<OrderResponseDTO> orders = orderService.getOrder(searchOrder);
        req.setAttribute("orders", orders);
        String url = "/listOrder.jsp";
        getServletContext().getRequestDispatcher(url).forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        FeedbackResponseDTO responseDTO = new FeedbackResponseDTO();
        if (pathInfo != null && pathInfo.length() > 1) {
            try {
                Long orderId = Long.parseLong(pathInfo.substring(1));
                responseDTO = feedbackService.getFeedback(orderId);
                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                resp.getWriter().write(new Gson().toJson(responseDTO));
            } catch (NumberFormatException e) {
                // Nếu không phải số, gửi lỗi về phía client
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                resp.getWriter().write("Invalid ID format");
            }
        } else {

            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write("Missing or invalid path info");
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        List<ProductOfOrderResponseDTO> responseDTO=new ArrayList<>();
        if (pathInfo != null && pathInfo.length() > 1) {
            try {
                Long orderId = Long.parseLong(pathInfo.substring(1));
                responseDTO = productOfOrderService.getProductOfOrder(orderId);
                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                resp.getWriter().write(new Gson().toJson(responseDTO));
            } catch (NumberFormatException e) {
                // Nếu không phải số, gửi lỗi về phía client
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                resp.getWriter().write("Invalid ID format");
            }
        } else {

            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write("Missing or invalid path info");
        }
    }
}