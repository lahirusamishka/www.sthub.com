package lk.ijse.sthub.controller;

import lk.ijse.sthub.dto.AdminUserDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
public class AdminController {

    @PostMapping(value = "api/v1/adminlogin", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean canAuthenticate(@RequestBody AdminUserDTO adminUserDTO) {
//        return userService.userValid(ParentUserDTO.getUsername(), ParentUserDTO.getPassword());
        return true;
    }
}
