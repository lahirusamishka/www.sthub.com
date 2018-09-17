package lk.ijse.sthub.controller;

import lk.ijse.sthub.dto.ParentDTO;
import lk.ijse.sthub.dto.ParentUserDTO;
import lk.ijse.sthub.dto.UserDTO;
import lk.ijse.sthub.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/parents")
public class ParentController {

    private final ParentService parentService;

    @Autowired
    public ParentController(ParentService parentService) {
        this.parentService = parentService;
    }


    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean canAuthenticate(@RequestBody UserDTO userDTO) {
        System.out.println(userDTO);
        return parentService.parentValid(userDTO.getUsername(), userDTO.getPassword());

    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<ParentDTO> getAllTeachers(){
        return parentService.getAllParent();
    }

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ParentDTO getParent(@PathVariable("id")String parentemail){
        return parentService.getParent(parentemail);
    }

    @DeleteMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public  boolean deleteParent(@PathVariable("id")String parentEmail){
        return parentService.deleteParent(parentEmail);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveParent(@RequestBody ParentDTO parentDTO){
        return parentService.saveParent(parentDTO);
    }

    @GetMapping(value = "/count",produces = MediaType.APPLICATION_JSON_VALUE)
    public long getTotalParent(){
        return parentService.getTotalParent();
    }}
