package ru.softmedialab.testtask.exceptions;

import lombok.Getter;
import ru.softmedialab.testtask.dto.wrapped.DtoWrapper;

import java.io.Serial;
import java.io.Serializable;

@Getter
public class IlligalLocalDateException extends RuntimeException implements Serializable {

    @Serial
    private static final long serialVersionUID = 1124227676864110335L;
    
    private final DtoWrapper dtoWrapper;
    public IlligalLocalDateException() {
        this.dtoWrapper = DtoWrapper.builder().message("Некорректная дата").success(false).snackbarType("error").build();
    }
}
