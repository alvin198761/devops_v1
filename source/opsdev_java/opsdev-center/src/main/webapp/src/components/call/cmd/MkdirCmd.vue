<template>
    <el-row>
        <el-col :span="12">
            <el-form-item label="创建类型">
                <el-select  placeholder="请选择创建类型">
                    <el-option label="文件" :value="1"></el-option>
                    <el-option label="目录" :value="2"></el-option>
                </el-select>
            </el-form-item>
        </el-col>
        <el-col :span="12">
            <el-form-item label="文件名称">
                <el-input  placeholder="示例：/test/test.txt">
                </el-input>
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