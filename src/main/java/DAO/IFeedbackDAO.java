package DAO;

import DTO.responseDTO.FeedbackResponseDTO;
import business.Order;
import business.Review;

public interface IFeedbackDAO {
    Review getFeedback(Long orderID);

}
