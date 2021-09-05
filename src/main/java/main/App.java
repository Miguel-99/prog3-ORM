package main;


import entities.Domicilio;
import entities.Persona;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class App {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EjemploPersistenciaPU");
        EntityManager em = emf.createEntityManager();
        
        try {
            em.getTransaction().begin();
            
            Persona persona = new Persona();
            persona.setNombre("Miguel");
            
            Domicilio domicilio = new Domicilio();
            domicilio.setLocalidad("Far far away");
            domicilio.setCalle("Calle 123");
            
            persona.setDomicilio(domicilio);
            em.persist(persona);
            
            em.flush();
            
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        em.close();
        emf.close();
    }
}