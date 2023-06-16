package com.contrabass.mapleclassic.domain.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO {
    
    private int userSequence;
    private String userId;
    private String userPw;
    private String userNickName;
}
