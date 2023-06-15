package com.contrabass.mapleclassic.domain.service;

import com.contrabass.mapleclassic.domain.repository.UserRepository;

import static com.contrabass.mapleclassic.Constant.CONTEXT;

public class UserDomainService {
    UserRepository userRepository = CONTEXT.getBean("userRepository", UserRepository.class);

    public void validateUserId(String readLine) {
        
    }
}
