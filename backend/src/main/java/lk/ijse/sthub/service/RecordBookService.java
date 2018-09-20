package lk.ijse.sthub.service;

import lk.ijse.sthub.dto.RecordBookDTO;

import java.util.ArrayList;

public interface RecordBookService {

    public ArrayList<RecordBookDTO> getAllRecord();

    public RecordBookDTO getRecord(String studentName);

    public boolean deleteRecord(String studentName);

    public boolean saveRecord(RecordBookDTO recordBookDTO);

    public long getTotalRecord();

    public RecordBookDTO serchRecord(String studentName);
}
