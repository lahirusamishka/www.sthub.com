package lk.ijse.sthub.controller;


import lk.ijse.sthub.dto.RegisterDTO;
import lk.ijse.sthub.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/registers")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveRegister(@RequestBody RegisterDTO studentDTO){
        return registerService.saveRegister(studentDTO);
    }

}
