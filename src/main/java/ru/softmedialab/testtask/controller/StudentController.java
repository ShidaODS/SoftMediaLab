package ru.softmedialab.testtask.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.softmedialab.testtask.dto.StudentDto;
import ru.softmedialab.testtask.dto.StudyProgressDto;
import ru.softmedialab.testtask.dto.wrapped.*;
import ru.softmedialab.testtask.controller.docs.StudentControllerDoc;
import ru.softmedialab.testtask.service.StudentService;

@RestController
@RequestMapping("/api")
@Slf4j
public class StudentController implements StudentControllerDoc {
    
    private final StudentService studentService;
    
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    
    @Override
    @PostMapping("/AddStudent")
    public ResponseEntity<DtoWrapper> addStudent(@RequestBody @Valid StudentDto studentDto) {
        DtoWrapper result = studentService.createStudent(studentDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @Override
    @DeleteMapping("/DeleteStudent")
    public ResponseEntity<DtoWrapper> deleteStudent(@RequestParam Integer studentId) {
        DtoWrapper result = studentService.deleteStudent(studentId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Override
    @PostMapping("/EditStudent")
    public ResponseEntity<DtoWrapper> editStudent(@RequestBody @Valid StudentDto studentDto) {
        DtoWrapper result = studentService.createStudent(studentDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Override
    @GetMapping("/GetStudents")
    public ResponseEntity<StudentDtoListWrapped> getStudents() {
        StudentDtoListWrapped result = studentService.getAllStudents();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Override
    @PostMapping("/EditStudyProgressDict")
    public ResponseEntity<DtoWrapper> editStudyProgressDict(@RequestBody @Valid StudyProgressDto studyProgressDto) {
        DtoWrapper result = studentService.editStudyProgressDict(studyProgressDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Override
    @GetMapping("/GetStudyProgressDictionary")
    public ResponseEntity<StudyProgressDtoListWrapped> getStudyProgressDict() {
        StudyProgressDtoListWrapped result = studentService.getStudyProgressDict();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
