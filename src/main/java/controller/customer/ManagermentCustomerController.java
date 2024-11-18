package controller.customer;
import service.ISearchCustomerService;
import service.Impl.SearchCustomerServiceImpl;
import model.requestDTO.CustomerRequestDTO;
import model.responseDTO.CustomerResponseDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet(urlPatterns = {"/admin/customer-list/*"})

public class ManagermentCustomerController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ISearchCustomerService customerService=new SearchCustomerServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        CustomerRequestDTO reqDTO = new CustomerRequestDTO();
        reqDTO.setName(req.getParameter("name"));
        reqDTO.setPhone(req.getParameter("phone"));
        reqDTO.setEmail(req.getParameter("email"));
        List<CustomerResponseDTO> customerList = customerService.getAllCustomers(reqDTO);
        req.setAttribute("customerList", customerList);
        req.setAttribute("customerSearch", reqDTO);
        String url = "/listCustomer.jsp";
        getServletContext().getRequestDispatcher(url).forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Lấy ID từ path info
        String pathInfo = req.getPathInfo(); // Lấy phần sau "/customer-list"
        if (pathInfo != null && pathInfo.length() > 1) {
            String idsParam = pathInfo.substring(1); // Bỏ ký tự '/' đầu tiên
            String[] idArray = idsParam.split(","); // Tách chuỗi thành mảng
            List<String> ids = Arrays.asList(idArray); // Chuyển mảng sang danh sách;

            resp.setStatus(HttpServletResponse.SC_OK);
            resp.getWriter().write("Customer(s) deleted successfully.");
        } else {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write("No customer ID provided.");
        }
    }
}
