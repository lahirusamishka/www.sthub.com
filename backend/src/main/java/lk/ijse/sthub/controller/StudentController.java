package lk.ijse.sthub.controller;


import lk.ijse.sthub.dto.StudentDTO;
import lk.ijse.sthub.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/students")
public class StudentController {


    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<StudentDTO> getAllCustomer() {
        return studentService.getAllStudent();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public StudentDTO getStudent(@PathVariable("id") String studehtName) {
        return studentService.getStudent(studehtName);
    }

    @DeleteMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean deleteStudent(@PathVariable("id") String studehtName){
        return studentService.deleteStudent(studehtName);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveStudent(@RequestBody StudentDTO studentDTO){

        return studentService.saveStudent(studentDTO);
    }

    @GetMapping(value = "/count",produces = MediaType.APPLICATION_JSON_VALUE)
    public long getTotalStudent(){
        return studentService.getTotalStudent();
    }

}
