package StudentApplication.SpringJPAHibernate.Repository;

import StudentApplication.SpringJPAHibernate.Model.User;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

//    User findById(int id);
}
