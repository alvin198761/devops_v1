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
            <el-input v-model="form.name"></el-input>
          </el-form-item>
          <el-form-item
            label="描述"
            prop="description"
            :rules="[{ required: true, message: '描述不能为空', trigger: 'blur'   }]">
            <el-input v-model="form.description"></el-input>
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
  export default {
    data: function () {
      return {
        form: {
          name: '',
          description: ''
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
      })
  }
  }
</script>
<style>

</style>
