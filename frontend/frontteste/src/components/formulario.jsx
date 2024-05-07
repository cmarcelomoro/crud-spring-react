import React, {useState} from 'react';

function Formulario(){
    const [nome, setNome] = useState('');
    const [email, setEmail] = useState('');

    const handleSubmit = (event) =>{
        event.preventDefault();

        console.log('nome: ',nome)
        console.log('email: ',email)

        setNome('');
        setEmail('');
    };

    return(
        <form className="form container is-primary is-one-quarter mt-6" onSubmit={handleSubmit}>
            <field className="field m-4">
                <div className="control">
                <label> Nome: </label>
                <input  type="text" value={nome} onChange={(event) => setNome(event.target.value)}/>
                </div>
            </field>


            <field className="field m-4">
                <div className="control">
                <label> Email: </label>
                    <input type="text" value={email} onChange={(event) => setEmail(event.target.value)}/>
                </div>
            </field>
          
          
            <field className="field m-4">
                <div className="control">
                    <input type="submit" className="button is-primary" value="Confirmar"/>
                </div>
            </field>
            
        </form>
    );
}

export default Formulario;