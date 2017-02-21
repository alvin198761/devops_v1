<template>
    <el-tabs :active-name="activeName" class="diskTab" >
        <el-tab-pane label="文件管理" name="file">
            <Files></Files>
        </el-tab-pane>
        <el-tab-pane label="分发列表" name="distribute"  >
            <Distribute></Distribute>
        </el-tab-pane>
    </el-tabs>
</template>
<script>
    import Files from './files/Files.vue'
    import Distribute from './distribute/Distribute.vue'

    export default {
        data: function () {
            return {
                activeName: 'file'
            };
        },

        methods: {},
        components: {
            Files,
            Distribute
        }

    }
</script>
<style>

    .diskTab {
        width: 100%;
        height: 100%;
    }

    .diskTab .el-tabs__header .el-tabs__item {
        width: 50%;
        text-align: center;
    }


</style>