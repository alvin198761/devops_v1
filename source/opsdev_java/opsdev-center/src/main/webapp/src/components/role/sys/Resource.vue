<template>
    <div>
        <el-row>
            <el-col :span="6">
                <el-tree :highlight-current="true" style="min-height: 500px" :data="data" :props="defaultProps" @node-click="handleNodeClick"></el-tree>
            </el-col>
            <el-col :span="18">
               <div></div>
                <div>
                    <el-tag style="margin: 10px;"
                            v-for="tag in tags"
                            :closable="true"
                            :type="tag.type"
                            :key="tag"
                            :close-transition="false"
                            @close="handleClose(tag)"
                    >{{tag.name}}
                    </el-tag>
                </div>
            </el-col>
        </el-row>
    </div>
</template>

<script>
    export default {
        data:function () {
            return {
                defaultProps:{
                    label:'label',
                    children:'children'
                },
                data:[
                    {
                        label:'机房1',
                        children:[
                            {label:'机器1'},
                            {label:'机器2'},
                            {label:'机器3'}
                        ]
                    },
                    {
                        label:'机房2',
                                children:[
                                    {label:'机器1'},
                                    {label:'机器2'},
                                    {label:'机器3'}
                                ]
                    }
                ],
                tags: [
                    { key: 1, name: '张三', type: '' },
                    { key: 2, name: '李四', type: 'gray' },
                    { key: 5, name: '王二', type: 'primary' },
                    { key: 3, name: '麻子', type: 'success' },
                    { key: 4, name: '二狗子', type: 'warning' },
                    { key: 6, name: '狗蛋', type: 'danger' },
                    { key: 11, name: '张三', type: '' },
                    { key: 12, name: '李四', type: 'gray' },
                    { key: 15, name: '王二', type: 'primary' },
                    { key: 13, name: '麻子', type: 'success' },
                    { key: 14, name: '二狗子', type: 'warning' },
                    { key: 16, name: '狗蛋', type: 'danger' }
                ]
            }
        },
        methods: {
            handleNodeClick:function () {

            },
            handleClose:function () {
                console.log("remove User")
            }
        }
    }
</script>