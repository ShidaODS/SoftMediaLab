package ru.softmedialab.testtask.dto.wrapped;

import ru.softmedialab.testtask.dto.StudentDto;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public class StudentDtoListWrapped extends Wrapper<StudentDto> implements Serializable {
    @Serial
    private static final long serialVersionUID = -5922705249095312784L;
    
    public StudentDtoListWrapped(List<StudentDto> studentDtos) {
        if (studentDtos == null) {
            this.setSuccess(false);
            this.setMessage("Список студентов не получен");
            this.setSnackbarType("error");
            this.setContent(null);
        } else {
            this.setSuccess(true);
            this.setMessage("Все студенты получены");
            this.setSnackbarType("info");
            this.setContent(studentDtos);            
        }
    }
}
