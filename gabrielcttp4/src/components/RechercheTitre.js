import React, { useState } from "react";

const RechercheTitre = () => {
    const [data, setData] = useState(null);
    const [query, setQuery] = useState('');

    const handleSubmit = (e) => {
        e.preventDefault();
        if (!query) {
            alert('Veuillez entrer un titre')
            return
        }
    
        async function fetchData() {
          const response = await fetch(`http://localhost:8080/documents/titre/${query}`);
          const data = await response.json();
          setData(data);
        }
        fetchData();
    };

      return (
        <div>
            <h3>Recherche par titre</h3>
          <form onSubmit={handleSubmit}>
            <label>Titre:
                <input
                type="text"
                placeholder="Titre"
                value={query}
                onChange={(e) => {
                  setQuery(e.target.value);
                }}
              />
            </label>
            <input type="submit" value="Submit"/>
          </form>
          <h3>Titre | Auteur | Année | Catégorie | Examplaires</h3>
    
          {data &&
            data.map((document) => (
              <div key={document.id}>
                <p>{document.titre} | {document.auteur} | {document.annee} | {document.categorie} | {document.examplaires}</p>
              </div>
            ))}
        </div>
      );
}

export default RechercheTitre;