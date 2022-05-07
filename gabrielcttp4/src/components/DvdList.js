import { FaTimes } from 'react-icons/fa'

const DvdList = ({ dvd, onDelete }) => {
    return (
        <div>
            <p>{dvd.id} | {dvd.titre} | {dvd.auteur} | {dvd.annee} | {dvd.categorie} | {dvd.examplaires} | {dvd.duree} | {dvd.studio} <FaTimes
                style={{ color: 'red', cursor: 'pointer' }}
                onClick={() => onDelete(dvd.id)} /></p>
        </div>
    )
}

export default DvdList;