package com.contrabass.mapleclassic.infra;

import com.contrabass.mapleclassic.domain.entity.UserDTO;

import java.util.HashMap;
import java.util.Map;

public class UserDB {
    private final Map<Integer, UserDTO> userDB;

    public UserDB() {
        this.userDB = new HashMap<>();
    }
}
