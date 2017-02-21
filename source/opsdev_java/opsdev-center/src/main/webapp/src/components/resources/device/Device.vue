<template>
    <el-row class="content">
        <el-col>
            <div style="width: 98% ;padding-left:10px; ">
                <el-col :span="8" style="padding-top: 5px">
                    <el-input size="small"
                              placeholder="根据 Ip 搜索"
                              icon="search"
                              v-model="filterStr">
                    </el-input>
                </el-col>
                <el-col :span="16" style="padding-top: 5px">
                    <el-button-group>
                        <el-button size="small" icon="share" title="重新获取列表"></el-button>
                    </el-button-group>
                </el-col>
                <el-table
                        :data="devices"
                        v-loading="loading"
                        element-loading-text="跟你说，我为了加载，我也是蛮拼的"
                        highlight-current-row
                        style="width: 100%; ">
                    <el-table-column
                            type="index"
                            width="80">
                    </el-table-column>
                    <el-table-column
                            property="innerIp"
                            label="内网IP"
                    >
                    </el-table-column>
                    <el-table-column
                            property="outerIp"
                            label="外网Ip"
                    >
                    </el-table-column>
                    <el-table-column
                            property="room.name"
                            label="机房">
                    </el-table-column>
                    <el-table-column
                            property="remark"
                            label="备注"
                            width="300"
                    >
                    </el-table-column>
                </el-table>
                <el-row>
                    <el-pagination style="float:right"
                                   layout="prev, pager, next"
                                   @current-change="handleCurrentChange"
                                   :page-size="page.size"
                                   :page-count="page.pageCount"
                                   :current-page="page.number"
                                   :total="page.total">
                    </el-pagination>
                </el-row>
            </div>
        </el-col>
    </el-row>
</template>
<script>
    import {fetchAll} from '../../../service/DeviceService';

    export default {
        data: function () {
            return {
                loading: false,
                devices: [],
                allData: [],
                page: {
                    total: 0,
                    size: 20,
                    number: 1,
                    pageCount: 0
                },
                filterStr: ''

            };
        },
        created: function () {
            this.reload(this.page.number - 1);
        },
        methods: {
            handleNodeClick(){

            },
            filterData(allData){
                const datas = [];
                for (var item in allData) {
                    if (allData[item].innerIp.indexOf(this.filterStr) != -1 || allData[item].outerIp.indexOf(this.filterStr) != -1 ) {
                        datas.push(allData[item])
                    }
                }
                return datas;
            },
            handleCurrentChange(page){
                this.reload(page - 1)
            },
            reload(page){
                const _this = this;
                _this.loading = true;
               this.$http.get("/api/device/list/"+page).then(res => {
                    _this.allData = res.data.content;
                    _this.devices = this.filterData(this.allData);
                    _this.page = {
                        total: res.data.totalElements,
                        number: _this.page.number,
                        size: res.data.size,
                        pageCount: res.data.totalPages
                    }
                     _this.loading = false;
                }).catch(res =>{
                    _this.loading=false;
                });
            }
        }, watch: {
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