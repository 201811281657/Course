package com.course.business.controller.admin;

import com.course.server.dto.SectionDto;
import com.course.server.dto.PageDto;
import com.course.server.dto.ResponseDto;
import com.course.server.service.SectionService;
import com.course.server.util.ValidatorUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/section")
public class SectionController {
    private static final Logger log = LoggerFactory.getLogger(SectionController.class);
    public static final String BUSINESS_NAME = "小节";
    @Resource
    private SectionService sectionService;
    @PostMapping("/list")
    public ResponseDto list(@RequestBody PageDto pageDto) {
        ResponseDto responseDto = new ResponseDto();
         sectionService.list(pageDto);
         log.info("测试pageDto:{}",pageDto);
         responseDto.setContent(pageDto);
//        System.out.println(pageDto.getList());
         return responseDto;
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody SectionDto sectionDto){
        log.info("测试sectionDto:{}",sectionDto);
        ResponseDto responseDto = new ResponseDto();
        //保存校验

        sectionService.save(sectionDto);
        responseDto.setContent(sectionDto);
        return responseDto;
    }

    @RequestMapping("/delete/{id}")
    public ResponseDto delete (@PathVariable String id) {
        ResponseDto responseDto = new ResponseDto();
        log.info("测试id:{}",id);
        sectionService.delete(id);
        return responseDto;
    }

}
