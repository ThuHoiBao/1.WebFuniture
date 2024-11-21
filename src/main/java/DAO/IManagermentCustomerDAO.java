package DAO;

import business.Customer;
import DTO.requestDTO.CustomerRequestDTO;

import java.util.List;

public interface IManagermentCustomerDAO {
    List<Customer> getAllCustomer(CustomerRequestDTO reqDTO);
    Customer findById(String customerId);
    void updateCustomerStatus(List<String> customerIds, String status);
}