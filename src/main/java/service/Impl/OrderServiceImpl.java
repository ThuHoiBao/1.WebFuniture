package service.Impl;

import DAO.IOrderDAO;
import DAO.impl.OrderDAOImpl;
import DTO.requestDTO.OrderRequestDTO;
import DTO.responseDTO.OrderResponseDTO;
import business.Order;
import convert.OrderConvert;
import service.IOrderService;

import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl implements IOrderService {
    private IOrderDAO orderDAO = new OrderDAOImpl();
    private OrderConvert orderConvert = new OrderConvert();
    @Override
    public List<OrderResponseDTO> getOrder(OrderRequestDTO orderRequestDTO) {
       List<Order> orders = orderDAO.getOrder(orderRequestDTO);
       List<OrderResponseDTO> orderResponseDTOs = new ArrayList<>();
       for (Order order : orders) {
           OrderResponseDTO orderResponseDTO=new OrderResponseDTO();
           orderResponseDTO= orderConvert.convertToDTO(order);
           orderResponseDTOs.add(orderResponseDTO);
       }
        return orderResponseDTOs;
    }

    @Override
    public Long totalPriceOfOrder(Long orderId) {
        return 0l;
    }
}
