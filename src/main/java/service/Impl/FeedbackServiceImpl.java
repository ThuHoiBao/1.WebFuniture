package service.Impl;

import DAO.IFeedbackDAO;
import DAO.impl.FeedbackDAOImpl;
import DTO.responseDTO.FeedbackResponseDTO;
import business.Feedback;
import convert.FeedbackConvert;
import service.IFeedbackService;

public class FeedbackServiceImpl implements IFeedbackService {
    private IFeedbackDAO feedbackDAO = new FeedbackDAOImpl();
    private FeedbackConvert feedbackConvert = new FeedbackConvert();
    @Override
    public FeedbackResponseDTO getFeedback(Long orderID) {
        Feedback review=feedbackDAO.getFeedback(orderID);
        FeedbackResponseDTO feedbackResponseDTO=new FeedbackResponseDTO();
        feedbackResponseDTO=feedbackConvert.convertToDTO(review);
        return feedbackResponseDTO;
    }
}
