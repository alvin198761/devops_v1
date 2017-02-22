<template>
  <div id="app" style="min-width: 1100px">
    <header>
      <el-card>
        <el-row>
          <el-col :span="12" style="text-align: left">
            项目管理系统
          </el-col>
          <el-col :span="12" style="text-align: right">
            用户：{{userName}}
          </el-col>
        </el-row>
      </el-card>
    </header>
    <aside>
      <el-menu :default-active="navPath" theme="dark"
               style="  position: fixed; left: 0px; top: 65px; bottom: 0px ;width: 180px;">
        <router-link to="/project/list">
          <el-menu-item index="/project/list"><i class="el-icon-menu"></i>项目列表</el-menu-item>
        </router-link>
        <router-link to="/project/add">
          <el-menu-item index="/project/add"><i class="el-icon-setting"></i>添加项目</el-menu-item>
        </router-link>
      </el-menu>
    </aside>
    <div style="position: fixed; left: 185px; top: 65px; bottom: 0px; right: 5px">
      <el-card style="height: 50px">
        <el-breadcrumb separator="/">
          <el-breadcrumb-item v-for="path in _siteMapPath" :to="path.path">{{path.name == null ? '首页': path.name}}</el-breadcrumb-item>
        </el-breadcrumb>
      </el-card>
      <div style="margin-top: 20px">
        <el-card style="min-height:450px; ">
          <router-view></router-view>
        </el-card>
      </div>
      <footer style="text-align: center; vertical-align: middle; line-height: 50px; color: #cccccc">
        alvin198761@163.com
      </footer>
    </div>
  </div>
</template>

<script>
  import {mapGetters} from 'vuex'
  export default {
    name: 'app',
    data: function () {
      return {}
    },
    computed: {
      ...mapGetters({
        userName: 'app/_getUserName',
        navPath: 'app/_navPath'
      }),
     _siteMapPath:function () {
        return this.$route.matched;
     }
  }
  }
</script>

<style lang="less" rel="stylesheet/less">
  body {
    margin: 0;
    background-color: #f9f9f9;
  }

  #app {
    font-family: 'Microsoft YaHei', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    color: #2c3e50;
    font-size: 14px;
  }

  input, textarea, keygen, select, button, body {
    font-family: 'Microsoft YaHei', Helvetica, Arial, sans-serif;
  }

  input {
    // 消除IE浏览器下input自带的清空符号
    &::-ms-clear {
      display: none;
    }
  }

  .el-pagination--small .el-pager li {
    margin-left: 10px;
    &:last-child {
      margin-right: 10px;
    }
  }
</style>
