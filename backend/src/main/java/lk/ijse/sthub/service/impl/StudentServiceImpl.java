package lk.ijse.sthub.service.impl;


import lk.ijse.sthub.dto.StudentDTO;
import lk.ijse.sthub.dto.TeacherDTO;
import lk.ijse.sthub.dto.TeamDTO;
import lk.ijse.sthub.entity.RecodeBook;
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

        ArrayList<Student> studentArrayList = studentRepository.getallTems2();

        ArrayList<StudentDTO> studentDTOS = new ArrayList<>();

        for (Student student : studentArrayList) {

            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setStudentname(student.getStudentname());
            studentDTO.setEmail(student.getEmail());
            studentDTO.setAddress(student.getAddress());
            studentDTO.setContact(student.getContact());
            studentDTO.setTeachername(student.getTeacher().getName());
            studentDTO.setTeamid(student.getTeam().getTeamid());


            studentDTOS.add(studentDTO);

        }


        return studentDTOS;
        /*for (Student student : studentArrayList) {
            StudentDTO studentDTO = new StudentDTO(
                    student.getStudentname(),
                    student.getEmail(),
                    student.getAddress(),
                    student.getContact(),
                    student.getTeacher().getName(),
                    student.getTeam().getTeamid(),
                    student.getRecodeBook().getRecodeBookId());

            studentDTOS.add(studentDTO);

        }*/

        /*   return studentDTOS;*/

    }

    @Override
    public StudentDTO getStudent(String studentName) {

        Student student = studentRepository.findById(studentName).get();

        Team team = student.getTeam();
        Teacher teacher = student.getTeacher();


        StudentDTO studentDTO = new StudentDTO();

        studentDTO.setStudentname(student.getStudentname());
        studentDTO.setEmail(student.getStudentname());
        studentDTO.setAddress(student.getStudentname());
        studentDTO.setContact(student.getStudentname());
        studentDTO.setTeamid(team.getTeamid());

        studentDTO.setTeachername(teacher.getName());

        return studentDTO;


    }

    @Override

    public boolean deleteStudent(String studentName) {

        Student student = studentRepository.findById(studentName).get();


        student.setStatus("delete");

        studentRepository.save(student);
        return true;
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean saveStudent(StudentDTO studentDTO) {

        Teacher teacher = teacherRepository.findById(studentDTO.getTeachername()).get();
        Team team = teamRepository.findById(studentDTO.getTeamid()).get();

        Student student = new Student();

        student.setStudentname(studentDTO.getStudentname());
        student.setEmail(studentDTO.getEmail());
        student.setAddress(studentDTO.getAddress());
        student.setContact(studentDTO.getContact());
        student.setTeacher(teacher);
        student.setTeam(team);
        student.setStatus("active");

        studentRepository.save(student);
        return true;

    }

    @Override
    public long getTotalStudent() {
        return studentRepository.getTotalStudents();
    }

    @Override
    public ArrayList<StudentDTO> getAllStudent2(String teacherName) {
        ArrayList<Student> students22 = studentRepository.getallTems2();

        ArrayList<StudentDTO> studentDTOS = new ArrayList<>();

        for (Student student : students22) {

            if (teacherName.equals(student.getTeacher().getName())) {
                if (!"delete".equals(student.getStatus())) {
                    Team team = student.getTeam();
                    StudentDTO studentDTO = new StudentDTO();

                    studentDTO.setStudentname(student.getStudentname());
                    studentDTO.setEmail(student.getEmail());
                    studentDTO.setAddress(student.getAddress());
                    studentDTO.setContact(student.getContact());
                    studentDTO.setTeachername(team.getTeacher().getName());
                    studentDTO.setTeamid(team.getTeamid());


                    studentDTOS.add(studentDTO);

                }


            }
        }
        System.out.println(studentDTOS);
        return studentDTOS;

    }
}
