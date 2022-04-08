var app = new Vue({
    el: "#explorerPage",
    data: {
        url: "#",
        title: "Project",
        content: "Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Craspurus odio.",
        imgSrc: "../assets/logo.png"
    },
    methods: {
        redirect:function(){
            this.url = "#";
            console.log(1);
        }
    }
})