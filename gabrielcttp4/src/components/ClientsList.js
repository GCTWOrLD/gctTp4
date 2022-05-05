import ClientList from "./ClientList"
const ClientsList = ({clients, onDelete}) => {
    return (
        <>
            <h3>Opérations Client</h3>
            <h4>ID / Prénom / Nom / Username / Password / Email / Téléphone / Rue / Code Postal / Numéro Civique</h4>
            {clients.map((client) => (
                <ClientList key={client.id} 
                client={client} 
                onDelete={onDelete}/>
            ))}
        </>
    )
}

export default ClientsList;