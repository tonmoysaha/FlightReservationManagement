(function ( $ ) { 
	"use strict"; // Start of use strict

	// Smooth scrolling using jQuery easing
	$('a.js-scroll-trigger[href*="#"]:not([href="#"])').click(
			function() {
				if (location.pathname.replace(/^\//, '') == this.pathname
						.replace(/^\//, '')
						&& location.hostname == this.hostname) {
					var target = $(this.hash);
					target = target.length ? target : $('[name='
							+ this.hash.slice(1) + ']');
					if (target.length) {
						$('html, body').animate({
							scrollTop : (target.offset().top - 56)
						}, 1000, "easeInOutExpo");
						return false;
					}
				}
			});

	// Closes responsive menu when a scroll trigger link is clicked
	$('.js-scroll-trigger').click(function() {
		$('.navbar-collapse').collapse('hide');
	});

	// Activate scrollspy to add active class to navbar items on scroll
	$('body').scrollspy({
		target : '#mainNav',
		offset : 56
	});

}( jQuery ));



$(document).ready(function(){
	$("#formvalidate").validate({
		rules: {
			email: {
				required: true,
				email: true
			},
			password: "required",
				   confirmPassword: {
						required: true,
						equalTo: "#password"
						
					},
					
					
		},
		messages: {
			email: {
				required: "please enter your email",
				email: "please enter a valid email address"
			},
			
			password: "please enter your password",
			
			confirmPassword: {
				required: "please Confirm Password",
				equalTo: "Confirm Password does not match"
			},

		}
	});
	
});
