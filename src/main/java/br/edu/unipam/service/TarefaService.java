/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unipam.service;

import br.edu.unipam.apptodo.entity.Tarefa;
import br.edu.unipam.apptodo.entity.Usuario;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author joao
 */
public class TarefaService {

    @PersistenceContext(name = "pu_todo")
    private EntityManager entityManager;

    @Inject // injecao de dependencia
    private UsuarioService usuarioService;

    // Inserir
    public Tarefa salvarTarefa(Tarefa tarefa, Long id) {
        Usuario user = usuarioService.localizarPorId(id);

        if (user != null) {
            tarefa.setUsuario(user);
            entityManager.persist(tarefa);
        }
        return tarefa;
    }

    // Encontrar usuario por ID
    public Tarefa localizarPorId(Long id) {
        Tarefa tarefaBd = entityManager.find(Tarefa.class, id);
        return tarefaBd;
    }

    // Editar
    public Tarefa editar(Tarefa tarefa, Long id) {

        Tarefa tarefaBd = localizarPorId(tarefa.getId());

        if (tarefaBd == null) {
            return null;
        }

        Usuario userBd = usuarioService.localizarPorId(id);
        if (userBd == null) {
            return null;
        }

        tarefa.setUsuario(userBd);
        entityManager.merge(tarefa);
        return tarefa;
    }

    // Remover
    public void remover(Long id) {
        Tarefa tarefa = localizarPorId(id);
        if (tarefa != null) {
            entityManager.remove(tarefa);
        }
    }

    //Listar Tarefas
    public List<Tarefa> listarTodos() {
        return entityManager.createQuery("Select t from Tarefa t order by t.descricao", Tarefa.class).getResultList();
    }

    //Listar Tarefas por usuarios
    public List<Tarefa> listarPorUsuario(Long id) {
        Usuario user = usuarioService.localizarPorId(id);
        return entityManager.createQuery("Select t from Tarefa t where t.usuario :user order by t.descricao", Tarefa.class)
                .setParameter("user", user)
                .getResultList();
    }
}
