(function ($) {

    // 검색 결과 vue object
    var search_result = new Vue({
        el: '#search-result',
        data: {
            search_result : {}
        },
        method: {
            Button: function (event) {
                console.log("add");
            }
        }
    });


    // search
    $("#searchButton").click(function () {
        const username = $("#searchBox").val();
        $.get(`/api/search?username=${username}`, function (response) {
            search_result.search_result = response;
            $('#search-result').attr('style','visible');
            console.log(search_result.search_result);
        });
    });

    // Enter
    $("#searchBox").keydown(function(key) {
        if (key.keyCode === 13) {
            const username = $("#searchBox").val();
            $.get(`/api/search?username=${username}`, function (response) {
                search_result.search_result = response;
                $('#search-result').attr('style','visible');
            });
        }
    });

    $(document).ready(function () {
        console.log("init")
    });

})(jQuery);