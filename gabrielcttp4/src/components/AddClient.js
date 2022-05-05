import {useState} from 'react'

const AddClient = ({onAdd}) => {
    const [prenom, setPrenom] = useState('')
    const [nom, setNom] = useState('')
    const [username, setUsername] = useState('')
    const [password, setPassword] = useState('')
    const [email, setEmail] = useState('')
    const [telephone, setTelephone] = useState('')
    const [rue, setRue] = useState('')
    const [codePostal, setCodePostal] = useState('')
    const [numeroCivique, setNumeroCivique] = useState('')

    const onSubmit = (e) => {
        e.preventDefault()

        if (!prenom) {
            alert('Veuillez ajouter un prénom')
            return
        }

        onAdd({prenom, nom, username, password, email, telephone, rue, codePostal, numeroCivique})
        setPrenom('')
        setNom('')
        setUsername('')
        setPassword('')
        setEmail('')
        setTelephone('')
        setRue('')
        setCodePostal('')
        setNumeroCivique('')
    }

    return (
        <form className='add-form' onSubmit={onSubmit}>
            <div className='form-control'>
                <label>Prénom:</label>
                <input type='text' placeholder='Prénom'
                value={prenom}
                onChange={(e) => setPrenom(e.target.value)} />
            </div>
            <div className='form-control'>
                <label>Nom:</label>
                <input type='text' placeholder='Nom'
                value={nom}
                onChange={(e) => setNom(e.target.value)} />
            </div>
            <div className='form-control'>
                <label>Username:</label>
                <input type='text' placeholder='Username'
                value={username}
                onChange={(e) => setUsername(e.target.value)} />
            </div>
            <div className='form-control'>
                <label>Password:</label>
                <input type='text' placeholder='Password'
                value={password}
                onChange={(e) => setPassword(e.target.value)} />
            </div>
            <div className='form-control'>
                <label>Email:</label>
                <input type='text' placeholder='Email'
                value={email}
                onChange={(e) => setEmail(e.target.value)} />
            </div>
            <div className='form-control'>
                <label>Téléphone:</label>
                <input type='text' placeholder='Téléphone'
                value={telephone}
                onChange={(e) => setTelephone(e.target.value)} />
            </div>
            <div className='form-control'>
                <label>Rue:</label>
                <input type='text' placeholder='Rue'
                value={rue}
                onChange={(e) => setRue(e.target.value)} />
            </div>
            <div className='form-control'>
                <label>Code Postal:</label>
                <input type='text' placeholder='Code Postal'
                value={codePostal}
                onChange={(e) => setCodePostal(e.target.value)} />
            </div>
            <div className='form-control'>
                <label>Numéro Civique:</label>
                <input type='text' placeholder='Numéro Civique'
                value={numeroCivique}
                onChange={(e) => setNumeroCivique(e.target.value)} />
            </div>
            <input type='submit' value='Sauvegarder Client' className='btn btn-block'/>
        </form>
    )
}

export default AddClient;