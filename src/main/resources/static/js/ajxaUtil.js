let serverUrl = "http:localhost:8080/"

function ajaxGet(url){
    return{
        url: serverUrl + url,
        method: "GET",
        timeout:0,
        headers:{
            Authorization:"Bearer "+localStorage.token
        }
    }
}

function ajaxPOST(url, data){
    return {
     url: backEndURL + url,
     method: "POST",
     timeout: 0,
     headers: {
       'Content-Type':'application/json',
       Authorization: "Bearer "+localStorage.token
     },
     data:data
   }
  }