名称：opsdev-sync
描述: 数据库同步工具
功能：负责opsdev 项目中部分数据库的数据同步工作
目的：练习java 8 语法，和 maven 普通项目打包 ,jdbctemplate 练习
编译： mvn install
开发环境：jdk 1.8 ,maven 3.3.9 intellij idea 2016,mysql80 ,win7x64
部署：项目编译后会在target生成一个 zip 文件，将zip 拷贝到指定的位置，解压，
        在 data 目录下放好json格式的配置文件（细节见 /resources/simple.json）
运行：windows : .\bin\startup.bat
      linux : ./bin/startup

版本： v1.0
存在问题：
    1.只能针对单张表的同步，不能多个表的数据同步到一个表
    2.只支持mysql
    3.没有考虑数据了很大的时候查询会崩溃