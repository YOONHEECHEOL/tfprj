(function($) {
  "use strict"; // Start of use strict

  // Toggle the side navigation
  $("#sidebarToggle, #sidebarToggleTop").on('click', function(e) {
    $("body").toggleClass("sidebar-toggled");
    $(".sidebar").toggleClass("toggled");
    if ($(".sidebar").hasClass("toggled")) {
      $('.sidebar .collapse').collapse('hide');
    };
  });

  // Close any open menu accordions when window is resized below 768px
  $(window).resize(function() {
    if ($(window).width() < 768) {
      $('.sidebar .collapse').collapse('hide');
    };
    
    // Toggle the side navigation when window is resized below 480px
    if ($(window).width() < 480 && !$(".sidebar").hasClass("toggled")) {
      $("body").addClass("sidebar-toggled");
      $(".sidebar").addClass("toggled");
      $('.sidebar .collapse').collapse('hide');
    };
  });

  // Prevent the content wrapper from scrolling when the fixed side navigation hovered over
  $('body.fixed-nav .sidebar').on('mousewheel DOMMouseScroll wheel', function(e) {
    if ($(window).width() > 768) {
      var e0 = e.originalEvent,
        delta = e0.wheelDelta || -e0.detail;
      this.scrollTop += (delta < 0 ? 1 : -1) * 30;
      e.preventDefault();
    }
  });

  // Scroll to top button appear
  $(document).on('scroll', function() {
    var scrollDistance = $(this).scrollTop();
    if (scrollDistance > 100) {
      $('.scroll-to-top').fadeIn();
    } else {
      $('.scroll-to-top').fadeOut();
    }
  });

  // Smooth scrolling using jQuery easing
  $(document).on('click', 'a.scroll-to-top', function(e) {
    var $anchor = $(this);
    $('html, body').stop().animate({
      scrollTop: ($($anchor.attr('href')).offset().top)
    }, 1000, 'easeInOutExpo');
    e.preventDefault();
  });

})(jQuery); // End of use strict


// h1 tag => t-h1 custom element
class tH1 extends HTMLElement {
  connectedCallback() {
    let en = this.shadowRoot.getElementById('enTit');
    let ko = this.shadowRoot.getElementById('koTit');
    en.innerText = this.getAttribute('en');
    ko.innerText = this.getAttribute('ko');
  }

  constructor(params) {
    super();

    const shadow = this.attachShadow({mode: 'open'});

    const h1Box = document.createElement('div')
    h1Box.setAttribute('class', 'h1__box')

    const tBlue = document.createElement('div')
    const tBlueText = document.createElement('span')
    tBlueText.setAttribute('id', 'enTit')
    // tBlueText.innerText = 'LEAGUE';
    tBlue.append(tBlueText);

    const h1 = document.createElement('h1')
    h1.setAttribute('id', 'koTit')
    h1.setAttribute('class', 'h1')

    const img = document.createElement('img')
    img.setAttribute('src', '/images/cli/t1_deco.svg')

    h1Box.append(tBlue, h1, img);

    const style = document.createElement('style')
    style.innerText = `
      h1.h1 {
          font-family: "esB";
          font-size: 4rem;
          position: absolute;
          color: #3765C7;
          bottom: 0;
          left: 0;
          padding: 2rem 0 0;
          margin: 0;
          display: inline-block;
      }
      .h1__box {
          position: relative;
          height: 12rem;
      }
      .h1__box > div > span {
          font-family: "esB";
          position: absolute;
          bottom: -1.8rem;
          left: 2rem;
          font-size: 4.4rem;
          color: #fff;
      }
      .h1__box > div {
          height: 6rem;
          width: calc(100% - 4%);
          padding: 0 2%;
          background: #3765C7;
      }
      .h1__box > img {
          position: absolute;
          top: 0;
          right: 0;
      }
    `;

    shadow.append(style, h1Box);


  }
}

// h2 custrom tag
class tH2 extends HTMLElement {
  connectedCallback() {
    let tit = this.shadowRoot.querySelector('#tit');
    tit.innerText = this.getAttribute('ko');
  }

  constructor() {
    super();

    const shadow = this.attachShadow({mode:"open"})

    const box = document.createElement('div')
    box.setAttribute('class', 'h2__box')

    const h2 = document.createElement('h2')
    h2.setAttribute('class', 'h2')
    h2.setAttribute('id', 'tit')

    box.append(h2)

    const style = document.createElement('style')
    style.innerText = `            
      h2.h2 {
          font-family: 'esM';
          font-size: 2.8rem;
          font-weight: 500;
          position: relative;
          padding: 0.8rem 0 0;
          margin: 0;
          display: inline-block;
      }
      .h2__box {
          padding: 1.2rem 0 .8rem;
      }
      h2.h2::before {
          content: '';
          display: block;
          position: absolute;
          top: 0;
          left: 0;
          width: 100%;
          height: .2rem;
          background-color: #bbb;
      }
    `;

    shadow.append(style, box)
  }
}

customElements.define('t-h1',tH1)
customElements.define('t-h2',tH2)