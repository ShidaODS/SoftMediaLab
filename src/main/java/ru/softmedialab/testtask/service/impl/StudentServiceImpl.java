package ru.softmedialab.testtask.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.softmedialab.testtask.dto.StudyProgressDto;
import ru.softmedialab.testtask.dto.StudentDto;
import ru.softmedialab.testtask.dto.wrapped.*;
import ru.softmedialab.testtask.exceptions.IlligalLocalDateException;
import ru.softmedialab.testtask.exceptions.StudentNotFoundException;
import ru.softmedialab.testtask.model.Student;
import ru.softmedialab.testtask.model.StudyProgressDict;
import ru.softmedialab.testtask.repository.StudentListRepository;
import ru.softmedialab.testtask.repository.StudyProgressDictRepository;
import ru.softmedialab.testtask.service.StudentService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service(value = "studentService")
@Slf4j
public class StudentServiceImpl implements StudentService {
    
    private final StudentListRepository studentListRepository;
    private final StudyProgressDictRepository studyProgressDictRepository;
    
    @Autowired
    public StudentServiceImpl(
            StudentListRepository studentListRepository, 
            StudyProgressDictRepository studyProgressDictRepository) {
        
        this.studentListRepository = studentListRepository;
        this.studyProgressDictRepository = studyProgressDictRepository;        
    }
    
    @Override
    public DtoWrapper createStudent(StudentDto studentDto) {
        try {
            if(!isValidBirthDate(LocalDate.parse(studentDto.getBirthDate())))
                return DtoWrapper.builder().message("Некорректная дата рождения!").snackbarType("error").success(false).build();
        } catch (Exception e) {
            throw new IlligalLocalDateException();
        }
        Optional<StudyProgressDict> studyProgressDict =
                studyProgressDictRepository.findStudyProgressDictByProgressTextLikeIgnoreCase(studentDto.getStudyProgress());
        if(studyProgressDict.isEmpty())
            return DtoWrapper.builder().message("Нет такой успеваимости").snackbarType("error").success(false).build();
        
        if (studentDto.getId() != null) {
            Optional<Student> student = studentListRepository.findById(studentDto.getId());
            if (student.isPresent()) {
                student.get().setFullName(studentDto.getFullName());
                student.get().setBirthDate(LocalDate.parse(studentDto.getBirthDate()));
                student.get().setStudyProgressDict(studyProgressDict.get());
                studentListRepository.save(student.get());
                return DtoWrapper.builder().message("Студент отредактированн").snackbarType("info").success(true).build();
            } else
                return DtoWrapper.builder().message("Нет такого студента!").snackbarType("error").success(false).build();            
        }
        studentListRepository.save(Student.builder()
                .fullName(studentDto.getFullName())
                .birthDate(LocalDate.parse(studentDto.getBirthDate()))
                .studyProgressDict(studyProgressDict.get())
                .build());
        return DtoWrapper.builder().message("Студент добавлен").snackbarType("info").success(true).build();          
    }
    
    private boolean isValidBirthDate(LocalDate date) throws Exception{
        if (date.isAfter(LocalDate.now())) return false;
        int month = date.getMonthValue();
        int year = date.getYear();

        if (date.lengthOfMonth() == 31 && (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)) {
            return true;
        } else if (date.lengthOfMonth() == 30 && (month == 4 || month == 6 || month == 9 || month == 11)) {
            return true;
        } else if (date.lengthOfMonth() == 28 && month == 2 && !date.isLeapYear()) {
            return true;
        } else if (date.lengthOfMonth() == 29 && month == 2 && date.isLeapYear()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public DtoWrapper deleteStudent(Integer studentId) {
        if (studentId != null) {
            Optional<Student> student = studentListRepository.findById(studentId);
            if (student.isEmpty())
                return DtoWrapper.builder().message("Нет такого студента!").snackbarType("error").success(false).build();
            studentListRepository.delete(student.get());
            return DtoWrapper.builder().message("Студент удалён").snackbarType("info").success(true).build();
        }
        return DtoWrapper.builder().message("Нет такого студента!").snackbarType("error").success(false).build();
    }

    @Override
    @Transactional(readOnly = true)
    public StudentDtoListWrapped getAllStudents() {
        List<Student> students = studentListRepository.findAll();
        
        return (students == null || students.isEmpty())
               ? new StudentDtoListWrapped(null)
                : new StudentDtoListWrapped(students.stream().map(StudentDto::of).collect(Collectors.toList()));                      
    }

    @Override
    public DtoWrapper editStudyProgressDict(StudyProgressDto studyProgressDto) {
        if (studyProgressDto.getId() != null) {
            Optional<StudyProgressDict> studyProgressDict = studyProgressDictRepository.findById(studyProgressDto.getId());
            if (studyProgressDict.isEmpty())
                return DtoWrapper.builder().message("Нет сущности в справочнике успеваимости!").snackbarType("error").success(false).build();
            studyProgressDict.get().setProgressText(studyProgressDto.getText());
            studyProgressDictRepository.save(studyProgressDict.get());
            return DtoWrapper.builder().message("Справочник успеваимости изменён").snackbarType("info").success(true).build();
        }
        return DtoWrapper.builder().message("Нет сущности в справочнике успеваимости!").snackbarType("error").success(false).build();
    }

    @Override
    @Transactional(readOnly = true)
    public StudyProgressDtoListWrapped getStudyProgressDict() {
        List<StudyProgressDict> progressDictList = studyProgressDictRepository.findAll();
        return (progressDictList == null || progressDictList.isEmpty()) 
                ? new StudyProgressDtoListWrapped(null)
                : new StudyProgressDtoListWrapped(progressDictList.stream().map(StudyProgressDto::of).collect(Collectors.toList()));
    }

   
}
