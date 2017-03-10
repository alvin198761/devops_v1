描述：模拟项目中原来的办公系统，只是简单实现一个对人员的管理
        在做自动化运维系统中扮演一个用户信息提供者

环境：jdk1.8 ,mysql80, intellij Idea 2016.2.4 ,maven 3.3.9
后端架构：spring boot + spring data jpa + spring secrity
前端架构：vuejs 2.1.4 ,webpack ,nodejs 7,elementUI

架构描述：采用spring boot 做微服务架构，spring data jpa 来做持久化，可以减少部署和持久化的代码变现
        使用 RestController 做restful api 风格，方便系统以后提供api 调用。
        利用spring boot 的默认 security 实现，来做用户认证。目前只有一个用户。

公司人员管理系统
1.部门管理
    对部门的添加，修改
    基本属性：
    部门名称，描述
2.人员信息管理，
    录入信息，高级信息设置，删除信息。

        员工编号（从10000 开始开始增加），姓名,名字拼音,性别，年龄，邮件，电话

        公司系统账号，员工等级（A-E 级），员工所属部门，员工职位（枚举类型：普通职员，组长，经理）


2.提供查询接口，根据名称查询，根据员工编号查询

前端开发：
 安装:npm install
 开发运行：npm run dev 启动
启动后端：
1.先编译前端： npm run build
2.创建数据库：create database ioadb DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
3.启动后端：mvn spring-boot:run
访问地址：http://localhost:2011

打包：mvn install
部署：
1.把生成的 opsdev_oa-1.0-SNAPSHOT-bin.zip 文件拷贝到要部署的位置，解压
2.修改 application.properties
    server.port = 访问端口
    数据库连接地址修改，不多说
    配置用户名和密码
3.创建数据库：create database ioadb DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
4.运行：java -jar opsdev_oa.jar
5.使用： http://你的ip:访问端口
6.输入用户名，密码

