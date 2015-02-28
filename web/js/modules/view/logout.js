define(function(require, exports, module) {
    $(document).ready(function () {
        $('#logoutAction').off('click').on('click',function(){
            document.location.href='/common/authorize/logout';
        });
    });
});
