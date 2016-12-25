<template>
    <el-dialog title="添加文件" v-model="show" :show-close="false" :close-on-click-modal="false"
               :close-on-press-escape="false">
        <el-form :model="form" :rules="rules" ref="form">
            <el-row>
                <el-col :span="12">
                    <el-form-item label="类型" label-width="80px">
                        <el-select size="small" v-model="form.type" placeholder="请选择文件类型" prop="type">
                            <el-option label="文件" value="FILE" size="small"></el-option>
                            <el-option label="目录" value="DIR" size="small"></el-option>
                        </el-select>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="名称" prop="file" label-width="80px">
                        <el-input v-model="form.file" auto-complete="off" placeholder="请输入文件名称" size="small"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row>
                <el-col :span="12" :offset="5">
                    <el-upload
                            action="/file/upload"
                            type="drag"
                            name="upfile"
                            :multiple="false"
                            :on-preview="handlePreview"
                            :on-remove="handleRemove"
                            :on-success="handleSuccess"
                            :on-error="handleError"
                            :default-file-list="fileList"
                    >
                        <i class="el-icon-upload"></i>
                        <div class="el-dragger__text">将文件拖到此处，或<em>点击上传</em></div>
                        <div class="el-upload__tip" slot="tip">不得超过地球的最大容量</div>
                    </el-upload>
                </el-col>
            </el-row>
        </el-form>
        <div slot="footer" class="dialog-footer">
            <el-button @click="$parent.showAdd=false">取 消</el-button>
            <el-button type="primary" @click="doFormSubmit">确 定</el-button>
        </div>
    </el-dialog>
</template>
<script>
    import {addFileItem} from '../../../service/FileService';

    module.exports = {
        props: ['show'],
        data: function () {
            return {
                form: {
                    type: 'FILE',
                    file: '',
                },
                rules: {
                    file: [
                        {required: true, message: '请输入活动名称', trigger: 'blur'},
                        {min: 5, max: 50, message: '长度在 5 到 50 个字符', trigger: 'blur'}
                    ]
                }
            };
        },
        computed: {},
        methods: {
            doFormSubmit: function () {
                const _this = this;
                this.$refs.form.validate(function (valid) {
                    if (!valid) {
                        return;
                    }
                    addFileItem(_this.form).then(res =>{
                        _this.$message({
                            showClose: true,
                            message: '添加文件成功',
                            type: 'success'
                        });
                        _this.$parent.reload();
                    }).fail(res => {
                        _this.$message({
                            showClose: true,
                            message: '添加文件失败',
                            type: 'error'
                        });
                    });
                    _this.$refs.form.resetFields();
                })
            },
            handleSuccess: function (response, file, fileList) {
                this.file = file.name;
            }
        },
        components: {}

    }
</script>
<style>


</style>