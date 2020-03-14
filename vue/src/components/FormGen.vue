<template>
    <div>
        <el-table
                :data="tableData"
                stripe
                border
                style="width: 80%">
            <el-table-column
                    prop="id"
                    align="center"
                    label="编号"
                    width="180">
            </el-table-column>
            <el-table-column
                    prop="name"
                    align="center"
                    label="表单模板名"
                    width="180">
            </el-table-column>
            <el-table-column
                    prop="createTime"
                    align="center"
                    label="创建日期"
                    width="180">
            </el-table-column>
            <el-table-column label="操作" align="center">
                <template slot-scope="scope">
                    <el-button
                            size="mini"
                            @click="handleEdit(scope.$index, scope.row)">编辑
                    </el-button>
                    <el-button
                            size="mini"
                            type="danger"
                            @click="handleDelete(scope.$index, scope.row)">删除
                    </el-button>
                </template>
            </el-table-column>
        </el-table>

        <el-dialog
                title="提示"
                :visible.sync="dialogVisible"
                width="80%">
            <div>
                <fm-generate-form
                        :data="templateData"
                        :value="formdata"
                        ref="generateForm"
                >
                </fm-generate-form>
            </div>


            <span slot="footer" class="dialog-footer">
            <el-button @click="dialogVisible = false">取消</el-button>
            <el-button type="primary" @click="commitForm">提交</el-button>
  </span>
        </el-dialog>


    </div>
</template>

<script>
    export default {
        data() {
            return {
                dialogVisible: false,
                tableData: [],
                templateData: {},
                formdata: {
                    name: '',
                    dep: '',
                    reason: '',
                    startTime: '',
                    endTime: '',
                    auditor: ''
                }

            }
        },
        created() {
            this.initFormData()
        },
        methods: {
            // 提交操作
            commitForm() {
                this.$refs.generateForm.getData().then(data => {
                    this.putRequest("/form/commit/",data).then(resp=>{
                        if (resp){
                            this.dialogVisible=false
                        }
                    })
                })

            },


            // 从数据库中获取所有表单模板
            initFormData() {
                this.getRequest("/form/formlist/").then(resp => {
                    if (resp) {
                        this.tableData = resp
                    }
                })
            },

            // 编辑按钮
            handleEdit(index, data) {
                console.log("index:" + index)
                this.dialogVisible = true
                this.getRequest("/form/single/" + data.id).then(resp => {
                    if (resp) {
                        this.templateData = Object.assign({}, JSON.parse(resp.template))
                    }
                })

            },

            // 删除按钮
            handleDelete(index, data) {
                console.log("index:" + index)
                this.$confirm('此操作将永久删除【' + data.name + '】该表单模板, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    this.deleteRequest("/form/single/" + data.id).then(resp => {
                        if (resp) {
                            this.initFormData()
                        }
                    })
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: '已取消删除'
                    });
                });
            }
        }
    }
</script>

<style>

</style>
