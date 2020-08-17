/**

 @Name：按时间查询
 @Author：InterHorse
 @Date：2020-08-13
 */


layui.define(function (exports) {
    layui.use('table', function () {
        var table = layui.table;
        //第一个实例
        table.render({
            elem: '#table'
            , url: 'http://127.0.0.1/search/timeInterval' //数据接口
            , where: {}
            , page: true //开启分页
            , limit: 10
            , limits: [20, 50, 100, 500]
            , cols: [[ //表头
                {field: 'id', title: 'ID', sort: true}
                , {field: 'gender', title: '性别'}
                , {field: 'birthYear', title: '出生年份', sort: true}
                , {field: 'totalMileage', title: '总旅行里程', sort: true}
                , {field: 'totalTime', title: '总旅行时间', sort: true}
            ]]
            , parseData: function (res) {
                var resList = res.data.list;
                for (var i = 0; i < resList.length; i++) {
                    if (resList[i].gender == '0') {
                        resList[i].gender = '女';
                    } else {
                        resList[i].gender = '男';
                    }
                }
                return {
                    "code": res.code, //解析接口状态
                    "msg": res.msg, //解析提示文本
                    "count": res.data.total, //解析数据长度
                    "data": resList //解析数据列表
                };
            }
        });
    });

    exports('reloadTable', function () {
        layui.use(['table', 'form'], function () {
            var table = layui.table;
            var form = layui.form;

            var data = form.val("form");
            table.reload('table', {
                where: {
                    start: data.start,
                    end: data.end
                }, page: {
                    curr: 1 //重新从第 1 页开始
                }
            });
        });
    });

    exports('times', {})
});