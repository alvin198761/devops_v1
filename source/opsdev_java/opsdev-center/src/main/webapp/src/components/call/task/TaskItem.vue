<template>
    <el-dialog title="收货地址" v-model="show" :close-on-click-modal="false" :show-close="false"
               :close-on-press-escape="false" close="$parent.show=false">
        <el-form ref="form" :model="form" label-width="80px" @submit.prevent="onSubmit"
                 style="margin:20px;width:60%;min-width:600px;">
            <el-form-item label="执行次数">
                <el-input-number :min="1" :max="10" placeholder="最多10次"></el-input-number>
            </el-form-item>
            <CmdCommons :type="form.type" :form="form"></CmdCommons>
            <el-form-item>
                <el-button @click="$parent.show=false">取消</el-button>
                <el-button type="primary">添加</el-button>
            </el-form-item>
        </el-form>
    </el-dialog>
</template>

<script>
    import CmdCommons from '../cmd/CmdCommons.vue'
    export default {
        props:['show'],
        data: function () {
            return {
                form: {
                    type: 1,
                }
            }
        },
        methods: {
            onSubmit() {
                console.log('submit!');
            }
        },
        components: {
            CmdCommons
        }
    }
</script>