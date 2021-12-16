$(function (){
    var remUserName = $.cookie("remUserName");
    if (remUserName == "on"){
        $("#username").val($.cookie("username"));
        console.log(remUserName,$.cookie("username"))
        $("#remUserName").attr("checked","checked");
    }else {
        $("#username").val("");
        console.log(remUserName,$.cookie("username"))
        // $("#remUserName").attr("checked","checked");
    }


    $("#loginFrm").submit(function (e){
        if($("#username").val() == ""){
            console.log($("#username").val());
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