package convert;

import model.responseDTO.CustomerResponseDTO;
import business.Customer;
import business.Address;
import org.modelmapper.ModelMapper;


public class CustomerConvert {

    private static ModelMapper modelMapper = new ModelMapper();

    // Phương thức chuyển đổi từ Customer Entity sang CustomerResponseDTO
    public static CustomerResponseDTO convertToDTO(Customer customer) {
        // Chuyển đổi Customer thành CustomerResponseDTO bằng ModelMapper
        CustomerResponseDTO dto = modelMapper.map(customer, CustomerResponseDTO.class);

        // Lấy thông tin từ Address và kết hợp thành chuỗi
        if (customer.getAddress() != null) {
            Address address = customer.getAddress();
            String fullAddress = address.getStreet() + ", " + address.getCity() + ", " + address.getProvince() + ", " + address.getCountry();
            dto.setAddress(fullAddress);  // Gán địa chỉ đã kết hợp vào DTO
        }
        return dto;
    }

}

