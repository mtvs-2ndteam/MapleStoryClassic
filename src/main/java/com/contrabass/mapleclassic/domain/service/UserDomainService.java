package com.contrabass.mapleclassic.domain.service;

import com.contrabass.mapleclassic.domain.entity.UserDTO;
import com.contrabass.mapleclassic.domain.repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookServiceField")
public class UserDomainService {

    @Autowired
    UserDAO userDAO;

//    @Autowired
//    UserDB userDB;

    public void validateUserId(String userid) {  //사용자가 입력받은거
        List<UserDTO> userlist = userDAO.selectUser();
        for (UserDTO userdb : userlist) {
            System.out.println("userdb = " + userdb.toString());
        }
    }

    public void DeleteUserId(int userid) {  //사용자가 입력받은거
        List<UserDTO> userlist = userDAO.deleteUser(userid);

    }

    public void UpdateUserId(int aa, String b, String c, String d) { //사용자가 입력받은거
        List<UserDTO> userlist = userDAO.updateUser(aa, b, c, d);

    }

    public void InsertUserId(int userSequence, String userId, String userPw, String userNickName) {  //사용자가 입력받은거
        List<UserDTO> userlist = userDAO.insertUser(userSequence, userId, userPw, userNickName);

    }
}
