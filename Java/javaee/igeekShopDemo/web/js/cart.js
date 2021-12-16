$(function (){
    // 删除商品
    $(".delete").click(function (){
        var $delEle = $(this);
        // console.log($("#scPid").text());
        var flag = confirm("你确定要删除该条商品吗？");
        if (flag){
            $.ajax({
                url:"power/deleteCart.do",
                type:"get",
                data:{
                    pId:$("#scPid").text()
                },
                dataType:"json",
                success:function (res){
                    // console.log(res);
                    if (res.code == 100){
                        // console.log($("#scPid").text(res.data))
                        $delEle.parent().parent().remove();
                    }
                }
            })
        }
    })

    // 清空购物车
    $("#clear").click(function (){
        var flag = confirm("你确定要清空购物车吗？");
        if (flag){
            $.ajax({
                url:"power/removeCart.do",
                type:"get",
                dataType:"json",
                success:function (res){
                    console.log(res)
                    if (res.code == 100){
                        console.log($(".cartBody"))
                        $(".cartBody").text("");
                    }
                }
            })
        }
    })
})