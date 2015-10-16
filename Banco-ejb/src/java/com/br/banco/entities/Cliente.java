/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.banco.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "CLIENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByNroConta", query = "SELECT c FROM Cliente c WHERE c.nroConta = :nroConta"),
    @NamedQuery(name = "Cliente.findByNome", query = "SELECT c FROM Cliente c WHERE c.nome = :nome"),
    @NamedQuery(name = "Cliente.findBySenha", query = "SELECT c FROM Cliente c WHERE c.senha = :senha"),
    @NamedQuery(name = "Cliente.findBySaldo", query = "SELECT c FROM Cliente c WHERE c.saldo = :saldo")})
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NRO_CONTA")
    private Integer nroConta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOME")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "SENHA")
    private String senha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SALDO")
    private Double saldo;

    public Cliente() {
    }

    public Cliente(Integer nroConta) {
        this.nroConta = nroConta;
    }

    public Cliente(Integer nroConta, String senha) {
        this.nroConta = nroConta;
        this.senha = senha;
    }

    public Cliente(Integer nroConta, String nome, String senha) {
        this.nroConta = nroConta;
        this.nome = nome;
        this.senha = senha;
    }

    public Integer getNroConta() {
        return nroConta;
    }

    public void setNroConta(Integer nroConta) {
        this.nroConta = nroConta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nroConta != null ? nroConta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.nroConta == null && other.nroConta != null) || (this.nroConta != null && !this.nroConta.equals(other.nroConta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.banco.models.Cliente[ nroConta=" + nroConta + " ]";
    }
    
}
