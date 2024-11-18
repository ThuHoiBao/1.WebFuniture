package service;

import model.requestDTO.CustomerRequestDTO;
import model.responseDTO.CustomerResponseDTO;

import java.util.List;

public interface ISearchCustomerService {
    List<CustomerResponseDTO> getAllCustomers(CustomerRequestDTO reqDTO);
    void lockCustomerStatus(List<String> customerIds, String reason);
    void unlockCustomerStatus(List<String> customerIds);
}
