import React from "react";

const RechercheAnnee = () => (
    <div>
        <h3>Recherche par année</h3>
        <form>
            <label>
                Année:
                <input type="text" name="annee" />
            </label>
            <input type="submit" value="Submit" />
        </form>
    </div>
)

export default RechercheAnnee;