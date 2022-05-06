import React, { useEffect, useState } from "react";
import Emprunts from "./Emprunts";
import RechercheAnnee from "./RechercheAnnee";
import RechercheAuteur from "./RechercheAuteur";
import RechercheCategorie from "./RechercheCategorie";
import RechercheTitre from "./RechercheTitre";

function Client() {

    /*const [rechercheTitre, setRechercheTitre] = useState([])
    const [rechercheAuteur, setRechercheAuteur] = useState([])
    const [rechercheAnnee, setRechercheAnnee] = useState([])
    const [rechercheCategorie, setRechercheCategorie] = useState([])

    useEffect(() => {
        const getRechercheTitre = async () => {
            const rechercheTitreFromServer = await fetchRechercheTitre()
            setRechercheTitre(rechercheTitreFromServer)
        }
        getRechercheTitre()
        const getRechercheAuteur = async () => {
            const rechercheAuteurFromServer = await fetchRechercheAuteur()
            setRechercheAuteur(rechercheAuteurFromServer)
        }
        getRechercheAuteur()
        const getRechercheAnnee = async () => {
            const rechercheAnneeFromServer = await fetchRechercheAnnee()
            setRechercheAnnee(rechercheAnneeFromServer)
        }
        getRechercheAnnee()
        const getRechercheCategorie = async () => {
            const rechercheCategorieFromServer = await fetchRechercheCategorie()
            setRechercheCategorie(rechercheCategorieFromServer)
        }
        getRechercheCategorie()
    }, [])

    const fetchRechercheTitre = async (titre) => {
        const res = await fetch(`http://localhost:8080/titre/${titre}`)
        const data = await res.json()
        return data
    }

    const fetchRechercheAuteur = async (auteur) => {
        const res = await fetch(`http://localhost:8080/auteur/${auteur}`)
        const data = await res.json()
        return data
    }

    const fetchRechercheAnnee = async (annee) => {
        const res = await fetch(`http://localhost:8080/annee/${annee}`)
        const data = await res.json()
        return data
    }

    const fetchRechercheCategorie = async (categorie) => {
        const res = await fetch(`http://localhost:8080/categorie/${categorie}`)
        const data = await res.json()
        return data
    }*/

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