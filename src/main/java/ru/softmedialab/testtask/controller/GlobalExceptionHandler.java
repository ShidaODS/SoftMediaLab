package ru.softmedialab.testtask.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.softmedialab.testtask.dto.wrapped.DtoWrapper;
import ru.softmedialab.testtask.dto.wrapped.StudentDtoWrapper;
import ru.softmedialab.testtask.dto.wrapped.StudyProgressDtoWrapper;
import ru.softmedialab.testtask.exceptions.IlligalLocalDateException;
import ru.softmedialab.testtask.exceptions.StudentNotFoundException;
import ru.softmedialab.testtask.exceptions.StudyProgressNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({StudentNotFoundException.class})
    public ResponseEntity<StudentDtoWrapper> handlerStudentNotFoundException(StudentNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getStudentDtoWrapper());
    }
    
    @ExceptionHandler(StudyProgressNotFoundException.class)
    public ResponseEntity<StudyProgressDtoWrapper> handlerStudyProgressNotFoundException(StudyProgressNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getStudyProgressDtoWrapper());
    }
    
    @ExceptionHandler(IlligalLocalDateException.class)
    public ResponseEntity<DtoWrapper> handleIlligalLocalDateException(IlligalLocalDateException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getDtoWrapper());
    }
    
}
