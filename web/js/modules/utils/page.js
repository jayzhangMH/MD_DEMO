define(function (require, exports, module) {
    $(document).ready(function () {
        $('a', '.md-oa-page').each(function () {
            if (!$(this).hasClass('current')&&!$(this).hasClass('disabled')&&!$(this).hasClass('next')&&!$(this).hasClass('prev')) {
                $(this).off('click').on('click', function () {
                    var p = $(this).text();
                    p = parseInt(p);
                    var rows =everyPage;
                    rows = parseInt(rows);
                    var start = p * rows - rows;
                    eval(evalActionJs+'('+start+','+rows+')');
                });
            }
        });
        $('.next', '.md-oa-page').off('click').on('click', function () {
            if (!$(this).hasClass('disabled')) {
                var last=$(this).prev();
                var p = $(last).text();
                p = parseInt(p);
                var rows =everyPage;
                rows = parseInt(rows);
                var start = p * rows;
                eval(evalActionJs+'('+start+','+rows+')');
            }
        });
        $('.prev', '.md-oa-page').off('click').on('click', function () {
            if (!$(this).hasClass('disabled')) {
                var next=$(this).next();
                var p = $(next).text();
                p = parseInt(p);
                p=p-4;
                var rows =everyPage;
                rows = parseInt(rows);
                var start = p * rows- rows;
                eval(evalActionJs+'('+start+','+rows+')');
            }
        });
    });
});