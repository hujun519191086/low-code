<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>${table.comment}首页</title>
    <!-- 引入样式 -->
    <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css"/>
    <link rel="stylesheet" href="/css/common.css"/>
</head>
<body>
<div id="app">
    <el-container direction="vertical">
        <my-header></my-header>

        <el-main>

            <el-form :model="queryForm" ref="queryForm" :inline="true" label-width="100px">
                <#-- ----------  BEGIN 字段循环遍历  ---------->
                <#list queryFields as field>
                    <#if field.customMap.hasEnum>
                        <el-form-item label="${field.comment}" label-width="100px">
                            <el-select v-model="queryForm.${field.propertyName}" placeholder="请选择">
                                <el-option
                                        v-for="item in ${field.propertyName}Options"
                                        :key="item.value"
                                        :label="item.label"
                                        :value="item.value">
                                </el-option>
                            </el-select>
                        </el-form-item>
                    <#else>
                        <el-form-item label="${field.comment}" label-width="100px">
                            <el-input v-model="queryForm.${field.propertyName}"
                                      style="width: 217px;"></el-input>
                        </el-form-item>
                    </#if>
                </#list>
                <#------------  END 字段循环遍历  ---------->

                <el-form-item>
                    <el-button-group>
                        <el-button type="primary" @click="doQuery('queryForm')" icon="el-icon-search">查询</el-button>
                        <el-button type="warning" @click="doQueryClear('queryForm')" icon="el-icon-refresh-right">重置</el-button>
                        <el-button type="default" @click="doExport('queryForm')" icon="el-icon-download">导出</el-button>
                    </el-button-group>

                    <el-button type="success" @click="dialogAddVisible = true" icon="el-icon-plus">新增</el-button>
                </el-form-item>

            </el-form>

            <el-divider></el-divider>

            <el-table
                    ref="singleTable"
                    :data="tableData"
                    border
                    stripe
                    style="width: 100%">
<#--                <el-table-column type="index" label="序号" width="60">-->
                </el-table-column>

                <#-- ----------  BEGIN 字段循环遍历  ---------->
                <#list table.fields as field>
                    <#if field.customMap.hasEnum>
                        <el-table-column
                                property="${field.propertyName}"
                                label="${field.comment}"
                                :formatter="${field.propertyName}Formatter">
                        </el-table-column>
                    <#else>
                        <el-table-column
                                property="${field.propertyName}"
                                label="${field.comment}">
                        </el-table-column>
                    </#if>

                </#list>
                <#------------  END 字段循环遍历  ---------->

                <el-table-column label="操作">
                    <template slot-scope="scope">
                        <el-button-group>
                            <el-button
                                    size="mini"
                                    @click="handleEdit(scope.row)"><i class="el-icon-edit"></i></el-button>
                            <el-button
                                    size="mini"
                                    type="danger"
                                    @click="handleDelete(scope.row)"><i class="el-icon-delete"></i></el-button>
                        </el-button-group>
                    </template>
                </el-table-column>
            </el-table>

            <el-pagination
                    background
                    layout="total, prev, pager, next"
                    :data="page"
                    :total="page.total"
                    :current-page="page.pageNum"
                    :page-size="page.pageSize"
                    @current-change="handleCurrentChange"
            >
            </el-pagination>

        </el-main>

        <my-footer></my-footer>

        <el-dialog title="添加${table.comment}" :visible.sync="dialogAddVisible">
            <el-form :model="addForm"  ref="addForm">
                <#list addFields as field>
                    <#if field.customMap.hasEnum>
                        <el-form-item label="${field.comment}" label-width="100px">
                            <el-select v-model="addForm.${field.propertyName}" placeholder="请选择">
                                <el-option
                                        v-for="item in ${field.propertyName}Options"
                                        :key="item.value"
                                        :label="item.label"
                                        :value="item.value">
                                </el-option>
                            </el-select>
                        </el-form-item>
                    <#else>
                        <el-form-item label="${field.comment}"
                                      prop="${field.propertyName}"
                                      label-width="100px">
                            <el-input v-model="addForm.${field.propertyName}" style="width: 217px;">
                            </el-input>
                        </el-form-item>
                    </#if>
                </#list>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="dialogAddVisible = false">取 消</el-button>
                <el-button type="primary" @click="saveAddForm('addForm')">确 定</el-button>
            </div>
        </el-dialog>

        <el-dialog title="修改${table.comment}" :visible.sync="dialogEditVisible" @close="closeDialogEditVisible">
            <el-form :model="editForm" ref="editForm">

                <#list editFields as field>
                    <#if field.customMap.hasEnum>
                        <el-form-item label="${field.comment}" label-width="100px">
                            <el-select v-model="editForm.${field.propertyName}" placeholder="请选择">
                                <el-option
                                        v-for="item in ${field.propertyName}Options"
                                        :key="item.value"
                                        :label="item.label"
                                        :value="item.value">
                                </el-option>
                            </el-select>
                        </el-form-item>
                    <#else>
                        <el-form-item label="${field.comment}"
                                      prop="${field.propertyName}"
                                      label-width="100px">
                            <el-input v-model="editForm.${field.propertyName}" style="width: 217px;">
                            </el-input>
                        </el-form-item>
                    </#if>
                </#list>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="dialogEditVisible = false">取 消</el-button>
                <el-button type="primary" @click="saveEditForm('editForm')">确 定</el-button>
            </div>
        </el-dialog>

    </el-container>
