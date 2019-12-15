//导入公钥参数
var m = '<%=mou%>';
var e = '<%=exp%>';
var key = '';
setMaxDigits(128);
key = new RSAKeyPair(e, '', m);

var onoff = true//根据此布尔值判断当前为注册状态还是登录状态
var confirm = document.getElementsByClassName("confirm")[0]

//自动居中title
var name_c = document.getElementById("title")
var name = name_c.innerHTML.split("")
name_c.innerHTML = ""
for (i = 0; i < name.length; i++)
    if (name[i] != ",")
        name_c.innerHTML += "<i>" + name[i] + "</i>"
//注册按钮
function signin() {
    var status = document.getElementById("status").getElementsByTagName("i")
    if (onoff) {
        confirm.style.height = 51 + "px"
        status[0].style.top = 35 + "px"
        status[1].style.top = 0
        onoff = !onoff
    } else {
        if (!/^([0-9A-Za-z\-_\.]+)@([0-9a-z]+\.[a-z]{2,3}(\.[a-z]{2})?)$/g.test(user.value)){
            hint('请输入正确的邮箱格式','0');
            return;
// //             if (!/^[A-Za-z0-9]+$/.test(user.value))
// //                 hit.innerHTML = "账号只能为英文和数字"
// //             else if (user.value.length < 6)
// //                 hit.innerHTML = "账号长度必须大于6位"
        }else if ($("#passwd").val().length < 6){
            hint('密码长度必须大于6位','0');
            return;
        }else if ($("#passwd").val() != $("#confirm-passwd").val()){
            hint('两次密码不相等','0');
            return;
        }else if ($("#passwd").val() == $("#confirm-passwd").val()) {
            $.ajax({
                url : "register.ajax",
                type : "post",
                data : {
                    emUserName : $("#user").val(),
                    emPassWord : encryptedString(key, encodeURIComponent($("#passwd").val())),//加密后的密码
                    validate : $("#validate").val()
                },
                dataType : "json",
                success : function(respDate) {
                    console.log(respDate);
                    if(respDate.result=='0'){
                        hint('验证码不对','0');
                    }else if(respDate.result=='-1'){
                        hint('该邮箱已存在','0');
                    }else if(respDate.result=='1'){
                        hint('账号注册成功，两秒后自动刷新页面','1');
                        window.setTimeout("window.location='index.html'",2000);
                    }
                },
                error : function(err) {

                }
            });
        }
        changeImg();
    }
}

//登录按钮
function login() {
    if (onoff) {
        $.ajax({
            url : "login.ajax",
            type : "post",
            data : {
                username : $("#user").val(),
                //PassWord : encryptedString(key, encodeURIComponent($("#passwd").val())),//加密后的密码
                password :$("#passwd").val(),//加密后的密码
                validate : $("#validate").val()
            },
            dataType : "json",
            success : function(respDate) {
                console.log(respDate);
                if (respDate.result == 3) {

                    window.location = "index.html";
                } else if (respDate.result == 1) {
                    hint('账号密码错误','0');
                } else if (respDate.result == 2) {
                    hint('账号已被禁用','0');
                } else if (respDate.result == 0) {
                    hint('验证码有误','0');
                } else if (respDate.result == 4) {
                    hint('该账户没有管理员权限','0');
                }
                $("#user").val("");
                $("#passwd").val("");
                $("#validate").val("");
                changeImg();
            },
            error : function(err) {

            }
        });
    } else {
        var status = document.getElementById("status").getElementsByTagName("i")
        confirm.style.height = 0
        status[0].style.top = 0
        status[1].style.top = 35 + "px"
        onoff = !onoff
    }
}
//点击更改验证码
$("#validateimg").click(function() {
    changeImg();
})
//更改验证码
function changeImg() {
    $('#validateimg').attr("src","get-code.html?/t=" + new Date().getTime());
}
//弹窗
function hint(incof,select) {
    layui.use('layer', function() {
        if(select=='0'){
            layer.msg(incof, function() {
            });
        }else if(select=='1'){
            layer.msg(incof);
        }
    })

}