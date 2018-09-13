package lk.ijse.sthub.service;





import lk.ijse.sthub.dto.TeacherDTO;
import lk.ijse.sthub.dto.UserDTO;

import java.util.ArrayList;

public interface TeacherService {
    public ArrayList<TeacherDTO>  getAllTeachers();

    public TeacherDTO getTeacher(String teacherEmail);

    public boolean deleteTeacher(String teacherEmail);

    public boolean saveTeacher(TeacherDTO teacherDTO);

    public boolean teacherValid(String username,String password);

    public long getTotalTeacher();
}
