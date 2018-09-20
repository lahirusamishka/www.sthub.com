package lk.ijse.sthub.repository;

import lk.ijse.sthub.entity.AllRecords;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface AllRecordsRepository extends JpaRepository<AllRecords,Long> {



    @Query("SELECT count(a.id) from AllRecords a")
    long getTotalAllRecords();

    @Query(value = "SELECT * from allrecords",nativeQuery = true)
    ArrayList<AllRecords> getAllRecordsById();

}
