import CdList from "./CdList";

const CdsList = ({cds, onDelete}) => {
    return (
        <>
            <h3>Opérations Cd</h3>
            <h4>ID | Titre | Auteur | Année | Catégorie | Examplaires | Durée | Studio</h4>
            {cds.map((cd) => (
                <CdList key={cd.id} 
                cd={cd} 
                onDelete={onDelete}/>
            ))}
        </>
    )
}

export default CdsList;