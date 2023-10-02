package ru.softmedialab.testtask.dto.wrapped;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DtoWrapper implements Serializable {
    @Serial
    private static final long serialVersionUID = -5061724121305948102L;
    
    private boolean success;
    private String message;
    private String snackbarType;
}
