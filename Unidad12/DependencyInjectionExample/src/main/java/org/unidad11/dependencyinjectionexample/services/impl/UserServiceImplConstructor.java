package org.unidad11.dependencyinjectionexample.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.unidad11.dependencyinjectionexample.repository.UserRepository;
import org.unidad11.dependencyinjectionexample.services.IUserService;

import java.util.List;

//@Qualifier("constructor")
@Service("constructor")
public class UserServiceImplConstructor implements IUserService {

    UserRepository userRepository;

    @Autowired
    public UserServiceImplConstructor(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<String> getAllUsers() {
        System.out.println("UserServiceImplConstructor method call...");
        return userRepository.getList();
    }
}
