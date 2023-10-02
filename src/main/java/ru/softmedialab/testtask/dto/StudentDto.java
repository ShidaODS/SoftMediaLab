package ru.softmedialab.testtask.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import ru.softmedialab.testtask.model.Student;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1230882534459701977L;
    
    private Integer id;
    private String fullName;
    private String birthDate;
    private String studyProgress;
    
    public static List<StudentDto> of(Collection<Student> studentList) {
        return studentList != null ? studentList.stream()
                .map(StudentDto::of)
                .toList() : null;
    }
    
    public static StudentDto of(Student student) {
        return StudentDto.builder()
                .id(student.getId())
                .fullName(student.getFullName())
                .birthDate(student.getBirthDate().toString())
                .studyProgress(student.getStudyProgressDict().getProgressText())
                .build();
    }
}
