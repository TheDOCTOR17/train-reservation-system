package com.example.trainreservationsystem.service;

import com.example.trainreservationsystem.model.Train;
import com.example.trainreservationsystem.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainService {
    @Autowired
    private TrainRepository trainRepository;

    public void saveTrain(Train train){
        trainRepository.save(train);
    }

    public List<Train> searchTrains(String source, String destination) {
        return trainRepository.findBySourceAndDestination(source, destination);
    }
}
