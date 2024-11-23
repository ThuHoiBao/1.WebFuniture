package DAO.impl;

import DAO.IPaymentDAO;
import business.Feedback;
import business.Payment;
import service.IFurnitureOfOrderService;
import service.Impl.FurnitureOfOrderServiceImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class PaymentDAOImpl implements IPaymentDAO {
    private IFurnitureOfOrderService furnitureOfOrderService =new FurnitureOfOrderServiceImpl();

    private EntityManagerFactory emf;

    public PaymentDAOImpl() {
        this.emf = Persistence.createEntityManagerFactory("employeePU"); // Tạo EntityManagerFactory
    }
    @Override
    public Payment getPayment(Long orderID) {
        EntityManager em = emf.createEntityManager();
        StringBuilder query = new StringBuilder("SELECT r FROM Payment r WHERE r.order.id = :orderID");
        TypedQuery<Payment> queryPayment = em.createQuery(query.toString(), Payment.class);
        queryPayment.setParameter("orderID", orderID);
        return queryPayment.getSingleResult();
    }
}
