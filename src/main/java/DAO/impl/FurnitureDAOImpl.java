package DAO.impl;

import DAO.IFurnitureDAO;
import business.Furniture;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class FurnitureDAOImpl implements IFurnitureDAO {
    private EntityManagerFactory emf;

    public FurnitureDAOImpl() {
        this.emf = Persistence.createEntityManagerFactory("employeePU"); // Tạo EntityManagerFactory
    }
    @Override
    public List<Furniture> getFurnituresByOrderId(Long orderId) {
        EntityManager em = emf.createEntityManager();
        String jpql = "SELECT f FROM Furniture f WHERE f.order.id = :orderId";
        TypedQuery<Furniture> query = em.createQuery(jpql, Furniture.class);
        query.setParameter("orderId", orderId);
        return query.getResultList();
    }
}
