项目名： opsdev_core 远程命令通道

开发环境：
window 7 x86_64
intellij idea 2016.2.4
maven 3.3.9
mysql80
jdk 1.8.0_60

目的：学习 spring boot ,restful ,sshj

项目描述：
是项目自动化运维的核心模块，负责远程的需要部署的服务器进行操作，
目前只支持linux的 ssh 命令，且只支持密码登录

项目采用spring-boot 微服务架构，数据库mysql,
该项目只提供 restful 接口，不提供界面操作。

编译，打包方式：
1.切换到 opsdev-core 目录下：执行：maven install
2.切换到target 目录，获取zip 文件

部署：
1.拷贝target\zip 文件 ，到部署的位置，解压zip
2.修改 server.port 和数据库连接地址
3.执行 java -jar opsdev-core.jar

测试访问：
浏览器输入： http://服务器IP:服务端口 (默认例子地址：http://localhost:1987) ，浏览器显示：core is started

版本：v1.0
提供接口：
   org.alvin.opsdev.core.web.CommandController ：命令的执行，获取状态，和取消命令
   org.alvin.opsdev.core.web.FileController：提供文件上传


