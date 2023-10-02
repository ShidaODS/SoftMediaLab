package ru.softmedialab.testtask.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student_list")
public class Student extends AbstractEntity{
    @Serial
    private static final long serialVersionUID = -4706448174649445231L;
    
    @Column(name = "full_name")
    private String fullName;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "progress_id", foreignKey = @ForeignKey(name = "student_list_fk"))
    private StudyProgressDict studyProgressDict;   
}
       