package lk.ijse.sthub.service;


import lk.ijse.sthub.dto.StudentDTO;

import java.util.ArrayList;

public interface StudentService {

    public ArrayList<StudentDTO> getAllStudent();

    public StudentDTO getStudent(String studentName);

    public boolean deleteStudent(String studentName);

    public boolean saveStudent(StudentDTO studentDTO);

    public long getTotalStudent();


    public ArrayList<StudentDTO> getAllStudent2(String teacherName);


    public ArrayList<StudentDTO> getAllStudentByTeamId(Long teanId);
}

