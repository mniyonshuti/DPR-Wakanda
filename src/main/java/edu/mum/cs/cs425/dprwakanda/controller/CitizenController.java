package edu.mum.cs.cs425.dprwakanda.controller;

import edu.mum.cs.cs425.dprwakanda.model.Citizen;
import edu.mum.cs.cs425.dprwakanda.servirce.CitizenService;
import edu.mum.cs.cs425.dprwakanda.servirce.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class CitizenController {
    @Autowired
    private CitizenService citizenService;

    @Autowired
    private StateService stateService;

    @GetMapping(value = "/wakandadpr/citizen/list")
    public ModelAndView dispalyAllCitizens(@RequestParam(defaultValue = "0") Integer pageno){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("citizens", citizenService.listOfAllCitizens(pageno));
        modelAndView.addObject("currentPageNo", pageno);
        modelAndView.addObject("totalYearIncome", citizenService.NationalYearlyIncome());
        modelAndView.setViewName("citizen/list");
        return modelAndView;
    }


    @GetMapping(value = "/wakandadpr/citizen/new")
    public String displayNewCitizenPage(Model model){
        model.addAttribute("citizen", new Citizen());
        model.addAttribute("states", stateService.getAllStates());
        return "citizen/new";
    }

    @PostMapping(value = "/wakandadpr/citizen/new")
    public String saveProduct(@Valid @ModelAttribute Citizen citizen, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "citizen/new";
        }
        citizen = citizenService.saveNewCitizen(citizen);
        return "redirect:/wakandadpr/citizen/list";
    }
}
