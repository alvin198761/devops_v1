<template>
  <el-row>
    <el-col :span="12" :push="6">
      <el-form :model="form" label-width="150px" style="width: 50%">
        <el-form-item label="项目名称">
          <span>{{form.name}}</span>
        </el-form-item>
        <el-form-item label="构建方式">
          <el-select v-model="form.buildType" placeholder="构建方式">
            <el-option v-for="item in _buildTypes" :label="item.label" :value="item.value"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="版本控制">
          <el-select v-model="form.versionControl" placeholder="版本控制">
            <el-option v-for="item in _versionControls" :label="item.label" :value="item.value"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="saveBasicInfo">保存</el-button>
        </el-form-item>
      </el-form>
    </el-col>
  </el-row>
</template>
<script>
  import {mapGetters} from 'vuex';
  import {builds, versionContrls} from '../../constant';
  export default{
    props: ['project'],
    data: function () {
      return {
        form: this.project.project
      }
    },
    computed: {
      _buildTypes: function () {
        return builds;
      },
      _versionControls: function () {
        return versionContrls;
      }
    }
    ,
    methods: {
      saveBasicInfo() {
        this.$store.dispatch("project/saveBasicInfo")
      }
    }
  }
</script>
<style>

</style>
