<template>
  <el-tabs class="towTab">
    <el-tab-pane label="基本信息">
      <BasicInfo :project="project"></BasicInfo>
    </el-tab-pane>
    <el-tab-pane label="配置信息">
      <ConfigInfo :project="project"></ConfigInfo>
    </el-tab-pane>
  </el-tabs>
</template>
<script>
  import BasicInfo from './BasicInfo.vue';
  import ConfigInfo from './ConfigInfo.vue';
  import {mapGetters} from 'vuex';
  export default{
    components: {
      BasicInfo, ConfigInfo
    },
    created:function () {
//      let id = this.$route.params.id;
//      if(!id){
//        id = 1;
//      }
//      this.$store.dispatch("project/detail",{ id: id});
    } ,
    computed: {
      ...mapGetters({
        project: 'project/_getProject'
      }),
  }
  }
</script>
<style>
  .towTab {
    width: 100%;
  }

  .towTab .el-tabs__header .el-tabs__item {
    width: 50%;
    text-align: center;
  }
</style>
