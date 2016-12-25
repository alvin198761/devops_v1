<template>
    <el-row class="content">
        <div  style="width: 98% ;padding-left:10px; ">
            <el-col :span="8" style="padding-top: 5px">
                <el-input size="small"
                          placeholder="根据名称搜索"
                          icon="search"
                          v-model="filterStr" >
                </el-input></el-col>
            <el-col :span="16" style="padding-top: 5px">

                <el-button-group>
                    <el-button size="small"   icon="share" title="重新获取列表"></el-button>
                </el-button-group>
            </el-col>
            <el-table
                    :data="projects"
                    highlight-current-row
                    @current-change="handleCurrentChange"
                    style="width: 100%; ">
                <el-table-column
                        type="index"
                        width="50">
                </el-table-column>
                <el-table-column
                        property="name"
                        label="项目"
                        width="120">
                </el-table-column>
                <el-table-column
                        property="user"
                        label="负责人"
                        width="120">
                </el-table-column>
                <el-table-column
                        property="type"
                        label="项目类型">
                </el-table-column>
                <el-table-column
                        property="build"
                        label="编译方式">
                </el-table-column>
                <el-table-column
                        property="versionM"
                        label="管理工具"
                        width="120"
                >
                </el-table-column>
                <el-table-column
                        property="remark"
                        label="描述"
                        width="300"
                >
                </el-table-column>
            </el-table>
        </div>
        </el-col>
    </el-row>
</template>
<script>

    export default {
        data :function () {
            return {
                projects: [{
                    index:1,
                    id:1,
                    name:'时空传送项目',
                    user:'赵日天',
                    type:'JAVA',
                    build:'MAVEN',
                    versionM:'SVN',
                    remark:'这种项目也就我能带'
                }, {
                    index:2,
                    id:3,
                    name:'火星移民项目',
                    user:'叶良辰',
                    type:'JAVA',
                    build:'ANT',
                    versionM:'GIT',
                    remark:'老子是火星本地人，有的是办法折磨你'
                } ],
                currentRow: null,
                defaultProps: {
                    children: 'children',
                    label: 'label'
                },
                filterStr:''

            };
        },

        methods: {
            handleNodeClick(){

            },
            handleCurrentChange(row){

            }

        }

    }
</script>
<style>
    .content {
        top: 50px;
        bottom: 25px;
        position: absolute;
        width: 98%;
        background: white;
    }

</style>