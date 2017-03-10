<template>
    <el-row class="panel">
        <el-col :span="24" class="panel-top">
            <el-col :span="20" style="font-size:26px;">
                <img src="../assets/logo4.png" class="logo"> <span>人员<i style="color:#20a0ff">管理系统</i></span>
            </el-col>
        </el-col>
        <el-col :span="24" class="panel-center">
            <section class="panel-c-c">
                <div class="grid-content bg-purple-light">
                    <el-row>
                        <el-col :span="20" :offset="2" style="margin-bottom:15px; background: white;">
                            <el-breadcrumb separator="/" style="line-height: 35px">
                                <el-breadcrumb-item :to="{ path: '/table' }">首页</el-breadcrumb-item>
                                <el-breadcrumb-item>{{currentPathNameParent}}</el-breadcrumb-item>
                                <el-breadcrumb-item>{{currentPathName}}</el-breadcrumb-item>
                            </el-breadcrumb>
                        </el-col>
                        <el-col :span="20" :offset="2">
                            <el-row>
                                <el-col :span="4">
                                    <aside>
                                        <el-menu style="border-top: 1px solid #475669;" default-active="/department"
                                                 @open="handleopen"
                                                 @close="handleclose" @select="handleselect" unique-opened router>
                                            <el-menu-item index="/department">部门管理</el-menu-item>
                                            <el-menu-item index="/employee">职员管理</el-menu-item>
                                            <el-menu-item index="/account">高级设置</el-menu-item>
                                        </el-menu>
                                    </aside>
                                </el-col>
                                <el-col :span="17"  style="background-color:#fff;box-sizing: border-box;">
                                    <transition name="fade">
                                        <router-view></router-view>
                                    </transition>
                                </el-col>
                            </el-row>
                        </el-col>
                    </el-row>
                </div>
            </section>
            <!--</el-col>-->
        </el-col>
    </el-row>
</template>

<script>
    export default {
        data() {
            return {
                currentPathName: '部门管理',
                currentPathNameParent: '部门',
            }
        },
        watch: {
            '$route' (to, from) {//监听路由改变
                this.currentPathName = to.name;
                this.currentPathNameParent = to.matched[0].name;
            }
        },
        methods: {
            onSubmit() {
                console.log('submit!');
            },
            handleopen(){
                //console.log('handleopen');
            },
            handleclose(){
                //console.log('handleclose');
            },
            handleselect: function (a, b) {
            }
        }
    }
</script>

<style scoped>
    .fade-enter-active,
    .fade-leave-active {
        transition: opacity .5s
    }

    .fade-enter,
    .fade-leave-active {
        opacity: 0
    }

    .panel {
        position: absolute;
        top: 0px;
        bottom: 0px;
        width: 100%;
    }

    .panel-top {
        height: 60px;
        line-height: 60px;
        background: #1F2D3D;
        color: #c0ccda;
    }

    .panel-center {
        background: #324057;
        position: absolute;
        top: 60px;
        bottom: 0px;
        overflow: hidden;
    }

    .panel-c-c {
        background: #f1f2f7;
        position: absolute;
        right: 0px;
        top: 0px;
        bottom: 0px;
        left: 0px;
        overflow-y: scroll;
        padding: 20px;
    }

    .logo {
        width: 40px;
        float: left;
        margin: 10px 10px 10px 18px;
    }

    .admin {
        color: #c0ccda;
        text-align: center;
    }
</style>