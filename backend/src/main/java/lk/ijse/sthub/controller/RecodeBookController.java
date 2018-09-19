package lk.ijse.sthub.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/recodes")
public class RecodeBookController {


    @Autowired
    private ParentService parentService;




    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<ParentDTO> getAllRecodes() {
        return parentService.getAllParent();
    }


    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ParentDTO getRecode(@PathVariable("id") String parentemail) {
        return parentService.getParent(parentemail);
    }


    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean deleteRecodes(@PathVariable("id") String parentEmail) {
        return parentService.deleteParent(parentEmail);
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveRecode(@RequestBody ParentDTO parentDTO) {
        return parentService.saveParent(parentDTO);
    }


    @GetMapping(value = "/count", produces = MediaType.APPLICATION_JSON_VALUE)
    public long getTotalRecode() {
        return parentService.getTotalParent();
    }

}
