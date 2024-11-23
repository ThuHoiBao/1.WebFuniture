package convert;

import DTO.responseDTO.FeedbackResponseDTO;
import business.Feedback;
import business.ImageFeedback;
import org.modelmapper.ModelMapper;

import java.util.Base64;
import java.util.stream.Collectors;

public class FeedbackConvert {
    private static ModelMapper modelMapper = new ModelMapper();

    public static FeedbackResponseDTO convertToDTO(Feedback review) {
        // Chuyển đổi các thuộc tính cơ bản từ Review sang FeedbackResponseDTO
        FeedbackResponseDTO feedbackResponseDTO = modelMapper.map(review, FeedbackResponseDTO.class);

        // Chuyển đổi danh sách ImageFeedback
        if (review.getImageFeedbacks() != null) {
            feedbackResponseDTO.setImageFeedbacks(
                    review.getImageFeedbacks().stream()
                            .map(imageFeedback -> Base64.getEncoder().encodeToString(imageFeedback.getFeedbackImage()))
                            .collect(Collectors.toList())
            );
        }

        return feedbackResponseDTO;
    }
}
