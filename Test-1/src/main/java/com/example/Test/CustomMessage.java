package com.example.Test;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Builder
@Getter
@Setter
public class CustomMessage {

	private String message;
	private boolean	success=false;
	
}
