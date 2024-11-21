package convert;

import DTO.responseDTO.ProductOfOrderResponseDTO;
import business.Furniture;
import org.modelmapper.ModelMapper;

public class FurnitureConvert {
    private static ModelMapper modelMapper = new ModelMapper();

    public static ProductOfOrderResponseDTO convertToDTO(Furniture furniture ) {
        ProductOfOrderResponseDTO productOfOrderConvert = modelMapper.map(furniture, ProductOfOrderResponseDTO.class);
        return productOfOrderConvert;
    }
}
