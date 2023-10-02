package ru.softmedialab.testtask.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serial;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "study_progress_dict")
public class StudyProgressDict extends AbstractEntity {
    @Serial
    private static final long serialVersionUID = 906777908727082347L;
    
    @Column(name = "text")
    private String progressText;
}
