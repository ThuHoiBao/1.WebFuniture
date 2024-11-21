package service;

import DTO.responseDTO.ProductOfOrderResponseDTO;

import java.util.List;

public interface IProductOfOrderService {
    List<ProductOfOrderResponseDTO> getProductOfOrder(Long orderID);
}
