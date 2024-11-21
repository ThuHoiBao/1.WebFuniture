package service;

import DTO.requestDTO.CustomerRequestDTO;
import DTO.responseDTO.CustomerResponseDTO;

import java.util.List;

public interface IManagermentCustomerService {
    List<CustomerResponseDTO> getAllCustomers(CustomerRequestDTO reqDTO);
    void lockCustomerStatus(List<String> customerIds, String reason);
    void unlockCustomerStatus(List<String> customerIds);
}
