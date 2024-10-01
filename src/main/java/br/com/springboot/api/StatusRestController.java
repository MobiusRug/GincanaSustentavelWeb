package br.com.springboot.api;

import br.com.springboot.bo.StatusBO;
import br.com.springboot.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/status")
public class StatusRestController {

    @Autowired
    private StatusBO statusBO;

    @GetMapping
    public List<Status> listaStatus() {
        return statusBO.obterStatus();
    }
}
