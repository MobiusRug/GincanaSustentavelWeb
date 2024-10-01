package br.com.springboot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.springboot.bo.AlunoBO;
import br.com.springboot.model.Aluno;

@Controller
@RequestMapping("/alunos")
public class AlunoController {
	
	@Autowired
	private AlunoBO alunoBO;
	
	@RequestMapping(value = "/novo", method = RequestMethod.GET)
	public ModelAndView novo(ModelMap model) {
		model.addAttribute("aluno", new Aluno());
		return new ModelAndView("/aluno/formulario", model);
	}
	
	@RequestMapping(value = "", method=RequestMethod.POST)
	public String salva(@Valid @ModelAttribute Aluno aluno, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors())
			return "aluno/formulario";
		
		if (aluno.getId() == null) {
			alunoBO.insere(aluno);
			attr.addFlashAttribute("feedback", "Aluno foi cadastrado com sucesso");
		}
		else { 
			alunoBO.atualiza(aluno);
			attr.addFlashAttribute("feedback", "Aluno foi atualizado com sucesso");
		}
		return "redirect:/alunos";
	}
	
	@RequestMapping(value = "", method=RequestMethod.GET)
	public ModelAndView lista(ModelMap model) {
		model.addAttribute("alunos", alunoBO.listaTodos());
		return new ModelAndView("/aluno/lista", model);		
	}

	@RequestMapping(value = "/edita/{id}", method = RequestMethod.GET)
	public ModelAndView edita(@PathVariable("id") Long id, ModelMap model) {
		try {
			model.addAttribute("aluno", alunoBO.pesquisaPeloId(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("/aluno/formulario", model);
	}
	
	@RequestMapping(value = "/inativa/{id}", method = RequestMethod.GET)
	public String inativa(@PathVariable("id") Long id, RedirectAttributes attr) {
		System.out.println(id);
		try {
			Aluno cliente = alunoBO.pesquisaPeloId(id); 
			alunoBO.inativa(cliente);
			attr.addFlashAttribute("feedback", "Aluno foi inativado com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/alunos";
	}
	
	@RequestMapping(value = "/ativa/{id}", method = RequestMethod.GET)
	public String ativa(@PathVariable("id") Long id, RedirectAttributes attr) {
		System.out.println(id);
		try {
			Aluno cliente = alunoBO.pesquisaPeloId(id); 
			alunoBO.ativa(cliente);
			attr.addFlashAttribute("feedback", "Aluno foi ativado com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/alunos";
	}
}
