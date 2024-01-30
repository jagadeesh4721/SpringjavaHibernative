package StudentApplication.SpringJPAHibernate.Model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue
    private int id;

    private int rollNo;

    private String firstName;

    private float marks;
}
