package org.alvin.opsdev.project.service.test;

import com.google.gson.Gson;
import org.alvin.opsdev.project.Application;
import org.alvin.opsdev.project.bean.enums.ProjectStatus;
import org.alvin.opsdev.project.domain.Project;
import org.alvin.opsdev.project.domain.ProjectAttr;
import org.alvin.opsdev.project.service.ProjectAttrService;
import org.alvin.opsdev.project.service.ProjectService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.Assert;

import java.util.List;

/**
 * Created by tangzhichao on 2017/2/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class AttrServiceTest {

    @Autowired
    private ProjectService projectService;
    @Autowired
    private ProjectAttrService projectAttrService;

    @Test
    public void addTest(){
        List<Project> list = this.projectService.findAll();
        list.forEach(item -> {
            ProjectAttr attr = new ProjectAttr();
            attr.setId(item.getId());
            attr.setIcon("test.icon");
            attr.setDescription("this is a remark");
            attr.setMail(false);
            attr.setMailUser("alvin198761@163.com");
            attr.setOptPassword("aaaa");
            attr.setOptUser("alvin");
            attr.setProjectStatus(ProjectStatus.DEV);
            projectAttrService.save(attr);
        });
    }

    @Test
    public void fetch(){
        ProjectAttr attr = this.projectAttrService.findOne(1L);
        System.out.println(new Gson().toJson(attr));
        Assert.notNull(attr);
    }
}
