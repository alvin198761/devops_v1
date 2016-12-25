<template>
    <div>
        <div>
            <el-table
                    :data="channels"
                    style="width: 100%">
                <el-table-column
                        prop="id"
                        label="ID"
                        width="50">
                </el-table-column>
                <el-table-column
                        prop="ip"
                        label="地址"
                        width="180">
                </el-table-column>
                <el-table-column
                        prop="port"
                        label="端口">
                </el-table-column>
                <el-table-column
                        prop="remark"
                        label="备注">
                </el-table-column>
                <el-table-column
                        inline-template
                        prop="id"
                        label="操作"
                        width="180">
                    <span>
                    <el-button type="text" @click="edit(row)">编辑</el-button>
                    <el-button type="text" @click="delete(row)">删除</el-button>
                    <el-button type="text" @click="setControl(row)">分配用户</el-button>
                        </span>
                </el-table-column>
            </el-table>
        </div>

        <el-form ref="form" :model="form" label-width="80px"   style="margin:20px;width:60%;min-width:600px;">
            <el-row>
                <el-col :span="16">
                    <el-form-item label="服务器" prop="ip" :rules="[
                     { required: true, message: '服务器不能为空', trigger: 'blur' }
                    ]">
                        <el-input  v-model="ip"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="8">
                    <el-form-item label="端口" porp="port" :rules="[
                     { required: true, message: '端口不能为空', trigger: 'blur' }
                    ]">
                        <el-input-number v-model="form.port" :min="0"
                        ></el-input-number>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-form-item label="备注" porp="remark">
                <el-input  v-model="form.remark" type="textarea"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="onSubmit">添加/修改</el-button>
                <el-button >清空</el-button>
            </el-form-item>
        </el-form>
        <ChannelSettingDialog :show="show" :entry="entry"></ChannelSettingDialog>

        </div>

</template>

<script>
    import {saveOrUpdate} from '../../../service/ChannelService'
    import ChannelSettingDialog from './dailog/ChannelSettingDialog.vue'

    export default {
        data:function () {
            return {
                show:false,
                entry:null,
                channels: [{
                    id:1,
                    ip: '10.10.10.1',
                   port:1111,
                    remark:'这是一个神奇的机器'
                } ],
                form: {
                    ip:'',
                    port:22,
                    remark:'',
                    id:null
                },
                opsStatus:0
            }
        },
        methods: {
            onSubmit:function() {
                const _this = this;
                this.$refs.form.validate((valid) => {
                    if(!valid){
                        return ;
                    }
                    saveOrUpdate(_this.opsStatus,_this.form).then((res) =>{
                        this.$message({
                        message: '操作成功',
                        type: 'success'
                    });
                    }).fail((res) => {
                            this.$message({
                            message: '操作失败',
                            type: 'error'
                        });
                     });
                });
            },
            edit:function (row) {
                console.log(row);
            },
            delete: function (row) {
                console.log(row);
            },
            setControl:function (row) {
                this.show = true;
                this.entry = row;
            }
        },
        components:{
            ChannelSettingDialog
        }
    }
</script>