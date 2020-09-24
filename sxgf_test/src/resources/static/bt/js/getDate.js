$(function () {
    $.post({
        url: '/alluser',
        success: function (data) {
            for (var i = 0; i < data.length; i++) {
                var text = "<tr>\n" +
                    "                    <td>" + data[i].id + "</td>\n" +
                    "                    <td>" + data[i].name + "</td>\n" +
                    "                    <td>" + data[i].sex + "</td>\n" +
                    "                    <td>" + data[i].age + "</td>\n" +
                    "                    <td>" + data[i].class1 + "</td>\n" +
                    "                    <td>" + data[i].tel + "</td>\n" +
                    "                    <td>\n" +
                    "                        <a href=\"delById/" + data[i].id + "\"  class=\"btn btn-danger\">删除</a>\n" +
                    "                        <a href=\"../../update.html\" class=\"btn btn-success\">增加</a>\n" +
                    "                    </td>\n" +
                    "                </tr>"

                var obj = $(".pool");
                obj.append(text);
            }

        }
    });
});