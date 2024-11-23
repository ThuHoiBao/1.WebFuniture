package DAO;

import DTO.responseDTO.FeedbackResponseDTO;
import business.Feedback;
import business.Order;


public interface IFeedbackDAO {
    Feedback getFeedback(Long orderID);

}
