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
          font-size: 4.4rem;
          color: #fff;
      }
      .h1__box > div {
          height: 6rem;
          width: calc(100% + 4%);
          padding: 0 2%;
          transform: translate(-2%, 0);
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

// 공통 코드 뽑기
class convertCommonCode extends HTMLElement {
  connectedCallback() {
    let out = this.shadowRoot.querySelector('.converted');

    function convertCode(data) {
      fetch('http://localhost:18000/convertCommonCode?code=' + data, {
          method: 'get'
      })
        .then(res => res.json())
        .then(res => {
          // 출력
          out.innerText = res.codeValue;
        })
    }

    console.log(this.getAttribute('data'))
    convertCode(this.getAttribute('data').toString())

  }

  constructor() {
    super();

    const shadow = this.attachShadow({mode:'open'});

    let span = document.createElement('span');
    span.setAttribute('class', 'converted');

    shadow.append(span);
  }
}

// 팀원 불러오는 태그
class teamMembers extends HTMLElement {
  connectedCallback() {
    // attribute로 teamId 받기
    let teamId = this.getAttribute('teamId');
    let doFnc = this.getAttribute('do');

    let root = this.shadowRoot;

    function getMemberList(teamId, doFnc) {
      // memberList 조회
      fetch('/cli/selectTeamMembers?teamId=' + teamId)
        .then(res => res.json())
        .then(res => {
          let ul = document.createElement('ul')
          ul.setAttribute('id', 'et')

          res.forEach(res => {

            let output = document.createElement('li');
            let inner = document.createElement('div')
            inner.innerText = res.memberId;
            output.append(inner);
            ul.append(output);

          })

          root.append(ul);



          let eventTarget = root.getElementById('et');
          eventTarget.addEventListener('click', (r) => {
            console.log(r.composedPath()[0].innerText)
            // doFnc(r.composedPath()[0].innerText)
            // return r.composedPath()[0].innerText;
          })
        })
    }

    getMemberList(teamId, doFnc);


    // eventTarget.addEventListener('click', () => {
    //   console.log(event.target)
    // })
  }

  constructor() {
    super();

    const shadow = this.attachShadow({mode: 'open'});

    let style = document.createElement('style')
    style.innerText = `
      ul {
          list-style: none;
          padding: 0;
          margin: 0;
      }
      li * {
        font-family: "esM";
        font-size: 1.8rem;
      }
    `

    shadow.append(style)

  }
}


customElements.define('t-h1',tH1)
customElements.define('t-h2',tH2)
customElements.define('convert-c-code',convertCommonCode)
customElements.define('team-members', teamMembers)



// Admin 관리자

class aH1 extends HTMLElement {
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
          left: 2rem;
          padding: 2rem 0 0;
          margin: 0;
          display: inline-block;
      }
      .h1__box {
          position: relative;
          height: 12rem;
          overflow: hidden;
      }
      .h1__box > div > span {
          font-family: "esB";
          position: absolute;
          bottom: 4.2rem;
          left: 2rem;
          font-size: 4.4rem;
          color: #fff;
      }
      .h1__box > div {
          height: 6rem;
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

customElements.define('a-h1',aH1)

