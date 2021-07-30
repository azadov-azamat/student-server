package ai.ecma.appstudent.repository;

import ai.ecma.appstudent.Entity.Student;
import ai.ecma.appstudent.payload.CustomStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource(path = "student", excerptProjection = CustomStudent.class)
public interface StudentRepository extends JpaRepository<Student, UUID> {
    boolean existsById(UUID id);

}
