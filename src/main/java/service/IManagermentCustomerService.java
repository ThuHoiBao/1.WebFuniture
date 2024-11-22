package service;

import DTO.requestDTO.CustomerRequestDTO;
import DTO.responseDTO.CustomerByIdResponseDTO;
import DTO.responseDTO.CustomerResponseDTO;

import java.util.List;

public interface IManagermentCustomerService {
    List<CustomerResponseDTO> getAllCustomers(CustomerRequestDTO reqDTO);
    void lockCustomerStatus(List<Long> customerIds, String reason);
    void unlockCustomerStatus(List<Long> customerIds);
    CustomerResponseDTO getCustomerById(Long customerId);
}
