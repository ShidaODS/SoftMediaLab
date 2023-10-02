package ru.softmedialab.testtask.exceptions;

import lombok.Getter;
import ru.softmedialab.testtask.dto.wrapped.StudentDtoWrapper;

import java.io.Serial;
import java.io.Serializable;

@Getter
public class StudentNotFoundException extends RuntimeException implements Serializable {

    @Serial
    private static final long serialVersionUID = 1124227676864110335L;
    
    private final StudentDtoWrapper studentDtoWrapper;
    public StudentNotFoundException() {
        this.studentDtoWrapper = new StudentDtoWrapper(null);
    }
}
