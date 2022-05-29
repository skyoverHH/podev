package gerbut.homework.dao;

import gerbut.homework.entity.Person;
import jakarta.persistence.EntityManager;

import java.util.List;

public class PersonDAO {
    private EntityManager entityManager;

    public PersonDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Person person) {
        entityManager.persist(person);
    }

    public void delete(Person person) {
        entityManager.remove(person);
    }

    public List<Person> findAll() {
        return entityManager.createQuery("from Person", Person.class).getResultList();
    }

    public Person findById(Long id) {
        return entityManager.find(Person.class, id);
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
