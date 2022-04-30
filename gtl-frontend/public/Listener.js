var orignalSetItem = sessionStorage.setItem;
sessionStorage.setItem = function(key, newValue) {
    var setItemEvent = new Event("setItemEvent");
    setItemEvent.newValue = newValue;
    windown.dispatchEvent(setItemEvent);
    orignalSetItem.apply(this, arguments);
}

var info = sessionStorage.getItem("userAccount");
if(info) {
    console.log(info);
} else {
    window.addEventListener('setItemEvent', function(e){
        if ((e.key = "userAccount")) {
            var _this = sessionStorage.getItem("userAccount");
            if (_this != e.newValue) {
                if (e.newValue) {
                    console.log(e.newValue);
                    console.log(_this);
                }
            }
        }
    });
}