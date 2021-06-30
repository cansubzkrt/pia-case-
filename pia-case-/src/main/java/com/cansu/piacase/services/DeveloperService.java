package com.cansu.piacase.services;

import com.cansu.piacase.dtos.DeveloperRequest;
import com.cansu.piacase.models.DeveloperModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeveloperService {

    @Autowired
    private DeveloperRepository developerRepository;
    public List<DeveloperModel> findAll() {
        return developerRepository.findAll();
    }

    public DeveloperModel addDeveloper(DeveloperRequest request) {
        DeveloperModel developerModel = new DeveloperModel();
        developerModel.setName(request.getName());
        developerModel.setSurname(request.getSurname());
        return developerRepository.save(developerModel);
    }

    public DeveloperModel findById(Long id) {
        return developerRepository.findOne(id);
    }

    public DeveloperModel updateDeveloper(Long id, DeveloperRequest request) {
        DeveloperModel updatedDeveloper = Optional.ofNullable(developerRepository.findOne(id)).map(developer -> {
            developer.setName(request.getName());
            developer.setSurname(request.getSurname());
            return developer;
        }).get();
        return  developerRepository.save(updatedDeveloper);
    }

    public void deleteDeveloper(Long id) {
        developerRepository.delete(id);
    }
}
