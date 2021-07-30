package ai.ecma.appstudent.payload;

/*
 Created azamat_azadov 13/07/2021
 */

import ai.ecma.appstudent.Entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.rest.core.config.Projection;

import java.util.UUID;

@Projection(name = "customStudent", types = Student.class)
public interface CustomStudent {

    UUID getId();

    String getFirstName();

    String getLastName();

    String getAddress();

}
