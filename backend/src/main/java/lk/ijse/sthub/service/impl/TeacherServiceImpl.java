package lk.ijse.sthub.service.impl;



import lk.ijse.sthub.dto.TeacherDTO;
import lk.ijse.sthub.dto.UserDTO;
import lk.ijse.sthub.entity.Teacher;
import lk.ijse.sthub.repository.TeacherRepository;
import lk.ijse.sthub.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TeacherServiceImpl implements TeacherService {


    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public ArrayList<TeacherDTO> getAllTeachers() {
        List<Teacher> allTeachers = teacherRepository.findAll();

        ArrayList<TeacherDTO> teacherDTOS = new ArrayList<>();

        for (Teacher teacher : allTeachers) {
            TeacherDTO teacherDTO = new TeacherDTO(

                    teacher.getName(),
                    teacher.getAddress(),
                    teacher.getContact(),
                    teacher.getEmail(),
                    teacher.getScode()
            );

            teacherDTOS.add(teacherDTO);
        }
        return teacherDTOS;


    }

    @Override
    public TeacherDTO getTeacher(String teacherEmail) {
        Teacher teacher = teacherRepository.findById(teacherEmail).get();
        return new TeacherDTO(

                teacher.getName(),
                teacher.getAddress(),
                teacher.getContact(),
                teacher.getEmail(),
                teacher.getScode()
        );

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean deleteTeacher(String teacherEmail) {
        teacherRepository.deleteById(teacherEmail);
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean saveTeacher(TeacherDTO teacherDTO) {
        Teacher student = new Teacher(
                teacherDTO.getName(),
                teacherDTO.getAddress(),
                teacherDTO.getContact(),
                teacherDTO.getEmail(),
                teacherDTO.getScode()
        );

        teacherRepository.save(student);
        return true;
    }

    @Override
    public boolean teacherValid(String username, String password) {

        System.out.println(username+password);
        boolean teach = teacherRepository.existsById(username);
        if(!teach){
            System.out.println(teach+"sssss");
            return false;
        }
        System.out.println(teach+"ffff");
        Teacher teacher = teacherRepository.findById(username).get();
        return teacher.getScode().equals(password);
    }



    @Override
    public long getTotalTeacher() {
        return teacherRepository.getTotalTeachers();
    }
}
