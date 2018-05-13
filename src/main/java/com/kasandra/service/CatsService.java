package com.kasandra.service;

import com.kasandra.entity.Cat;

import java.util.List;

public interface CatsService {

    List<Cat> searchAll();

    void create(Cat cat) throws Exception;

    List<Cat> getByName(String name);

    Cat getById(Long id);

    void delete(Long id);

    void update(Cat cat) throws Exception;
}
