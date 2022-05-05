import React from "react";
import {useState, useEffect} from 'react';
import AddCd from "./AddCd";
import AddDvd from "./AddDvd";
import AddLivre from "./AddLivre";
import ClientsList from "./ClientsList";
import AddClient from "./AddClient";
import LivresList from "./LivresList";
import CdsList from "./CdsList";
import DvdsList from "./DvdsList";

function Admin() {
    const [showAddClient, setShowAddClient] = useState(false)
    const [clients, setClients] = useState([])
    const [showAddLivre, setShowAddLivre] = useState(false)
    const [livres, setLivres] = useState([])
    const [showAddCd, setShowAddCd] = useState(false)
    const [cds, setCds] = useState([])
    const [showAddDvd, setShowAddDvd] = useState(false)
    const [dvds, setDvds] = useState([])
    
  useEffect(() => {
    const getClients = async () => {
      const clientsFromServer = await fetchClients()
      setClients(clientsFromServer)
    }
    getClients()
    const getLivres = async () => {
        const livresFromServer = await fetchLivres()
        setLivres(livresFromServer)
    }
    getLivres()
    const getCds = async () => {
        const cdsFromServer = await fetchCds()
        setCds(cdsFromServer)
    }
    getCds()
    const getDvds = async () => {
        const dvdsFromServer = await fetchDvds()
        setDvds(dvdsFromServer)
    }
    getDvds()
  }, []) 

  const fetchClients = async () => {
    const res = await fetch('http://localhost:8080/clients')
    const data = await res.json()
    return data
  }

  const fetchClient = async(id) => {
    const res = await fetch(`http://localhost:8080/clients/${id}`)
    const data = await res.json()
    return data
  }

  const addClient = async (client) => {
    const res = await fetch('http://localhost:8080/clients',
    {
      method: 'POST',
      headers: {
        'Content-type': 'application/json',
      },
      body: JSON.stringify(client)
    })
    const data = await res.json()
    setClients([...clients, data])
  }

  const deleteClient = async (id) => {
    await fetch(`http://localhost:8080/clients/${id}`, {
      method: 'DELETE'
    })
    setClients(clients.filter((client) => client.id !== id))
  }

  const fetchLivres = async () => {
    const res = await fetch('http://localhost:8080/livres')
    const data = await res.json()
    return data
  }

  const fetchLivre = async(id) => {
    const res = await fetch(`http://localhost:8080/livres/${id}`)
    const data = await res.json()
    return data
  }

  const addLivre = async (livre) => {
    const res = await fetch('http://localhost:8080/livres',
    {
      method: 'POST',
      headers: {
        'Content-type': 'application/json',
      },
      body: JSON.stringify(livre)
    })
    const data = await res.json()
    setLivres([...livres, data])
  }

  const deleteLivre = async (id) => {
    await fetch(`http://localhost:8080/livres/${id}`, {
      method: 'DELETE'
    })
    setLivres(livres.filter((livre) => livre.id !== id))
  }

  const fetchCds = async () => {
    const res = await fetch('http://localhost:8080/cds')
    const data = await res.json()
    return data
  }

  const fetchCd = async(id) => {
    const res = await fetch(`http://localhost:8080/cds/${id}`)
    const data = await res.json()
    return data
  }

  const addCd = async (cd) => {
    const res = await fetch('http://localhost:8080/cds',
    {
      method: 'POST',
      headers: {
        'Content-type': 'application/json',
      },
      body: JSON.stringify(cd)
    })
    const data = await res.json()
    setCds([...cds, data])
  }

  const deleteCd = async (id) => {
    await fetch(`http://localhost:8080/cds/${id}`, {
      method: 'DELETE'
    })
    setCds(cds.filter((cd) => cd.id !== id))
  }

  const fetchDvds = async () => {
    const res = await fetch('http://localhost:8080/dvds')
    const data = await res.json()
    return data
  }

  const fetchDvd = async(id) => {
    const res = await fetch(`http://localhost:8080/dvds/${id}`)
    const data = await res.json()
    return data
  }

  const addDvd = async (dvd) => {
    const res = await fetch('http://localhost:8080/dvds',
    {
      method: 'POST',
      headers: {
        'Content-type': 'application/json',
      },
      body: JSON.stringify(dvd)
    })
    const data = await res.json()
    setDvds([...dvds, data])
  }

  const deleteDvd = async (id) => {
    await fetch(`http://localhost:8080/dvds/${id}`, {
      method: 'DELETE'
    })
    setDvds(dvds.filter((dvd) => dvd.id !== id))
  }

  return (
    <div>
        <h2>Admin Pannel</h2>
        <ClientsList clients={clients} onDelete={deleteClient}/>
        <AddClient onAdd={addClient}/>
        <LivresList livres={livres} onDelete={deleteLivre}/>
        <AddLivre onAdd={addLivre}/>
        <CdsList cds={cds} onDelete={deleteCd}/>
        <AddCd onAdd={addCd}/>
        <DvdsList dvds={dvds} onDelete={deleteDvd}/>
        <AddDvd onAdd={addDvd}/>
    </div>
  );
}

export default Admin;