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

    // refresh
    $("#refreshButton").click(function () {
        const userId = $("#userid").val();
        console.log(userId);
        $.get(`/api/search/${userId}`, function (response) {
            search_result.search_result = response;
            $('#search-result').attr('style','visible');
            console.log(search_result.search_result);
        });
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