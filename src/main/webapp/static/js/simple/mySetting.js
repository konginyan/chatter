var changeSetting = ()=>{
    $.ajax({
        url: 'um_changeSetting',
        type: 'POST',
        data: {
            'openPersonal': $("#openPersonal").is(':checked'),
            'openArticle': $("#openArticle").is(':checked'),
            'openCollection': $("#openCollection").is(':checked'),
            'openFollow': $("#openFollow").is(':checked')
        }
    })
}
