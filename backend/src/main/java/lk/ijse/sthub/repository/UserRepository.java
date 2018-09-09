package lk.ijse.sthub.repository;




import lk.ijse.sthub.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, String> {
}
