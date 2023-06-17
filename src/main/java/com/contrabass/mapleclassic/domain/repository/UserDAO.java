package com.contrabass.mapleclassic.domain.repository;

import com.contrabass.mapleclassic.infra.UserDB;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static com.contrabass.mapleclassic.Constant.CONTEXT;

@Repository
public class UserDAO {
    UserDB userDB = CONTEXT.getBean("userDB", UserDB.class);

    public List<UserDB> selectUser() { // 유저 전체 조회
        List<UserDB> userDBList = new ArrayList<>();
        return userDBList;
    }
}
