import React from "react";
import Emprunts from "./Emprunts";
import RechercheAnnee from "./RechercheAnnee";
import RechercheAuteur from "./RechercheAuteur";
import RechercheCategorie from "./RechercheCategorie";
import RechercheTitre from "./RechercheTitre";

const Client = () => (
    <div>
        <h2>Client Pannel</h2>
        <RechercheTitre/>
        <RechercheAuteur/>
        <RechercheAnnee/>
        <RechercheCategorie/>
        <Emprunts/>
    </div>
)

export default Client;