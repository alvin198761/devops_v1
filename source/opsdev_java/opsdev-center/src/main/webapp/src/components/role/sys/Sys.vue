<template>
    <el-tabs :active="activeName" class="systemTab">
        <el-tab-pane label="项目控制" name="1"  >
            <ProjectControl></ProjectControl>
        </el-tab-pane>
        <el-tab-pane label="机房/服务器控制" name="2"  >
            <Resource></Resource>
        </el-tab-pane>
        <el-tab-pane label="通道控制" name="3"  >
            <Channel></Channel>
        </el-tab-pane>
        <el-tab-pane label="邮件设置" name="4"  >
            <Mail></Mail>
        </el-tab-pane>
    </el-tabs>
</template>
<script>
    import ProjectControl from './ProjectControl.vue'
    import Resource from './Resource.vue'
    import Channel from './Channel.vue'
    import Mail from './Mail.vue'

    export default {

        data: function () {
            return {
                activeName: '1'
            };
        },

        methods: {},
        components: {
            ProjectControl,Resource,Channel,Mail
        }

    }
</script>
<style >

    .systemTab {
        width: 100%;
        height: 100%;
    }

    .systemTab .el-tabs__header .el-tabs__item {
        width: 25%;
        text-align: center;
    }


</style>