package lk.ijse.sthub.service.impl;



import lk.ijse.sthub.dto.TeacherDTO;
import lk.ijse.sthub.entity.Teacher;
import lk.ijse.sthub.repository.TeacherRepository;
import lk.ijse.sthub.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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
                    teacher.getTid(),
                    teacher.getName(),
                    teacher.getAddress(),
                    teacher.getContact(),
                    teacher.getEmail());

            teacherDTOS.add(teacherDTO);
        }
        return teacherDTOS;


    }

    @Override
    public TeacherDTO getTeacher(Long teacherId) {
        Teacher teacher = teacherRepository.findById(teacherId).get();
        return new TeacherDTO(
                teacher.getTid(),
                teacher.getName(),
                teacher.getAddress(),
                teacher.getContact(),
                teacher.getEmail()
        );

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean deleteTeacher(Long teacherId) {
        teacherRepository.deleteById(teacherId);
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean saveTeacher(TeacherDTO teacherDTO) {
        Teacher student = new Teacher(
                teacherDTO.getName(),
                teacherDTO.getAddress(),
                teacherDTO.getContact(),
                teacherDTO.getEmail()
        );

        teacherRepository.save(student);
        return true;
    }

    @Override
    public long getTotalTeacher() {
        return teacherRepository.getTotalTeachers();
    }
}
