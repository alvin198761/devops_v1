<template>
    <el-row class="content">
        <div style="width: 98% ;padding-left:10px; ">
            <el-col :span="8" style="padding-top: 5px">
                <el-input size="small"
                          placeholder="根据机房搜索"
                          icon="search"
                          v-model="filterStr">
                </el-input>
            </el-col>
            <el-col :span="16" style="padding-top: 5px">
                <el-button-group>
                    <el-button size="small" @click="reload" icon="share" title="重新获取列表"></el-button>
                </el-button-group>
            </el-col>
            <el-table
                    v-loading="loading"
                    highlight-current-row
                    element-loading-text="跟你说，我为了加载，我也是蛮拼的"
                    :data="rooms"
                    @current-change="handleCurrentChange"
                    style="width: 100%; ">
                <el-table-column
                        type="index"
                        width="50">
                </el-table-column>
                <el-table-column
                        property="name"
                        label="机房">
                </el-table-column>
                <el-table-column
                        property="manager"
                        label="负责人"
                        width="120">
                </el-table-column>
                <el-table-column
                        property="address"
                        label="地址">
                </el-table-column>
                </el-table-column>
                <el-table-column
                        property="remark"
                        label="备注"
                        width="300">
                </el-table-column>
            </el-table>
        </div>
        </el-col>
    </el-row>
</template>
<script>

    import {fetchAll} from '../../../service/RoomService';

    export default {
        data (){
            return {
                allData: [],
                filterStr: '',
                loading: false,
                rooms: [],
                currentRow: null,
                defaultProps: {
                    children: 'children',
                    label: 'label'
                }
            };
        },

        created: function () {
            this.reload();
        },

        methods: {
            handleNodeClick(){

            },
            handleCurrentChange(row){

            },
            filterData(allData){
                const datas = [];
                for (var item in allData) {
                    if (allData[item].name.indexOf(this.filterStr) != -1) {
                        datas.push(allData[item])
                    }
                }
                return datas;
            },
            reload: function (e) {
                const _this = this;
                _this.loading = true;
                fetchAll().then(res => {
                    _this.allData = res;
                    _this.rooms = _this.filterData(_this.allData);
                    _this.loading = false;
                })
            }

        },

        watch: {
            'filterStr' (to, from) {
                this.rooms = this.filterData(this.allData);
            }
        }
    }
</script>
<style>
    .content {
        top: 50px;
        bottom: 25px;
        position: absolute;
        width: 98%;
        background: white;
    }

</style>