package com.example.emailservice.domain;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Email implements Serializable{
    private String title;
    private Date timeSent;
    private String sender;
    private String receiver;
    private String body;
}
