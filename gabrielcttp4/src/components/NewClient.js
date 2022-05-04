import React from "react";

const NewClient = () => (
    <div>
        <h3>Nouveau Client</h3>
        <form>
            <label>
                Prénom:
                <input type="text" name="prenom" />
            </label><br></br>
            <label>
                Nom:
                <input type="text" name="nom" />
            </label><br></br>
            <label>
                Username:
                <input type="text" name="username" />
            </label><br></br>
            <label>
                Password:
                <input type="text" name="password" />
            </label><br></br>
            <label>
                Courriel:
                <input type="text" name="courriel" />
            </label><br></br>
            <label>
                Téléphone:
                <input type="text" name="telephone" />
            </label><br></br>
            <label>
                Rue:
                <input type="text" name="rue" />
            </label><br></br>
            <label>
                Code postal:
                <input type="text" name="codePostal" />
            </label><br></br>
            <label>
                Numéro civique:
                <input type="text" name="numeroCivique" />
            </label><br></br>
            <input type="submit" value="Créer Client" />
        </form>
    </div>
)

export default NewClient;