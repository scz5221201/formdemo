package org.hzy.formdemo.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @program: formdemo
 * @description
 * @author: hzy
 * @create: 2020-03-13 17:16
 **/
public class FormInfo {
    private Integer id;
    private String template;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
