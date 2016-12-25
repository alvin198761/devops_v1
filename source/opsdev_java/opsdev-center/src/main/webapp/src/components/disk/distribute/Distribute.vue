<template>
    <div>
        <el-row >
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
                        <el-button size="small" @click="showAdd=true" icon="plus" title="添分发任务"></el-button>
                        <el-button size="small" icon="minus" title="删除"></el-button>
                    </el-button-group>
                </el-col>
                <el-table
                        :data="tasks"
                        highlight-current-row
                        @current-change="handleCurrentChange"
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
                    <el-button type="text" size="small">取消</el-button>
                    <el-button type="text" size="small">重试</el-button>
                  </span>
                    </el-table-column>
                </el-table>
            </div>
            </el-col>
        </el-row>
        <AddFileTaskDialog :show="showAdd"></AddFileTaskDialog>
    </div>
</template>
<script>
    import AddFileTaskDialog from './AddFileTaskDialog.vue'
    module.exports = {
        data: function () {
            return {
                tasks: [{
                    id: 1,
                    file: '再论时空穿梭.txt',
                    hosts: '牛逼1，很牛逼2',
                    target:'/test/nb.txt',
                    time: '2100-1-1 12:12:12',
                    user: '赵日天',
                    ops: '操作',
                    status:'客观别急'
                } ],
                currentRow: null,
                defaultProps: {
                    children: 'children',
                    label: 'label'
                },
                filterStr: '',
                showAdd:false

            };
        },

        methods: {
            handleNodeClick(){

            },
            handleCurrentChange(row){

            }

        },

        created: function () {
           // console.log("enter")
        },
        components :{
            AddFileTaskDialog
        }
    }
</script>
<style >
    /*.content {*/
        /*top: 50px;*/
        /*bottom: 25px;*/
        /*position: absolute;*/
        /*width: 98%;*/
        /*background: white;*/
    /*}*/

</style>