package br.com.springboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.springboot.model.Aluno;

@Repository
@Transactional
public class AlunoDAO implements CRUD<Aluno, Long> {

	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
	public Aluno pesquisaPeloId(Long id) {
		return entityManager.find(Aluno.class, id);
	}

	@Override
	public List<Aluno> listaTodos() {
		Query query = entityManager.createQuery("SELECT c FROM Aluno c");
	    return (List<Aluno>) query.getResultList();
	}

	@Override
	public void insere(Aluno aluno) {
		entityManager.persist(aluno);
	}

	@Override
	public void atualiza(Aluno aluno) {
		entityManager.merge(aluno);
	}

	@Override
	public void remove(Aluno aluno) {
		entityManager.remove(aluno);
	}
}