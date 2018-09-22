package lk.ijse.sthub.controller;

import lk.ijse.sthub.dto.AllRecordsDTO;
import lk.ijse.sthub.service.AllRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/allrecords")
public class AllRecordsController {

    @Autowired
    private AllRecordsService allRecordsService;



    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<AllRecordsDTO> getAllRecodes() {
        return allRecordsService.getAllRecods2();
    }





    @GetMapping(value = "/all/{studentname}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<AllRecordsDTO> getAllRecodes(@PathVariable("studentname") String studentName) {
        System.out.println("controller call");
        return allRecordsService.getAllRecodsByStudentName(studentName);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public AllRecordsDTO getRecords2(@PathVariable("id") long record2id) {
        return allRecordsService.getRecord2(record2id);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean deleteRecodes(@PathVariable("id") long record2id) {
        return allRecordsService.deleteAllRecord2(record2id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveRecode2(@RequestBody AllRecordsDTO allRecordsDTO) {

        return allRecordsService.saveRecord2(allRecordsDTO);
    }

    @GetMapping(value = "/count", produces = MediaType.APPLICATION_JSON_VALUE)
    public long getTotalRecode() {
        return allRecordsService.getTotalRecord2();
    }

}
