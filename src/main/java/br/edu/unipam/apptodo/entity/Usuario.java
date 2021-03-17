/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unipam.apptodo.entity;

import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author joao
 */
@Entity
@NamedQuery(name = Usuario.GET_ALL_USERS, query = "select u from Usuario u order by u.nome")
public class Usuario extends AbstractEntity {

    public static final String GET_ALL_USERS = "Usuario.getAllUsers";

    private String nome;
    private String Email;

    @OneToMany(mappedBy = "usuario")
    private Collection<Tarefa> tarefas;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

}
