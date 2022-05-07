import { FaTimes} from 'react-icons/fa'

const EmpruntList = ({emprunt, onDelete}) => {
    return (
        <div>
            <p>{emprunt.document.titre} / {emprunt.document.auteur} /{emprunt.dateEmprunt} / {emprunt.dateRetour} <FaTimes
            style={{color: 'red', cursor: 'pointer'}}
            onClick={()=>onDelete(emprunt.id)}/></p>
        </div>
    )
}

export default EmpruntList;