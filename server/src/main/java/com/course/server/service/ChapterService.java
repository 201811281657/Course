package com.course.server.service;

import com.course.server.domain.Chapter;
import com.course.server.domain.ChapterExample;
import com.course.server.dto.ChapterDto;
import com.course.server.dto.PageDto;
import com.course.server.mapper.ChapterMapper;
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
public class ChapterService {
    @Resource
    private ChapterMapper chapterMapper;
    public void list( PageDto pageDto){
        PageHelper.startPage(pageDto.getPage(),pageDto.getSize());
        ChapterExample chapterExample = new ChapterExample();
        List<Chapter> chapterList= chapterMapper.selectByExample(chapterExample);
        PageInfo<Chapter> pageInfo = new PageInfo<>(chapterList);
        pageDto.setTotal(pageInfo.getTotal());

        List<ChapterDto> chapterDtoList = new ArrayList<ChapterDto>();
        for (Chapter chapter : chapterList) {
            ChapterDto chapterDto = new ChapterDto();
            BeanUtils.copyProperties(chapter, chapterDto);
            chapterDtoList.add(chapterDto);
        }
        pageDto.setList(chapterDtoList);
        System.out.println(pageDto.toString());

    }
    public void save( ChapterDto chapterDto){
        Chapter chapter = CopyeUtil.copy(chapterDto,Chapter.class);
        if(StringUtil.isEmpty(chapterDto.getId())){
          this.insert(chapter);
      }else{
          this.update(chapter);
      }

    }
    private void insert( Chapter chapter){
        chapter.setId(UuidUtil.getShortUuid());
//        Chapter chapter = new Chapter();
//        BeanUtils.copyProperties(chapterDto,chapter);
        chapterMapper.insert(chapter);
    }
    private void update( Chapter chapter){
//        Chapter chapter = new Chapter();
//        BeanUtils.copyProperties(chapterDto,chapter);
        chapterMapper.updateByPrimaryKey(chapter);

    }

    public void delete(String id) {
        chapterMapper.deleteByPrimaryKey(id);
    }
}
