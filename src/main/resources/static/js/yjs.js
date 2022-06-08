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
          font-size: 3.6rem;
          position: absolute;
          color: #3765C7;
          bottom: 4.8rem;
          left: 0;
          margin: 0;
          display: inline-block;
          animation: appear2 .8s forwards;
      }
      .h1__box {
          position: relative;
          height: 12rem;
      }
      .h1__box > div > span {
          font-family: "esB";
          position: absolute;
          bottom: -4.8rem;
          font-size: 3.8rem;
          color: #fff;
          animation: appear .8s forwards;
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
        @keyframes appear {
            0% {
                bottom: -4.8rem;
            }
            100% {
                bottom: -1.6rem;
            }
        }
        @keyframes appear2 {
            0% {
                bottom: 4.8rem;
            }
            100% {
                bottom: .4rem;
            }
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

        const shadow = this.attachShadow({mode: "open"})

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
          position: relative;
          padding: 0.4rem 0 0 1.2rem;
          margin: 0;
          display: inline-block;
          color: #222;
      }
      .h2__box {
          padding: 1.2rem 0 .8rem;
      }
      h2.h2::before {
          content: '';
          display: block;
          position: absolute;
          top: 0;
          right: 0;
          width: 0%;
          height: .1rem;
          background-color: #222;
          animation: line 1s forwards ease;
      }
      h2.h2::after {
          content: '';
          display: block;
          position: absolute;
          top: -.4rem;
          left: 100%;
          width: 1rem;
          height: 1rem;
          border-radius: 12rem;
          background-color: #222;
          animation: dot 1s forwards ease;
      }
      @keyframes dot {
            0% {
                left: 100%;
                top: -.4rem;
            }
            100% {
                left: 0;
                top: -.4rem;
            }
        }
      @keyframes line {
            0% {
                width:0%;
            }
            100% {
                width: 100%;
            }
        }
    `;

        shadow.append(style, box)
    }
}

// 공통 코드 뽑기
class convertCommonCode extends HTMLElement {
    connectedCallback() {
        let out = this.shadowRoot;
        let tagCheck = this.getAttribute('tagname')

        if (tagCheck == undefined) {
            tagCheck = 'span';
        }

        // console.log(tagCheck)

        function convertCode(data) {
            fetch('http://localhost:18000/convertCommonCode?code=' + data, {
                method: 'get'
            })
                .then(res => res.json())
                .then(res => {
                    // 출력
                    // out.innerText = res.codeValue;

                    let tag = document.createElement(tagCheck);
                    tag.setAttribute('class', 'converted');
                    if (tagCheck != 'option') {
                        tag.innerText = res.codeValue;
                    } else {
                        tag.setAttribute('value', res.codeValue);
                        tag.innerText = res.codeValue;
                    }

                    out.append(tag)
                })
        }

        convertCode(this.getAttribute('data').toString())

    }

    constructor() {
        super();

        const shadow = this.attachShadow({mode: 'open'});

    }
}

// 팀원 불러오는 태그
class teamMembers extends HTMLElement {
    connectedCallback() {
        // attribute로 teamId 받기
        let teamId = this.getAttribute('teamId');
        let root = this.shadowRoot;

        function getMemberList(teamId) {
            // memberList 조회
            fetch('/cli/selectTeamMembers?teamId=' + teamId)
                .then(res => res.json())
                .then(res => {
                    let ul = document.createElement('ul')
                    ul.setAttribute('id', 'et')
                    console.log(res)
                    res.forEach(res => {
                        let output = document.createElement('li');
                        let memberId = document.createElement('div')
                        memberId.innerText = res.memberId;

                        output.append(memberId);
                        ul.append(output);

                    })

                    root.append(ul);

                })
        }

        getMemberList(teamId);


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

// 팀원 수 불러오는 태그
class teamMembersCnt extends HTMLElement {
    connectedCallback() {
        // attribute로 teamId 받기
        let teamId = this.getAttribute('teamId');
        let root = this.shadowRoot;

        function getMemberList(teamId) {
            // memberList 조회
            fetch('/cli/selectTeamMembers?teamId=' + teamId)
                .then(res => res.json())
                .then(res => {
                    let cnt = document.createElement('span');
                    let memberCount = 0;
                    res.forEach(res => {
                        memberCount += 1;
                    })

                    cnt.innerText = memberCount;
                    root.append(cnt);
                })
        }

        getMemberList(teamId);
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

// team info 불러오는 tag
class teamInfo extends HTMLElement {

    connectedCallback() {

        // attribute로 teamId 받기
        let teamId = this.getAttribute('teamId');
        let leagueId = this.getAttribute('leagueId');
        let root = this.shadowRoot;

        const getLeagueApplyTeam = (teamId) => {
            fetch('/adm/getLeagueApplyTeam', {
                method: 'post',
                headers: {'Content-type': 'application/json'},
                body: JSON.stringify({
                    teamId: teamId,
                    leagueId: leagueId
                })
            })
                .then(res => res.json())
                .then(res => {
                    console.log(res)
                    let cnt = 1;
                    res.leagueApplyTeam.forEach(t => {
                        let div = document.createElement('div')
                        div.innerHTML = `
              <div class="info">
                <input type="hidden" value="${t.teamId}">                              
                <input type="hidden" value="${t.isApprove}">
                <span>${cnt}</span>
                <span>[${t.teamName}]</span>
                <span>팀장 : ${t.leader}</span>
                <span>팀원 수 : <team-members-cnt teamId="${t.teamId}"></team-members-cnt></span>                           
                <convert-c-code data="${t.isApprove}"></convert-c-code>                       
              </div>
            `
                        cnt++;
                        root.append(div)
                    })
                })
        }
        getLeagueApplyTeam(teamId);

    }

    constructor() {
        super();

        const shadow = this.attachShadow({mode: 'open'});

        let style = document.createElement('style');
        style.innerHTML = `
      span {
        font-family: "esL";
        font-size: 1.8rem;
        color: #222;
        line-height: 3.2rem; 
      }
      team-members-cnt {
        font-family: "esM";
        font-size: 1.8rem;
        color: #222;
      }
      .info {
        display: flex;
        justify-content: space-around;
        pointer-events: none;
      }
      convert-c-code {
        font-family: "esM";
        font-size: 1.8rem;
        color: #222;
      }
    `

        shadow.append(style)
    }

}

// team info 불러오는 tag
class teamApproveInfo extends HTMLElement {

    connectedCallback() {

        // attribute로 teamId 받기
        let teamId = this.getAttribute('teamId');
        let leagueId = this.getAttribute('leagueId');
        let root = this.shadowRoot;

        const getLeagueApplyTeam = (teamId) => {
            fetch('/adm/getLeagueApplyTeam', {
                method: 'post',
                headers: {'Content-type': 'application/json'},
                body: JSON.stringify({
                    teamId: teamId,
                    leagueId: leagueId
                })
            })
                .then(res => res.json())
                .then(res => {
                    console.log(res)
                    let cnt = 1;
                    res.leagueApplyApproveTeam.forEach(t => {
                        let div = document.createElement('div')
                        div.innerHTML = `
              <div class="info">
                <input type="hidden" value="${t.teamId}">                              
                <input type="hidden" value="${t.isApprove}">
                <span>${cnt}</span>
                <span>[${t.teamName}]</span>
                <span>팀장 : ${t.leader}</span>
                <span>팀원 수 : <team-members-cnt teamId="${t.teamId}"></team-members-cnt></span>                           
                <convert-c-code data="${t.isApprove}"></convert-c-code>                       
              </div>
            `
                        cnt++;
                        root.append(div)
                    })
                })
        }
        getLeagueApplyTeam(teamId);

    }

    constructor() {
        super();

        const shadow = this.attachShadow({mode: 'open'});

        let style = document.createElement('style');
        style.innerHTML = `
      span {
        font-family: "esL";
        font-size: 1.8rem;
        color: #222;
        line-height: 3.2rem; 
      }
      team-members-cnt {
        font-family: "esM";
        font-size: 1.8rem;
        color: #222;
      }
      .info {
        display: flex;
        justify-content: space-around;
        pointer-events: none;
      }
      convert-c-code {
        font-family: "esM";
        font-size: 1.8rem;
        color: #222;
      }
    `

        shadow.append(style)
    }

}


customElements.define('t-h1', tH1)
customElements.define('t-h2', tH2)
customElements.define('convert-c-code', convertCommonCode)
customElements.define('team-members', teamMembers)
customElements.define('team-members-cnt', teamMembersCnt)
customElements.define('team-info', teamInfo)
customElements.define('team-info-approve', teamApproveInfo)


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
          color: #222;
          bottom: 0;
          left: 1rem;
          padding: 2rem 0 0;
          margin: 0;
          display: inline-block;
          animation: appear2 1s forwards ease;
      }
      .h1__box {
          position: relative;
          height: 12rem;
      }
      .h1__box > div > span {
          font-family: "esB";
          position: absolute;
          top: 6rem;
          left: 1rem;
          font-size: 4.4rem;
          color: #fff;
          animation: appear 1s forwards ease;
      }
      .h1__box > div {
          width: 100%;
          height: 6rem;
          background: #222;
      }
      .h1__box > img {
          position: absolute;
          top: 0;
          right: 0;
      }
      @keyframes appear {
            0% {
                top: 6rem;
            }
            100% {
                top: 1.2rem;
            }
        }
        @keyframes appear2 {
            0% {
                bottom: 4.8rem;
            }
            100% {
                bottom: .4rem;
            }
        }
    `;

        shadow.append(style, h1Box);


    }
}

