<template>
    <el-row>
        <el-col :span="9">
            <el-form-item label="文件/目录">
                <el-input placeholder="请选择文件/目录" v-model="input" :disabled="true" size="small"></el-input>
            </el-form-item>
        </el-col>
        <el-col :span="2" >  &nbsp;
            <el-button icon="more" size="small" title="选择文件"></el-button>
        </el-col>
       <el-col :span="9">
           <el-form-item label="目标位置">
               <el-input placeholder="例子：/test/test.txt" v-model="input"   size="small"></el-input>
           </el-form-item>
       </el-col>
        <el-col :span="4">
            &nbsp;
            <el-button icon="plus" title="添加文件"  size="small"></el-button>
            <el-button icon="minus" title="删除" size="small"> </el-button>
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