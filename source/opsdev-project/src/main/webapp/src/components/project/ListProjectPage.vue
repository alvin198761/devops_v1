<template>
  <div>
    <div style="max-height: 500px; overflow: auto">
      <el-table v-loading="loading" element-loading-text="拼命加载中"
                :data="projects"
                style="width: 100%">
        <el-table-column type="expand">
          <template scope="props">
            <div>图标: <i :class="props.row.attr.icon"></i></div>
            <div>状态: {{ props.row.attr.projectStatus }}</div>
            <div>描述: {{ props.row.attr.description }}</div>
          </template>
        </el-table-column>
        <el-table-column
          label="名称"
          prop="project.name">
        </el-table-column>
        <el-table-column
          label="构建方式"
          >
          <template scope="scope">
             <span>
                 {{scope.row.project.buildType | build-format}}
             </span>
          </template>
        </el-table-column>
        <el-table-column
          label="版本控制">
           <template scope="scope">
             <span>
                 {{scope.row.project.versionControl | version-format}}
             </span>
          </template>
        </el-table-column>
        <el-table-column
          label="创建人"
          prop="project.author">
        </el-table-column>
        <el-table-column
          label="操作">
          <template scope="scope">
            <el-button
              @click="setting(scope.$index,scope.row)"
              type="text"
              size="small">
              设置
            </el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
    <div style="text-align: right">
      <el-pagination
        small
        layout="prev, pager, next"
        :page-size="20"
        :total="page.total"
        :current-page="page.number"
        @current-change="handleCurrentChange"
      >
      </el-pagination>
    </div>
  </div>
</template>
<script>
  import {mapGetters} from 'vuex'
  import {buildFormat, versionFormat} from '../../constant';
  export default{

    computed: {
      ...mapGetters({
        projects: 'project/_getList',
        loading: 'project/_loading',
        page: 'project/_page'
      })
  }
  ,
  created: function () {
    let page = this.$route.params.page;
    if(!page){
      page = 1;
    }
    this.$store.dispatch('project/fetch',{page:page});
  } ,
  methods:{
    handleCurrentChange(current){
      this.$router.push("/project/list/"+ current);
      this.$store.dispatch('project/fetch',{page:current});
    },
    setting(index,row){
//      const _this = this;
//     this.$store.dispatch("project/detail",{
//       id:row.project.id,
//       $router:_this.$router
//     })
    }
  }
  ,
  filters :{
    'build-format' :   buildFormat,
      'version-format'  : versionFormat
  }
  }
</script>
<style>

</style>
