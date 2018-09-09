package lk.ijse.sthub.service.impl;


import lk.ijse.sthub.entity.User;
import lk.ijse.sthub.repository.UserRepository;
import lk.ijse.sthub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly =  true)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public boolean userValid(String username, String password) {
        boolean existUser= userRepository.existsById(username);
        if (!existUser){
            return false;
        }

        User user= userRepository.findById(username).get();

        return user.getPassword().equals(password);

    }
}
