$(function (){
    $.ajax({
        url:"head.do",
        type:"get",
        dataType:"json",
        success:function (res){
            res.data.forEach(function (item){
              var $li = $(`<li class="active"><a href="proList.do?cId=${item.cId}">${item.cName}<span class="sr-only">(current)</span></a></li>`);
              $(".nav").append($li);
            })
        }
    })
})