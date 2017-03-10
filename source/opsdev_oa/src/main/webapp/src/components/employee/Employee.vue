<template>
    <el-row class="content">
        <el-col  >
            <div  style="width: 98% ;padding-left:10px; ">
                <el-col :span="8" style="padding-top: 5px">
                    <el-input size="small"
                            placeholder="根据名称搜索"
                            icon="search"
                            v-model="filterStr" >
                    </el-input></el-col>
                <el-col :span="16" style="padding-top: 5px">

                    <el-button-group>
                        <el-button size="small"   icon="plus" placeholder="添加员工"></el-button>
                        <el-button size="small"  icon="edit"></el-button>
                        <el-button size="small"  icon="delete"></el-button>
                    </el-button-group>
                </el-col>
                <el-table
                        :data="tableData"
                        highlight-current-row
                        @current-change="handleCurrentChange"
                        style="width: 100%; ">
                    <el-table-column
                            property="id"
                            width="50">
                    </el-table-column>
                    <el-table-column
                            property="name"
                            label="姓名"
                            width="120">
                    </el-table-column>
                    <el-table-column
                            property="age"
                            label="年龄"
                            width="50">
                    </el-table-column>
                    <el-table-column
                            property="gender"
                            label="性别">
                    </el-table-column>
                    <el-table-column
                            property="phone"
                            label="手机">
                    </el-table-column>
                </el-table>
                <el-pagination style="float: right"
                        small
                        layout="prev, pager, next"
                        :total="50">
                </el-pagination>
            </div>
        </el-col>
    </el-row>
</template>
<script>
    export default {
        data :function(){
            return {
                tableData: [{
                    index:1,
                    date: '2016-05-02',
                    name: '王小虎',
                    address: '上海市普陀区金沙江路 1518 弄'
                }, {
                    index:2,
                    date: '2016-05-04',
                    name: '王小虎',
                    address: '上海市普陀区金沙江路 1517 弄'
                }, {
                    index:3,
                    date: '2016-05-01',
                    name: '王小虎',
                    address: '上海市普陀区金沙江路 1519 弄'
                }, {
                    index:3,
                    date: '2016-05-03',
                    name: '王小虎',
                    address: '上海市普陀区金沙江路 1516 弄'
                }],
                currentRow: null,
                filterStr:''

            };
        },

        methods: {
            handleNodeClick:function(){

            },
            handleCurrentChange:function(row){

            }
        }
    }
</script>
<style>
    .content {
        top: 5px;
        bottom: 25px;
        position: absolute;
    }

</style>