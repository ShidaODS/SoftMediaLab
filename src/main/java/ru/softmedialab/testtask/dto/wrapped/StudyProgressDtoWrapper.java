package ru.softmedialab.testtask.dto.wrapped;

import ru.softmedialab.testtask.dto.StudyProgressDto;

import java.io.Serial;
import java.io.Serializable;

public class StudyProgressDtoWrapper extends WrapperOne<StudyProgressDto> implements Serializable {

    @Serial
    private static final long serialVersionUID = 2813866136058439143L;
    
    public StudyProgressDtoWrapper(StudyProgressDto studyProgressDto) {
        if (studyProgressDto == null) {
            this.setSuccess(false);
            this.setMessage("Информация из справочника успеваимости не получена");
            this.setSnackbarType("error");
            this.setContent(null);
        } else {
            this.setSuccess(true);
            this.setMessage("Информация из справочника успеваимости получена");
            this.setSnackbarType("info");
            this.setContent(studyProgressDto);
        }
    }
}
