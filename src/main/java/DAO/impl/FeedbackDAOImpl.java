package DAO.impl;

import DAO.IFeedbackDAO;
import business.Review;
import service.IFeedbackService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class FeedbackDAOImpl implements IFeedbackDAO {
    private EntityManagerFactory emf;

    public FeedbackDAOImpl() {
        this.emf = Persistence.createEntityManagerFactory("employeePU"); // Tạo EntityManagerFactory
    }
    @Override
    public Review getFeedback(Long orderID) {
        EntityManager em = emf.createEntityManager();
        StringBuilder query = new StringBuilder("SELECT r FROM Review r WHERE r.order.orderID = :orderID");
        TypedQuery<Review> queryReview = em.createQuery(query.toString(), Review.class);
        queryReview.setParameter("orderID", orderID);
        return queryReview.getSingleResult();
    }
}
