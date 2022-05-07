import React, { useEffect, useState } from "react";
import EmpruntsList from "./EmpruntsList";
import RechercheAnnee from "./RechercheAnnee";
import RechercheAuteur from "./RechercheAuteur";
import RechercheCategorie from "./RechercheCategorie";
import RechercheTitre from "./RechercheTitre";
import AmendesList from "./AmendesList";

function Client() {

    const [emprunts, setEmprunts] = useState([])
    const [amendes, setAmendes] = useState([])
    // id du client courrant hardcodé
    const idClientCourrant = 1;

    useEffect(() => {
        const getEmprunts = async () => {
            const empruntsFromServer = await fetchEmprunts(idClientCourrant)
            setEmprunts(empruntsFromServer)
        }
        getEmprunts()
        const getAmendes = async () => {
            const amendesFromServer = await fetchAmendes(idClientCourrant)
            setAmendes(amendesFromServer)
        }
        getAmendes()
    }, [])

    const fetchEmprunts = async (id) => {
        const res = await fetch(`http://localhost:8080/emprunts/client/${id}`)
        const data = await res.json()
        return data
    }

    const deleteEmprunt = async (id) => {
        await fetch(`http://localhost:8080/emprunts/${id}`, {
            method: 'DELETE'
        })
        setEmprunts(emprunts.filter((emprunt) => emprunt.id !== id))
    }

    const fetchAmendes = async (id) => {
        const res = await fetch(`http://localhost:8080/amendes/client/${id}`)
        const data = await res.json()
        return data
    }

    const deleteAmende = async (id) => {
        await fetch(`http://localhost:8080/amendes/${id}`, {
            method: 'DELETE'
        })
        setAmendes(amendes.filter((amende) => amende.id !== id))
    }

    return (

        <div>
            <h2>Client Pannel</h2>
            <EmpruntsList emprunts={emprunts} onDelete={deleteEmprunt} />
            <AmendesList amendes={amendes} onDelete={deleteAmende} />
            <RechercheTitre />
            <RechercheAuteur />
            <RechercheAnnee />
            <RechercheCategorie />
        </div>
    );
}

export default Client;