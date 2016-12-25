<template>
    <el-tabs :active="activeName" class="roleTab"  >
        <el-tab-pane label="用户管理" name="user"  style="min-height: 500px">
           <User></User>
        </el-tab-pane>
        <el-tab-pane label="权限管理" name="role"  >
            <Role></Role>
        </el-tab-pane>
    </el-tabs>
</template>
<script>
    import User from './User.vue'
    import Role from './Role.vue'
    export default {
        data: function () {
            return {
                activeName: 'user'
            };
        },

        methods: {},
        components: {
            Role ,User
        }

    }
</script>
<style >
    .roleTab {
        width: 100%;
        height: 100%;
    }

    .roleTab .el-tabs__header .el-tabs__item {
        width: 50%;
        text-align: center;
    }


</style>