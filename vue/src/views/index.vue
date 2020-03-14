<template>
    <el-container>
        <el-header class="header-container">
            <div class="header-title">xx系统</div>
        </el-header>
        <el-container>
            <el-aside width="200px">
                <el-menu
                        router
                        class="el-menu-vertical-demo">
                    <el-submenu index="1">
                        <template slot="title">
                            <i class="el-icon-location"></i>
                            <span>工具</span>
                        </template>
                        <el-menu-item index="/formmake">
                            表单构建
                        </el-menu-item>
                        <el-menu-item index="/formgen">
                            表单生成
                        </el-menu-item>
                        <el-menu-item index="/formlist">
                            表单数据
                        </el-menu-item>

                    </el-submenu>
                </el-menu>
            </el-aside>
            <el-main>
                <router-view/>
            </el-main>
        </el-container>
    </el-container>
</template>

<script>
    export default {
        name: "index",
        data() {
            return {

            }
        },
        methods: {
        }
    }
</script>

<style>
    .header-container {
        background-color: #5bb6ff;
        align-items: center;
        display: flex;
        justify-content: space-between;
        padding: 0 15px;
        box-sizing: border-box;
    }

    .header-title {
        color: white;
        font-size: 25px;
    }
</style>