 var app = new Vue({
    el: "#mainPage",
    data:{
        isHomePage: true,
        isExplorePage: false
    },
    methods:{
        goExplore:function(){
            this.isHomePage = false;
            this.isExplorePage = true;
            console.log(1);
        }
    }

 })