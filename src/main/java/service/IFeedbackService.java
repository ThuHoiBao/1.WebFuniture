package service;

import DTO.responseDTO.FeedbackResponseDTO;

public interface IFeedbackService {
    FeedbackResponseDTO getFeedback(Long orderID);
}
