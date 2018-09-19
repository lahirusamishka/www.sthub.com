package lk.ijse.sthub.controller;


import lk.ijse.sthub.dto.TeacherDTO;
import lk.ijse.sthub.dto.UserDTO;
import lk.ijse.sthub.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;
    /*teacher login*/
    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean canAuthenticate(@RequestBody UserDTO userDTO) {
        System.out.println(userDTO);
        return teacherService.teacherValid(userDTO.getUsername(), userDTO.getPassword());
    }
    /*get all teachers*/
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<TeacherDTO> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    /*search teachers by teacher name*/
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public TeacherDTO getTeacher(@PathVariable("id") String teacheremail) {
        return teacherService.getTeacher(teacheremail);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean deleteTeacher(@PathVariable("id") String treacheEmail) {
        return teacherService.deleteTeacher(treacheEmail);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveTeacher(@RequestBody TeacherDTO teacherDTO) {
        return teacherService.saveTeacher(teacherDTO);
    }

    @GetMapping(value = "/count", produces = MediaType.APPLICATION_JSON_VALUE)
    public long getTotalTeachers() {
        return teacherService.getTotalTeacher();
    }


}

