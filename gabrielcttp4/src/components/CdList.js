import { FaTimes} from 'react-icons/fa'

const CdList = ({cd, onDelete}) => {
    return (
        <div>
            <p>{cd.id} / {cd.titre} / {cd.auteur} / {cd.annee} / {cd.categorie} / {cd.examplaires} / {cd.duree} / {cd.studio} <FaTimes
            style={{color: 'red', cursor: 'pointer'}}
            onClick={()=>onDelete(cd.id)}/></p>
        </div>
    )
}

export default CdList;