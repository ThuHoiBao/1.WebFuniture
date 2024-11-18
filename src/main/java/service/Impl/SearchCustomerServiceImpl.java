package service.Impl;

import DAO.ISearchCustomerDAO;
import DAO.impl.SearchCustomerDAOImpl;
import business.Customer;
import model.requestDTO.CustomerRequestDTO;
import model.responseDTO.CustomerResponseDTO;
import convert.CustomerConvert;
import service.ISearchCustomerService;

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

}
