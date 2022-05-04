import React from "react";

const NewDvd = () => (
    <div>
        <h3>Nouveau Dvd</h3>
        <form>
            <label>
                Titre:
                <input type="text" name="titredvd" />
            </label><br></br>
            <label>
                Auteur:
                <input type="text" name="auteurdvd" />
            </label><br></br>
            <label>
                Année:
                <input type="text" name="anneedvd" />
            </label><br></br>
            <label>
                Catégorie:
                <input type="text" name="categoriedvd" />
            </label><br></br>
            <label>
                Examplaires:
                <input type="text" name="examplairesdvd" />
            </label><br></br>
            <label>
                Duréee:
                <input type="text" name="dureedvd" />
            </label><br></br>
            <label>
                Studio:
                <input type="text" name="studiodvd" />
            </label><br></br>
            <input type="submit" value="Créer Dvd" />
        </form>
    </div>
)

export default NewDvd;