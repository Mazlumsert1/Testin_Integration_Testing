/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import entity.Facade;
import entity.Project;
import entity.ProjectUser;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author Mazlum
 */
public class TestFacade {

    EntityManagerFactory emfac;
    EntityManager em;
    Facade facade;


    @Before
    public void setUp() {
        emfac = mock(EntityManagerFactory.class);
        em = mock(EntityManager.class);
        facade = mock(Facade.class);
    }



    @Test
    public void FindUser(ProjectUser pUser) {


        long id = 5;
        pUser.setId(id);
        pUser.setEmail("user@tester.dk");
        pUser.setUserName("UserName");

        when(emfac.createEntityManager()).thenReturn(em);
        when(facade.getEM()).thenReturn(em);
        when(em.find(ProjectUser.class, id)).thenReturn(pUser);
        when(facade.findUser(id)).thenReturn(pUser);

        ProjectUser returnUser = facade.findUser(id);
        assertEquals(pUser, returnUser);
    }

    @Test
    public void FindProject(Project project )  {

        long id = 5;
        project.setId(id);
        project.setDescription("projectDescription");
        project.setName("project");

        when(emfac.createEntityManager()).thenReturn(em);
        when(facade.getEM()).thenReturn(em);
        when(em.find(Project.class, id)).thenReturn(project);
        when(facade.findProject(id)).thenReturn(project);

        Project found = facade.findProject(id);
        assertEquals(project, found);
    }

}
