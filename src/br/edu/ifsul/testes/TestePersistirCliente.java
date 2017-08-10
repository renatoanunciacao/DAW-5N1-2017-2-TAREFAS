/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.cliente.Cliente;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Renato
 */
public class TestePersistirCliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DAW-5N1-2017-2-TAREFAS-PU");
        EntityManager em = emf.createEntityManager();
        Cliente c = new Cliente();
        c.setNome("Renato Anunciação");
        c.setRg("5109797422");
        c.setCpf("02584758032");
        c.setTelefone("54991975497");
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();

    }
    
}
