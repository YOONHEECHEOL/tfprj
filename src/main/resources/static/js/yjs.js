/* 사용자 슬라이더 cli-slider-menu */
// document.addEventListener('DOMContentLoaded', () => {
//   let cliSliderMenu = document.querySelector('#cli-slider-menu')
//   let cliSliderNav = document.querySelector('#cli-slider-nav')
//
//   console.log(cliSliderNav)
//
//   cliSliderNav.addEventListener('click', () => {
//     console.log(event.target)
//   })
// })

let cliSliderMenu = document.querySelector('#cli-slider-menu')
let cliSliderNav = document.querySelector('#cli-slider-nav')
console.log(cliSliderNav)


cliSliderMenu.addEventListener('click', () => {
  cliSliderNav.classList.toggle('active')
})