function loginAjax(){
    let userInfo = ajaxPOST("/jwtTest", JSON.stringify({
        "user_id":$("#login_id").val(),
        "user_pw":$("#login_pw").val()
    }));
    console.log(userInfo)
    
}