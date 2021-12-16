$(function (){
    $.validator.addMethod("regrules",function(value,element,param){
        //value--表单元素的value值
        //element--被验证的表单元素对象
        //param--规则的取值（正则表达式）
        if(param.test(value))
        {
            return true;
        }
        return false;
    });

    $.validator.addMethod("checkUsername",function(value,element,param){
        var result = false;
        if(param)
        {
            //发ajax
            var url='checkUsername.do'
            $.ajax({
                url:url,
                data:{userName:value},
                async:false, //同步
                success:function(res){
                    console.log(res);
                    if(res.code==103)
                    {
                        result = false;
                    }else if(res.code==100)
                    {
                        result = true;
                    }
                }
            })
        }
        // console.log('----',result)
        return result;
    });

    $.validator.addMethod("checkEmail",function(value,element,param){
        var result = false;
        if(param)
        {
            //发ajax
            var url='checkEmail.do'
            $.ajax({
                url:url,
                data:{email:value},
                async:false, //同步
                success:function(res){
                    console.log(res);
                    if(res.code==103)
                    {
                        result = false;
                    }else if(res.code==100)
                    {
                        result = true;
                    }
                }
            })
        }

        console.log('----',result)
        return result;
    });

    $("#regFrm").validate({
        onfocusout:function (e){
            $(e).valid();
        },
        rules:{
            userName:{
                required: true,
                minlength: 4,
                checkUsername:true
            },
            password:{
                required: true,
                regrules:/^\w{5,10}$/
            },
            confirmpwd:{
                required:true,
                equalTo:"#password"
            },
            email:{
                required:true,
                email:true,
                checkEmail:true
            },
            name:{
                required:true
            },
            sex:{
                required:true
            },
            birthday:{
                required:true
            }
        },
        messages:{
            userName:{
                required: "用户名不能为空",
                minlength: "用户名最少为4位",
                checkUsername:"该用户名已被注册"
            },
            password:{
                required: "密码不能为空",
                regrules:"密码长度为5-10位"
            },
            confirmpwd:{
                required: "确认密码不能为空",
                equalTo:"两次密码不一致"
            },
            email:{
                required:"邮箱不能为空",
                email:"必须符合邮箱格式",
                checkEmail:"该邮箱已被注册"
            },
            name:{
                required:"姓名不能为空"
            },
            sex:{
                required:"性别不能为空"
            },
            birthday:{
                required:"生日不能为空"
            }
        },
        errorPlacement:function(errorEle,element)
        {
            if(element.is(':radio') ||element.is(':checkbox'))
            {
                errorEle.appendTo(element.parent().parent());
            }else{
                errorEle.appendTo(element.parent());
            }
        }
    });
});