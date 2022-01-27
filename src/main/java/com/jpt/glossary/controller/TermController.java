package com.jpt.glossary.controller;

import com.jpt.glossary.model.Term;
import com.jpt.glossary.repository.TermRepository;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TermController {

    private final TermRepository termRepository;

    public TermController(TermRepository termRepository) {
        this.termRepository = termRepository;
    }

    @RequestMapping("/term")
    public String term(Model model) {
        model.addAttribute("term", termRepository.findAll());
        return "term";
    }

    @RequestMapping("/create")
    public String create(Model model) {
        return "create";
    }

    @RequestMapping("/save")
    public String save(@RequestParam String termName, @RequestParam String termDesc) {
        Term term = new Term();
        term.setTermName(termName);
        term.setTermDesc(termDesc);
        termRepository.save(term);

        return "redirect:/show/" + term.getId();
    }

    @RequestMapping("/show/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("term", termRepository.findById(id).get());
        return "show";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam String id) {
        Optional<Term> term = termRepository.findById(id);
        termRepository.delete(term.get());

        return "redirect:/term";
    }
    
    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable String id, Model model) {
        model.addAttribute("term", termRepository.findById(id).get());
        return "edit";
    }
    
    @RequestMapping("/update")
    public String update(@RequestParam String id, @RequestParam String termName, @RequestParam String termDesc) {
        Optional<Term> term = termRepository.findById(id);
        term.get().setTermName(termName);
        term.get().setTermDesc(termDesc);
        termRepository.save(term.get());

        return "redirect:/show/" + term.get().getId();
    }
}
