import React from "react";

const RechercheCategorie = () => (
    <div>
        <h3>Recherche par catégorie</h3>
        <form>
            <label>
                Catégorie:
                <input type="text" name="categorie" />
            </label>
            <input type="submit" value="Submit" />
        </form>
    </div>
)

export default RechercheCategorie;