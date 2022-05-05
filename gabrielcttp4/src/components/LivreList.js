import { FaTimes} from 'react-icons/fa'

const LivreList = ({livre, onDelete}) => {
    return (
        <div>
            <p>{livre.id} / {livre.titre} / {livre.auteur} / {livre.annee} / {livre.categorie} / {livre.examplaires} / {livre.editeur} <FaTimes
            style={{color: 'red', cursor: 'pointer'}}
            onClick={()=>onDelete(livre.id)}/></p>
        </div>
    )
}

export default LivreList;