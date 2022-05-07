import EmpruntList from "./EmpruntList";

const EmpruntsList = ({emprunts, onDelete}) => {

    return (
        <>
            <h3>Liste de vos emprunts</h3>
            <h4>Document / Auteur / Date d'emprunt / Date de retour</h4>
            {emprunts.map((emprunt) => (
                <EmpruntList key={emprunt.id}
                emprunt={emprunt} 
                onDelete={onDelete}/>
            ))}
        </>
    )
}

export default EmpruntsList;