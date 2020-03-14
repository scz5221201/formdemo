package org.hzy.formdemo.service;

import org.hzy.formdemo.dao.FormDao;
import org.hzy.formdemo.model.FormContent;
import org.hzy.formdemo.model.FormInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @program: formdemo
 * @description
 * @author: hzy
 * @create: 2020-03-13 17:16
 **/
@Service
public class FormService {
    @Autowired(required = false)
    FormDao formDao;

    public Integer addForm(FormInfo formInfo) {
        formInfo.setCreateTime(new Date());
        return formDao.insert(formInfo);
    }

    public List<FormInfo> getFormList() {
        return formDao.getFormList();
    }

    public FormInfo getForm(Integer id) {
        return formDao.queryById(id);
    }

    public Integer deleteForm(Integer id) {
        return formDao.deleteById(id);
    }

    public Integer commitForm(FormContent formContent) {
        return formDao.commitForm(formContent);
    }

    public List<FormContent> getFormContentList() {
        return formDao.getFormContentList();
    }
}
