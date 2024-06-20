package com.example.trainreservationsystem.controller;

import com.example.trainreservationsystem.model.Train;
import com.example.trainreservationsystem.service.TrainService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TrainController {
    @Autowired
    private TrainService trainService;

    @GetMapping("/add-train")
    public String showAddTrainForm(Model model){
        model.addAttribute("train", new Train());
        return "add-train";
    }

    @PostMapping("/add-train")
    public String addTrain(@Valid @ModelAttribute Train train, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "add-train";
        }
        trainService.saveTrain(train);
        model.addAttribute("message", "Train added successfully");
        return "add-train";
    }

    @GetMapping("/search")
    public String searchForm() {
        return "search";
    }

    @GetMapping("/results")
    public String searchResults(@RequestParam String source, @RequestParam String destination, Model model) {
        List<Train> trains = trainService.searchTrains(source, destination);
        model.addAttribute("trains", trains);
        return "results";
    }
}
