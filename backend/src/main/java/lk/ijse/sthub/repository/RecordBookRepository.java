package lk.ijse.sthub.repository;

import lk.ijse.sthub.entity.RecordBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RecordBookRepository extends JpaRepository<RecordBook,String> {

    @Query(value = "SELECT count(b.id) from RecordBook b")
    long getTotalParents();
}
