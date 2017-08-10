/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.cliente.Vaga;
import br.edu.ifsul.cliente.Veiculo;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Renato
 */
public class TestePersistirVaga {
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirVaga() {
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
            Vaga va = new Vaga();
            va.setNumero(01);
            va.setSetor("Aluguéis");
            Veiculo v = em.find(Veiculo.class, 1);
            va.setVeiculo(v);
            em.getTransaction().begin();
            em.persist(va);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            exception = true;
        }
        Assert.assertEquals(false, exception);
    }
}
