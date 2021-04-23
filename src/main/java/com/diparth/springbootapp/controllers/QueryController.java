package com.diparth.springbootapp.controllers;

import com.diparth.springbootapp.entities.QueryReport;
import com.diparth.springbootapp.repositories.QueryRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class QueryController {
    QueryRepository queryRepository;

    @RequestMapping("/")
    public String index() {
        return "welcome";
    }

    @GetMapping("/query")
    public String getQueryForm(Model model, @RequestParam(name = "submitted", required = false) boolean submitted) {
        model.addAttribute("submitted", submitted);
        model.addAttribute("queryForm", new QueryReport());

        return "queries/query_form";
    }

    @PostMapping("/query")
    public String postQuery(QueryReport queryReport, RedirectAttributes ra) {
        this.queryRepository.save(queryReport);

        ra.addAttribute("submitted", true);
        
        return "redirect:/query";
    }
    
    @GetMapping("/queries")
    public String getAllQueries(Model model) {
        model.addAttribute("queries", this.queryRepository.findAllButPrivate());

        return "queries/queries_list";
    }
}
