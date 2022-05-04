import React from "react";

const RechercheTitre = () => (
    <div>
        <h3>Recherche par titre</h3>
        <form>
            <label>
                Titre:
                <input type="text" name="titre" />
            </label>
            <input type="submit" value="Submit" />
        </form>
    </div>
)

export default RechercheTitre;