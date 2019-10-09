$(document).ready(function() {
    $("#formvalidate").validate({
        rules: {
            password: "required",
            newPassword: "required",
            confirmPassword: {
                required: true,
                equalTo: "#newPassword"
            },

        },
        messages: {
            password: "please enter your password",

            confirmpassword: {
                required: "please Confirm Password",
                equalTo: "Confirm Password does not match"
            },

        }
    });
});