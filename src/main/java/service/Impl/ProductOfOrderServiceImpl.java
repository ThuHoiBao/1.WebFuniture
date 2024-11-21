package service.Impl;

import DAO.IFurnitureDAO;
import DAO.impl.FurnitureDAOImpl;
import DTO.responseDTO.ProductOfOrderResponseDTO;
import business.Furniture;
import convert.FurnitureConvert;
import service.IProductOfOrderService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductOfOrderServiceImpl implements IProductOfOrderService {
    FurnitureConvert furnitureConvert = new FurnitureConvert();
    IFurnitureDAO furnitureDAO = new FurnitureDAOImpl();
    @Override
    public List<ProductOfOrderResponseDTO> getProductOfOrder(Long orderID) {
        List<Furniture> furnitures = furnitureDAO.getFurnituresByOrderId(orderID);
        Map<Long, ProductOfOrderResponseDTO> groupedMap = new HashMap<>();
        for (Furniture furniture : furnitures) {
            Long categoryId = furniture.getCategory().getId();
            // Lấy hoặc tạo mới ProductOfOrderResponseDTO cho Category này
            ProductOfOrderResponseDTO dto = groupedMap.getOrDefault(categoryId, new ProductOfOrderResponseDTO());
            if (dto.getCategoryName() == null) {
                dto = FurnitureConvert.convertToDTO(furniture);
            }
//            if (furniture.getCategory().getManufacture() != null) {
//                dto.setManufacture(furniture.getCategory().getManufacture());
//            }
            if (dto.getTotalPrice() == null) {
                dto.setTotalPrice(0L);
            }
            if (dto.getQuantity() == null) {
                dto.setQuantity(0L);
            }
            dto.setTotalPrice(dto.getTotalPrice() + furniture.getFurniturePrice());
            dto.setQuantity(dto.getQuantity() + 1);
            groupedMap.put(categoryId, dto);
        }
        return new ArrayList<>(groupedMap.values());
    }
}
