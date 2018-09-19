package lk.ijse.sthub.service.impl;

import lk.ijse.sthub.dto.ParentDTO;
import lk.ijse.sthub.entity.Parent;
import lk.ijse.sthub.repository.ParentRepository;
import lk.ijse.sthub.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class ParentServiceImpl implements ParentService {


    @Autowired
    private ParentRepository parentRepository;

    @Override
    public ArrayList<ParentDTO> getAllParent() {
        List<Parent> allTeachers = parentRepository.findAll();

        ArrayList<ParentDTO> teacherDTOS = new ArrayList<>();

        for (Parent teacher : allTeachers) {
            ParentDTO teacherDTO = new ParentDTO(

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
    public ParentDTO getParent(String parentEmail) {
        Parent teacher = parentRepository.findById(parentEmail).get();
        return new ParentDTO(

                teacher.getName(),
                teacher.getAddress(),
                teacher.getContact(),
                teacher.getEmail(),
                teacher.getScode()
        );
    }

    @Override
    public boolean deleteParent(String parentEmail) {
        parentRepository.deleteById(parentEmail);
        return true;
    }

    @Override
    public boolean saveParent(ParentDTO parentDTO) {
        Parent parent = new Parent();

        parent.setName(parentDTO.getName());
        parent.setEmail(parentDTO.getEmail());
        parent.setAddress(parentDTO.getAddress());
        parent.setContact(parentDTO.getContact());
        parent.setScode(parentDTO.getScode());



        parentRepository.save(parent);
        return true;
    }

    @Override
    public boolean parentValid(String username, String password) {

        boolean teach = parentRepository.existsById(username);
        if(!teach){

            return false;
        }

        Parent teacher = parentRepository.findById(username).get();
        return teacher.getScode().equals(password);
    }

    @Override
    public long getTotalParent() {
        return parentRepository.getTotalParents();
    }
}
