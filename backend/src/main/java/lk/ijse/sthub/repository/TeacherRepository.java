package lk.ijse.sthub.repository;



import lk.ijse.sthub.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TeacherRepository extends JpaRepository<Teacher,String> {

    @Query("SELECT count(t.id) from Teacher t")
    long getTotalTeachers();
}
