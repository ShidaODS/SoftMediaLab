package ru.softmedialab.testtask.dto.wrapped;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Wrapper<T> { 
    private List<T> content;
    private boolean success;
    private String message;
    private String snackbarType;
   
}
