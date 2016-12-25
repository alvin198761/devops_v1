项目名： opsdev_center 远程管理平台

开发环境：
window 7 x86_64
intellij idea 2016.2.4
maven 3.3.9
mysql80
jdk 1.8.0_60

项目描述：
机房，服务器 的设备管理
文件上传，下发到服务器
远程命令执行，指定远程任务
权限管理，
命令通道管理。
邮件通知

架构：
    1.后端： spring boot 1.4.0 + spring data jpa + flyway + freemark
    2.前端： vue2.0 + elementui + reqwest

目的：学习 data jpa ,restful api 调用
        vue2.0 + elementui

项目采用spring-boot 微服务架构，
通过命令通道，对各个机房的服务器进行远程操作
指定任务，可以自定义一系列有序的命令操作
对项目远程下载，编译，打包，发布

前端编译，打包：
npm install
npm run build

后端 编译，打包方式：
1.切换到 opsdev-core 目录下：执行：maven install
2.切换到target 目录，获取zip 文件


部署：
1.拷贝target\zip 文件 ，到部署的位置，解压zip
2.修改 server.port 和数据库连接地址
3.执行 java -jar opsdev-center.jar

访问：localhost:1988





