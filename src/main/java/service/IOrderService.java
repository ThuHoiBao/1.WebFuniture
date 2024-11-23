package service;

import DTO.requestDTO.OrderRequestDTO;
import DTO.responseDTO.OrderResponseDTO;
import business.Order;

import java.util.List;

public interface IOrderService {
    List<OrderResponseDTO> getOrder(OrderRequestDTO orderRequestDTO);
    Long totalPriceOfOrder(Long orderId);
}
