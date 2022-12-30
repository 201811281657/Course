package com.course.server.service;

import com.course.server.domain.${Domain};
import com.course.server.domain.${Domain}Example;
import com.course.server.dto.${Domain}Dto;
import com.course.server.dto.PageDto;
import com.course.server.mapper.${Domain}Mapper;
import com.course.server.util.CopyeUtil;
import com.course.server.util.UuidUtil;
import com.fasterxml.jackson.databind.util.BeanUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ${Domain}Service {
    @Resource
    private ${Domain}Mapper ${domain}Mapper;
    public void list( PageDto pageDto){
        PageHelper.startPage(pageDto.getPage(),pageDto.getSize());
        ${Domain}Example ${domain}Example = new ${Domain}Example();
        List<${Domain}> ${domain}List= ${domain}Mapper.selectByExample(${domain}Example);
        PageInfo<${Domain}> pageInfo = new PageInfo<>(${domain}List);
        pageDto.setTotal(pageInfo.getTotal());

        List<${Domain}Dto> ${domain}DtoList = new ArrayList<${Domain}Dto>();
        for (${Domain} ${domain} : ${domain}List) {
            ${Domain}Dto ${domain}Dto = new ${Domain}Dto();
            BeanUtils.copyProperties(${domain}, ${domain}Dto);
            ${domain}DtoList.add(${domain}Dto);
        }
        pageDto.setList(${domain}DtoList);
        System.out.println(pageDto.toString());

    }
    public void save( ${Domain}Dto ${domain}Dto){
        ${Domain} ${domain} = CopyeUtil.copy(${domain}Dto,${Domain}.class);
        if(StringUtil.isEmpty(${domain}Dto.getId())){
          this.insert(${domain});
      }else{
          this.update(${domain});
      }

    }
    private void insert( ${Domain} ${domain}){
        ${domain}.setId(UuidUtil.getShortUuid());
//        ${Domain} ${domain} = new ${Domain}();
//        BeanUtils.copyProperties(${domain}Dto,${domain});
        ${domain}Mapper.insert(${domain});
    }
    private void update( ${Domain} ${domain}){
//        ${Domain} ${domain} = new ${Domain}();
//        BeanUtils.copyProperties(${domain}Dto,${domain});
        ${domain}Mapper.updateByPrimaryKey(${domain});

    }

    public void delete(String id) {
        ${domain}Mapper.deleteByPrimaryKey(id);
    }
}
