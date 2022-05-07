import React, { useEffect, useState } from "react";
import EmpruntsList from "./EmpruntsList";
import RechercheAnnee from "./RechercheAnnee";
import RechercheAuteur from "./RechercheAuteur";
import RechercheCategorie from "./RechercheCategorie";
import RechercheTitre from "./RechercheTitre";

function Client() {

    const [emprunts, setEmprunts] = useState([])
    // id du client courrant hardcodé
    const idClientCourrant = 1;

    useEffect(() => {
        const getEmprunts = async () => {
            const empruntsFromServer = await fetchEmprunts(idClientCourrant)
            setEmprunts(empruntsFromServer)
          }
          getEmprunts()
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

    return (

        <div>
            <h2>Client Pannel</h2>
            <EmpruntsList emprunts={emprunts} onDelete={deleteEmprunt} />
            <RechercheTitre/>
            <RechercheAuteur/>
            <RechercheAnnee/>
            <RechercheCategorie/>
        </div>
    );
}

export default Client;