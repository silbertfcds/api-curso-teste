package br.com.firmino.api.controller.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StandardError {

	private LocalDateTime timestamp;
	private Integer status;
	private String error;
	private String path;
}
