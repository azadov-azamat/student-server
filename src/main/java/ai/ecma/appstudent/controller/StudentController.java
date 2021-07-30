package ai.ecma.appstudent.controller;

import ai.ecma.appstudent.Entity.Student;
import ai.ecma.appstudent.payload.StudentDto;
import ai.ecma.appstudent.payload.ApiResponse;
import ai.ecma.appstudent.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;
//    @CrossOrigin

    @GetMapping("/getAllStudents")
    public List<Student> getStudentList(){
        return studentService.getStudentList();
    }

    @PostMapping("/saveStudent")
    public HttpEntity<?> addStudent(@RequestBody StudentDto studentDto){
        ApiResponse apiResponse = studentService.saveStudent(studentDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }


    @DeleteMapping("/deleteStudent/{uuid}")
    public HttpEntity<?> deleteStudent(@PathVariable UUID uuid){
        return ResponseEntity.ok(studentService.deleteStudent(uuid));
    }

}
