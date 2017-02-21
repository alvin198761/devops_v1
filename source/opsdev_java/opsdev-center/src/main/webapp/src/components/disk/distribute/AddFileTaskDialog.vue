<template>
    <el-dialog title="分发文件任务" v-model="show" :show-close="true" :close-on-click-modal="false"
               :close-on-press-escape="false">
        <el-steps :active="active" :space="175" finish-status="success">
            <el-step title="常规">
            </el-step>
            <el-step title="选择文件">
            </el-step>
            <el-step title="选择服务器">
            </el-step>
            <el-step title="开始下发">
            </el-step>
        </el-steps>
        <el-card>
            <el-form :model="form" :rules="rules" ref="form">
                <el-row v-if="active==1">
                    <el-col :span="20">
                        <el-form-item label="目标位置" label-width="180px" prop="target">
                            <el-input v-model="form.target" auto-complete="off" size="small"
                                      placeholder="示例:/test/test1/"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span="20">
                        <el-form-item label="任务类型" prop="type" label-width="180px">
                            <el-select size="small" v-model="form.type">
                                <el-option label="立即发送" value="1" size="small"></el-option>
                                <el-option label="定时发送" value="2" size="small"></el-option>
                            </el-select>
                        </el-form-item>
                    </el-col>
                </el-row>
                <div v-if="active==2">
                    <el-row>
                        <el-col :span="24">
                            <el-tree
                                    :data="files"
                                    :props="props"
                                    show-checkbox
                                    @check-change="handleCheckChange">
                            </el-tree>
                        </el-col>
                    </el-row>
                </div>
                <div v-if="active==3">
                    <div v-for="o in 4">
                        {{'列表内容 ' + o }}
                    </div>
                </div>
                <div v-if="active==4">
                    <div>对所有的结果审查一次，呵呵哈哈哈，然后提交一哈</div>
                </div>
            </el-form>
        </el-card>
        <div style="text-align: right">
            <el-button style="margin-top: 12px;" @click="previous" :disabled="active==1">上一步</el-button>
            <el-button style="margin-top: 12px;" @click="next" v-show="active<4" :diabled="active==3">下一步</el-button>
            <el-button style="margin-top: 12px;" type="primary" @click="doFormSubmit" v-show="active==4">点击下发
            </el-button>
        </div>
    </el-dialog>
</template>
<script>
    module.exports = {
        props: ['addCDNTask'],
        data: function () {
            return {
                show: false,
                form: {
                    type: 1,
                    target: ''
                },
                rules: {
                    target: [
                        {required: true, message: '请输入目标位置', trigger: 'blur'}
                    ]
                },
                active: 1,
                files: [],
                hosts: [],
                defaultProps: {
                    children: 'children',
                    label: 'label'
                }
            };
        },
        created: function () {
            this.loadFiles();
            this.loadHosts();
        },
        computed: {},
        methods: {
            loadFiles: function () {
                this.$http.get('/api/cdn/files').then(res => {
                    this.files = res.data;
                });
            },
            loadHosts: function () {
                this.$http.get('/api/cdn/hosts').then(res => {
                    this.hosts = res.data;
                });
            },
            doFormSubmit: function () {
                this.$refs.form.validate(function (valid) {
                    if (!valid) {
                        return;
                    }
                    alert("do submit");
                    this.$refs.form.resetFields();
                })

            },
            next: function (e) {
                var _this = this;
                console.log("aaaa" + this.active)
                if (this.active >= 4) {
                    return;
                }
                _this.active += 1;

            },
            previous: function () {
                if (this.active == 4) {
                    return;
                }
                this.active -= 1;
            },
            handleCheckChange: function (data, checked, indeterminate) {
                console.log(data, checked, indeterminate)
            },
            showDialog: function () {
                this.show = true;
            }
        },
        components: {}

    }
</script>
<style>

</style>