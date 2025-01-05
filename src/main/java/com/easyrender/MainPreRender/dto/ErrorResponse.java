package com.easyrender.MainPreRender.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ErrorResponse {
    public LocalDateTime timestamp;
    public String message;
    public String details;
}
