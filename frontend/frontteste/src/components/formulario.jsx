import React, {useState} from 'react';
import axios from 'axios';

function Formulario(){
    const [nome, setNome] = useState('');
    const [email, setEmail] = useState('');

    
    const handleSubmit = async (event) =>{
        event.preventDefault();

        const data = {
            nome: nome,
            email: email
        
          };
          
        try{
            console.log(data);
            const response = await axios.post('http://localhost:8080/pessoa/cadastrar',data);
            console.log('Resposta da API', response.data);
        }catch(error){
            console.error('KKKKKKKKKKKKKKKKK:',error);
        }

       

        setNome('');
        setEmail('');
    };

    return(
        <form method='post' className="form container is-primary is-one-quarter mt-6" onSubmit={handleSubmit}>
            <div className="field m-4">
                <div className="control">
                <label> Nome: </label>
                <input  type="text" value={nome} onChange={(event) => setNome(event.target.value)}/>
                </div>
            </div>


            <div className="field m-4">
                <div className="control">
                <label> Email: </label>
                    <input type="text" value={email} onChange={(event) => setEmail(event.target.value)}/>
                </div>
            </div>
          
          
            <div className="field m-4">
                <div className="control">
                    <input type="submit" className="button is-primary" value="Confirmar"/>
                </div>
            </div>
            
        </form>
    );
}

export default Formulario;