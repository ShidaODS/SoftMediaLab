package ru.softmedialab.testtask.service;

import ru.softmedialab.testtask.dto.StudentDto;
import ru.softmedialab.testtask.dto.StudyProgressDto;
import ru.softmedialab.testtask.dto.wrapped.*;

public interface StudentService {
    DtoWrapper createStudent(StudentDto studentDto);
    DtoWrapper deleteStudent(Integer studentId);    
    StudentDtoListWrapped getAllStudents();
    DtoWrapper editStudyProgressDict(StudyProgressDto studyProgressDto);
    StudyProgressDtoListWrapped getStudyProgressDict();
}
