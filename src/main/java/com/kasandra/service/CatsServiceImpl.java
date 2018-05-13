package com.kasandra.service;

import com.kasandra.dao.CatDao;
import com.kasandra.entity.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatsServiceImpl implements CatsService{

    @Autowired
    public CatDao catDao;

    public List<Cat> searchAll(){
        return catDao.searchAll();
    }

    @Override
    public void create(Cat cat) throws Exception {
        if (cat.getName() != null && cat.getName().length() > 0) {
            catDao.create(cat);
        } else {
            throw new Exception();
        }
    }

    @Override
    public List<Cat> getByName(String name) {
        return catDao.getByName(name);
    }

    @Override
    public Cat getById(Long id) {
        return catDao.getById(id);
    }

    @Override
    public void delete(Long id) {
        catDao.delete(id);
    }

    @Override
    public void update(Cat cat) throws Exception {
        if (cat.getName() != null && cat.getName().length() > 0) {
            catDao.update(cat);
        } else {
            throw new Exception();
        }
    }


}
