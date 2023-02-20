// Add Buddy (POST)
$(document).ready(
    function() {

        $("#registerBuddyForm").submit(function(event) {
            event.preventDefault();
            ajaxPost();
        });

        function ajaxPost() {

            var formData = {
                name : $("#buddyName").val(),
                number : $("#buddyNumber").val()
            }

            $.ajax({
                type : "POST",
                contentType : "application/json",
                url : "/api/v0/addressbook/book1/buddies",
                data : JSON.stringify(formData),
                dataType : 'json'
            }).then(function(data) {
                console.log(data);
            })
        }
    });

// Delete Buddy (DELETE)
$(document).ready(
    function() {

        $("#deleteBuddyForm").submit(function(event) {
            event.preventDefault();
            ajaxPost();
        });

        function ajaxPost() {
            var name = $("#buddyToDelete").val();
            $.ajax({
                type : "DELETE",
                contentType : "application/json",
                url : "/api/v0/addressbook/book1/buddies/" + name,
                dataType : 'json'
            }).then(function(data) {
                console.log(data);
            })
        }
    });