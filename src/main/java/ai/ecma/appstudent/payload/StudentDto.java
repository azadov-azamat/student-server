package ai.ecma.appstudent.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private UUID id;
    private String firstName;
    private String lastName;
    private String address;
}
