package DAO;

import DTO.requestDTO.OrderRequestDTO;
import business.Order;

import java.util.List;

public interface IOrderDAO {
    List<Order> getOrder(OrderRequestDTO orderRequestDTO);
}
