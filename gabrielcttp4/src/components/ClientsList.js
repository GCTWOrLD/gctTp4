import ClientList from "./ClientList"
const ClientsList = ({clients, onDelete}) => {
    return (
        <>
            <h3>Opérations Client</h3>
            {clients.map((client) => (
                <ClientList key={client.id} 
                client={client} 
                onDelete={onDelete}/>
            ))}
        </>
    )
}

export default ClientsList