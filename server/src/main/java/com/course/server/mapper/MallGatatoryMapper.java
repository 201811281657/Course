package com.course.server.mapper;

import com.course.server.domain.MallGatatory;
import com.course.server.domain.MallGatatoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MallGatatoryMapper {
    long countByExample(MallGatatoryExample example);

    int deleteByExample(MallGatatoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MallGatatory record);

    int insertSelective(MallGatatory record);

    List<MallGatatory> selectByExample(MallGatatoryExample example);

    MallGatatory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MallGatatory record, @Param("example") MallGatatoryExample example);

    int updateByExample(@Param("record") MallGatatory record, @Param("example") MallGatatoryExample example);

    int updateByPrimaryKeySelective(MallGatatory record);

    int updateByPrimaryKey(MallGatatory record);
}