package lk.ijse.sthub.service.impl;

import lk.ijse.sthub.dto.AllRecordsDTO;
import lk.ijse.sthub.entity.AllRecords;
import lk.ijse.sthub.repository.AllRecordsRepository;
import lk.ijse.sthub.service.AllRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AllRecordsServiceImpl implements AllRecordsService {

    @Autowired
    private AllRecordsRepository allRecordsRepository;

    @Override
    public ArrayList<AllRecordsDTO> getAllRecods2() {
        List<AllRecords> all = allRecordsRepository.findAll();

        ArrayList<AllRecordsDTO> allRecordsDTOS = new ArrayList<>();

        for (AllRecords allRecords : all) {

            AllRecordsDTO allRecordsDTO = new AllRecordsDTO();

            allRecordsDTO.setARId(allRecords.getARId());
            allRecordsDTO.setStudentName(allRecords.getStudentName());
            allRecordsDTO.setTeatName(allRecords.getTeatName());
            allRecordsDTO.setDate(allRecords.getDate());
            allRecordsDTO.setMarks(allRecords.getMarks());

            allRecordsDTOS.add(allRecordsDTO);
        }

        return allRecordsDTOS;

    }

    @Override
    public AllRecordsDTO getRecord2(Long allRecods2Id) {
        return null;
    }

    @Override
    public boolean deleteAllRecord2(Long allRecods2Id) {
        return false;
    }

    @Override
    public boolean saveRecord2(AllRecordsDTO recordBookDTO) {
        return false;
    }

    @Override
    public long getTotalRecord2() {
        return 0;
    }

    @Override
    public AllRecordsDTO serchRecord2(String studentName) {
        return null;
    }

    @Override
    public ArrayList<AllRecordsDTO> getAllRecodsByStudentName(String studentName) {

        System.out.println(studentName);
        ArrayList<AllRecords> allRecordsById = allRecordsRepository.getAllRecordsById();

        System.out.println(allRecordsById);
        ArrayList<AllRecordsDTO> allRecordsDTOS = new ArrayList<>();

        for (AllRecords allRecords : allRecordsById) {

            if (studentName.equals(allRecords.getStudentName())) {

                System.out.println("awa");
                AllRecordsDTO allRecordsDTO = new AllRecordsDTO();

                allRecordsDTO.setARId(allRecords.getARId());
                allRecordsDTO.setStudentName(allRecords.getStudentName());
                allRecordsDTO.setTeatName(allRecords.getTeatName());
                allRecordsDTO.setDate(allRecords.getDate());
                allRecordsDTO.setMarks(allRecords.getMarks());

                allRecordsDTOS.add(allRecordsDTO);
            }

        }

        return allRecordsDTOS;

    }


}
