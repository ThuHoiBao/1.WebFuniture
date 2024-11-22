package DAO;

import DTO.responseDTO.CustomerByIdResponseDTO;
import business.Customer;
import DTO.requestDTO.CustomerRequestDTO;

import java.util.List;

public interface IManagermentCustomerDAO {
    List<Customer> getAllCustomer(CustomerRequestDTO reqDTO);
    Customer findById(Long customerId);
    void updateCustomerStatus(List<Long> customerIds, String status);

}