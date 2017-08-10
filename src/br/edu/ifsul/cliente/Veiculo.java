/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.cliente;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Renato
 */
@Entity
@Table(name = "veiculo")
public class Veiculo implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_veiculo", sequenceName = "seq_veiculo_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_veiculo", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotNull(message = "A placa não pode ser nula")
    @NotBlank(message = "A placa não pode ser em branca")
    @Length(max = 8, message = "A placa não pode ter mais do que {max} caracteres")
    @Column(name = "placa", length = 8, nullable = false)
    private String placa;
    @NotNull(message = "O renavam não pode ser nulo")
    @NotBlank(message = "O renavam não pode ser em branco")
    @Length(max = 11, message = "O renavam não pode ter mais do que {max} caracteres")
    @Column(name = "renavam", length = 11, nullable = false)
    private String renavam;
    @NotNull(message = "O modelo não pode ser nulo")
    @NotBlank(message = "O modelo não pode ser em branco")
    @Length(max = 20, message = "O modelo não pode ter mais do que {max} caracteres")
    @Column(name = "modelo", length = 20, nullable = false)
    private String modelo;
     @NotNull(message = "O fabricante não pode ser nulo")
    @NotBlank(message = "O fabricante não pode ser em branco")
    @Length(max = 30, message = "O fabricante não pode ter mais do que {max} caracteres")
    @Column(name = "fabricante", length = 30, nullable = false)
    private String fabricante;
    @NotNull(message = "O ano não pode ser nulo")
    @Column(name = "ano",  nullable = false) 
    private Integer ano;
    @NotNull(message = "O cliente não pode ser nulo")
    @ManyToOne
    @JoinColumn(name = "cliente", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_cliente_id")
    private Cliente cliente;
    
    public Veiculo(){
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Veiculo other = (Veiculo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
}
