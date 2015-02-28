define(function (require, exports, module) {
    exports.accDiv = function (arg1, arg2) {
        var t1 = 0, t2 = 0, r1, r2;
        try {
            t1 = arg1.toString().split(".")[1].length
        } catch (e) {
        }
        try {
            t2 = arg2.toString().split(".")[1].length
        } catch (e) {
        }
        with (Math) {
            r1 = Number(arg1.toString().replace(".", ""));
            r2 = Number(arg2.toString().replace(".", ""));
            return (r1 / r2) * pow(10, t2 - t1);
        }
    };
    //说明：javascript的乘法结果会有误差，在两个浮点数相乘的时候会比较明显。这个函数返回较为精确的乘法结果。
    exports.accMul = function (arg1, arg2) {
        var m = 0, s1 = arg1.toString(), s2 = arg2.toString();
        try {
            m += s1.split(".")[1].length
        } catch (e) {
        }
        try {
            m += s2.split(".")[1].length
        } catch (e) {
        }
        return Number(s1.replace(".", "")) * Number(s2.replace(".", "")) / Math.pow(10, m);
    };
    exports.alphabetIndex = function (index) {
        var engMap = new HashMap();
        engMap.put(0, "A");
        engMap.put(1, "B");
        engMap.put(2, "C");
        engMap.put(3, "D");
        engMap.put(4, "E");
        engMap.put(5, "F");
        engMap.put(6, "G");
        engMap.put(7, "H");
        engMap.put(8, "I");
        engMap.put(9, "J");
        engMap.put(10, "K");
        engMap.put(11, "L");
        engMap.put(12, "M");
        engMap.put(13, "N");
        engMap.put(14, "O");
        engMap.put(15, "P");
        engMap.put(16, "Q");
        engMap.put(17, "R");
        engMap.put(18, "S");
        engMap.put(19, "T");
        engMap.put(20, "U");
        engMap.put(21, "V");
        engMap.put(22, "W");
        engMap.put(23, "X");
        engMap.put(24, "Y");
        engMap.put(25, "Z");
        var place;
        var basic = 25;
        var j = 0;
        var t = 0;
        var k = 0;
        var n = 0;
        var e = 0;
        var begin = 0;
        var end = 0;
        if (index > basic) {
            j = index / basic;
            k = j - 1;
            t = j * basic + j;
            if (index >= t) {
                begin = j - 1;
            } else {
                begin = k - 1;
            }
            if (k == 0) {
                k = 1;
            }
            n = j * basic;
            e = index - n;
            if (e >= j) {
                end = e - j;
            } else {
                end = (basic + 1) - (j - e);
            }
            place = engMap.get(begin) + engMap.get(end);
        } else {
            place = engMap.get(index);
        }
        return place;
    };
});