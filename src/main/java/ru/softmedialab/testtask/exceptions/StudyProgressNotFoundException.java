package ru.softmedialab.testtask.exceptions;

import lombok.Getter;
import ru.softmedialab.testtask.dto.wrapped.StudyProgressDtoWrapper;

import java.io.Serial;
import java.io.Serializable;

@Getter
public class StudyProgressNotFoundException extends RuntimeException implements Serializable {
    @Serial
    private static final long serialVersionUID = -4909965391364313579L;
    
    private final StudyProgressDtoWrapper studyProgressDtoWrapper;
    public StudyProgressNotFoundException() {
        this.studyProgressDtoWrapper = new StudyProgressDtoWrapper(null);
    }
}
