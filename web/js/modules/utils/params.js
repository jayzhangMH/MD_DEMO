/**
 * Created by wangjia on 14-11-11.
 */
define(function (require, exports, module) {

    exports.formDataAsParams = function (element) {
        var data = $(element).serialize();
        var params = {};
        if (data) {
            var arrays = decodeURIComponent(data).split("&");
            for (var i = 0; i < arrays.length; i++) {
                var key = arrays[i].split('=')[0];
                var value = arrays[i].split('=')[1];
                if (value) {
                    var oldVal = params[key];
                    if (oldVal) {
                        params[key] = oldVal + ',' + value;
                    } else {
                        params[key] = value;
                    }
                }
            }
        }
        return params;
    };
    exports.refreshToken = function (callbackAction) {
        $.ajax({
            type: 'POST',
            url: '/common/common/refreshTokenId',
            dataType: 'json',
            async:false,
            success: function (jsonData) {
                if (jsonData) {
                    if (jsonData['result'] == '0') {
                        var token = 'org\\.guiceside\\.web\\.jsp\\.taglib\\.Token';
                        var tokenId = jsonData['tokenId'];
                        $('#' + token).val(tokenId);
                        if (callbackAction && typeof  callbackAction == 'function') {
                            callbackAction(tokenId);
                        }
                    }
                }
            },
            error: function (jsonData) {
            }
        });
    };
});