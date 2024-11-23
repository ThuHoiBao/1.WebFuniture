package convert;

import DTO.responseDTO.CustomerByIdResponseDTO;
import DTO.responseDTO.PaymentResponseDTO;
import business.Payment;
import org.modelmapper.ModelMapper;

import java.util.Base64;

public class PaymentConvert {
    private static ModelMapper modelMapper = new ModelMapper();

    public static PaymentResponseDTO convertToPeyment (Payment payment) {
        PaymentResponseDTO dto = modelMapper.map(payment, PaymentResponseDTO.class);
        return dto;
    }
}
