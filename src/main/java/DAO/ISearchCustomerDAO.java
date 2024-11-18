package DAO;

import business.Customer;
import model.requestDTO.CustomerRequestDTO;

import java.util.List;

public interface ISearchCustomerDAO {
    List<Customer> getAllCustomer(CustomerRequestDTO reqDTO);
}
