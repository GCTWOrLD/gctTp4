import React, { useState } from "react";

const RechercheAuteur = () => {
    const [data, setData] = useState(null);
    const [query, setQuery] = useState('');

    const handleSubmit = (e) => {
        e.preventDefault();
        if (!query) {
            alert('Veuillez entrer un auteur')
            return
        }
    
        async function fetchData() {
          const response = await fetch(`http://localhost:8080/documents/auteur/${query}`);
          const data = await response.json();
          setData(data);
        }
        fetchData();
    };

      return (
        <div>
            <h3>Recherche par auteur</h3>
          <form onSubmit={handleSubmit}>
            <label>Auteur:
                <input
                type="text"
                placeholder="Auteur"
                value={query}
                onChange={(e) => {
                  setQuery(e.target.value);
                }}
              />
            </label>
            <input type="submit" value="Submit"/>
          </form>
          <h3>Titre / Auteur / Année / Catégorie / Examplaires</h3>
    
          {data &&
            data.map((document) => (
              <div key={document.id}>
                <p>{document.titre} / {document.auteur}</p>
              </div>
            ))}
        </div>
      );
}

export default RechercheAuteur;