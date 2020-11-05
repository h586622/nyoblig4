"use strict";

class validator2 {
    constructor(root){
        this.root = root;
        this.run = this.run.bind(this);
    }
    
    run(){
         this.rootElement = document.getElementById(this.root);
         
         this.fornavn = this.rootElement.querySelector('input[id="fornavn"]');
         this.fornavn.addEventListener("input", this.fornavnSjekk());
         
         this.etternavn = this.rootElement.querySelector('input[id="etternavn"]');
         this.etternavn.addEventListener("input", this.etternavnSjekk());
           
         this.mobil = this.rootElement.querySelector('input[id="mobil"]');
         this.mobil.addEventListener("input", this.mobilSjekk());
             
         this.passord = this.rootElement.querySelector('input[id="passord"]');
         this.passord.addEventListener("input", this.passordSjekk());
             
         this.passordRepetert = this.rootElement.querySelector('input[id="passordRepetert"]');
         this.fornavn.addEventListener("input", this.passordLikt());
    }
}


function fornavnSjekk(){
    if (fornavn.value.match("^[A-ZÆØÅ][A-Za-zÆØÅæøå\\-]{2,19}$")){
        fornavn.style.borderColor = "green"
        }
        else{
         fornavn.style.borderColor = "red"  
         //deltagerForm.fornavnMelding = "feil fornavn"
        }
    console.log("fornavn");
}

function etternavnSjekk(){
    if (etternavn.value.match("^[A-ZÆØÅ][A-Za-zÆØÅæøå\\-]{2,19}$")) {
    etternavn.style.borderColor = "green";}
    else{
        etternavn.style.borderColor = "red"
    }
    console.log("Etternavn");
}

function mobilSjekk(){
    if (mobil.value.match("^[\\d]{7}$")) {
    mobil.style.borderColor = "green"
    }else{
        mobil.style.borderColor = "red"
    }
    console.log("mobil");
}

function passordSjekk(){
   if (passord.value.match("^(((?=.*[a-z])(?=.*[A-Z]))|((?=.*[a-z])(?=.*[0-9]))|((?=.*[A-Z])(?=.*[0-9])))(?=.{6,})")) {
    passord.style.borderColor = "green"
    }else{
      passord.style.borderColor = "red"  
    }
    console.log("passord");
}

function passordLikt(){
   if (passordRep.value === passord.value) {
    passordRep.style.borderColor = "green"
    }else{
        passordRep.style.borderColor = "red"
    }
    console.log("passordLikt");
}

function musOver(){
    console.log("mouseover");
}

 // const rootElement = document.getElementById("root")
const validator = new validator2("validator")

document.addEventListener("DOMContentLoaded", validator.run)

