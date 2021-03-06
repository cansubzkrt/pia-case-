package com.cansu.piacase.controllers;

import com.cansu.piacase.dtos.DeveloperRequest;
import com.cansu.piacase.models.DeveloperModel;
import com.cansu.piacase.services.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/developer", produces = "application/json")
public class DeveloperController {

    @Autowired
    private DeveloperService developerService;

    @RequestMapping(value = "/list")
    public List<DeveloperModel> listAllDevelopers() {
        return developerService.findAll();
    }

    @RequestMapping(value = "/list/{id}")
    public DeveloperModel findById(@PathVariable Long id) {
        return developerService.findById(id);
    }

    @RequestMapping(value = "/add" , method = RequestMethod.POST)
    public DeveloperModel addDeveloper(@RequestBody DeveloperRequest request) {
        return developerService.addDeveloper(request);
    }

    @RequestMapping(value = "/update/{id}" , method = RequestMethod.PUT)
    public DeveloperModel updateDeveloper(@PathVariable Long id, @RequestBody DeveloperRequest request) {
        return developerService.updateDeveloper(id,request);
    }

    @RequestMapping(value = "/delete/{id}" , method = RequestMethod.DELETE)
    public boolean deleteDeveloper(@PathVariable Long id) {
        developerService.deleteDeveloper(id);
        return true;
    }
}
