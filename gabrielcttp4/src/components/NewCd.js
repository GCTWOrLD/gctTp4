import React from "react";

const NewCd = () => (
    <div>
        <h3>Nouveau Cd</h3>
        <form>
            <label>
                Titre:
                <input type="text" name="titrecd" />
            </label><br></br>
            <label>
                Auteur:
                <input type="text" name="auteurcd" />
            </label><br></br>
            <label>
                Année:
                <input type="text" name="anneecd" />
            </label><br></br>
            <label>
                Catégorie:
                <input type="text" name="categoriecd" />
            </label><br></br>
            <label>
                Examplaires:
                <input type="text" name="examplairescd" />
            </label><br></br>
            <label>
                Duréee:
                <input type="text" name="dureecd" />
            </label><br></br>
            <label>
                Studio:
                <input type="text" name="studiocd" />
            </label><br></br>
            <input type="submit" value="Créer Cd" />
        </form>
    </div>
)

export default NewCd;