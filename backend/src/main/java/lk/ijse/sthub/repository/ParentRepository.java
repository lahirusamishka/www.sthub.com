package lk.ijse.sthub.repository;

import lk.ijse.sthub.entity.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ParentRepository extends JpaRepository<Parent,String> {

    @Query(value = "SELECT count(p.id) from Parent p")
    long getTotalParents();

}
