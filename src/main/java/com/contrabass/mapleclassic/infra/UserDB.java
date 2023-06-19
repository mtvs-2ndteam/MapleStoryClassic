package com.contrabass.mapleclassic.infra;

import com.contrabass.mapleclassic.application.dto.UserDTO;

import java.util.HashMap;
import java.util.Map;

public class UserDB {
    private final Map<Integer, UserDTO> userDB = new HashMap<>();
    private final int a = 0;


    public UserDB() {
        userDB.put(1, new UserDTO(1, "hi", "hi", "hi"));
        userDB.put(2, new UserDTO(2, "hi", "hi", "hi"));
//        List<UserDTO> keyList = new ArrayList<>(userDB.values());
    }


    public Map<Integer, UserDTO> getUserDB() {
        return userDB;
    }

    public Map<Integer, UserDTO> setUserDB(int aa, String b, String c, String d) {
        userDB.put(a + 1, new UserDTO(a + 1, b, c, d));
        System.out.println("회원가입 완료되었습니다");
        return userDB;
    }

    public Map<Integer, UserDTO> UpdateUserDB(int aa, String b, String c, String d) {
        userDB.put(aa, new UserDTO(aa, b, c, d));
        System.out.println("업데이트를 완료되었습니다");
        return userDB;
    }

    public Map<Integer, UserDTO> DeleteUserDB(int aa) {
        userDB.keySet().remove(aa);
        System.out.println("사용자 삭제가 완료되었습니다");
        return userDB;
    }


}
