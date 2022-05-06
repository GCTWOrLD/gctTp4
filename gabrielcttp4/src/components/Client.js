import React, { useEffect, useState } from "react";
import Emprunts from "./Emprunts";
import RechercheAnnee from "./RechercheAnnee";
import RechercheAuteur from "./RechercheAuteur";
import RechercheCategorie from "./RechercheCategorie";
import RechercheTitre from "./RechercheTitre";

function Client() {

    return (

        <div>
            <h2>Client Pannel</h2>
            <RechercheTitre/>
            <RechercheAuteur/>
            <RechercheAnnee/>
            <RechercheCategorie/>
        </div>
    );
}

export default Client;