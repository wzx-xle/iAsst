$(function() {
    my_clock($("#clock_div"));
});

function my_clock(el$) {
    var today = new Date();

    var h = today.getHours();
    var m = today.getMinutes();
    var s = today.getSeconds();

    m = m >= 10 ? m : ('0' + m);
    s = s >= 10 ? s : ('0' + s);

    el$.html(h + ":" + m + ":" + s);

    setTimeout(function() {my_clock(el$)}, 1000);
}