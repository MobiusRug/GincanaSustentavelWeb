package br.com.springboot.bo;

import br.com.springboot.dao.StatusDAO;
import br.com.springboot.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusBO {

    @Autowired
    private StatusDAO statusDAO;

    public List<Status> obterStatus() {
        return statusDAO.listaQuantidadesPorCategoria();
    }
}
