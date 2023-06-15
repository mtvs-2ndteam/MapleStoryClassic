package com.contrabass.mapleclassic.application.service;

import com.contrabass.mapleclassic.domain.service.UserDomainService;
import org.springframework.stereotype.Service;

import static com.contrabass.mapleclassic.Constant.CONTEXT;

@Service
public class GameService {
    UserDomainService userDomainService = CONTEXT.getBean("userDomainService", UserDomainService.class);

    // 특정 회원 정보 조회
    public void selectOneUser(String userId) {
//        userDomainService.checkUserId(userId);
    }

}
