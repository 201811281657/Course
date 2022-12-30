package com.course.business.controller.admin;

import com.course.server.dto.PageDto;
import com.github.pagehelper.Page;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class ChapterControllerTest {
    @Autowired
    private ChapterController chapterController;
    @Test
    void list() {
        PageDto pageDto = new PageDto();
        pageDto.setPage(1);
        pageDto.setSize(1);
        chapterController.list(pageDto);
    }
}