package ru.softmedialab.testtask.dto.wrapped;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WrapperOne<T> {
    private T content;
    private boolean success;
    private String message;
    private String snackbarType;
    
}
