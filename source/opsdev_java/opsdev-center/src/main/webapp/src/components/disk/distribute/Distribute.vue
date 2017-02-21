<template>
    <div>
        <el-row>
            <div style="width: 98% ;padding-left:10px; ">
                <el-col :span="8" style="padding-top: 5px">
                    <el-input size="small"
                              placeholder="根据名称搜索"
                              icon="search"
                              v-model="filterStr">
                    </el-input>
                </el-col>
                <el-col :span="16" style="padding-top: 5px">
                    <el-button-group>
                        <el-button size="small" @click="$refs.dialog.showDialog()" icon="plus"
                                   title="添分发任务"></el-button>
                        <el-button size="small" icon="minus" title="删除"></el-button>
                    </el-button-group>
                </el-col>
                <el-table
                        :data="tasks"
                        highlight-current-row
                        v-loading="loading"
                        element-loading-text="为了数据，冲啊"
                        style="width: 100%; ">
                    <el-table-column
                            type="index"
                            width="50">
                    </el-table-column>
                    <el-table-column
                            property="file"
                            label="文件"
                    >
                    </el-table-column>
                    <el-table-column
                            property="hosts"
                            label="目标服务器"
                    >
                    </el-table-column>
                    <el-table-column
                            property="target"
                            label="目标位置"
                    >
                    </el-table-column>
                    <el-table-column
                            property="time"
                            label="开始时间"
                            width="180"
                    >
                    </el-table-column>
                    <el-table-column
                            property="user"
                            label="上传人">
                    </el-table-column>
                    <el-table-column
                            property="status"
                            label="状态">
                    </el-table-column>
                    <el-table-column
                            property="ops"
                            label="操作"
                            inline-template>
                     <span>
                    <el-button type="text" size="small" @click="cancelCDN($index,row)">取消</el-button>
                    <el-button type="text" size="small" @click="retryCDN($index,row)">重试</el-button>
                  </span>
                    </el-table-column>
                </el-table>
                <el-row>
                    <el-pagination style="margin-top:20px;float: right; margin-right: 10px;"
                                   layout="prev, pager, next"
                                   :total="page.total" :page-size="page.pageSize" :current-page="page.current">
                    </el-pagination>
                </el-row>
            </div>
            </el-col>
        </el-row>
        <AddFileTaskDialog ref="dialog"></AddFileTaskDialog>
    </div>
</template>
<script>
    import AddFileTaskDialog from './AddFileTaskDialog.vue'
    module.exports = {
        data: function () {
            return {
                tasks: [],
                currentRow: null,
                loading: false,
                defaultProps: {
                    children: 'children',
                    label: 'label'
                },
                filterStr: '',
                showAdd: false,
                page: {
                    current: 1,
                    total: 0,
                    pageSize: 20
                }
            };
        },

        methods: {
            reload(){
                this.loading = true;
                const _this = this;
                this.$http.get('/api/cdn/' + (this.page.current - 1)).then(res => {
                    let data = res.data;
                    _this.tasks = data.content;
                    _this.page = {
                        total: data.totalElements,
                        current: _this.page.current
                    }
                    _this.loading = false;
                }).catch(res => {
                    _this.loading = false;
                });
            },
            cancelCDN(index, row){
                this.$http.get('/api/cdn/cancel/' + row.id).then(res => {
                    this.$message({
                        message: '取消成功',
                        type: 'success'
                    });
                    this.reload();
                }) .catch(res => {
                    this.$message({
                        message: '取消失败',
                        type: 'error'
                    });
                })

            },
            retryCDN(index,row) {
                this.$http.get('/api/cdn/retry/' + row.id).then(res => {
                    this.$message({
                        message: '重试成功',
                        type: 'success'
                    });
                    this.reload();
                }).catch(res => {
                    this.$message({
                        message: '重试失败',
                        type: 'error'
                    });
                });
            }
        },

        created: function () {
            this.reload();
        },
        components: {
            AddFileTaskDialog
        }
    }
</script>
<style>
</style>