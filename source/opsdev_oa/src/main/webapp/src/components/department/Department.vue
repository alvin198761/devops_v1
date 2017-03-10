<template>
    <el-row class="content">
        <el-row>
            <el-table
                    :data="departmentList"
                    highlight-current-row
                    @current-change="handleCurrentChange"
                    style="width: 100%; margin-left: 10px ">
                <el-table-column
                        property="id"
                        width="50"
                        label="#"
                >
                </el-table-column>
                <el-table-column
                        property="name"
                        label="部门"
                        width="220">
                </el-table-column>
                <el-table-column
                        property="description"
                        label="描述"
                >
                </el-table-column>
            </el-table>
        </el-row>

        <el-row>
            <el-form :model="form" :rules="rules" ref="form" label-width="100px" style="padding-top:50px">
                <el-row>
                    <el-col :span="15">
                        <el-form-item label="部门名称" prop="name">
                            <el-input type="text" v-model="form.name" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row>
                    <el-col :span="15">
                        <el-form-item label="描述" prop="description">
                            <el-input type="textarea" v-model="form.description"></el-input>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-form-item>
                    <el-button type="primary" @click="addDepartment">添 加</el-button>
                </el-form-item>
            </el-form>
        </el-row>
    </el-row>
</template>
<script>
    import {fetchDepartmentList,checkName,addDepartment} from '../../service/department.js'

    export default {
        data: function () {
            const checkDepartmentNameValidator = (rule, value, callback)=>{
                checkName(value).then(res => {
                    if(!res.res){
                       callback(new Error("名称已经存在！"));
                    }
                }).fail(res =>{
                    callback(new Error("检查出错！"));
                });
                callback();
            };

            return {
                departmentList: [],
                filterStr: '',
                form: {
                    name: '',
                    description: ''
                },
                rules :{
                    name:[
                        { required: true, message: '名称不能为空！', trigger: 'blur'} ,
                        { validator: checkDepartmentNameValidator, trigger: 'blur' }
                    ]
                }
            };
        },
        created: function () {
           this.refresh();
        },
        methods: {
            handleNodeClick: function () {

            },
            handleCurrentChange: function (row) {

            },
            refresh :function () {
                const _this = this;
                fetchDepartmentList().then(function (res) {
                    _this.departmentList = res;
                }).fail(function (res) {
                    console.log(res);
                });
            },
            addDepartment: function (e) {
                const _this = this;
                this.$refs.form.validate((valid) => {
                    if (!valid) {
                        return ;
                    }
                addDepartment(_this.form).then(res => {
                    _this.refresh();
                    _this.$notify({
                        title: '提示',
                        message: '添加成功！',
                        type: 'success'
                     });
                }).fail(res => {
                    _this.$notify({
                    title: '提示',
                    message: '添加失败！',
                    type: 'error'
                });
                });
             })
            }
        }
    }
</script>
<style>
    .content {
        top: 5px;
        bottom: 25px;
        position: absolute;
        width: inherit;
    }

</style>