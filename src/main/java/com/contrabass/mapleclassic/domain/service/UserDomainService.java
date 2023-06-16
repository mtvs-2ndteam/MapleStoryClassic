package com.contrabass.mapleclassic.domain.service;

import com.contrabass.mapleclassic.domain.entity.UserDTO;
import com.contrabass.mapleclassic.domain.repository.UserRepository;
import com.contrabass.mapleclassic.infra.UserDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.contrabass.mapleclassic.Constant.CONTEXT;

@Service("bookServiceField")
public class UserDomainService {

    @Autowired
    UserRepository userRepository;

//    @Autowired
//    UserDB userDB;

    public void validateUserId(String userid)  {  //사용자가 입력받은거
        List<UserDTO> userlist = userRepository.selectUser();
        for(UserDTO userdb : userlist){
            System.out.println("userdb = " + userdb.toString());
        }
    }
    public void DeleteUserId(int userid)  {  //사용자가 입력받은거
        List<UserDTO> userlist = userRepository.deleteUser(userid);

    }
    public void UpdateUserId(int aa,String b, String c,String d){ //사용자가 입력받은거
        List<UserDTO> userlist = userRepository.updateUser(aa,b,c,d);

    }
    public void InsertUserId(int userSequence , String userId,String userPw,String userNickName)  {  //사용자가 입력받은거
        List<UserDTO> userlist = userRepository.insertUser(userSequence , userId, userPw, userNickName);

    }
}
