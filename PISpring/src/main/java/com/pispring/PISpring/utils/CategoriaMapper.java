package com.pispring.PISpring.utils;

import com.pispring.PISpring.entities.Categoria;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class CategoriaMapper implements RowMapper<Categoria> {
    public Categoria mapRow(ResultSet rs, int rowNum) throws SQLException {
        Categoria student = new Categoria();
        student.setId(rs.getInt("id"));

        return student;
    }
}
