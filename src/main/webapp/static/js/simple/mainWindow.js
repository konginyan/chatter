var readNotice = (id)=>{
    $("#mainWindow").load("readNotice",{
        'id':id
    })
}

var downloadFile = (id)=>{
    $("#fileId").val(id)
    $("#downloadForm").submit()
}