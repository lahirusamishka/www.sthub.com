package lk.ijse.sthub.repository;



import lk.ijse.sthub.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface StudentRepository extends JpaRepository<Student,String> {

    @Query(value = "select count(s.id) from Student s")
    long getTotalStudents();

    @Query(value = "SELECT * from student",nativeQuery = true)
    ArrayList<Student> getallTems2();


}