// h2 custrom tag
class aH2 extends HTMLElement {
    connectedCallback() {
        let tit = this.shadowRoot.querySelector('#tit');
        tit.innerText = this.getAttribute('ko');

    }

    constructor() {
        super();

        const shadow = this.attachShadow({mode: "open"})

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
          font-weight: 400;
          font-size: 2.2rem;
          position: relative;
          padding: 0.4rem 0 0 1.2rem;
          margin: 0;
          display: inline-block;
          color: #fff;
      }
      .h2__box {
          padding: 1.2rem 0 .8rem;
      }
      h2.h2::before {
          content: '';
          display: block;
          position: absolute;
          top: 0;
          right: 0;
          width: 0%;
          height: .1rem;
          background-color: #fff;
          animation: line 1s forwards ease;
      }
      h2.h2::after {
          content: '';
          display: block;
          position: absolute;
          top: -.4rem;
          left: 100%;
          width: 1rem;
          height: 1rem;
          border-radius: 12rem;
          background-color: #fff;
          animation: dot 1s forwards ease;
      }
      @keyframes dot {
            0% {
                left: 100%;
                top: -.4rem;
            }
            100% {
                left: 0;
                top: -.4rem;
            }
        }
      @keyframes line {
            0% {
                width:0%;
            }
            100% {
                width: 100%;
            }
        }
    `;

        shadow.append(style, box)
    }
}

customElements.define('a-h1', aH1)
customElements.define('a-h2', aH2)

