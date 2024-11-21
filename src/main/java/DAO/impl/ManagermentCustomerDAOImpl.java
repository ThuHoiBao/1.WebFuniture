package DAO.impl;

import DAO.IManagermentCustomerDAO;
import business.Customer;
import DTO.requestDTO.CustomerRequestDTO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class ManagermentCustomerDAOImpl implements IManagermentCustomerDAO {

    private EntityManagerFactory emf;

    public ManagermentCustomerDAOImpl() {
        this.emf = Persistence.createEntityManagerFactory("employeePU"); // Tạo EntityManagerFactory
    }

    @Override
    public List<Customer> getAllCustomer(CustomerRequestDTO reqDTO) {
        EntityManager em = emf.createEntityManager();
        try {
            StringBuilder queryBuilder = new StringBuilder("SELECT c FROM Customer c WHERE 1=1");
            if (reqDTO.getEmail() != null && !reqDTO.getEmail().isEmpty()) {
                queryBuilder.append(" AND c.email LIKE '%" + reqDTO.getEmail() + "%'");
            }
            if (reqDTO.getPhone() != null && !reqDTO.getPhone().isEmpty()) {
                queryBuilder.append(" AND c.phone LIKE '%" + reqDTO.getPhone() + "%'");
            }
            if (reqDTO.getName() != null && !reqDTO.getName().isEmpty()) {
                queryBuilder.append(" AND c.name LIKE '%" + reqDTO.getName() + "%'");
            }
            queryBuilder.append(" ORDER BY c.status ASC");
            TypedQuery<Customer> query = em.createQuery(queryBuilder.toString(), Customer.class);
            return query.getResultList();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Có lỗi xảy ra khi lấy danh sách khách hàng: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }
    @Override
    public Customer findById(String customerId) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Customer.class, customerId);
        } finally {
            em.close();
        }
    }
@Override
public void updateCustomerStatus(List<String> customerIds, String status) {
    EntityManager em = emf.createEntityManager();
    try {
        em.getTransaction().begin();
        // Truy vấn JPQL(Java Persistence Query Language) để cập nhật trạng thái hàng loạt
        String jpql = "UPDATE Customer c SET c.status = :status WHERE c.personID IN :ids";
        em.createQuery(jpql)
                .setParameter("status", status)
                .setParameter("ids", customerIds)
                .executeUpdate();
        em.getTransaction().commit();
    } catch (Exception e) {
        em.getTransaction().rollback();
        throw new RuntimeException("Có lỗi xảy ra khi cập nhật trạng thái hàng loạt: " + e.getMessage(), e);
    } finally {
        em.close();
    }
}

}