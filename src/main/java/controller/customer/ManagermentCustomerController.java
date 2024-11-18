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
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String pathInfo = req.getPathInfo();
//        String reason = req.getParameter("reason");
//
//        if (pathInfo != null && pathInfo.length() > 1) {
//            String[] idArray = pathInfo.substring(1).split(",");
//            List<String> ids = Arrays.asList(idArray);
//
//            if (reason == null || reason.isEmpty()) {
//                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//                resp.getWriter().write("Lý do xóa không được để trống.");
//                return;
//            }
//
//            ISearchCustomerService customerService = new SearchCustomerServiceImpl();
//            customerService.lockCustomerStatus(ids, reason);
//            resp.setStatus(HttpServletResponse.SC_OK);
//            resp.getWriter().write("Khách hàng đã được xóa thành công.");
//        } else {
//            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//            resp.getWriter().write("Không tìm thấy ID khách hàng.");
//        }
//    }
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String pathInfo = req.getPathInfo();
    String action = req.getParameter("action");
    String reason = req.getParameter("reason");

    if (pathInfo != null && pathInfo.length() > 1) {
        String[] idArray = pathInfo.substring(1).split(",");
        List<String> ids = Arrays.asList(idArray);

        if (action == null || action.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write("Hành động không hợp lệ.");
            return;
        }


        if ("lock".equals(action)) {
            if (reason == null || reason.isEmpty()) {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                resp.getWriter().write("Lý do khóa tài khoản không được để trống.");
                return;
            }
            customerService.lockCustomerStatus(ids, reason);
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.getWriter().write("Khách hàng đã được khóa tài khoản thành công.");
        } else if ("unlock".equals(action)) {
            customerService.unlockCustomerStatus(ids);
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.getWriter().write("Khách hàng đã được mở khóa tài khoản thành công.");
        } else {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write("Hành động không được hỗ trợ.");
        }
    } else {
        resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        resp.getWriter().write("Không tìm thấy ID khách hàng.");
    }
}


}
