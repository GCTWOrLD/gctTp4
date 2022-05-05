import React from "react";
import {useState, useEffect} from 'react';
import NewCd from "./NewCd";
import NewClient from "./NewClient";
import NewDvd from "./NewDvd";
import NewLivre from "./NewLivre";
import ClientsList from "./ClientsList";
import AddClient from "./AddClient";

function Admin() {
    const [showAddClient, setShowAddClient] = useState(false)
    const [clients, setClients] = useState([])
    const [showAddLivre, setShowAddLivre] = useState(false)
    const [livres, setLivres] = useState([])

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

  return (
    <div>
        <h2>Admin Pannel</h2>
        <ClientsList clients={clients} onDelete={deleteClient}/>
        <AddClient onAdd={addClient}/>
        {/* 
        <NewClient/>
        <NewLivre/>
        <NewCd/>
        <NewDvd/> */}
    </div>
  );
}

export default Admin;