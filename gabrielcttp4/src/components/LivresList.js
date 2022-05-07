import LivreList from "./LivreList"

const LivresList = ({livres, onDelete}) => {
    return (
        <>
            <h3>Opérations Livre</h3>
            <h4>ID | Titre | Auteur | Année | Catégorie | Examplaires | Éditeur</h4>
            {livres.map((livre) => (
                <LivreList key={livre.id} 
                livre={livre} 
                onDelete={onDelete}/>
            ))}
        </>
    )
}

export default LivresList;