</div>

<script src="https://unpkg.com/vue/dist/vue.js"></script>
<!-- 引入组件库 -->
<script src="https://unpkg.com/element-ui/lib/index.js"></script>

<!--axios-->
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script src="https://cdn.bootcss.com/qs/6.5.1/qs.min.js"></script>
<script src="/js/main.js"></script>
<script>
    var vm = new Vue({
        el: '#app',
        data: {
            tableData: [],
            page: {
                total: 0,
                pageNum: 1,
                pageSize: 10
            },
            <#list queryFields as field>
                <#if field.customMap.hasEnum>
                    ${field.propertyName}Options: [
                        <#list field.customMap.enumMapping as option>
                        {
                            value: '${option.key}',
                            label: '${option.label}'
                        },
                        </#list>
                    ],
                </#if>
            </#list>
            dialogAddVisible: false,
            addForm: {
                <#list addFields as field>
                ${field.propertyName}: '',
                </#list>
            },
            queryForm: {
                <#list queryFields as field>
                ${field.propertyName}: null,
                </#list>
            },
            dialogEditVisible: false,
            editForm: {
                <#list editFields as field>
                ${field.propertyName}: '',
                </#list>
            },
        },
        mounted () {
            // 接在完成之后，调用初始化方法
            this.init()
        },
        methods: {
            init() {
                // 加载数据
                this.doQuery();
            },
            // 格式化输出方法
            <#list queryFields as field>
                <#if field.customMap.hasEnum>
                ${field.propertyName}Formatter(row, column) {
                    <#list field.customMap.enumMapping as option>
                    if(row.${field.propertyName} === '${option.key}') {
                        return '${option.label}';
                    }
                    </#list>
                },
                </#if>
            </#list>

            doQuery() {
                var req = {
                    <#list table.fields as field>
                    ${field.propertyName}: this.queryForm.${field.propertyName},
                    </#list>
                    pageNum: this.page.pageNum,
                    pageSize: this.page.pageSize
                }

                console.log("请求：" + JSON.stringify(req));
                //axios 中的 this 并不指向 vue
                var _this = this;
                axios.post('/${table.entityPath}/list', req).then(function (response) {
                    if(response.data.respCode === '0000') {
                        _this.tableData = response.data.list;
                        _this.page.total = response.data.total;
                    } else {
                        ELEMENT.Message.error(response.data.respMessage);
                    }
                }).catch(function (error) {
                    ELEMENT.Message.error("请求失败");
                    console.log(error);
                });
            },
            doQueryClear() {
                <#list table.fields as field>
                this.queryForm.${field.propertyName} = null;
                </#list>

                this.doQuery();
            },
            doExport() {
                var req = {
                    <#list table.fields as field>
                    ${field.propertyName}: this.queryForm.${field.propertyName},
                    </#list>
                }

                console.log("请求：" + JSON.stringify(req));
                //axios 中的 this 并不指向 vue
                var _this = this;
                axios({ // 用axios发送post请求
                    method: 'post',
                    url: '/${table.entityPath}/export', // 请求地址
                    data: req, // 参数
                    responseType: 'blob', // 表明返回服务器返回的数据类型
                    headers: {'Content-Type': 'application/json'}
                }).
                then(function (response) {
                    let fileName = window.decodeURI(response.headers['content-disposition'].split('=')[1]);
                    let link = document.createElement("a");
                    const blob =new Blob([response.data]);
                    link.href = window.URL.createObjectURL(blob);
                    link.target = "_blank";
                    link.download = fileName;
                    document.body.appendChild(link);
                    link.click();
                    document.body.removeChild(link);
                }).catch(function (error) {
                    ELEMENT.Message.error("请求失败");
                    console.log(error);
                });
            },
            /**
             * 处理删除逻辑
             * @param row 当前行
             */
            handleDelete(row) {
                var id = row.id;
                var _this = this;
                axios.post('/${table.entityPath}/remove/' + id).then(function (response) {
                    if(response.data.respCode === '0000') {
                        _this.doQuery();

                        ELEMENT.Message.success("删除成功");
                        visible = false;
                    } else {
                        ELEMENT.Message.error(response.data.respMessage);
                    }
                }).catch(function (error) {
                    ELEMENT.Message.error("删除失败");
                });
            },
            /**
             * 处理页面变化
             * @param val 当前页面
             */
            handleCurrentChange(val) {
                this.page.pageNum = val;
                this.doQuery();
            },
            /**
             * 关闭新增模态框
             */
            closeDialogAddVisible() {
                //element封装的方法,清空模态框的值
                this.$refs.addForm.resetFields();
                this.dialogAddVisible = false;
            },
            /**
             * 保存新增数据
             * @param aaa 表单信息
             */
            saveAddForm(aaa) {
                var _this = this;

                var entity = {
                    <#-- ----------  BEGIN 字段循环遍历  ---------->
                    <#list table.fields as field>
                    ${field.propertyName}: this.addForm.${field.propertyName},
                    </#list>
                    <#------------  END 字段循环遍历  ---------->
                }
                axios.post('/${table.entityPath}/add', entity).then(function (response) {
                    if(response.data.respCode === '0000') {
                        ELEMENT.Message.success("请求成功");
                        _this.closeDialogAddVisible();
                        _this.doQuery();
                    } else {
                        ELEMENT.Message.error(response.data.respMessage);
                    }
                }).catch(function (error) {
                    ELEMENT.Message.error("请求失败");
                    console.log(error);
                });
            },
            /**
             * 关闭编辑页面
             */
            closeDialogEditVisible() {
                //element封装的方法,清空模态框的值
                this.$refs.editForm.resetFields();
                this.dialogEditVisible = false;
            },
            handleEdit(row) {
                <#-- ----------  BEGIN 字段循环遍历  ---------->
                <#list table.fields as field>
                this.editForm.${field.propertyName} = row.${field.propertyName};
                </#list>
                <#------------  END 字段循环遍历  ---------->

                // 显示编辑 form
                this.dialogEditVisible = true;
            },
            /**
             * 保存编辑表单
             * @param editForm 编辑表单
             */
            saveEditForm(editForm) {
                var entity = {
                    <#-- ----------  BEGIN 字段循环遍历  ---------->
                    <#list table.fields as field>
                    ${field.propertyName}: this.editForm.${field.propertyName},
                    </#list>
                    <#------------  END 字段循环遍历  ---------->
                };
                // 此处使用 qs 序列化，后端不需要使用 @RequestBody 注解。
                var data = Qs.stringify(entity);
                var _this = this;
                axios.post('/${table.entityPath}/edit', data).then(function (response) {
                    if(response.data.respCode === '0000') {
                        ELEMENT.Message.success("请求成功");
                        _this.doQuery();
                        _this.closeDialogEditVisible();
                    } else {
                        ELEMENT.Message.error(response.data.respMessage);
                    }
                }).catch(function (error) {
                    ELEMENT.Message.error("请求失败");
                    console.log(error);
                });
            }
        }
    })
</script>
</body>
</html>