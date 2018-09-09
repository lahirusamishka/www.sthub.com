package lk.ijse.sthub.repository;



import lk.ijse.sthub.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("select count(s.id) from Student s")
    long getTotalStudents();

}
