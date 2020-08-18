/**

 @Name：按出生年份查询
 @Author：InterHorse
 @Date：2020-08-07
 */
let limitNum = 10;
let currentNum = 2;
let index = 2;

layui.define(function (exports) {
    layui.use('table', function () {
        let table = layui.table;
        //第一个实例
        table.render({
            elem: '#table'
            , url: 'http://127.0.0.1/search/birthYearInterval' //数据接口
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
                let resList = res.data.list;
                for (let i = 0; i < resList.length; i++) {
                    if (resList[i].gender === '0') {
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
            let table = layui.table;
            let form = layui.form;

            let data = form.val("form");
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

    exports('addForm', function () {
        if (currentNum >= limitNum) {
            return;
        }
        layui.use('jquery', function () {
            let $ = layui.$
            $("#chart-form").append('<div class="layui-inline" id="chart-form-line-' + index + '">\n' +
                '                        <div class="layui-input-inline" style="width: 20%;">\n' +
                '                          <input type="text" name="start-' + index + '" autocomplete="off" class="layui-input" oninput="value=value.replace(/[^\\d]/g,\'\')" placeholder="1900">\n' +
                '                        </div>\n' +
                '                        <div class="layui-form-mid">-</div>\n' +
                '                        <div class="layui-input-inline" style="width: 20%;">\n' +
                '                          <input type="text" name="end-' + index + '" autocomplete="off" class="layui-input" oninput="value=value.replace(/[^\\d]/g,\'\')" placeholder="2020">\n' +
                '                        </div>\n' +
                '                        <button type="button" class="layui-btn layui-btn-danger" onclick="delForm(' + index + ')">\n' +
                '                          <i class="layui-icon">&#xe67e;</i>\n' +
                '                        </button>' +
                '                      </div>');
        });
        currentNum++;
        index++;

    });

    exports('delForm', function (num) {
        layui.use('jquery', function () {
            let $ = layui.$
            $("#chart-form-line-" + num).remove();
        });
        currentNum--;
    });

    exports('searchChart', function () {
        layui.use(['jquery', 'form'], function () {
            let $ = layui.jquery;
            let form = layui.form;
            let data = form.val("chart-form");
            let arr = [];
            let j = 0
            for (let i in data) {
                let curData = data[i];
                if (curData === '') {
                    curData = 0;
                }
                if (j % 2 === 0) {
                    arr[j] = curData;
                } else {
                    if (curData < arr[j - 1]) {
                        arr[j] = arr[j - 1];
                        arr[j - 1] = curData;
                    }else {
                        arr[j] = curData;
                    }
                }
                j++;
            }

            $.ajax({
                url:"http://127.0.0.1/search/birthChart",
                type:"post",
                contentType: "application/json",
                data: JSON.stringify({
                    data: arr
                }),
                dataType:"json",
                success:function(data){
                }
            });
        });
    });

    exports('birth', {})
});