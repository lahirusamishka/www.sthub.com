package lk.ijse.sthub.controller;




import lk.ijse.sthub.dto.TeacherDTO;
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
    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<TeacherDTO> getAllTeachers(){
        return teacherService.getAllTeachers();
    }

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public TeacherDTO getTeacher(@PathVariable("id")Long teacherId){
        return teacherService.getTeacher(teacherId);
    }

    @DeleteMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public  boolean deleteTeacher(@PathVariable("id")Long treacheId){
        return teacherService.deleteTeacher(treacheId);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveTeacher(@RequestBody TeacherDTO teacherDTO){
        return teacherService.saveTeacher(teacherDTO);
    }

    @GetMapping(value = "/count",produces = MediaType.APPLICATION_JSON_VALUE)
    public long getTotalTeachers(){
        return teacherService.getTotalTeacher();
    }



}

