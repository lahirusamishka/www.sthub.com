package lk.ijse.sthub.service;




import lk.ijse.sthub.dto.StudentDTO;

import java.util.ArrayList;

public interface StudentService {

    public ArrayList<StudentDTO> getAllStudent();

    public StudentDTO getStudent(Long studentId);

    public boolean deleteStudent(Long studentId);

    public boolean saveStudent(StudentDTO studentDTO);

    public long getTotalStudent();

}

