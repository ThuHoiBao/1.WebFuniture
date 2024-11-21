package convert;

import DTO.responseDTO.FeedbackResponseDTO;
import DTO.responseDTO.OrderResponseDTO;
import business.Review;
import org.modelmapper.ModelMapper;

import java.util.Base64;

public class FeedbackConvert {
    private static ModelMapper modelMapper = new ModelMapper();

    public static FeedbackResponseDTO convertToDTO(Review review) {
        // Chuyển đổi các thuộc tính khác từ Review sang FeedbackResponseDTO
        FeedbackResponseDTO feedbackResponseDTO = modelMapper.map(review, FeedbackResponseDTO.class);

        // Chuyển đổi mảng byte của feedbackImage thành chuỗi Base64
        if (review.getFeedbackImage() != null) {
            String base64Image = Base64.getEncoder().encodeToString(review.getFeedbackImage());
            feedbackResponseDTO.setFeedbackImage(base64Image);
        }

        return feedbackResponseDTO;
    }
}
