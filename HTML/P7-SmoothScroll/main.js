// Option 2 - jQuery Smooth Scrolling

/*This is grabbing the navabr link elements
This returns a clalback which takes in an event
we want ot check if there is a hash (the section of the page)
We then prevent the default behaviour from occuring
We then set the hash value into a variable
Then target hr body and call the animate method
This takes an object one of the properties we can use 
is the scroll top and take the hash value then call the offset method and scroll form the top
the second parameter is the speed at which the scroll occurs **in ms**
*/
$('.navbar a').on('click', function (e) {
  if (this.hash !== '') {
    e.preventDefault();

    const hash = this.hash;

    $('html, body')
      .animate({
        scrollTop: $(hash).offset().top
      },100);
  }
});
