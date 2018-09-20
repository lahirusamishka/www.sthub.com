package lk.ijse.sthub.service;

import lk.ijse.sthub.dto.AllRecordsDTO;

import java.util.ArrayList;

public interface AllRecordsService {

    public ArrayList<AllRecordsDTO> getAllRecods2();

    public AllRecordsDTO getRecord2(Long allRecods2Id);

    public boolean deleteAllRecord2(Long allRecods2Id);

    public boolean saveRecord2(AllRecordsDTO recordBookDTO);

    public long getTotalRecord2();

    public AllRecordsDTO serchRecord2(String studentName);

    public ArrayList<AllRecordsDTO> getAllRecodsByStudentName(String studentName);
}
