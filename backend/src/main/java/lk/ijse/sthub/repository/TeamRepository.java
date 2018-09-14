package lk.ijse.sthub.repository;


import lk.ijse.sthub.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface TeamRepository extends JpaRepository<Team,Long> {

    @Query(value = "SELECT count(tm.id) from Team tm")
    long getTotalTeachers();

    @Query(value = "SELECT * from team",nativeQuery = true)
    ArrayList<Team> getallTems();

}
