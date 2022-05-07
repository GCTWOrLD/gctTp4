import { FaDollarSign } from 'react-icons/fa'

const AmendeList = ({ amende, onDelete }) => {
    return (
        <div>
            <p>{amende.dateRetard} | {amende.nbDeJoursEnRetard} | {amende.nomDuDocument} | {amende.montant} <FaDollarSign
                style={{ color: 'green', cursor: 'pointer' }}
                onClick={() => onDelete(amende.id)} /></p>
        </div>
    )
}

export default AmendeList;