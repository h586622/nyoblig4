"use strict";

class validator2 {
    constructor(root){
        this.root = root;
        this.run = this.run.bind(this);
        this.rootElement = document.getElementById(this.root);
         
         this.fornavn = this.rootElement.querySelector('input[id="fornavn"]');
         this.fornavn.addEventListener("input", fornavnSjekk);
         
         this.etternavn = this.rootElement.querySelector('input[id="etternavn"]');
         this.etternavn.addEventListener("input", etternavnSjekk);
           
         this.mobil = this.rootElement.querySelector('input[id="mobil"]');
         this.mobil.addEventListener("input", mobilSjekk);
             
         this.passord = this.rootElement.querySelector('input[id="passord"]');
         this.passord.addEventListener("input", passordSjekk);
             
         this.passordRepetert = this.rootElement.querySelector('input[id="passordRepetert"]');
         this.passordRepetert.addEventListener("input", passordLikt); 
         
         this.feilmeldingboks = this.rootElement.querySelector('div[id="feilmeldingboks"]');
         this.feilmeldingboks.addEventListener("click", sjekkSkjema);
         
         this.passordInfo = this.rootElement.querySelector('div[id="passordInfo"]');
         this.passord.addEventListener("mouseover", musOver);
         this.passord.addEventListener("mouseout", musUt);
         
         
         
       // this.kjonn = this.rootElement.querySelector('radio[id="kjonn"]');
      //  this.kjonn.addEventListener("click", kjonnSjekk);
         
    }
    
    run(){        
     
        
    }
}


function fornavnSjekk(){
    if (fornavn.value.match("^[A-ZÆØÅ][A-Za-zÆØÅæøå\\-]{2,19}$")){
        
        fornavn.classList.remove("formcontroller_redBorder")
        fornavn.classList.add("formcontroller_greenBorder")
     
        }
        else{
         
          fornavn.classList.remove("formcontroller_greenBorder")
         fornavn.classList.add("formcontroller_redBorder")
     
         
        }
  
}

function etternavnSjekk(){
    if (etternavn.value.match("^[A-ZÆØÅ][A-Za-zÆØÅæøå\\-]{2,19}$")) {
        etternavn.classList.remove("formcontroller_redBorder")
        etternavn.classList.add("formcontroller_greenBorder")  
    }
    else{
         etternavn.classList.remove("formcontroller_greenBorder")
         etternavn.classList.add("formcontroller_redBorder")
    }
  
}

function mobilSjekk(){
    if (mobil.value.match("^[\\d]{8}$")) {
        mobil.classList.remove("formcontroller_redBorder")
        mobil.classList.add("formcontroller_greenBorder")
    }else{
         mobil.classList.remove("formcontroller_greenBorder")
         mobil.classList.add("formcontroller_redBorder")
    }
    console.log("mobil");
}

function passordSjekk(){
   if (passord.value.match("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})")){
        passord.classList.remove("formcontroller_redBorder")
        passord.classList.remove("formcontroller_yellowBorder")
        passord.classList.add("formcontroller_greenBorder")  
    }else if (passord.value.match("^(((?=.*[a-z])(?=.*[A-Z]))|((?=.*[a-z])(?=.*[0-9]))|((?=.*[A-Z])(?=.*[0-9])))(?=.{6,})")) {
        passord.classList.remove("formcontroller_redBorder")
        passord.classList.add("formcontroller_yellowBorder")
 
    }else{
         passord.classList.remove("formcontroller_greenBorder")
         passord.classList.add("formcontroller_redBorder")
    }
}

function passordLikt(){
   if (passordRepetert.value === passord.value){
        passordRepetert.classList.remove("formcontroller_redBorder")
        passordRepetert.classList.add("formcontroller_greenBorder")
    }else{
         passordRepetert.classList.remove("formcontroller_greenBorder")
         passordRepetert.classList.add("formcontroller_redBorder")
    }
    
}

function kjonnSjekk(){
    
}

function musOver(){
     passordInfo.classList.remove("formcontroller_hidden")
     passordInfo.innerHTML = "Passord må inneholde en stor bokstav, ett tall, ett tegn og må være minst 6 tegn"
     console.log("mus inn")
}

function musUt(){
     passordInfo.classList.add("formcontroller_hidden")
     console.log("mus ut")
}

function sjekkSkjema(){
    
     var feilmelding = new String("");
    
    if (!fornavn.value.match("^[A-ZÆØÅ][A-Za-zÆØÅæøå\\-]{2,19}$")){
       feilmelding += "Ugyldig fornavn \n"
    }
    if (!etternavn.value.match("^[A-ZÆØÅ][A-Za-zÆØÅæøå\\-]{2,19}$")){
       feilmelding += "Ugyldig etternavn \n"
    }
    if (!mobil.value.match("^[\\d]{8}$")) {
        feilmelding += "Ugyldig telefonnummer \n"
    }
    if (!passord.value.match("^(((?=.*[a-z])(?=.*[A-Z]))|((?=.*[a-z])(?=.*[0-9]))|((?=.*[A-Z])(?=.*[0-9])))(?=.{6,})")){
        feilmelding += "Ugyldig passord \n"
    }
    if (!passordRepetert.value === passord.value){
        feilmelding += "Passord er ikke likt"
        }
    if (feilmelding.length === 0){
        console.log("submit gokjent")
    }else{
         console.log("stopper submit")
         feilmeldingboks.classList.remove("formcontroller_hidden")
         feilmeldingboks.innerHTML = feilmelding
         event.preventDefault()
    }
}

 // const rootElement = document.getElementById("root")
const validator = new validator2("root")

document.addEventListener("DOMContentLoaded", validator.run)

