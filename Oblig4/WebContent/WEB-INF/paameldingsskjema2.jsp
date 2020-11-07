<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="no">
  <head>
    <link rel="shortcut icon" href="#">
    <link href="main.css" rel="stylesheet" type="text/css" />
    <link href="formcontroller.css" rel="stylesheet" type="text/css" />
    <script src="js/validator2.js" defer></script>
    <script src="js/formcontroller.js" defer></script>

    <title>Påmelding</title>
  </head>
  <body>
    <h2>Påmelding</h2>

    <div id="root">
      <form method="post">
        <fieldset>
          <label for="fornavn">Fornavn:</label> <input type="text" name="fornavn" id="fornavn" value="${deltagerForm.fornavn}" required/>
          <span class="melding">${ffnavn}</span>

          <label for="etternavn">Etternavn:</label> <input type="text" name="etternavn" id="etternavn" value="${deltagerForm.etternavn}"  required/>
          <span class="melding">${deltagerForm.etternavnMelding}</span>

          <label for="mobil">Mobil (8 siffer):</label> <input type="text" name="mobil" id="mobil" value="${deltagerForm.mobil}"  required/>
          <span class="melding">${deltagerForm.mobilMelding}</span>

          <label for="passord">Passord:</label> <input type="password" name="passord" id="passord" value="${deltagerForm.passord}" /> 
          <span class="melding">${deltagerForm.passordMelding}</span>          

          <label for="passordRepetert">Passord repetert:</label> <input type="password" name="passordRepetert" id="passordRepetert" value="${deltagerForm.passordRepetert}"  required/>
          <span class="melding">${deltagerForm.passordRepetertMelding}</span>

          <span class="columnfirst">Kjønn:</span>
          <span data-kjonn>
            <label><input type="radio" name="kjonn" value="mann" checked="checked" ${deltagerForm.kjonn eq "mann" ? "checked=\"checked\"" : ""} /> Mann</label>
            <label><input type="radio" name="kjonn" value="kvinne" ${deltagerForm.kjonn eq "kvinne" ? "checked=\"checked\"" : ""} />Kvinne</label>
          </span>
          <span class="melding">${deltagerForm.kjonnMelding}</span>

          <button type="submit" onclick="sjekkSkjema()">Meld meg på</button>
        </fieldset>
      </form>
        <div id="feilmeldingboks" data-info="passord" class="formcontroller_hidden"></div>
        <div id="passordInfo" data-info="submit" class="formcontroller_hidden"></div>
    </div>
  </body>
</html>
