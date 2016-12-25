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
                        <el-button size="small" icon="plus" @click="showAdd=true" title="添加文件"></el-button>
                        <el-button size="small" icon="minus" title="删除文件"
                                   :disabled="selectedRows.length==0"></el-button>
                    </el-button-group>
                </el-col>
                <el-table
                        :data="files"
                        highlight-current-row
                        @current-change="handleCurrentChange"
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
                            property="author"
                            label="上传人">
                    </el-table-column>
                    <el-table-column
                            property="ops"
                            label="操作"
                            inline-template>
                     <span>
                    <el-button type="text" size="small">下载</el-button>
                    <el-button type="text" size="small">删除</el-button>
                  </span>
                    </el-table-column>
                </el-table>
            </div>
            </el-col>
        </el-row>
        <el-row>
            <el-pagination style="float: right; margin-right: 10px;"
                           style="float:right"
                           v-loading="loading"
                           highlight-current-row
                           element-loading-text="跟你说，我为了加载，我也是蛮拼的"
                           layout="prev, pager, next"
                           @current-change="handleCurrentChange"
                           :page-size="page.size"
                           :page-count="page.pageCount"
                           :current-page="page.number"
                           :total="page.total">
            </el-pagination>
        </el-row>
        <AddFileDialog :show="showAdd"></AddFileDialog>
    </div>
</template>
<script>
    import AddFileDialog from './AddFileDialog.vue'
    import {fetchAll} from '../../../service/FileService'
    module.exports = {
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

        methods: {
            handleNodeClick(){

            },
            handleSelectionChange(val){
                this.selectedRows = val;
            },
            handleCurrentChange(page){
                this.reload(page - 1)
            },
            created: function () {
                this.reload(page.number - 1);
            },
            reload(page){
                const _this = this;
                this.loading = false;
                fetchAll(page).then(res => {
                    _this.files = res.content;
                    _this.page = {
                        total: res.totalElements,
                        number: res.number + 1,
                        size: res.size,
                        pageCount: res.totalPages
                    }
                    _this.loading = false;
                });
            }

        },
        components: {
            AddFileDialog
        }

    }
</script>
<style>

</style>