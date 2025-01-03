package com.raj.blog.payloads;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {

    private Integer categoryId;

    @NotEmpty(message = "title must not be empty")
    private String categoryTitle;
    @NotEmpty(message = "description must not be empty")
    private String categoryDescription;
}
