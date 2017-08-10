/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.cliente.Cliente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Renato
 */
public class TesteListarCliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DAW-5N1-2017-2-TAREFAS-PU");
        EntityManager em = emf.createEntityManager();
        List<Cliente> lista = em.createQuery("from Cliente").getResultList();
        for(Cliente c : lista){
            System.out.println("ID: "+c.getId() + " Nome: " + c.getNome() + " RG: " + c.getRg()
                                + " CPF: "+ c.getCpf() + " Telefone : " + c.getTelefone());
        }

    }
    
}
