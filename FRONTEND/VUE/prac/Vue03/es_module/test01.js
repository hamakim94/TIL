import {title, add, sub} from './test01_module2.js'

console.log(title);

const vm = new Vue({
    el : '#app',
    data(){
        return{
            num1 : 0,
            num2 : 0,
            op : '-',
            result : 0,
        }
    },
    methods : {
        doCal(){
            if(this.op === '+'){
                this.result = add(this.num1, this.num2)
            }else(
                this.result = sub(this.num1, this.num2)
            )
        }
    },
    watch:{
        op(val){
            if (val ==='+'){
                this.result = add(this.num1, this.num2)
            } else{
                this.result = sub(this.num1, this.num2)
            }
        }
    }
});