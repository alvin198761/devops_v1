<template>
    <el-row>
        <el-col :span="16">
            <el-form-item label="名称">
                <el-input  placeholder="示例：/test/test.txt">
                </el-input>
            </el-form-item>
        </el-col>
        <el-col :span="8">
            <el-form-item label="选项">
                <el-checkbox  checked>级联删除</el-checkbox>
            </el-form-item>
        </el-col>
    </el-row>
</template>
<script>
    module.exports = {
        data: function () {
            return {}
        }

    }
</script>
<style ></style>