<template>
    <div>
        <el-form-item label="命令" prop="type">
            <el-select @change="form.type=type" v-model="type" placeholder="请选择要执行的命令">
                <el-option label="上传文件" :value="1"></el-option>
                <el-option label="执行脚本" :value="2"></el-option>
                <el-option label="创建文件/目录" :value="3"></el-option>
                <el-option label="删除文件/目录" :value="4"></el-option>
                <el-option label="解压文件" :value="5"></el-option>
                <el-option label="基础命令" :value="6"></el-option>
            </el-select>
        </el-form-item>
        <el-row >
            <FileCmd v-if="type==1"></FileCmd>
            <ShellCmd v-if="type==2"></ShellCmd>
            <MkdirCmd v-if="type==3"></MkdirCmd>
            <RmdirCmd v-if="type==4"></RmdirCmd>
            <UnCompress v-if="type==5"></UnCompress>
            <BaiscCmd v-if="type==6"></BaiscCmd>
        </el-row>
    </div>
</template>
<script>
    import FileCmd from './FileCmd.vue';
    import ShellCmd from './ShellCmd.vue'
    import MkdirCmd from './MkdirCmd.vue'
    import RmdirCmd from './RmdirCmd.vue'
    import UnCompress from './UnCompress.vue'
    import BaiscCmd from './BaiscCmd.vue'

    export default {
        props :['form'],
        data :function () {
            return {
                type:this.form.type
            }
        },
        created:function () {

        }
        ,
        components: {
            FileCmd, ShellCmd, MkdirCmd, RmdirCmd, UnCompress, BaiscCmd
        },
        methods: {

        }
    }
</script>
<style></style>