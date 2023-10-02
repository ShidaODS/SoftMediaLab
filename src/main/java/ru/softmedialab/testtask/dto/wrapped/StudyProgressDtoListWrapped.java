package ru.softmedialab.testtask.dto.wrapped;

import ru.softmedialab.testtask.dto.StudyProgressDto;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public class StudyProgressDtoListWrapped extends Wrapper<StudyProgressDto> implements Serializable {
    @Serial
    private static final long serialVersionUID = -5922705249345312784L;
    
    public StudyProgressDtoListWrapped(List<StudyProgressDto> studyProgressDtos) {
        if (studyProgressDtos == null) {
            this.setSuccess(false);
            this.setMessage("Справочник успеваимости не получен");
            this.setSnackbarType("error");
            this.setContent(null);
        } else {
            this.setSuccess(true);
            this.setMessage("Справочник успеваимости получен");
            this.setSnackbarType("info");
            this.setContent(studyProgressDtos);            
        }
    }
}
