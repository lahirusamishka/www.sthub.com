package lk.ijse.sthub.service.impl;


import lk.ijse.sthub.dto.StudentDTO;
import lk.ijse.sthub.entity.Student;
import lk.ijse.sthub.repository.StudentRepository;
import lk.ijse.sthub.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public ArrayList<StudentDTO> getAllStudent() {
        List<Student> allstudents = studentRepository.findAll();
        ArrayList<StudentDTO> studentDTOS = new ArrayList<>();

        for (Student student : allstudents) {
            StudentDTO studentDTO = new StudentDTO(
                    student.getStId(),
                    student.getName(),
                    student.getAddress(),
                    student.getContact(),
                    student.getEmail());

            studentDTOS.add(studentDTO);

        }
        return studentDTOS;
    }

    @Override
    public StudentDTO getStudent(Long studentId) {
        Student student = studentRepository.findById(studentId).get();


        return new StudentDTO(
                student.getStId(),
                student.getName(),
                student.getAddress(),
                student.getContact(),
                student.getEmail());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean deleteStudent(Long studentId) {

        studentRepository.deleteById(studentId);
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean saveStudent(StudentDTO studentDTO) {
        Student student= new Student(
                studentDTO.getStId(),
                studentDTO.getName(),
                studentDTO.getAddress(),
                studentDTO.getContact(),
                studentDTO.getEmail()
        );

        studentRepository.save(student);
        return true;

    }

    @Override
    public long getTotalStudent() {
       return studentRepository.getTotalStudents();
    }
}
