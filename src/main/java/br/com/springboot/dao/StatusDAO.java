package br.com.springboot.dao;

import br.com.springboot.model.Categoria;
import br.com.springboot.model.Status;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class StatusDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Status> listaQuantidadesPorCategoria() {
        Query query = entityManager.createQuery(
            "SELECT p.categoria, SUM(p.qtd) FROM Produto p WHERE p.ativo = true GROUP BY p.categoria"
        );
        List<Object[]> resultados = query.getResultList();
        
        List<Status> statusList = new ArrayList<>();
        for (Object[] resultado : resultados) {
            Categoria categoria = (Categoria) resultado[0];
            Double quantidadeTotal = (Double) resultado[1]; // Use Double em vez de Float
            statusList.add(new Status(categoria, quantidadeTotal.floatValue())); // Converta Double para Float
        }

        return statusList;
    }
}
