//引入superagent用来发送http请求
 const superagent = require('superagent');
function getDate(){
    return new Promise((resolve => {
        //现在的时间
        const today = new Date();
        //认识的时间
        const meet = new Date("2018-06-28");
        //相识的天数
        const count = Math.ceil(today-meet);//这个是向上取整 向下取整fool
        //格式化今天的日期
        const format = today.getFullYear()+' / '+today.getMonth()+1+' / '+today.getDate();
        const dayDate = {count,format};
        console.log(dayDate);
    }))
}
getDate();

function getMojiData(){
        superagent('https://tez.dingdongzhh.net/apen/ROE-064/240/ts/ROE-064-16.ts?sign=ebf7db2183bd512c669b4a038d741f83&t=1652054492').end((err,res)=>{
            if(err) return console.log("数据请求失败");
            return console.log(res);
        })

}

getMojiData();
