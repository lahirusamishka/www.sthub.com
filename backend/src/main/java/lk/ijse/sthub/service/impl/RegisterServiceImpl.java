package lk.ijse.sthub.service.impl;


import lk.ijse.sthub.dto.RegisterDTO;
import lk.ijse.sthub.dto.StudentDTO;
import lk.ijse.sthub.entity.Register;
import lk.ijse.sthub.entity.Student;
import lk.ijse.sthub.repository.RegisterRepository;
import lk.ijse.sthub.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private RegisterRepository registerRepository;


    @Override
    public boolean saveRegister(RegisterDTO registerDTO) {


        StudentDTO studentDTO = registerDTO.getStudentDTO();

        Student student = new Student();

        student.setStId(studentDTO.getStId());

        student.setName(studentDTO.getName());
        student.setAddress(studentDTO.getAddress());
        student.setContact(studentDTO.getContact());
        student.setEmail(studentDTO.getEmail());

        Register register = new Register();
        register.setrID(registerDTO.getrID());
        register.setDate(registerDTO.getDate());
        register.setTeamID(registerDTO.getTeamId());
        register.setStudent(student);

        registerRepository.save(register);


        return true;
    }
}
