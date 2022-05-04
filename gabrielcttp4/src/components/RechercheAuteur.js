import React from "react";

const RechercheAuteur = () => (
    <div>
        <h3>Recherche par auteur</h3>
        <form>
            <label>
                Année:
                <input type="text" name="auteur" />
            </label>
            <input type="submit" value="Submit" />
        </form>
    </div>
)

export default RechercheAuteur;