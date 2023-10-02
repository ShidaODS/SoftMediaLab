package ru.softmedialab.testtask.controller.docs;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import ru.softmedialab.testtask.dto.StudentDto;
import ru.softmedialab.testtask.dto.StudyProgressDto;
import ru.softmedialab.testtask.dto.wrapped.*;

@Tag(name = "Student", description = "Контроллер для работы со студентами.")
public interface StudentControllerDoc {
    @Operation(summary = "Метод добавления нового студента.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Студент добавлен",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = DtoWrapper.class))),
            @ApiResponse(responseCode = "404", description = "Студент не добавлен",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = DtoWrapper.class)))
    })
    ResponseEntity<DtoWrapper> addStudent(StudentDto studentDto);

    @Operation(summary = "Метод удаления существующего студента")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Студент удалён",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = DtoWrapper.class))),
            @ApiResponse(responseCode = "404", description = "Студент не удалён",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = DtoWrapper.class)))
    })
    ResponseEntity<DtoWrapper> deleteStudent(@Parameter(description = "идентификатор студента") Integer studentId);

    @Operation(summary = "Метод редактирования существующего студента")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Студент отредактирован",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = DtoWrapper.class))),
            @ApiResponse(responseCode = "404", description = "Студент не отредактирован",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = DtoWrapper.class)))
    })
    ResponseEntity<DtoWrapper> editStudent(StudentDto studentDto);
    
    @Operation(summary = "Метод получения списка студентов.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Данные получены",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = StudentDtoListWrapped.class))),
            @ApiResponse(responseCode = "404", description = "Данные не получены",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = StudentDtoListWrapped.class)))
    })
    ResponseEntity<StudentDtoListWrapped> getStudents();

    @Operation(summary = "Метод изменения названия полей в справочнике успеваимости.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Данные отредактированы",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = DtoWrapper.class))),
            @ApiResponse(responseCode = "404", description = "Данные не отредактированы",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = DtoWrapper.class)))
    })
    ResponseEntity<DtoWrapper> editStudyProgressDict(StudyProgressDto studyProgressDto);

    @Operation(summary = "Метод получения справочника успеваимости.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Данные получены",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = StudyProgressDtoListWrapped.class))),
            @ApiResponse(responseCode = "404", description = "Данные не получены",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = StudyProgressDtoListWrapped.class)))
    })
    ResponseEntity<StudyProgressDtoListWrapped> getStudyProgressDict();

}
