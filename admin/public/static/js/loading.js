loading = {
    show: function () {
        $.blockUI({
            message: '<img src="/static/images/loading.gif" />',
            css: {
                zIndex: "10011",
                padding: "32px",
                left: "50%",
                width: "100px",
                marginLeft: "-40px",
            }
        });

    },
    hide: function () {
        //本地查询速度过快,加入等待时间做个延迟方便展现
        setTimeout(function () {
            $.unblockUI();
        },500)
    }
};