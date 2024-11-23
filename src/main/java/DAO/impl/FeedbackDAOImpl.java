package DAO.impl;

import DAO.IFeedbackDAO;
import business.Feedback;
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
    public Feedback getFeedback(Long orderID) {
        EntityManager em = emf.createEntityManager();
        StringBuilder query = new StringBuilder("SELECT r FROM Feedback r WHERE r.order.id = :orderID");
        TypedQuery<Feedback> queryReview = em.createQuery(query.toString(), Feedback.class);
        queryReview.setParameter("orderID", orderID);
        return queryReview.getSingleResult();
    }
}
