import { FaTimes} from 'react-icons/fa'

const ClientList = ({client, onDelete}) => {
    return (
        <div>
            <p>{client.id} / {client.prenom} / {client.nom} / {client.username} / 
            {client.password} / {client.email} / {client.telephone} / {client.rue} / 
            {client.codePostal} / {client.numeroCivique} <FaTimes
            style={{color: 'red', cursor: 'pointer'}}
            onClick={()=>onDelete(client.id)}/></p>
        </div>
    )
}

export default ClientList;
