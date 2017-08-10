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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
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
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "vaga")
public class Vaga extends Veiculo implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_vaga", sequenceName = "seq_vaga_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_vaga", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotNull(message = "O número não pode ser nulo")
    @Column(name = "numero", nullable = false)
    private Integer numero;
    @NotNull(message = "O setor não pode ser nulo")
    @NotBlank(message = "O setor não pode ser em branco")
    @Length(max = 20, message = "O setor não pode ter mais do que {max} caracteres")
    @Column(name = "setor", length = 20, nullable = false)
    private String setor;
    @NotNull(message = "O veículo não pode ser nulo")
    @ManyToOne
    @JoinColumn(name = "veiculo", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_veiculo_id")
    private Veiculo veiculo;
    
    public void Veiculo(){
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.id);
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
        final Vaga other = (Vaga) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
