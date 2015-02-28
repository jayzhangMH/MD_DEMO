define(function(require, exports, module) {
    $(document).ready(function () {
        $('#loginAction').off('click').on('click',function(){
            document.editForm.submit();
        });
    });
});
