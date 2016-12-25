<template>
    <div>
        <el-row>
            <el-col :span="24">
                <el-form-item label="命令">
                    <el-input placeholder="示例：ping" v-model="input"   size="small"></el-input>
                </el-form-item>
            </el-col>
        </el-row>
        <el-row>
            <el-col :span="10">
                <el-form-item label="选项">
                    <el-input placeholder="示例：-t" v-model="input"  size="small"></el-input>
                </el-form-item>
            </el-col>
            <el-col :span="9">
                <el-form-item label="参数">
                    <el-input placeholder="例子：100" v-model="input" size="small"></el-input>
                </el-form-item>
            </el-col>
            <el-col :span="4">
                &nbsp;
                <el-button icon="plus" title="添加选项" size="small"></el-button>
                <el-button icon="minus" title="删除" size="small"></el-button>
            </el-col>
        </el-row>
    </div>
</template>
<script>
    module.exports = {
        data: function () {
            return {}
        }

    }
</script>
<style ></style>