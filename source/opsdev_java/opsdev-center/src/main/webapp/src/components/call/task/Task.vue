<template>
    <div>
        <el-form ref="form" :model="form" label-width="80px" @submit.prevent="onSubmit"
                 style="margin:20px;width:60%;min-width:600px;">
            <el-form-item label="任务名称">
                <el-input placeholder="示例：对老板的复仇任务"></el-input>
            </el-form-item>
            <el-form-item label="任务类型">
                <el-radio-group>
                    <el-radio :label="1">立即执行</el-radio>
                    <el-radio :label="2">定时执行</el-radio>
                    <el-radio :label="3">周期执行</el-radio>
                </el-radio-group>
            </el-form-item>
            <div>操作步骤：
                <el-button type="primary" @click="show=true">添加任务项</el-button>
                <!--<router-link to="task-item" class="el-button el-button&#45;&#45;primary" style="text-decoration: none">添加任务项</router-link>-->
            </div>
            <br/>
            <el-steps :space="50" direction="vertical" :active="stepActive">
                <el-step v-for="item in stepData" :title="item.title" :description="item.description">
                </el-step>
            </el-steps>
            <br/>
            <el-form-item>
                <br/>
                <el-button type="primary">创建并发起</el-button>
                <el-button @click.native.prevent>取消</el-button>
            </el-form-item>
        </el-form>
        <TaskItem :show="show"></TaskItem>
    </div>
</template>

<script>
    import TaskItem from './TaskItem.vue'

    export default {
        data: function () {
            return {
                form: {
                    name: '',
                    region: '',
                    date1: '',
                    date2: '',
                    delivery: false,
                    type: [],
                    resource: '',
                    desc: ''
                },
                stepActive: 0,
                stepData: [
                    {title: '步骤 1', description: '删除根分区目录adfasdasdfsdafdsfdsfdssdffdsfdsfsdsdffdsfd'},
                    {title: '步骤 2', description: '格式化所有硬盘'},
                    {title: '步骤 3', description: '赶紧跑路'}
                ],
                show: false
            }
        },
        methods: {
            onSubmit() {
                console.log('submit!');
            }
        },
        components: {TaskItem}
    }
</script>