package org.hzy.formdemo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.hzy.formdemo.model.FormContent;
import org.hzy.formdemo.model.FormInfo;

import java.util.List;

/**
 * @program: formdemo
 * @description
 * @author: hzy
 * @create: 2020-03-13 17:16
 **/
@Mapper
public interface FormDao {

    Integer insert(@Param("formInfo") FormInfo formInfo);

    List<FormInfo> getFormList();

    FormInfo queryById(Integer id);

    Integer deleteById(Integer id);

    Integer commitForm(@Param("formContent") FormContent formContent);

    List<FormContent> getFormContentList();
}
