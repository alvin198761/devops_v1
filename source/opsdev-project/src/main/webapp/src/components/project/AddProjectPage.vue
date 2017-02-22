<template>
  <el-row>
    <el-col :span="18" :push="3">
      <div v-loading="loading" element-loding-text="正在拼命加载中...">
        <el-form :model="form" ref="form" label-width="150px">
          <el-form-item
            prop="name"
            label="名称"
            :rules="[{ required: true, message: '请输入项目名称', trigger: 'blur' } ]"
          >
            <el-input v-model="form.name" style="width: 300px"></el-input>
          </el-form-item>
          <el-form-item
            label="编译方式"
            prop="buildType"            >
            <el-select v-model="form.buildType" placeholder="请选择构建方式">
              <el-option
                v-for="item in _buildTypes"
                :label="item.label"
                :value="item.value">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item
            label="版本管理"
            prop="versionControl" >
            <el-select v-model="form.versionControl" placeholder="请选择版本管理">
              <el-option
                v-for="item in _versionControls"
                :label="item.label"
                :value="item.value">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="addProject('form')">提交</el-button>
            <el-button @click="cancel('form')">返回列表</el-button>
          </el-form-item>
        </el-form>
    </el-col>
  </el-row>
  </div>
</template>
<script>
  import {mapGetters} from 'vuex'
  import {builds ,versionContrls} from '../../constant';
  export default {
    data: function () {
      return {
        form: {
          name: '',
          versionControl:1,
          buildType:1
        }
      }
    },
    methods: {
      cancel(formName)
      {
        this.$refs[formName].resetFields();
        this.$router.push("/project/list");
      },
      addProject(formName)     {
        const _this = this;
        this.$refs[formName].validate(function (valid) {
          if (valid) {
            _this.$store.dispatch('project/add',_this.$router, _this.form);
          }
        })
      }
    },
    computed: {
      ...mapGetters({
        loading: 'project/_loading'
      }),
      _buildTypes:function () {
        return builds;
      },
      _versionControls:function () {
        return versionContrls;
      }
    }
  }
</script>
<style>

</style>
