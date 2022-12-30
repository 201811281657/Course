package com.course.server.mapper;

import com.course.server.domain.MallGatatory;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MallGatatoryMapperTest {

    @Autowired
    private MallGatatoryMapper mallGatatoryMapper;
    @Test
    void countByExample() {
    }

    @Test
    void deleteByExample() {
    }

    @Test
    void deleteByPrimaryKey() {
    }

    @Test
    void insert() {
    }

    @Test
    void insertSelective() {
    }

    @Test
    void selectByExample() {
    }

    @Test
    void selectByPrimaryKey() {
        MallGatatory mallGatatory = mallGatatoryMapper.selectByPrimaryKey(11134342);
        System.out.println(mallGatatory.toString());

    }

    @Test
    void updateByExampleSelective() {
    }

    @Test
    void updateByExample() {
    }

    @Test
    void updateByPrimaryKeySelective() {
    }

    @Test
    void updateByPrimaryKey() {
    }
}