package com.diparth.springbootapp.controllers;

import com.diparth.springbootapp.entities.QueryReport;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class QueryController {

    @RequestMapping("/")
    public String index() {
        return "queries/query_form";
    }

    @GetMapping("/query")
    public String getQueryForm(Model model) {
        model.addAttribute("query", new QueryReport());

        return "queries/query_form";
    }

    @PostMapping("/query")
    public String postQuery(QueryReport queryReport, Model model) {
        model.addAttribute("query", new QueryReport());
        model.addAttribute("submitted", true);

        return "queries/query_form";
    }
    
    @GetMapping("/queries")
    public String getAllQueries() {
        return "queries/queries_list";
    }
}
