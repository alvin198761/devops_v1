package org.alvin.opsdev.project.service.test;

import com.google.gson.Gson;
import org.alvin.opsdev.project.Application;
import org.alvin.opsdev.project.bean.enums.BuildType;
import org.alvin.opsdev.project.bean.enums.VersionControl;
import org.alvin.opsdev.project.domain.Project;
import org.alvin.opsdev.project.service.ProjectService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.Assert;

/**
 * Created by tangzhichao on 2017/2/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class ProjectServiceTest {

    @Autowired
    private ProjectService projectService;

    @Test
    public void addProjectTest() {
        for (int i = 0; i < 20; i++) {
            Project project = new Project();
            project.setName("project_" + i);
            project.setAuthor("alvin");
            project.setBuildType(BuildType.MAVEN);
            project.setVersionControl(VersionControl.SVN);
            this.projectService.save(project);
        }
    }

    @Test
    public void fetch() {
        Project project = this.projectService.findOne(1L);
        System.out.println(project.getName());
        Gson gson = new Gson();
        System.out.println(gson.toJson(project));
        Assert.notNull(project);
    }
}
