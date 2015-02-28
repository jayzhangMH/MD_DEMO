define(function(require, exports, module) {
    $(document).ready(function () {
        $('#saveAction').off('click').on('click',function(){
            document.editForm.submit();
        });
    });
});
