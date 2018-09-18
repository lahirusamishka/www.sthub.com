package lk.ijse.sthub.service.impl;


import lk.ijse.sthub.dto.StudentDTO;
import lk.ijse.sthub.dto.TeacherDTO;
import lk.ijse.sthub.dto.TeamDTO;
import lk.ijse.sthub.entity.Student;
import lk.ijse.sthub.entity.Teacher;
import lk.ijse.sthub.entity.Team;
import lk.ijse.sthub.repository.StudentRepository;
import lk.ijse.sthub.repository.TeacherRepository;
import lk.ijse.sthub.repository.TeamRepository;
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

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public ArrayList<StudentDTO> getAllStudent() {
        List<Student> allstudents = studentRepository.findAll();
        ArrayList<StudentDTO> studentDTOS = new ArrayList<>();

        for (Student student : allstudents) {
            StudentDTO studentDTO = new StudentDTO(
                    student.getStudentname(),
                    student.getEmail(),
                    student.getAddress(),
                    student.getContact(),
                    student.getTeacher().getName(),
                    student.getTeam().getTeamid(),
                    student.getRecodeBook().getRecodeBookId()
            );

            studentDTOS.add(studentDTO);

        }
        return studentDTOS;
    }

    @Override
    public StudentDTO getStudent(String studentName) {
        Student student = studentRepository.findById(studentName).get();

        return new StudentDTO(
                student.getStudentname(),
                student.getEmail(),
                student.getAddress(),
                student.getContact(),
                student.getTeacher().getName(),
                student.getTeam().getTeamid(),
                student.getRecodeBook().getRecodeBookId()
        );
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean deleteStudent(String studentName) {
        studentRepository.deleteById(studentName);
        return true;
    }



    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean saveStudent(StudentDTO studentDTO) {

        Teacher teacher = teacherRepository.findById(studentDTO.getTeachername()).get();
        Team team = teamRepository.findById(studentDTO.getTeamid()).get();

        Student student= new Student();

        student.setStudentname(studentDTO.getStudentname());
        student.setEmail(studentDTO.getEmail());
        student.setAddress(studentDTO.getAddress());
        student.setContact(studentDTO.getContact());
        student.setTeacher(teacher);
        student.setTeam(team);

        studentRepository.save(student);
        return true;

    }

    @Override
    public long getTotalStudent() {
       return studentRepository.getTotalStudents();
    }
}
