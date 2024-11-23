package service.Impl;

import DAO.IPaymentDAO;
import DAO.impl.PaymentDAOImpl;
import DTO.responseDTO.PaymentResponseDTO;
import business.Payment;
import convert.PaymentConvert;
import service.IFurnitureOfOrderService;
import service.IPaymentService;

public class PaymentServiceImpl implements IPaymentService {
    private IPaymentDAO paymentDAO = new PaymentDAOImpl();
    private PaymentConvert paymentConvert = new PaymentConvert();
    private IFurnitureOfOrderService furnitureOfOrderService = new FurnitureOfOrderServiceImpl();
    @Override
    public PaymentResponseDTO getPayment(Long orderID) {
        Payment payment = paymentDAO.getPayment(orderID);
        PaymentResponseDTO paymentResponseDTO = new PaymentResponseDTO();
        paymentResponseDTO=paymentConvert.convertToPeyment(payment);
        Long totalPriceFurniture = furnitureOfOrderService.totalPriceOfOrder(orderID);
        paymentResponseDTO.setTotalPrice(totalPriceFurniture);
        return paymentResponseDTO;
    }

}
