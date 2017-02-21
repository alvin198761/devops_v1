<template>
    <div>
        <el-row>
            <el-col>
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
                            <el-button size="small" icon="plus" @click="showAdd=true" title="添加文件"></el-button>
                            <el-button size="small" icon="minus" title="删除文件"
                                       :disabled="selectedRows.length==0" @click="deleteAllFile"></el-button>
                        </el-button-group>
                    </el-col>
                    <el-table
                            :data="files"
                            v-loading="loading"
                            element-loading-text="跟你说，我为了加载，我也是蛮拼的"
                            highlight-current-row
                            @selection-change="handleSelectionChange"
                            style="width: 100%; ">
                        <el-table-column
                                type="selection"
                                width="50">
                        </el-table-column>
                        <el-table-column
                                property="name"
                                label="名称"
                        >
                        </el-table-column>
                        <el-table-column
                                property="type"
                                label="类型"
                        >
                        </el-table-column>
                        <el-table-column
                                property="time"
                                label="上传时间">
                        </el-table-column>
                        <el-table-column
                                property="userName"
                                label="上传人">
                        </el-table-column>
                        <el-table-column
                                label="操作" :context="_self" inline-template>
                                <span>
                                <el-button type="text" size="small" @click="download($index,row,files)">下载
                                </el-button>
                                <el-button type="text" size="small" @click="deleteFile($index,row,files)">删除</el-button>
                                </span>
                        </el-table-column>
                    </el-table>
                </div>
            </el-col>
        </el-row>
        <el-row>
            <el-pagination style="float: right; margin-right: 10px;"
                           layout="prev, pager, next"
                           @current-change="handleCurrentChange"
                           :page-size="page.size"
                           :page-count="page.pageCount"
                           :current-page="page.number"
                           :total="page.total"></el-pagination>
        </el-row>
        <AddFileDialog :show="showAdd"></AddFileDialog>
    </div>
</template>
<script>
    import AddFileDialog from './AddFileDialog.vue'
    export default{
        data: function () {
            return {
                files: [],
                page: {
                    total: 0,
                    number: 1,
                    size: 0,
                    pageCount: 0
                },
                allData: [],
                loading: false,
                filterStr: '',
                showAdd: false,
                selectedRows: []
            };
        },
        created: function () {
            this.reload(this.page.number - 1);
        },
        components: {
            AddFileDialog
        },
        watch: {
            'filterStr' (to, from) {
                this.files = this.filterData(this.allData);
            }
        },
        methods: {
            handleNodeClick(){

            },
            filterData(list){
                return list.filter(item => item.name.indexOf(this.filterStr) != -1)
            },
            handleSelectionChange(val){
                this.selectedRows = val;
            },
            handleCurrentChange(page){
                this.reload(page - 1)
            },
            reload(page){
                const _this = this;
                this.loading = true;
                this.showAdd = false;
                this.$http.get("api/file/" + page).then(function (res) {
                    _this.allData = res.data.content || [];
                    _this.files = _this.filterData(_this.allData);
                    _this.page = {
                        total: res.data.totalElements,
                        number: _this.page.number,
                        size: res.data.size,
                        pageCount: res.data.totalPages
                    }
                    _this.loading = false;
                }).catch(res => {
                    _this.loading = false;
                });
            },
            download(index, row, files){
                window.location.href = "/api/file/download/" + row.id;
            },
            deleteFile(index, row, files){
                const _this = this;
                this.$confirm('此操作将永久删除该文件, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    _this.$http.delete("/api/file/" + row.id)
                        .then(res => {
                            _this.$message({
                                type: 'success',
                                message: '删除成功!'
                            });
                            _this.reload(_this.page.number - 1)
                        }).catch(() => {
                        _this.$message({
                            type: 'error',
                            message: '删除失败'
                        });
                    });
                })
            },
            deleteAllFile(){
                const _this = this;
                this.$confirm('此操作将永久删除所选文件, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    this.$http.delete("/api/file/delete", {
                        params: _this.selectedRows
                    }).then(res => {
                        _this.$message({
                            type: 'success',
                            message: '删除成功!'
                        });
                        _this.reload(_this.page.number - 1)
                    }).catch(() => {
                        _this.$message({
                            type: 'error',
                            message: '删除失败'
                        });
                    });
                });
            }
        }
    }
</script>
<style>

</style>