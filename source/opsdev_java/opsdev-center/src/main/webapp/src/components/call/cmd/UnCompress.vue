<template>
    <div>
        <el-row>
            <el-col :span="12">
                <el-form-item label="解压方式">
                    <el-select placeholder="请选择解压方式">
                        <el-option label="Zip" :value="1"></el-option>
                        <el-option label="Tar" :value="2"></el-option>
                    </el-select>
                </el-form-item>
            </el-col>
            <el-col :span="12">
                <el-form-item label="选项">
                    <el-input placeholder="示例：-xf">
                    </el-input>
                </el-form-item>
            </el-col>
        </el-row>
        <el-row>
            <el-col :span="12">
                <el-form-item label="源文件">
                    <el-input placeholder="示例：/test/test.zip">
                    </el-input>
                </el-form-item>
            </el-col>
            <el-col :span="12">
                <el-form-item label="解压位置">
                    <el-input placeholder="示例：/test/test">
                    </el-input>
                </el-form-item>
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