import AmendeList from "./AmendeList";

const AmendesList = ({ amendes, onDelete }) => {

    return (
        <>
            <h3>Liste de vos amendes (cliquez sur le <span style={{ color: "green" }}>$</span> pour payer)</h3>
            <h4>Date de retard | Jours en retard | Document | Montant</h4>
            {amendes.map((amende) => (
                <AmendeList key={amende.id}
                    amende={amende}
                    onDelete={onDelete} />
            ))}
        </>
    )
}

export default AmendesList;