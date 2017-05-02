/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Mazlum
 */
public class Facade {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

    public EntityManager getEM() {
        return emf.createEntityManager();
    }

    public ProjectUser createUser(ProjectUser user) {
        EntityManager em = getEM();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        return user;
    }

    public ProjectUser findUser(String userName) {
        EntityManager em = getEM();
        return em.createNamedQuery("ProjectUser.findByUsername", ProjectUser.class).getSingleResult();
    }

    public ProjectUser findUser(Long id) {
        EntityManager em = getEM();
        return em.find(ProjectUser.class, id);
    }

    public List<ProjectUser> getUsers() {
        EntityManager em = getEM();
        return em.createNamedQuery("ProjectUser.findAll", ProjectUser.class).getResultList();
    }

    public List<Project> getProjects() {
        EntityManager em = getEM();
        return em.createNamedQuery("Project.findAll", Project.class).getResultList();
    }

    public Project findProject(Long id) {
        EntityManager em = getEM();
        return em.find(Project.class, id);
    }

}
