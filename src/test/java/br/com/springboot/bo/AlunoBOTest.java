package br.com.springboot.bo;

import java.util.List;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.springboot.model.Aluno;

@SpringBootTest
@ExtendWith(SpringExtension.class)
final public class AlunoBOTest {

	@Autowired
	private AlunoBO bo;

	public void pesquisaPeloId() {
		Aluno cliente = bo.pesquisaPeloId(1L);
		System.out.println(cliente);
	}
	
	public void lista() {
		List<Aluno> clientes = bo.listaTodos();
		for (Aluno cliente : clientes) {
			System.out.println(cliente);
		}
	}
	
	public void inativa() {
		Aluno cliente = bo.pesquisaPeloId(1L);
		bo.inativa(cliente);
	}
	
	public void remove() {
		Aluno cliente = bo.pesquisaPeloId(1L);
		bo.remove(cliente);
	}
}
