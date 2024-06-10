package org.unidad11.dependencyinjectionexample.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unidad11.dependencyinjectionexample.repository.UserRepository;
import org.unidad11.dependencyinjectionexample.services.IUserService;

import java.util.List;

@Service("field")
public class UserServiceImplField implements IUserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<String> getAllUsers() {
        System.out.println("UserServiceImplField method call...");
        return userRepository.getList();
    }
}
