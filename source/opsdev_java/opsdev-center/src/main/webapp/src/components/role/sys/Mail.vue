<template>
    <!--mail.smtp.host=smtp.163.com-->
    <!--mail.send.user=alvin198761@163.com-->
    <!--mail.send.password=333333-->
    <!--mail.send.to.user=2273410177@qq.com-->
    <el-form ref="form" :model="form"  label-width="80px" @submit.prevent="onSubmit"
             style="margin:20px;width:60%;min-width:600px;">
        <el-row>
            <el-col :span="12">
                <el-form-item label="发件人" prop="mail" :rules="[
                { required: true, message: '邮件不能为空', trigger: 'blur' },
                { type: 'email', message: '请输入正确的邮箱地址', trigger: 'blur,change' }
                ]">
                    <el-input v-model="form.mail" placeholder="示例：alvin198761@163.com"></el-input>
                </el-form-item>
            </el-col>
            <el-col :span="12">
                <el-form-item label="密码" prop="password" :rules="[
                 { required: true, message: '密码不能为空', trigger: 'blur' },
                 { min: 5, message: '密码至少5位', trigger: 'blur,change' } ]">
                    <el-input type="password" v-model="form.password" placeholder="邮件密码"></el-input>
                </el-form-item>
            </el-col>
        </el-row>
        <el-row>
            <el-col :span="12">
                <el-form-item label="服务器" prop="host" :rules="{
              required: true, message: '服务器不能为空', trigger: 'blur'
            }">
                <el-input v-model="form.host" placeholder="示例：smtp.163.com"></el-input>
                </el-form-item>
            </el-col>
            <!--<el-col :span="12">-->
            <!--<el-form-item label="端口">-->
            <!--<el-input></el-input>-->
            <!--</el-form-item>-->
            <!--</el-col>-->
        </el-row>
        <el-row>
            <el-col :span="24">
                <el-form-item label="收件人"   >
                    <el-col :span="10">
                        <el-input v-model="addItem" placeholder="示例：alvin198761@163.com"></el-input>
                    </el-col>
                    <el-col :span="2">
                        <el-button @click="addToUserItem" :disabled="addItem==''||addItem==form.mail" style="margin-left: 5px">添加
                        </el-button>
                    </el-col>
                    <br/>
                    <el-row v-for="(user ,userIndex) in form.toUser">
                        <el-col :span="10">
                            {{user}}
                        </el-col>
                        <el-col :span="2">
                            <el-button @click="deleteUserItem(userIndex)" title="删除" type="text" icon="circle-cross"
                                       size="mini" style="margin-left: 5px;color: red"></el-button>
                        </el-col>
                    </el-row>
                </el-form-item>
            </el-col>
        </el-row>
        <el-form-item>
            <el-button type="primary" @click="onSubmit">保存设置</el-button>
        </el-form-item>
    </el-form>
</template>

<script>
    import {settingMail} from '../../../service/MailService'
    import {checkMail} from '../../../validation/FormatValidator'

    export default {
        data: function () {
            return {
                addItem: '',
                form: {
                    mail: '',
                    password: '',
                    host: '',
                    port: '',
                    toUser: []
                }
            }
        },
        methods: {
            onSubmit() {
                const _this = this;
                this.$refs.form.validate((valid)=>{
                    if(!valid){
                        return ;
                    }
                    if(this.form.toUser.length ==0){
                        this.$alert('请至少指定一个收件人','提示',{
                            confirmButtonText:'确定'
                        });
                        return ;
                    }
                     settingMail(_this.form).then((res)=>{
                         this.$message({
                         message: '修改成功',
                         type: 'success'
                        });
                     }).fail((res)=>{
                        this.$message({
                        message: '修改失败',
                        type: 'error'
                        });
                     });
                });
            },
            addToUserItem (e) {
                console.log(e)
                const _this = this;
                if(!checkMail(this.addItem)){
                    this.$alert("邮件格式不正确!","提示",{
                        confirmButtonText:'确定'
                    });
                    return;
                }
               if(this.form.toUser.indexOf(this.addItem) !=-1){
                    this.$alert("邮件已经存在!","提示",{
                        confirmButtonText:'确定'
                    });
                   return;
               }
               this.form.toUser.push(this.addItem);
               this.addItem ='';
            },
            deleteUserItem(index){
                const _this = this;
                this.$confirm('确定删除?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    _this.form.toUser.splice(index, 1);
                 }).catch(() => {} );
            }
        }
    }
</script>