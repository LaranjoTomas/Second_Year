function loadSearchData() {
    const games = [
        { name: "Overwatch 2", icon: "./images/games/logos/overwatch-logo.png", href: "./page/game/overwatch2.html" },
        { name: "League of Legends", icon: "./images/games/logos/LoL_icon.svg.png", href: "./page/game/lol.html" },
        { name: "Counter-Strike 2", icon: "./images/games/logos/cs2.png", href: "./page/game/cs2.html" },
        { name: "Propnight", icon: "./images/games/logos/propnight_icon.jpg", href: "./page/game/propnight.html" },
        { name: "Among Us", icon: "./images/games/logos/Among-Us-Logo.png", href: "./page/game/sus.html" },
        { name: "F1 22", icon: "./images/games/logos/f1-logo.png", href: "./page/game/f1_22.html" },
        { name: "DayZ", icon: "./images/games/logos/dayz.png", href: "./page/game/dayz.html" },
    ]

    const list = document.getElementById('lista');
    games.forEach(game => {
        const a = document.createElement('a');
        a.innerHTML = `<img class="listItemImage" src="${game.icon}" alt="${game.name}"><span class="listItemText">${game.name}</span>`;
        a.href = game.href;
        a.classList.add('listItem');
        list.appendChild(a);
    });
}

function search() {
    const listContainer = document.getElementById('lista');
    const listItems = listContainer.getElementsByClassName('listItem');
    const input = document.getElementById('searchInput').value.toLowerCase();
    let noResults = true;
    for (i = 0; i < listItems.length; i++) { 
        if (!listItems[i].lastChild.innerHTML.toLowerCase().includes(input) || input === "") {
            listItems[i].style.display = "none";
            continue;
        } else {
            listItems[i].style.display = "flex";
            noResults = false; 
        }
    }
    listContainer.style.display = noResults ? "none" : "block";
}

function bodyLoad() {
    loadSearchData();
}