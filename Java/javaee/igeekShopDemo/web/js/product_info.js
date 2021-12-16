$(function (){
    $("#addCart").click(function (e){
        var num = $("#quantity").val();
        var pid = $("#proId").text();
        window.location.href = "/igeekShopDemo/addCart.do?num="+num+"&pid="+pid;
    })
})