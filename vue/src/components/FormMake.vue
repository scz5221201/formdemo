<template>
    <div>
        <fm-making-form
                ref="makingform"
                style="height: 550px;"
        >
            <template slot="action">
                <!-- 自定义操作区域插槽 -->
                <el-button type="text" icon="el-icon-upload" @click="showAddView">生成表单模板</el-button>
            </template>
        </fm-making-form>

        <el-dialog
                title="表单信息"
                :visible.sync="dialogVisible"
                width="30%">
            <div style="display: flex;justify-content: space-around">
                <el-tag style="margin-right: 5px">表单名</el-tag>
                <el-input size="mini" type="text" v-model="formInfo.name"></el-input>
            </div>
            <span slot="footer" class="dialog-footer">
    <el-button @click="dialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="addForm">确 定</el-button>
  </span>
        </el-dialog>
    </div>
</template>

<script>
    export default {
        name: "FormMake",
        data() {
            return {
                formInfo: {
                    template: '',
                    name: ''
                },
                dialogVisible: false
            }
        },

        created() {
            alert("自由组合的表单包括：请假申请人(字段标识:name),所属部门(字段标识:dep),请假理由(字段标识:reason),请假开始日期(字段标识:startTime)" +
                ",请假截止日期(字段标识:endTime),审批人(字段标识:auditor)，可使用上述标识字段自行搭配")
        },

        methods: {
            showAddView() {
                if (this.$refs.makingform.getJSON().list.length === 0) {
                    alert("设计的表单为空表单，生成失败")
                } else {
                    this.dialogVisible = true
                }
            },

            addForm() {
                let req = JSON.stringify(this.$refs.makingform.getJSON())
                this.formInfo.template = req
                console.log("req:" + req)
                if (req && this.formInfo.name) {
                    this.postRequest("/form/makeform/", this.formInfo).then(resp => {
                        if (resp) {
                            this.formInfo = {}
                            this.dialogVisible = false
                        }
                    })
                } else {
                    this.$message.error("生成失败，请填入表单名")
                }
            },

        }
    }
</script>

<style scoped>

</style>