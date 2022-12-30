package com.course.server.service;

import com.course.server.domain.Section;
import com.course.server.domain.SectionExample;
import com.course.server.dto.SectionDto;
import com.course.server.dto.PageDto;
import com.course.server.mapper.SectionMapper;
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
public class SectionService {
    @Resource
    private SectionMapper sectionMapper;
    public void list( PageDto pageDto){
        PageHelper.startPage(pageDto.getPage(),pageDto.getSize());
        SectionExample sectionExample = new SectionExample();
        List<Section> sectionList= sectionMapper.selectByExample(sectionExample);
        PageInfo<Section> pageInfo = new PageInfo<>(sectionList);
        pageDto.setTotal(pageInfo.getTotal());

        List<SectionDto> sectionDtoList = new ArrayList<SectionDto>();
        for (Section section : sectionList) {
            SectionDto sectionDto = new SectionDto();
            BeanUtils.copyProperties(section, sectionDto);
            sectionDtoList.add(sectionDto);
        }
        pageDto.setList(sectionDtoList);
        System.out.println(pageDto.toString());

    }
    public void save( SectionDto sectionDto){
        Section section = CopyeUtil.copy(sectionDto,Section.class);
        if(StringUtil.isEmpty(sectionDto.getId())){
          this.insert(section);
      }else{
          this.update(section);
      }

    }
    private void insert( Section section){
        section.setId(UuidUtil.getShortUuid());
//        Section section = new Section();
//        BeanUtils.copyProperties(sectionDto,section);
        sectionMapper.insert(section);
    }
    private void update( Section section){
//        Section section = new Section();
//        BeanUtils.copyProperties(sectionDto,section);
        sectionMapper.updateByPrimaryKey(section);

    }

    public void delete(String id) {
        sectionMapper.deleteByPrimaryKey(id);
    }
}
