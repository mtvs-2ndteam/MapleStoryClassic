package com.contrabass.mapleclassic.domain.service;

import com.contrabass.mapleclassic.domain.repository.UserDAO;
import org.springframework.stereotype.Service;

import static com.contrabass.mapleclassic.Constant.CONTEXT;

@Service
public class UserDomainService {
    UserDAO userDAO = CONTEXT.getBean("userDAO", UserDAO.class);

    public void checkUserId(String readLine) {

    }
}
