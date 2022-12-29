package com.course.business.controller.admin;

import com.course.server.dto.${Domain}Dto;
import com.course.server.dto.PageDto;
import com.course.server.dto.ResponseDto;
import com.course.server.service.${Domain}Service;
import com.course.server.util.ValidatorUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/${domain}")
public class ${Domain}Controller {
    private static final Logger log = LoggerFactory.getLogger(${Domain}Controller.class);
    public static final String BUSINESS_NAME = "小节";
    @Resource
    private ${Domain}Service ${domain}Service;
    @PostMapping("/list")
    public ResponseDto list(@RequestBody PageDto pageDto) {
        ResponseDto responseDto = new ResponseDto();
         ${domain}Service.list(pageDto);
         log.info("测试pageDto:{}",pageDto);
         responseDto.setContent(pageDto);
//        System.out.println(pageDto.getList());
         return responseDto;
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody ${Domain}Dto ${domain}Dto){
        log.info("测试${domain}Dto:{}",${domain}Dto);
        ResponseDto responseDto = new ResponseDto();
        //保存校验

        ${domain}Service.save(${domain}Dto);
        responseDto.setContent(${domain}Dto);
        return responseDto;
    }

    @RequestMapping("/delete/{id}")
    public ResponseDto delete (@PathVariable String id) {
        ResponseDto responseDto = new ResponseDto();
        log.info("测试id:{}",id);
        ${domain}Service.delete(id);
        return responseDto;
    }

}
