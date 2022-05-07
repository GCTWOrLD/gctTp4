import DvdList from "./DvdList";

const DvdsList = ({dvds, onDelete}) => {
    return (
        <>
            <h3>Opérations Dvd</h3>
            <h4>ID | Titre | Auteur | Année | Catégorie | Examplaires | Durée | Studio</h4>
            {dvds.map((dvd) => (
                <DvdList key={dvd.id} 
                dvd={dvd} 
                onDelete={onDelete}/>
            ))}
        </>
    )
}

export default DvdsList;