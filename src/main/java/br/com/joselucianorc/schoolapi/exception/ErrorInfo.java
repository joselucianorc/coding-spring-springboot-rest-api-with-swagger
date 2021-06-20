package br.com.joselucianorc.schoolapi.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorInfo {
	
    private Date timestamp;
    private String message;
    private String details;
    
}
