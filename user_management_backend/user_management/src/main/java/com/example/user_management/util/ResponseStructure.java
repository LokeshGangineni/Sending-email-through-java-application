package com.example.user_management.util;

import java.time.LocalDateTime;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseStructure {
	
	private  int status;
	private String msg;
	private Object data;
	private LocalDateTime dateTime;

}
