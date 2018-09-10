package lk.ijse.sthub.controller;

import lk.ijse.sthub.dto.ParentUserDTO;
import lk.ijse.sthub.dto.UserDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
public class ParentController {



    @PostMapping(value = "api/v1/parentlogin", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean canAuthenticate(@RequestBody ParentUserDTO ParentUserDTO) {
//        return userService.userValid(ParentUserDTO.getUsername(), ParentUserDTO.getPassword());
        return true;
    }
}
