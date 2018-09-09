package lk.ijse.sthub.service;





import lk.ijse.sthub.dto.TeacherDTO;

import java.util.ArrayList;

public interface TeacherService {
    public ArrayList<TeacherDTO>  getAllTeachers();

    public TeacherDTO getTeacher(Long teacherId);

    public boolean deleteTeacher(Long teacherId);

    public boolean saveTeacher(TeacherDTO teacherDTO);

    public long getTotalTeacher();
}
