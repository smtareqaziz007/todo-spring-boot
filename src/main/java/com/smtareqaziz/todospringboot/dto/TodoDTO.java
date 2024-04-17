package com.smtareqaziz.todospringboot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TodoDTO {
    Long id;
    String title;
    String description;
    Boolean completed;
}
