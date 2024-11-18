package service.Impl;

import DAO.ISearchCustomerDAO;
import DAO.impl.SearchCustomerDAOImpl;
import business.Customer;
import model.requestDTO.CustomerRequestDTO;
import model.responseDTO.CustomerResponseDTO;
import convert.CustomerConvert;
import service.ISearchCustomerService;
import utils.UtilsEmail;

import java.util.ArrayList;
import java.util.List;

public class SearchCustomerServiceImpl implements ISearchCustomerService {  // Đảm bảo tên lớp là CustomerServiceImpl

    private ISearchCustomerDAO customerDAO = new SearchCustomerDAOImpl();
    private CustomerConvert customerConvert = new CustomerConvert();
    // Constructor với tên khớp với tên lớp

    @Override
    public List<CustomerResponseDTO> getAllCustomers(CustomerRequestDTO reqDTO) {
        List<Customer> customers = customerDAO.getAllCustomer(reqDTO);
        List<CustomerResponseDTO> customerResponseDTOS = new ArrayList<>();
        for (Customer customer : customers) {
            CustomerResponseDTO dto = customerConvert.convertToDTO(customer);
            customerResponseDTOS.add(dto);
        }
        return customerResponseDTOS;
    }

    @Override
    public void lockCustomerStatus(List<String> customerIds, String reason) {
        for (String customerId : customerIds) {
            Customer customer = customerDAO.findById(customerId);
            if (customer != null) {
                // Cập nhật trạng thái thành "InActive"
                customerDAO.updateCustomerStatus(customerId, "InActive");

                // Gửi email thông báo
                String subject = "Funiture Shop";
                String content = "<h3>Furniture Shop</h3>"
                        + "<p><b>Thông báo khóa tài khoản tại Furniture Shop</b></p>"
                        + "<p>Chúng tôi xin thông báo rằng tài khoản của bạn trên Furniture Shop đã bị khóa.</p>"
                        + "<p>Nguyên nhân: " + reason + ".</p>"
                        + "<p>Quyết định này được đưa ra sau khi chúng tôi ghi nhận một số hoạt động không đúng quy định, gây ảnh hưởng đến quy trình hoạt động của cửa hàng.</p>"
                        + "<p>Tài khoản của bạn đã bị khóa, do đó bạn sẽ không thể truy cập và sử dụng dịch vụ trên Furniture Shop.</p>"
                        + "<p><b>Nếu có bất kỳ thắc mắc nào, vui lòng liên hệ với chúng tôi qua:</b></p>"
                        + "<ul>"
                        + "<li>Email hỗ trợ: <a href='mailto:furnitureshop267@gmail.com'>furnitureshop267@gmail.com</a></li>"
                        + "<li>Số điện thoại hỗ trợ: <a href='tel:0339263066'><b>0339263066</b></a></li>"
                        + "</ul>"
                        + "<p>Trân trọng,<br>Furniture Shop</p>";
                // Gọi hàm gửi email từ EmailUtil
                UtilsEmail.sendEmail(customer.getEmail(), subject, content);
            }
        }
    }

    @Override
    public void unlockCustomerStatus(List<String> customerIds) {
        for (String customerId : customerIds) {
            Customer customer = customerDAO.findById(customerId);
            if (customer != null) {
                // Cập nhật trạng thái thành "Active"
                customerDAO.updateCustomerStatus(customerId, "Active");

                // Nội dung email thông báo mở khóa tài khoản
                String subject = "Furniture Shop";
                String content = "<h3>Furniture Shop</h3>"
                        + "<p><b>Xin chào quý khách,</b></p>"
                        + "<p>Chúng tôi xin thông báo rằng tài khoản của bạn trên Furniture Shop đã được mở khóa thành công.</p>"
                        + "<p>Chúng tôi chân thành xin lỗi nếu quyết định khóa tài khoản trước đây đã gây ra bất kỳ bất tiện nào cho bạn. "
                        + "Sau khi xem xét lại, chúng tôi nhận thấy rằng việc khóa tài khoản có thể là do nhầm lẫn hoặc chưa đủ căn cứ.</p>"
                        + "<p>Tài khoản của bạn đã được kích hoạt lại, và bạn có thể tiếp tục truy cập và sử dụng tất cả các dịch vụ của Furniture Shop.</p>"
                        + "<p><b>Nếu bạn cần hỗ trợ thêm hoặc có bất kỳ thắc mắc nào, vui lòng liên hệ với chúng tôi qua:</b></p>"
                        + "<ul>"
                        + "<li>Email hỗ trợ: <a href='mailto:furnitureshop267@gmail.com'>furnitureshop267@gmail.com</a></li>"
                        + "<li>Số điện thoại hỗ trợ: <a href='tel:0339263066'><b>0339263066</b></a></li>"
                        + "</ul>"
                        + "<p>Chúng tôi rất mong nhận được sự thông cảm của bạn và hy vọng sẽ tiếp tục được phục vụ bạn trong tương lai.</p>"
                        + "<p>Trân trọng,<br>Furniture Shop</p>";

                // Gọi hàm gửi email từ UtilsEmail
                UtilsEmail.sendEmail(customer.getEmail(), subject, content);
            }
        }
    }
}

