 var app = new Vue({
    el: "#mainPage",
    data:{
        isHomePage: true,
        isExplorePage: false,
        isContentPage: false
    },
    methods:{
        goExplore:function(){
            this.isHomePage = false;
            this.isExplorePage = true;
            this.isContentPage = false;
        },
        showAboutUs:function(){
            this.isHomePage = true;
            this.isExplorePage = false;
            this.isContentPage = false;
        },
        goContent:function(){
            this.isContentPage = true;
            this.isHomePage = false;
            this.isExplorePage = false;
        }
    }
 })
