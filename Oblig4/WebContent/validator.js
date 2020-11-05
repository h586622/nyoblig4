
let passord;
function fornavnSjekk() {
    let fn = document.getElementById("fn");
    let fornavn = document.getElementById("fornavn").value;
    if (fornavn.match("^[A-ZÆØÅ][A-Za-zÆØÅæøå\\-]{2,19}$")){
        fn.innerHTML = "";
        document.getElementById("fornavn").style.borderColor = "green";
    } else {
        fn.innerHTML = "Ugyldig fornavn";
        document.getElementById("fornavn").style.borderColor = "red";
    }
}

function etternavnSjekk() {
    let en = document.getElementById("en");
    let etternavn = document.getElementById("etternavn").value;
    if (etternavn.match("^[A-ZÆØÅ][A-Za-zÆØÅæøå\\-]{2,19}$")) {
        en.innerHTML = "";
        document.getElementById("etternavn").style.borderColor = "green";
    } else {
        en.innerHTML = "Ugyldig etternavn";
        document.getElementById("etternavn").style.borderColor = "red";
    }
}
function mobilSjekk() {
    let mob = document.getElementById("mob");
    let mobil = document.getElementById("mobil").value;
    if (mobil.match("^[\\d]{7}$")) {
        mob.innerHTML = "";
        document.getElementById("mobil").style.borderColor = "green";
    } else {
        mob.innerHTML = "Ugyldig mobilnummer";
        document.getElementById("mobil").style.borderColor = "red";
    }
}
function passordSjekk() {
    let pass = document.getElementById("pass");
    passord = document.getElementById("passord").value;
    if (passord.match("^(((?=.*[a-z])(?=.*[A-Z]))|((?=.*[a-z])(?=.*[0-9]))|((?=.*[A-Z])(?=.*[0-9])))(?=.{6,})")) {
        pass.innerHTML = "";
        document.getElementById("passord").style.borderColor = "green";
    } else {
        pass.innerHTML = "Ugyldig passord";
        document.getElementById("passord").style.borderColor = "red";
    }
}
function passordRepSjekk() {
    let passRep = document.getElementById("passRep");
    let passordRep = document.getElementById("passordRep").value;
    if (passordRep === passord) {
        passRep.innerHTML = "";
        document.getElementById("passordRep").style.borderColor = "green";
    } else {
        passRep.innerHTML = "Passord er ikke likt";
        document.getElementById("passordRep").style.borderColor = "red";
    }
}


function kjonnSjekk(){
    let kjonnboks = document.getElementById("kjonn");
    let kjonn = document.getElementById("kjonn").value;
    if (kjonn.match("")){
        kjonn.innerHTML = "Du må velge kjønn";
    }else{
        kjonn.innerHTML = "";
    }
        
}

function infoBoks(){
    let passordStyrke = "";
}

