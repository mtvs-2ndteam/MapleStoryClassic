package com.contrabass.mapleclassic.application.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class JobDTO {
    private int id;
    private String jobName;
    private String description;
}
