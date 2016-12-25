<template>
    <el-row class="content" >
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
                    <el-button size="small" icon="edit"></el-button>
                    <el-button size="small" icon="share"></el-button>
                    <el-button size="small" icon="delete"></el-button>
                </el-button-group>
            </el-col>
            <el-table
                    :data="users"
                    highlight-current-row
                    @current-change="handleCurrentChange"
                    style="width: 100%; ">
                <el-table-column
                        type="index"
                        width="50">
                </el-table-column>
                <el-table-column
                        property="name"
                        label="用户名"
                >
                </el-table-column>
                <el-table-column
                        property="chianese"
                        label="中文名称"
                >
                </el-table-column>
                <el-table-column
                        property="role"
                        label="角色"
                >
                </el-table-column>
                <el-table-column
                        property="time"
                        label="添加时间">
                </el-table-column>
                <el-table-column
                        property="author"
                        label="添加人">
                </el-table-column>
                <el-table-column
                        property="ops"
                        label="操作"
                        inline-template>
                     <span>
                    <el-button type="text" size="small">编辑</el-button>
                    <el-button type="text" size="small">删除</el-button>
                  </span>
                </el-table-column>
            </el-table>
            <el-pagination style="float:right"
                    layout="prev, pager, next"
                    :total="50">
            </el-pagination>
        </div>
        </el-col>
    </el-row>
</template>
<script>


    module.exports = {
       data: function () {
            return {
                users: [{
                    id: 0,
                    name: 'chuangshiyuanling',
                    chianese: '创始元灵',
                    role: '盘古灵气',
                    time: '0-0-0 0:0:0',
                    author: '盘古',
                    ops: '操作'
                },{
                    id: 1,
                    name: 'hongjunlaozu',
                    chianese: '鸿钧老祖',
                    role: '混元大罗金仙',
                    time: '11111-11-11 11:11:11',
                    author: '创始元灵',
                    ops: '操作'
                }, {
                    id: 2,
                    name: 'luyadaojuen',
                    chianese: '陆压道君',
                    role: '混元大罗金仙',
                    time: '11111-11-11 11:11:11',
                    author: '创始元灵',
                    ops: '操作'
                }, {
                    id: 3,
                    name: 'nvwaniangniang',
                    chianese: '女娲娘娘',
                    role: '混元大罗金仙',
                    time: '11111-11-11 11:11:11',
                    author: '创始元灵',
                    ops: '操作'
                }, {
                    id: 4,
                    name: 'hunlingzushi',
                    chianese: '混鲲祖师',
                    role: '混元大罗金仙',
                    time: '11111-11-11 11:11:11',
                    author: '创始元灵',
                    ops: '操作'
                }, {
                    id: 5,
                    name: 'yuanshitianzun',
                    chianese: '原始天尊',
                    role: '大罗金仙-阐教祖师',
                    time: '111-11-11 11:11:11',
                    author: '鸿钧老祖',
                    ops: '操作'
                }, {
                    id: 6,
                    name: 'daodezhenjuen',
                    chianese: '道德真君',
                    role: '大罗金仙-道教祖师',
                    time: '111-12-11 11:11:11',
                    author: '鸿钧老祖',
                    ops: '操作'
                }, {
                    id: 7,
                    name: 'tongtianjiaozhu',
                    chianese: '通天教主',
                    role: '大罗金仙-截教祖师',
                    time: '111-13-11 11:11:11',
                    author: '鸿钧老祖',
                    ops: '操作'
                }],
                currentRow: null,
                defaultProps: {
                    children: 'children',
                    label: 'label'
                },
                filterStr: ''

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
        width: 98%;
        background: white;
    }

</style>