$(function (){
    $("#addCart").click(function (e){
        var num = $("#quantity").val();
        var pid = $("#proId").text();
        var userName = $("loginUserName").text();
        /*var pathname = window.location.pathname;
        console.log(num+pid+pathname);*/
        window.location.href = "/igeekShopDemo/power/addCart.do?num="+num+"&pid="+pid+"&userName="+userName;
    })
})