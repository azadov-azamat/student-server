package ai.ecma.appstudent.service;

import ai.ecma.appstudent.Entity.Student;
import ai.ecma.appstudent.exception.ResourceNotFoundException;
import ai.ecma.appstudent.payload.StudentDto;
import ai.ecma.appstudent.payload.ApiResponse;
import ai.ecma.appstudent.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> getStudentList() {
        return studentRepository.findAll();
    }

    public ApiResponse saveStudent(StudentDto studentDto) {
        try {
            if (studentDto.getId() != null){
                Student student = studentRepository.findById(studentDto.getId()).orElseThrow(() -> new ResourceNotFoundException("student", "id", studentDto.getId()));
                student.setLastName(studentDto.getLastName());
                student.setFirstName(studentDto.getFirstName());
                student.setAddress(studentDto.getAddress());
                studentRepository.save(student);
            }else {
                Student student = new Student();
                student.setFirstName(studentDto.getFirstName());
                student.setLastName(studentDto.getLastName());
                student.setAddress(studentDto.getAddress());
                studentRepository.save(student);
            }
            return new ApiResponse(studentDto.getId() != null ? "Edited Student" : "Saved Student", true);
        }catch (Exception e){
            return new ApiResponse("Student no?", false);
        }



    }

    public ApiResponse editStudent(UUID id, StudentDto studentDto) {
        try {
        Student student = studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("student", "id", id));
        student.setLastName(studentDto.getLastName());
        student.setFirstName(studentDto.getFirstName());
        student.setAddress(studentDto.getAddress());
            studentRepository.save(student);
            return new ApiResponse("Edited", true);
        } catch (Exception e) {
            e.printStackTrace();
            return new ApiResponse("Error in saving", false);
        }
    }

    public ApiResponse deleteStudent(UUID uuid) {
        studentRepository.deleteById(uuid);
        return new ApiResponse("Student deleted", true);
//        try {
//            studentRepository.deleteById(uuid);
//            return new ApiResponse("Student deleted", true);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ApiResponse("Error deleting", false);
//        }
    }
}
