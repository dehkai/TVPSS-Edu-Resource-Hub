package com.codecrafters.tvpss.dao;

import com.codecrafters.tvpss.model.ResourceRequestModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ResourceRequestDao {

    @Autowired
    private SessionFactory sessionFactory;

    public List<ResourceRequestModel> findByStatus(String status) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery(
                    "FROM ResourceRequestModel WHERE LOWER(status) = :status",
                    ResourceRequestModel.class)
                    .setParameter("status", status.toLowerCase())
                    .getResultList();
        }
    }

    public ResourceRequestModel findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(ResourceRequestModel.class, id);
        }
    }

    public void save(ResourceRequestModel request) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            try {
                session.persist(request);
                tx.commit();
            } catch (Exception e) {
                tx.rollback();
                throw e;
            }
        }
    }

    public void update(ResourceRequestModel request) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            try {
                session.merge(request);
                tx.commit();
            } catch (Exception e) {
                tx.rollback();
                throw e;
            }
        }
    }

    public void delete(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            try {
                ResourceRequestModel request = session.get(ResourceRequestModel.class, id);
                if (request != null) {
                    session.remove(request);
                }
                tx.commit();
            } catch (Exception e) {
                tx.rollback();
                throw e;
            }
        }
    }

    public List<ResourceRequestModel> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery(
                    "FROM ResourceRequestModel",
                    ResourceRequestModel.class)
                    .getResultList();
        }
    }
}