package com.br.banco.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author 31409695
 */
public class Cliente implements Serializable {
    
    private int nroConta;
    private String nome, senha;
    private double saldo;

    public Cliente(int nroConta, String senha) {
        this.nroConta = nroConta;
        this.senha = senha;
    }

    public Cliente() {
    }

    public Cliente(int nroConta, String nome, String senha, double saldo) {
        this.nroConta = nroConta;
        this.nome = nome;
        this.senha = senha;
        this.saldo = saldo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.nroConta;
        hash = 31 * hash + Objects.hashCode(this.nome);
        hash = 31 * hash + Objects.hashCode(this.senha);
        hash = 31 * hash + (int) (Double.doubleToLongBits(this.saldo) ^ (Double.doubleToLongBits(this.saldo) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (this.nroConta != other.nroConta) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        if (Double.doubleToLongBits(this.saldo) != Double.doubleToLongBits(other.saldo)) {
            return false;
        }
        return true;
    }

    public int getNroConta() {
        return nroConta;
    }

    public void setNroConta(int nroConta) {
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

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
}
