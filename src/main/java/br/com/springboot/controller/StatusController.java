package br.com.springboot.controller;

import br.com.springboot.model.Status;
import br.com.springboot.bo.StatusBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/status")
public class StatusController {

    @Autowired
    private StatusBO statusBO;

    @GetMapping
    public String status(Model model) {
        List<Status> statusList = statusBO.obterStatus();
        model.addAttribute("statusList", statusList);
        return "status/lista"; // Nome do template Thymeleaf
    }

    @GetMapping("/api")
    @ResponseBody
    public List<Status> listaStatus() {
        return statusBO.obterStatus();
    }
}
