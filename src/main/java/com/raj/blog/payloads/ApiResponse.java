package com.raj.blog.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ApiResponse {
    private String message;
    private Boolean status;

    public ApiResponse(String message, boolean status){
        this.message = message;
        this.status = status;
    }
}
