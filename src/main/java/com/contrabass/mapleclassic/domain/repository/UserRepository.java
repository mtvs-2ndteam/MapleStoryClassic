package com.contrabass.mapleclassic.domain.repository;

import com.contrabass.mapleclassic.domain.entity.UserDTO;
import com.contrabass.mapleclassic.infra.UserDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {
    // CRUD
    // create
    // read
    // update
    // delete
    @Autowired
    UserDB userDB;

    public  List<UserDTO> insertUser(int userSequence , String userId,String userPw,String userNickName){
        userDB.setUserDB(userSequence,userId,userPw,userNickName);
        return null;
    }

    public List<UserDTO> updateUser(int userSequence , String userId,String userPw,String userNickName){
        userDB.UpdateUserDB(userSequence,userId,userPw,userNickName);
        return null;
    }

    public List<UserDTO> deleteUser(int userSequence){
        userDB.DeleteUserDB(userSequence);
        return null;
    }

    public List<UserDTO> selectUser() { // 유저 전체 조회
        Map<Integer, UserDTO> map = userDB.getUserDB();
        //System.out.println("map = " + map);
        List<UserDTO> userDBList = new ArrayList<>(map.values());
        return userDBList;
    }
}
