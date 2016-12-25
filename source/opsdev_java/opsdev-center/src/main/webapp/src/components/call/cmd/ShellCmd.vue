<template>
    <div>
        <el-row>
            <el-col :span="9">
                <el-form-item label="脚本文件">
                    <el-input placeholder="请选择脚本文件" v-model="input" :disabled="true" size="small"></el-input>
                </el-form-item>
            </el-col>
            <el-col :span="2">  &nbsp;
                <el-button icon="more" size="small"></el-button>
            </el-col>
            <el-col :span="9">
                <el-form-item label="目标位置">
                    <el-input placeholder="例子：/test/test.sh" v-model="input" size="small"></el-input>
                </el-form-item>
            </el-col>
            <el-col :span="4">
                &nbsp;
                <el-button icon="plus" title="添加文件" size="small"></el-button>
                <el-button icon="minus" title="删除" size="small"></el-button>
            </el-col>
        </el-row>

        <el-row>
            <el-form-item label="执行命令">
                <el-input type="textarea"
                          :autosize="{ minRows: 2, maxRows: 4}"
                          placeholder="请输入要执行的命令"></el-input>
            </el-form-item>
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