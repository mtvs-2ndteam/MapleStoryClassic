package com.contrabass.mapleclassic.application.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class SaunaDTO {
    private PlayerDTO player;
    private String type;
}
