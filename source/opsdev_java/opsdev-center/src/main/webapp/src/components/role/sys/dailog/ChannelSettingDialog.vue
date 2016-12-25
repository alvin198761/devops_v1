<template>
    <el-dialog title="收货地址" v-model="show" :show-close="false" :close-on-click-modal="false"
               :close-on-press-escape="false" close="$parent.show=false">
        <el-form :model="form">
            <!--<el-form-item label="活动名称"  >-->
                <!--<el-input  auto-complete="off"></el-input>-->
            <!--</el-form-item>-->
            <!--<el-form-item label="活动区域" >-->
                <!--<el-select   placeholder="请选择活动区域">-->
                    <!--<el-option label="区域一" value="shanghai"></el-option>-->
                    <!--<el-option label="区域二" value="beijing"></el-option>-->
                <!--</el-select>-->
            <!--</el-form-item>-->
            内容暂无
        </el-form>
        <div slot="footer" class="dialog-footer">
            <el-button @click="$parent.show=false">取 消</el-button>
            <el-button type="primary" @click="dialogFormVisible = false">确 定</el-button>
        </div>
    </el-dialog>
</template>
<script>
    export default {
        props: ['show','entry'],
        data:function () {
           return {
               form:{

               }
           }
        }
        ,methods:{

        }
    }
</script>
<style>

</style>