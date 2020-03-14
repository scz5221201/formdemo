package org.hzy.formdemo.controller;

import org.hzy.formdemo.model.FormContent;
import org.hzy.formdemo.model.FormInfo;
import org.hzy.formdemo.service.FormService;
import org.hzy.formdemo.vo.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: formdemo
 * @description
 * @author: hzy
 * @create: 2020-03-13 17:01
 **/
@RestController
@RequestMapping("/form")
public class FormController {

    @Autowired
    FormService formService;

    @PostMapping("/makeform")
    public RespBean addForm(@RequestBody FormInfo formInfo){
        if (formService.addForm(formInfo)==1){
            return RespBean.ok("生成成功");
        }
        return RespBean.error("生成失败");
    }

    @GetMapping("/formlist")
    public List<FormInfo> getFormList(){
        return formService.getFormList();
    }

    @GetMapping("/single/{id}")
    public FormInfo getForm(@PathVariable Integer id){
        return formService.getForm(id);
    }

    @DeleteMapping("/single/{id}")
    public RespBean deleteForm(@PathVariable Integer id){
        if (formService.deleteForm(id)==1){
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }

    @PutMapping("/commit")
    public RespBean commitForm(@RequestBody FormContent formContent){
        if (formService.commitForm(formContent)==1){
            return RespBean.ok("提交成功");
        }
        return RespBean.error("提交失败");
    }

    @GetMapping("/fclist")
    public List<FormContent> getFormContentList(){
        return formService.getFormContentList();
    }

}
