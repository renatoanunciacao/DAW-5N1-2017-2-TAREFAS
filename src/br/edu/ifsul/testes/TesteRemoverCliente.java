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
public class TesteRemoverCliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DAW-5N1-2017-2-TAREFAS-PU");
        EntityManager em = emf.createEntityManager();
        Cliente c = em.find(Cliente.class, 3);
        em.getTransaction().begin();
        em.remove(c);
        em.getTransaction().commit();

    }
    
}
