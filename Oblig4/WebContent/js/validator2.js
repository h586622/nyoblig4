"use strict";

class validator2 {
    constructor(root){
        this.root = root;
        this.run = this.run.bind(this);
        this.rootElement = document.getElementById(this.root);
    }
    
    run(){
         
         root.querySelector("form")
         
         this.fornavn = this.rootElement.querySelector('input[id="fornavn"]');
         this.fornavn.addEventListener("input", fornavnSjekk);
         
         this.etternavn = this.rootElement.querySelector('input[id="etternavn"]');
         this.etternavn.addEventListener("input", etternavnSjekk);
           
         this.mobil = this.rootElement.querySelector('input[id="mobil"]');
         this.mobil.addEventListener("input", mobilSjekk);
             
         this.passord = this.rootElement.querySelector('input[id="passord"]');
         this.passord.addEventListener("input", passordSjekk);
             
         this.passordRepetert = this.rootElement.querySelector('input[id="passordRepetert"]');
         this.fornavn.addEventListener("input", passordLikt); 
    }
}


function fornavnSjekk(){
    if (fornavn.value.match("^[A-ZÆØÅ][A-Za-zÆØÅæøå\\-]{2,19}$")){
        fornavn.style.borderColor = "green"
        fornavn.classList.remove("formcontroller_invalidInput")
        fornavn.classList.add("formcontroller_validInput")
        }
        else{
         fornavn.style.borderColor = "red"  
          fornavn.classList.remove("formcontroller_validInput")
         fornavn.classList.add("formcontroller_invalidInput")
         
        }
  
}

function etternavnSjekk(){
    if (etternavn.value.match("^[A-ZÆØÅ][A-Za-zÆØÅæøå\\-]{2,19}$")) {
    etternavn.style.borderColor = "green";}
    else{
        etternavn.style.borderColor = "red"
    }
  
}

function mobilSjekk(){
    if (mobil.value.match("^[\\d]{8}$")) {
    mobil.style.borderColor = "green"
    }else{
        mobil.style.borderColor = "red"
    }
    console.log("mobil");
}

function passordSjekk(){
   if (passord.value.match("^(((?=.*[a-z])(?=.*[A-Z]))|((?=.*[a-z])(?=.*[0-9]))|((?=.*[A-Z])(?=.*[0-9])))(?=.{6,})")) {
    passord.style.borderColor = "green"
    passord.style.backgroundColor= "lightgreen"
    }else{
      passord.style.borderColor = "red" 
      passord.style.backgroundColor= "pink"
    }
    console.log("passord");
}

function passordLikt(){
   if (passordRepetert.value === passord.value){
    passordRepetert.style.borderColor = "green"
    }else{
        passordRepetert.style.borderColor = "red"
    }
    
}

function musOver(){

     
}

 // const rootElement = document.getElementById("root")
const validator = new validator2("root")

document.addEventListener("DOMContentLoaded", validator.run)

