$(function (){
    // 勾选自动登录时记住密码一起勾上
    $("#autoLogin").click(function (){
        if (this.checked){
            $("#remUserName").prop("checked",true)
        }
    })
    // 取消记住密码时取消自动登录
    $("#remUserName").click(function (){
        if (!this.checked){
            $("#autoLogin").prop("checked",false)
        }
    })
    // 获取cookie中的用户名
    var remUserName = $.cookie("remUserName");
    if (remUserName == "on"){
        $("#username").val($.cookie("username"));
        // console.log(remUserName,$.cookie("username"))
        $("#remUserName").attr("checked","checked");
    }
    /*else {
        $("#username").val("");
        console.log(remUserName,$.cookie("username"))
        // $("#remUserName").attr("checked","checked");
    }*/

    // 提交事件
    $("#loginFrm").submit(function (e){
        if($("#username").val() == ""){
            // console.log($("#username").val());
            $("#username").css("border","1px solid #FF5555");
            $("#usernameMsg").text("用户名不能为空");
            return false;
        }else {
            $("#usernameMsg").text("");
            $("#username").css("border","1px solid #ccc");
            if ($("#inputPassword").val() == ""){
                $("#inputPassword").css("border","1px solid #FF5555");
                $("#passwordMsg").text("密码不能为空");
                return false;
            }else {
                $("#inputPassword").css("border","1px solid #ccc");
                $("#passwordMsg").text("");
                return true;
            }
        }
    })
})