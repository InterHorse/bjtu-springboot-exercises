/**

 @Name：按出生年份查询
 @Author：InterHorse
 @Date：2020-08-07
 */


layui.define(function (exports) {
    layui.use('table', function () {
        var table = layui.table;
        //第一个实例
        table.render({
            elem: '#birth-table'
            , url: 'http://127.0.0.1/search/birthYearInterval' //数据接口
            , where : {
            }
            , page: true //开启分页
            , limit: 10
            , limits: [20, 50, 100, 500]
            , cols: [[ //表头
                {field: 'id', title: 'ID', sort: true}
                , {field: 'gender', title: '性别', }
                , {field: 'birthYear', title: '出生年份', sort: true}
                , {field: 'totalMileage', title: '总旅行里程'}
                , {field: 'totalTime', title: '总旅行时间'}
            ]]
            , parseData: function (res) {
                return {
                    "code": res.code, //解析接口状态
                    "msg": res.msg, //解析提示文本
                    "count": res.data.total, //解析数据长度
                    "data": res.data.list //解析数据列表
                };
            }
        });
    });

    exports('reloadBirthTable', function () {
        layui.use(['table','form'], function () {
            var table = layui.table;
            var form = layui.form;

            var data = form.val("birth_form");
            console.log(data);
            table.reload('birth-table', {
                where: {
                    start: data.birth_start,
                    end: data.birth_end
                }
            });
        });
    });

    exports('birth', {})
});