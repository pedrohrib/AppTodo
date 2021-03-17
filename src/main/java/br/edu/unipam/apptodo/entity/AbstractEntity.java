/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unipam.apptodo.entity;

import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author joao
 */

@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    protected Date DataCricao;
    protected Date DataAlteracao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataCricao() {
        return DataCricao;
    }

    public void setDataCricao(Date DataCricao) {
        this.DataCricao = DataCricao;
    }

    public Date getDataAlteracao() {
        return DataAlteracao;
    }

    public void setDataAlteracao(Date DataAlteracao) {
        this.DataAlteracao = DataAlteracao;
    }

}
