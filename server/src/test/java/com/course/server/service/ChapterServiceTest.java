package com.course.server.service;

import com.course.server.dto.PageDto;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class ChapterServiceTest {

    @Autowired
    private ChapterService chapterService;
    @Test
    void list222() {
        PageDto pageDto = new PageDto();
        pageDto.setPage(1);
        pageDto.setSize(1);
        chapterService.list(pageDto);


    }
}