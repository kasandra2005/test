package com.kasandra.mapper;

import com.kasandra.entity.Cat;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class CatMapper implements RowMapper<Cat> {

    public Cat mapRow(ResultSet resultSet, int i) throws SQLException{
        Cat cat = new Cat();
        cat.setId(resultSet.getLong("id"));
        cat.setName(resultSet.getString("name"));
        return cat;
    }
}
