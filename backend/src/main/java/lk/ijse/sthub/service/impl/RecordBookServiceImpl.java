package lk.ijse.sthub.service.impl;

import lk.ijse.sthub.dto.RecordBookDTO;
import lk.ijse.sthub.entity.AllRecords;
import lk.ijse.sthub.entity.RecordBook;
import lk.ijse.sthub.repository.AllRecordsRepository;
import lk.ijse.sthub.repository.RecordBookRepository;
import lk.ijse.sthub.service.RecordBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class RecordBookServiceImpl implements RecordBookService {

    @Autowired
    private AllRecordsRepository allRecordsRepository;

    @Autowired
    private RecordBookRepository recordBookRepository;

    @Override
    public ArrayList<RecordBookDTO> getAllRecord() {
        return null;
    }

    @Override
    public RecordBookDTO getRecord(String studentName) {
        return null;
    }

    @Override
    public boolean deleteRecord(String studentName) {
        return false;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean saveRecord(RecordBookDTO recordBookDTO) {

        RecordBook recordBook = new RecordBook();

        recordBook.setStudentName(recordBookDTO.getStudentName());
        recordBook.setTeatName(recordBookDTO.getTeatName());
        recordBook.setDate(getCurrentTimeUsingDate());
        recordBook.setMarks(recordBookDTO.getMarks());

        recordBookRepository.save(recordBook);

        AllRecords allRecords = new AllRecords();

        allRecords.setStudentName(recordBookDTO.getStudentName());
        allRecords.setTeatName(recordBookDTO.getTeatName());
        allRecords.setDate(getCurrentTimeUsingDate());
        allRecords.setMarks(recordBookDTO.getMarks());

        allRecordsRepository.save(allRecords);

        return true;

    }

    @Override
    public long getTotalRecord() {
        return 0;
    }

    @Override
    public RecordBookDTO serchRecord(String studentName) {
        return null;
    }

    public String getCurrentTimeUsingDate() {
        Date date = new Date();
        String strDateFormat = "YYYY:MM:dd";
        DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
        String formattedDate = dateFormat.format(date);
        return formattedDate;
    }

}
