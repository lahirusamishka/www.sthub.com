package lk.ijse.sthub.controller;

import lk.ijse.sthub.dto.RecordBookDTO;
import lk.ijse.sthub.service.RecordBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/records")
public class RecordBookController {

    @Autowired
    private RecordBookService recordBookService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<RecordBookDTO> getAllRecodes() {

        return recordBookService.getAllRecord();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public RecordBookDTO getRecode(@PathVariable("id") String studentName) {
        return recordBookService.getRecord(studentName);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean deleteRecodes(@PathVariable("id") String studentName) {
        return recordBookService.deleteRecord(studentName);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveRecode(@RequestBody RecordBookDTO recordBookDTO) {

        return recordBookService.saveRecord(recordBookDTO);
    }

    @GetMapping(value = "/count", produces = MediaType.APPLICATION_JSON_VALUE)
    public long getTotalRecode() {
        return recordBookService.getTotalRecord();
    }




}
