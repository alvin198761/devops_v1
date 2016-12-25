<template>
    <el-form ref="form" :model="form" label-width="80px" @submit.prevent="onSubmit"
             style="margin:20px;width:60%;min-width:600px;">
        <CmdCommons :form="form"></CmdCommons>
        <el-form-item label="服务器">
            <el-button icon="plus" size="small" title="选择服务器"></el-button>
            <el-row>西海龙宫机房：10.110.0.1</el-row>
            <el-row>南天门机房：10.110.0.2</el-row>
            <el-row>狮驼岭机房：10.110.0.3</el-row>
            <el-row>小西天机房：10.110.0.4</el-row>
        </el-form-item>
        <el-form-item>
            <el-button type="primary">执行</el-button>
            <el-button @click.native.prevent>取消</el-button>
        </el-form-item>
    </el-form>
</template>

<script>
    import CmdCommons from './CmdCommons.vue'
    export default {
        data: function () {
            return {
                form: {
                    type: 1
                }
            }
        },
        methods: {
            onSubmit() {
                console.log('submit!');
            }
        },
        components: {
            CmdCommons
        }
    }
</script>