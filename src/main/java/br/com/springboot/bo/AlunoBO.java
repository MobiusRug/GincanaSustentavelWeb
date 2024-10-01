package br.com.springboot.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.springboot.dao.CRUD;
import br.com.springboot.dao.AlunoDAO;
import br.com.springboot.model.Aluno;

@Service
public class AlunoBO implements CRUD<Aluno, Long> {

	@Autowired
	private AlunoDAO dao;

	@Override
	public Aluno pesquisaPeloId(Long id) {
		return dao.pesquisaPeloId(id);
	}

	@Override
	public List<Aluno> listaTodos() {
		return dao.listaTodos();
	}

	@Override
	public void insere(Aluno aluno) {
		dao.insere(aluno);
	}

	@Override
	public void atualiza(Aluno aluno) {
		dao.atualiza(aluno);
	}

	@Override
	public void remove(Aluno aluno) {
		dao.remove(aluno);
	}
	
	public void inativa(Aluno aluno) {
		aluno.setAtivo(false);
		dao.atualiza(aluno);
	}
	
	public void ativa(Aluno aluno) {
		aluno.setAtivo(true);
		dao.atualiza(aluno);
	}
}