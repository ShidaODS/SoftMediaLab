package ru.softmedialab.testtask.dto;

import lombok.*;
import ru.softmedialab.testtask.model.StudyProgressDict;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudyProgressDto implements Serializable {
    @Serial
    private static final long serialVersionUID = -4737815922387155236L;
    
    private Integer id;
    private String text;

    public static List<StudyProgressDto> of(Collection<StudyProgressDict> studyProgressDicts) {
        return studyProgressDicts != null ? studyProgressDicts.stream()
                .map(StudyProgressDto::of)
                .toList() : null;
    }

    public static StudyProgressDto of(StudyProgressDict studyProgressDict) {
        return StudyProgressDto.builder()
                .id(studyProgressDict.getId())
                .text(studyProgressDict.getProgressText())
                .build();
    }
}
