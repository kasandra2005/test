package com.kasandra.dao;

import com.kasandra.entity.Cat;

import java.util.List;

public interface CatDao {

    void create(Cat cat);

    List<Cat> getByName(String name);

    Cat getById(Long id);

    void delete(Long id);

    void update(Cat cat);

    public List<Cat> searchAll();
}
