package com.kasandra.controller;

import com.kasandra.entity.Cat;
import com.kasandra.service.CatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class CatsController {

    @Autowired
    public CatsService catsService;

    public static final String CREATE_VIEW = "create";
    public static final String MENU = "menu";
    public static final String VIEW_LIST = "catsList";
    public static final String EDIT_VIEW = "edit";

    @GetMapping("/")
    public String index() {
        return MENU;
    }

    @GetMapping("/menu")
    public String menu(){
        return MENU;
    }

    @GetMapping("/search")
    public String getAllCats(Model model) {
        model.addAttribute("cats", catsService.searchAll());
        return VIEW_LIST;
    }

    @PostMapping("/searchCat")
    public String searchCat(@ModelAttribute("cat") Cat cat, Model model){
        model.addAttribute("cats", catsService.getByName(cat.getName()));
        return VIEW_LIST;
    }

    @GetMapping("/create")
    public String create(Model model) {
        return CREATE_VIEW;
    }

    @PostMapping("/create")
    public String createCat(@ModelAttribute("cat") Cat cat, Model model){
        try {
            catsService.create(cat);
            return "redirect:/search";
        } catch (Exception e){
            model.addAttribute("name", true);
            return CREATE_VIEW;
        }
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, Model model){
        model.addAttribute("cat", catsService.getById(id));
        return EDIT_VIEW;
    }

    @PostMapping("/updateCat")
    public String updateCat(@ModelAttribute("cat") Cat cat, Model model){
        try {
            catsService.update(cat);
            return "redirect:/search";
        } catch (Exception e){
            model.addAttribute("name", true);
            return EDIT_VIEW;
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteCat(@PathVariable("id") Long id){
        catsService.delete(id);
        return "redirect:/search";
    }


}
