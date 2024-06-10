package org.unidad11.dependencyinjectionexample.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unidad11.dependencyinjectionexample.repository.UserRepository;
import org.unidad11.dependencyinjectionexample.services.IUserService;

import java.util.List;

@Service("setter")
public class UserServiceImplSetter implements IUserService {
    private UserRepository userRepository;


    //    Esto está bien? o tengo que inicializar el repository en el main? chequear..
    @Autowired
    public void setRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<String> getAllUsers() {
        System.out.println("UserServiceImplSetter method call...");
        return userRepository.getList();
    }
}
