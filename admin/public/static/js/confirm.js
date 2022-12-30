const confirm = {
    show : function (message,aaa) {
        Swal.fire({
            title: '确定删除该数据吗?',
            text: message,
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: '是的,删除!'
        }).then((result)=>{
            if(result.value){
                if(aaa){
                    aaa();
                }
            }
        })
    }
}