import React from "react";

const NewLivre = () => (
    <div>
        <h3>Nouveau Livre</h3>
        <form>
            <label>
                Titre:
                <input type="text" name="titre" />
            </label><br></br>
            <label>
                Auteur:
                <input type="text" name="auteur" />
            </label><br></br>
            <label>
                Année:
                <input type="text" name="annee" />
            </label><br></br>
            <label>
                Catégorie:
                <input type="text" name="categorie" />
            </label><br></br>
            <label>
                Examplaires:
                <input type="text" name="examplaires" />
            </label><br></br>
            <label>
                Éditeur:
                <input type="text" name="editeur" />
            </label><br></br>
            <input type="submit" value="Créer Livre" />
        </form>
    </div>
)

export default NewLivre;