import {useState} from 'react'

const AddLivre = ({onAdd}) => {
    const [titre, setTitre] = useState('')
    const [auteur, setAuteur] = useState('')
    const [annee, setAnnee] = useState('')
    const [categorie, setCategorie] = useState('')
    const [examplaires, setExamplaires] = useState('')
    const [editeur, setEditeur] = useState('')

    const onSubmit = (e) => {
        e.preventDefault()

        if (!titre) {
            alert('Veuillez ajouter un titre')
            return
        }

        onAdd({titre, auteur, annee, categorie, examplaires, editeur})
        setTitre('')
        setAuteur('')
        setAnnee('')
        setCategorie('')
        setExamplaires('')
        setEditeur('')
    }

    return (
        <form className='add-form' onSubmit={onSubmit}>
            <div className='form-control'>
                <label>Titre:</label>
                <input type='text' placeholder='Titre'
                value={titre}
                onChange={(e) => setTitre(e.target.value)} />
            </div>
            <div className='form-control'>
                <label>Auteur:</label>
                <input type='text' placeholder='Auteur'
                value={auteur}
                onChange={(e) => setAuteur(e.target.value)} />
            </div>
            <div className='form-control'>
                <label>Année:</label>
                <input type='text' placeholder='Année'
                value={annee}
                onChange={(e) => setAnnee(e.target.value)} />
            </div>
            <div className='form-control'>
                <label>Catégorie:</label>
                <input type='text' placeholder='Catégorie'
                value={categorie}
                onChange={(e) => setCategorie(e.target.value)} />
            </div>
            <div className='form-control'>
                <label>Examplaires:</label>
                <input type='text' placeholder='Examplaires'
                value={examplaires}
                onChange={(e) => setExamplaires(e.target.value)} />
            </div>
            <div className='form-control'>
                <label>Éditeur:</label>
                <input type='text' placeholder='Éditeur'
                value={editeur}
                onChange={(e) => setEditeur(e.target.value)} />
            </div>
            <input type='submit' value='Sauvegarder Livre' className='btn btn-block'/>
        </form>
    )
}

export default AddLivre;