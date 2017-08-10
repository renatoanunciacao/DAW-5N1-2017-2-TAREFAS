/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.cliente.Cliente;
import br.edu.ifsul.cliente.Veiculo;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Renato
 */
public class TestePersistirVeiculo {
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirVeiculo() {
    }
    
    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("DAW-5N1-2017-2-TAREFAS-PU");
        em = emf.createEntityManager();
    }
    
    @After
    public void tearDown() {
        em.close();
        emf.close();
    }
    
    @Test
    public void teste(){
       boolean exception = false;
       try{
           Veiculo v = new Veiculo();
           v.setPlaca("ALS-7458");
           v.setRenavam("00861118960");
           v.setModelo("Palio");
           v.setFabricante("Fiat");
           v.setAno(2012);
           Cliente c = em.find(Cliente.class, 2);
           v.setCliente(c);
           em.getTransaction().begin();
           em.persist(v);
           em.getTransaction().commit();
       }catch(Exception e){
           e.printStackTrace();
           exception = true;
       }
       Assert.assertEquals(false, exception);
    }
    
}
