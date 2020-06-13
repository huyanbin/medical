(function ($) {
    $.fn.hsCheckData = function (options) {
        var defaults = {
            isShowCheckBox: false,
            minCheck: 0,
            maxCheck: 0,
            data: null
        };
        var opts = $.extend(defaults, options);
        $(this).addClass("hsCheckData");
        var id = $(this).attr("id");
        $(this).click(function () {
            if ($('#' + id + "_hcd").length > 0) {
                $('#' + id + "_hcd").remove();
                $('#' + id).removeClass('hsCjeckData_check');
                return false;
            }
            $(this).addClass("hsCjeckData_check")
            var mainHtml = "<div id='" + id + "_hcd' class='hcd_main_border'>";
            //1、筛选input
            var filterHtml = filterHtmlFun();
            //2、数据列表
            var dataListHtml = dataListHtmlFun();
            //3、确定按钮
            var btnHtml = buttonHtml();
            mainHtml += filterHtml + dataListHtml + btnHtml + "</div>";
            //4、输出选择框
            $("body").append(mainHtml);

            //5、设置悬浮位置和大小、默认值
            var width = $(this).outerWidth();
            var height = $(this).outerHeight();
            var x = $(this).offset().top;
            var y = $(this).offset().left;
            $('#' + id + '_input').css("width", (width - 26));
            $('#' + id + '_hcd').css("width", (width - 12))
                .css("left", y)
                .css("top", (x + height));
            //判断是否存在已经选择的
            setCheckData();
            //6、绑定事件
            $('.exsitChild').click(function () {
                if ($(this).parent().nextAll("ul").is(":hidden")) {
                    $(this).addClass("exsitChild_check");
                } else {
                    $(this).removeClass("exsitChild_check");
                }
                $(this).parent().nextAll("ul").toggle();
                return false;
            });
            $("[name='dataliCheck']").click(function (e) {
                e.stopPropagation();
            });
            $("[name='childcheckbox']").click(function (e) {
                e.stopPropagation();
            });
            $("[name='datali']>div").click(function () {

                if (!opts.isShowCheckBox) {
                    $('.hcd_dataList :checkbox').prop("checked", false);
                    $(this).children('input[type="checkbox"]').prop("checked", true);
                    var data_id = "";
                    var data_value = "";
                    data_id = $(this).children('input[type="checkbox"]').val();
                    data_value = $(this).children('input[type="checkbox"]').nextAll("span").text();
                    $('#' + id).attr('data-id', data_id).text(data_value);
                    $('#' + id + "_hcd").remove();
                    $('#' + id).removeClass('hsCjeckData_check');
                } else {
                    if ($(this).children('input[type="checkbox"]').is(":checked")) {
                        $(this).children('input[type="checkbox"]').prop("checked", false);
                    } else {
                        $(this).children('input[type="checkbox"]').prop("checked", true);
                    }
                }
                return false;
            });
            if (!opts.isShowCheckBox) {
                $('#' + id + '_btn').hide();
            } else {
                $("#" + id + "_btn").click(function () {
                    var data_id = "";
                    var data_value = "";

                    $('#' + id + '_hcd').find('input[type="checkbox"]').each(function (index, element) {
                        if ($(this).prop("checked")) {
                            data_id += $(this).val() + "-";
                            data_value += $(this).nextAll("span").text() + ",";
                        }
                    });
                    data_id = data_id.substr(0, data_id.length - 1);
                    data_value = data_value.substr(0, data_value.length - 1);
                    if (data_id.split('-').length < opts.minCheck && opts.minCheck != 0) {
                        alert("至少选择 " + opts.minCheck + " 个选项")
                        return false;
                    }
                    if (data_id.split('-').length > opts.maxCheck && opts.maxCheck != 0) {
                        alert("最多选择 " + opts.maxCheck + " 个选项")
                        return false;
                    }

                    $('#' + id).attr('data-id', data_id).text(data_value);
                    $('#' + id + "_hcd").remove();
                    $('#' + id).removeClass('hsCjeckData_check');
                });
            }
            //筛选
            $('#' + id + '_input').keyup(function () {
                if ($(this).val() != "") {
                    var filterHtml = "<ul>";
                    var getFilterHtml = getFilterHtmlFun($(this).val());
                    filterHtml += getFilterHtml + "</ul>";
                    $('#' + id + "_hcd").children(".hcd_dataList").html(filterHtml);
                    $("[name='childcheckbox']").click(function (e) {
                        e.stopPropagation();
                    });
                    $("[name='datali']>div").click(function () {
                        if (!opts.isShowCheckBox) {
                            $('.hcd_dataList :checkbox').prop("checked", false);
                            $(this).children('input[type="checkbox"]').prop("checked", true);
                            var data_id = "";
                            var data_value = "";
                            data_id = $(this).children('input[type="checkbox"]').val();
                            data_value = $(this).children('input[type="checkbox"]').nextAll("span").text();
                            $('#' + id).attr('data-id', data_id).text(data_value);
                            $('#' + id + "_hcd").remove();
                            $('#' + id).removeClass('hsCjeckData_check');
                        } else {
                            if ($(this).children('input[type="checkbox"]').is(":checked")) {
                                $(this).children('input[type="checkbox"]').prop("checked", false);
                            } else {
                                $(this).children('input[type="checkbox"]').prop("checked", true);
                            }
                        }
                        return false;
                    });
                    setCheckData();
                } else {
                    $('#' + id + "_hcd").children(".hcd_dataList").html(dataListHtmlFun());
                    setCheckData();
                }
            });
            return false;
        });
        setShowData();
        //点击空白选择框消失
        $(document).click(function (e) {
            var clickEle = $(e.target).attr('id');
            var clickName = $(e.target).attr('name');
            if (clickEle == id + "_input" || clickEle == id + "_hcd" || clickName == 'datali') {
                return false;
            }
            $('#' + id + "_hcd").remove();
            $('#' + id).removeClass('hsCjeckData_check');
        });
        //筛选input
        function filterHtmlFun() {
            var html = "<div class='hcd_filter'>";
            html += "<input type='text' id='" + id + "_input' class='hcd_filter_input'/>";
            html += "</div>";
            return html;
        }
        //数据列表
        function dataListHtmlFun() {
            var html = "<div class='hcd_dataList'>"
            //1、解析json数据
            var data = getDataHtml();
            html += data + "</div>"
            return html;
        }
        //绑定默认值
        function setCheckData() {
            if ($('#' + id).attr("data-id") != undefined && $('#' + id).attr("data-id") != "") {
                var data_id = $('#' + id).attr("data-id");
                var dataidArray = data_id.split('-');
                for (var i = 0; i < dataidArray.length; i++) {
                    $('#' + id + "_hcd")
                        .find('.hcd_dataList input[value="' + dataidArray[i] + '"]')
                        .prop("checked", true);
                }
            }
        }
        //设置显示默认值
        function setShowData() {
            if ($('#' + id).attr("data-id") != undefined && $('#' + id).attr("data-id") != "") {
                var data_id = $('#' + id).attr("data-id");
                var dataidArray = data_id.split('-');
                var text = "";
                for (var i = 0; i < dataidArray.length; i++) {
                    text += getName(opts.data, dataidArray[i]) + ",";
                }
                $('#' + id).text(text.substr(0, text.length - 1));
            }
        }
        //获取名称
        function getName(json, jsonId) {
            for (var i = 0; i < json.length; i++) {
                for (var key in json[i]) {
                    if (key == jsonId) {
                        
                        return json[i][key];
                    } else if (jsonId.indexOf(key) > -1) {
                        return getName(json[i]["childCity"], jsonId);
                    }
                }
            }
        }
        //解析Json并生成html
        function getDataHtml() {
            var html = "<ul>"
            var childIsNUll = true;
            for (var i = 0; i < opts.data.length; i++) {
                if ("childCity" in opts.data[i]) {
                    childIsNUll = false;
                }
                for (var key in opts.data[i]) {
                    if (opts.data[i][key].toString().indexOf("object") == -1) {
                        if (childIsNUll == false) {
                            html += "<li class='ec' name='datali'><div><a class='exsitChild'></a>";
                            if (opts.isShowCheckBox) {
                                html += "<input type='checkbox' name='dataliCheck' value='" + key + "'/>";
                            } else {
                                html += "<input type='checkbox' style='display:none' name='dataliCheck' value='" + key + "'/>";
                            }
                            html += "<span>" + opts.data[i][key] + "</span></div > ";
                            childIsNUll = true
                        } else {
                            html += "<li  name='datali'><div>";
                            if (opts.isShowCheckBox) {
                                html += "<input type='checkbox' name='dataliCheck' value='" + key + "'/>";
                            } else {
                                html += "<input type='checkbox' style='display:none' name='dataliCheck' value='" + key + "'/>";
                            }
                            html += "<span>" + opts.data[i][key] + "</span>";
                            html += "</div></li>"
                        }
                    } else {
                        html += childDataHtml(opts.data[i][key]);
                        html += "</li>"
                    }

                }
            }
            html += "</ul>";
            return html;
        }
        //解析子项
        function childDataHtml(json) {
            var html = "<ul style='display:none;padding-left:20px;'>";
            for (var i = 0; i < json.length; i++) {
                for (var key in json[i]) {
                    html += "<li name='datali'><div>";
                    if (opts.isShowCheckBox) {
                        html += "<input name='childcheckbox' type='checkbox' value='" + key + "'/>";
                    } else {
                        html += "<input name='childcheckbox' style='display:none' type='checkbox' value='" + key + "'/>";
                    }
                    html += "<span>" + json[i][key] + "</span></div ></li > ";
                }
            }
            return html + "</ul>";
        }
        function buttonHtml() {
            var html = "<div class='hcd_btn_div'>";
            html += "<button type='button' id='" + id + "_btn' class='hcd_btn'>确定</button>";
            html += "</div>";
            return html;
        }
        //过滤父项目
        function getFilterHtmlFun(filterInput) {
            var html = "";
            for (var i = 0; i < opts.data.length; i++) {
                for (var key in opts.data[i]) {
                    if (opts.data[i][key].indexOf(filterInput) > -1) {
                        html += "<li name='datali'><div>";
                        if (opts.isShowCheckBox) {
                            html += "<input name='childcheckbox' type='checkbox' value='" + key + "'/>";
                        } else {
                            html += "<input name='childcheckbox' style='display:none' type='checkbox' value='" + key + "'/>";
                        }
                        html += "<span>" + opts.data[i][key] + "</span></div ></li > ";
                    } else {
                        html += getChildFilterHtmlFun(opts.data[i][key], filterInput);
                    }
                }
            }
            return html;
        }
        function getChildFilterHtmlFun(json, filterInput) {
            var html = "";
            for (var i = 0; i < json.length; i++) {
                for (var key in json[i]) {
                    if (json[i][key].indexOf(filterInput) > -1) {
                        html += "<li name='datali'><div>";
                        if (opts.isShowCheckBox) {
                            html += "<input name= 'childcheckbox' name= 'dataliCheck' type= 'checkbox' value= '" + key + "' />";
                        } else {
                            html += "<input name= 'childcheckbox' name= 'dataliCheck' style='display:none' type= 'checkbox' value= '" + key + "' />";
                        }
                        html += "<span>" + json[i][key] + "</span></div ></li > ";
                    }
                }
            }
            return html;
        }
    };
})(jQuery);