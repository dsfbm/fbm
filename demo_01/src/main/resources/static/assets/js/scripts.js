jQuery(document).ready(function () {

    $('.page-container form').submit(function () {
        var username = $(this).find('.username').val();
        var password = $(this).find('.password').val();
        if (username == '') {
            $(this).find('.error').fadeOut('fast', function () {
                $(this).css('top', '27px');
            });
            $(this).find('.error').fadeIn('fast', function () {
                $(this).parent().find('.username').focus();
            });
            return false;
        }
        if (password == '') {
            $(this).find('.error').fadeOut('fast', function () {
                $(this).css('top', '96px');
            });
            $(this).find('.error').fadeIn('fast', function () {
                $(this).parent().find('.password').focus();
            });
            return false;
        }


        $.getJSON("LoginServlet", {loginname: username, password: password}, function (json) {
            //判断登录上是否成功
            if (json.flag) {
                window.location.href = "test05_布局和选项卡.html?uid=" + json.uid;

            } else {

                $("#errormsg").text("json.msg");
            }
            //跳转到菜单页面
            //不成功，提示当前页面

        });
        return false;
    });

    $('.page-container form .username, .page-container form .password').keyup(function () {
        $(this).parent().find('.error').fadeOut('fast');
    });

});
