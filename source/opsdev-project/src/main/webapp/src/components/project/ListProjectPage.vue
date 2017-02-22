<template>
  <div>
    <div style="max-height: 500px; overflow: auto">
      <el-table v-loading="loading" element-loading-text="拼命加载中"
                :data="projects"
                style="width: 100%">
        <el-table-column type="expand">
          <template scope="props">
            <p>图标: {{ props.row.attr.icon }}</p>
          </template>
        </el-table-column>
        <el-table-column
          label="编号"
          prop="project.id">
        </el-table-column>
        <el-table-column
          label="名称"
          prop="project.name">
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
  export default{

    computed: {
      ...mapGetters({
        projects: 'project/_getList',
        loading: 'project/_loading',
        page: 'project/_page'
      })
  }  ,
  created: function () {
    this.$store.dispatch('project/fetch');
  } ,
  methods:{
    handleCurrentChange(current) {
      if(current === this.page.number){
        return ;
      }
      this.$store.dispatch('project/changePage', {
        number: current
      });
    }
  }
  }
</script>
<style>

</style>
