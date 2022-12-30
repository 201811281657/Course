<template>
    <div class="pagination" role="group" aria-lable="分页">
        <button type="button"  class="btn btn-default btn-white btn-round"
        v-bind:disabled="page===1"
        v-on:click="selectPage(1)">
            1
        </button>
        <button type="button" class="btn btn-default btn-white btn-round"
                v-bind:disabled="page===1"
                v-on:click="selectPage(page-1)">
            上一页
        </button>
        <button v-for="p in pages" v-bind:id="'page-'+p"
                type="button" class="btn btn-default btn-white btn-round"
                v-bind:class="{'btn-primary active': page==p}"
                v-on:click="selectPage(p)">
            {{p}}
        </button>
        <button type="button" class="btn btn-default btn-white btn-round"
                v-bind:disabled="page===1"
                v-on:click="selectPage(page+1)">
            下一页
        </button>

        <button type="button" class="btn btn-default btn-white btn-round"
                v-bind:disabled="page===pageTotal"
                v-on:click="selectPage(pageTotal)">
            {{pageTotal||1}}
        </button>

        <span class="m--padding-10">
            每页
            <select v-model="size">
                <option value="1">1</option>
                <option value="5">5</option>
                <option value="10">10</option>
                <option value="20">20</option>
                <option value="30">30</option>
            </select>
            条,共[{{total}}]条
        </span>
    </div>
</template>

<script>
    export default {
        name: 'pagination',
        props: {
            list: {
                type: Function,
                default: null
            },
            itemCount: Number//显示的页码数,比如总共有100页,只显示10条,其他用省略号表示
        },
        data: function () {
            return {
                total: 0,//总行数
                size: 10,//每条页数
                page: 0,//当前页码
                pageTotal: 0,//总页数
                pages: [],//显示的页码数组
            }
        },
        methods: {
            /**
             * 渲染分页组件
             */
            render(page,total){
                let _this = this;
                _this.page = page;
                _this.total = total;
                _this.pageTotal = Math.ceil(total/_this.size);
                _this.pages = _this.getPageItems(_this.pageTotal,page,_this.itemCount||5);
            },
            /**
             * 查询上一页
             */
            selectPage(page){
                let _this = this;
                if(page <1){
                    page = 1;
                }
                if(page > _this.pageTotal){
                    page == _this.pageTotal;
                }
                if(this.page !== page){
                    _this.page = page;
                    if(_this.list){
                        _this.list(page);
                    }
                }
            },
            /**
             * 当前要显示在页面上的页码
             */
            getPageItems(total,current,length){
                let items = [];
                if(length >= total){
                    for(let i = 1;i<= total;i++){
                        items.push(i);
                    }
                }else{
                    let base = 0;
                    //前移
                    if(current-0>Math.floor((length-1)/2)){
                        //后移
                        base = Math.min(total,current-0+Math.ceil((length-1)/2))-length;
                    }
                    for(let i = 1;i<= length; i++){
                        items.push(base+i);
                    }
                }
                return items;
            }
        }
    }
</script>