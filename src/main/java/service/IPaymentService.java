package service;

import DTO.responseDTO.PaymentResponseDTO;

public interface IPaymentService {
    PaymentResponseDTO getPayment(Long orderID);
}
