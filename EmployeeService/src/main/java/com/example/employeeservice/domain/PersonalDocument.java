package com.example.employeeservice.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PersonalDocument {

    private String path;
    private String title;
    private String comment;
    @CreatedDate
    private Date createDate;
}
