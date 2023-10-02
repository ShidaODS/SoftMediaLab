package ru.softmedialab.testtask.dto.wrapped;

import ru.softmedialab.testtask.dto.StudentDto;

import java.io.Serial;
import java.io.Serializable;

public class StudentDtoWrapper extends WrapperOne<StudentDto> implements Serializable {

    @Serial
    private static final long serialVersionUID = 2813866136058439143L;
    
    public StudentDtoWrapper(StudentDto studentDto) {
        if (studentDto == null) {
            this.setSuccess(false);
            this.setMessage("Информация о студенте не получена");
            this.setSnackbarType("error");
            this.setContent(null);
        } else {
            this.setSuccess(true);
            this.setMessage("Информация о студенте получена");
            this.setSnackbarType("info");
            this.setContent(studentDto);
        }
    }
}
