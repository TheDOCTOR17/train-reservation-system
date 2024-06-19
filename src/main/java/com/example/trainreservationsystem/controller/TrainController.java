package com.example.trainreservationsystem.controller;

import com.example.trainreservationsystem.model.Train;
import com.example.trainreservationsystem.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TrainController {
    @Autowired
    private TrainService trainService;

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
