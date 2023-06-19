package com.contrabass.mapleclassic.application.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ShopDTO {
    private PlayerDTO player;
    private int wantCount;
    private String type;
}
