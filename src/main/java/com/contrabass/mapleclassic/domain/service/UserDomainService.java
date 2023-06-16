package com.contrabass.mapleclassic.domain.service;

import com.contrabass.mapleclassic.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

import static com.contrabass.mapleclassic.Constant.CONTEXT;

@Service
public class UserDomainService {
    UserRepository userRepository = CONTEXT.getBean("userRepository", UserRepository.class);

    public void checkUserId(String readLine) {

    }
}
