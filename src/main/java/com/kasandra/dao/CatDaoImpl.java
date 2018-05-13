package com.kasandra.dao;

import com.kasandra.entity.Cat;
import com.kasandra.mapper.CatMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class CatDaoImpl implements CatDao {

    public final JdbcTemplate jdbcTemplate;

    @Autowired
    public CatDaoImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Cat cat) {
        String sql = "INSERT INTO cats (name) VALUES (?)";
        jdbcTemplate.update(sql, cat.getName());
    }

    @Override
    public Cat getById(Long id) {
        String sql = "SELECT * FROM cats WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new CatMapper(), id);
    }

    @Override
    public List<Cat> getByName(String name) {
        String sql = "SELECT * FROM cats WHERE name=?";
        return jdbcTemplate.query(sql, new CatMapper(), name);
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM cats WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void update(Cat cat) {
        String sql = "UPDATE cats SET name=? WHERE id=?";
        jdbcTemplate.update(sql, cat.getName(), cat.getId());
    }

    public List<Cat> searchAll(){
        String sql = "SELECT * FROM cats";
        return jdbcTemplate.query(sql, new CatMapper());
    }


}
