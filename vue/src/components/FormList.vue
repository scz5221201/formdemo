<template>
    <div>
        <el-table
        :data="tableData"
        border
        stripe
        style="width: 100%">
        <el-table-column
                align="center"
                prop="id"
                label="编号"
                width="80">
        </el-table-column>
        <el-table-column
                align="center"
                prop="name"
                label="姓名"
                width="130">
        </el-table-column>
        <el-table-column
                align="center"
                prop="dep"
                label="所属部门">
        </el-table-column>
            <el-table-column
                    align="center"
                    prop="reason"
                    label="请假理由">
            </el-table-column>
            <el-table-column
                    align="center"
                    prop="startTime"
                    label="请假开始日期">
            </el-table-column>
            <el-table-column
                    align="center"
                    prop="endTime"
                    label="请假截止日期">
            </el-table-column>
            <el-table-column
                    align="center"
                    prop="auditor"
                    label="审批人">
            </el-table-column>

        </el-table>
    </div>
</template>

<script>
    export default {
        name: "FormList",
        data(){
            return{
                tableData:[]
            }
        },
        mounted(){
            this.initFormContent()
        },
        methods:{
            // 获取表单提交之后数据库中所有数据
            initFormContent(){
                this.getRequest("/form/fclist/").then(resp=>{
                    if (resp){
                        this.tableData=resp
                    }
                })
            }
        }
    }
</script>

<style scoped>

</style>