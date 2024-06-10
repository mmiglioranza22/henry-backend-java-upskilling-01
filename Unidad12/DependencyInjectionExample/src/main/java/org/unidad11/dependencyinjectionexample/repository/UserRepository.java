package org.unidad11.dependencyinjectionexample.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class UserRepository {
    private List<String> list = new ArrayList<>(Arrays.asList("Buenos Aires", "Córdoba", "La Plata"));

    public List<String> getList() {
        return list;
    }
}
