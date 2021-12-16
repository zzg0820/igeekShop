$(function (){
    var currentPage = 1;
    var totalPage = $(".pageItem").last().text();
    // var cId = $(".cId").text();
    $(".pageItem").click(function (e){
        currentPage = $(this).text();
        currentEle = $(this).parent();
        sendAjax(currentPage,currentEle)
    })
    $(".previousPage").click(function (e){
        var nextEle = $(".pageLi.active");
        // console.log(nextEle)
        // console.log(parseInt(nextEle.children().text()))
        var currentPage = parseInt(nextEle.children().text())-1;
        if (currentPage<1){
        }else {
            currentEle = nextEle.prev();
            // console.log(currentEle)
            sendAjax(currentPage,currentEle);
        }
    })
    $(".nextPage").click(function (e){
        var nextEle = $(".pageLi.active");
        // console.log(nextEle)
        // console.log(parseInt(nextEle.children().text()))
        var currentPage = parseInt(nextEle.children().text())+1;
        if (currentPage>totalPage){
        }else {
            currentEle = nextEle.next();
            // console.log(currentEle)
            sendAjax(currentPage,currentEle);
        }
    })

    function sendAjax(currentPage,currentEle){
        $.ajax({
            url:"page.do",
            type:"get",
            data:{
                currentPage:currentPage,
                cId:$(".cId").text()
            },
            dataType:"json",
            success:function (res){
                // console.log(res);
                $(".pageItems").text("");
                res.list.forEach(function (item){
                    var $div = $(`
                        <div class="col-md-2" style="overflow:hidden;white-space: nowrap;text-overflow: ellipsis">
                        <a href="proInfo.do?pid=${item.pId}"> 
                        <img src="${item.pImage}" width="170" height="170" style="display: inline-block;">
                        </a>
                        <p>
                            <a href="proInfo.do?pid=${item.pId}" style='color: green'>${item.pName}</a>
                        </p>
                        <p>
                            <font color="#FF0000">商城价：&yen;${item.shop_price}</font>
                        </p>
                    `)
                    $(".pageItems").append($div);
                    totalPage = res.totalPage;
                    // console.log(totalPage);
                })
                $(".pageLi").removeClass("active");
                currentEle.addClass("active");
                // console.log(currentEle);
                // console.log(currentPage);
                if (currentPage <= 1){
                    $(".previousPage").parent().addClass("disabled");
                }else {
                    $(".previousPage").parent().removeClass("disabled");
                }
                // console.log(totalPage);
                if (currentPage >= totalPage){
                    // console.log('last page');
                    $(".nextPage").parent().addClass("disabled");
                }else {
                    $(".nextPage").parent().removeClass("disabled");
                }
            }
        })
    }
})