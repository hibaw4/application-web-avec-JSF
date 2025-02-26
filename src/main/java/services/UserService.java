package services;

import entities.User;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


import java.util.List;

@Stateless
public class UserService {
    @PersistenceContext
    private EntityManager em;

    public List<User> getAllUsers() {
        return em.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    public void addUser(User user) {
        em.persist(user);
    }

    public void deleteUser(User user) {
        em.remove(em.merge(user));
    }
}
