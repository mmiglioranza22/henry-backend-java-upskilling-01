package org.unidad11.dependencyinjectionexample;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.unidad11.dependencyinjectionexample.repository.UserRepository;
import org.unidad11.dependencyinjectionexample.services.IUserService;
import org.unidad11.dependencyinjectionexample.services.impl.UserServiceImplConstructor;
import org.unidad11.dependencyinjectionexample.services.impl.UserServiceImplField;
import org.unidad11.dependencyinjectionexample.services.impl.UserServiceImplSetter;

import java.util.List;

@SpringBootApplication
public class DependencyInjectionExampleApplication {
    @Autowired
    @Qualifier("constructor")
    IUserService constructorInjectionUserService;

    @Autowired
    @Qualifier("setter")
    IUserService setterInjectionUserService;

    @Autowired
    @Qualifier("field")
    IUserService fieldInjectionUserService;

    public static void main(String[] args) {
        SpringApplication.run(DependencyInjectionExampleApplication.class, args);
    }

    @PostConstruct
    private void executeExample() {
        List<String> ex1 = constructorInjectionUserService.getAllUsers();
        ex1.forEach(System.out::println);

        List<String> ex2 = setterInjectionUserService.getAllUsers();
        ex2.forEach(System.out::println);

        List<String> ex3 = fieldInjectionUserService.getAllUsers();
        ex3.forEach(System.out::println);

    }
}

