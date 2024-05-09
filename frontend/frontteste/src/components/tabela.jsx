import React, {useEffect, useState} from 'react';
import axios from 'axios';


function Tabela(){

    
    const [pessoas, setPessoas] = useState([]);
    const getPessoas = async ()=>{
        
        try {
            const response = await axios.get("http://localhost:8080/pessoa/listar");
            

            const data = response.data;
    
            setPessoas(data);
            console.log(pessoas);

        } catch (error) {
            console.log(error);
        }

    };

    useEffect(()=> {

        getPessoas();
        console.log(pessoas);
    },[]);


    return(

        <div className='container m-4 is-danger box'>
             <table className='table is-fullwidth'>
                <thead className=' is-fullwidth'>
                    <tr className=' is-fullwidth table-header'>
                        
                            <th className='is-size-5 pl-5 is-4 has-text-centered'> Nome </th>
                      
                        
                             <th className='is-size-5 pl-5 is-4 has-text-centered'> Email  </th>
                     
                        
                    </tr>
                </thead>

                <tbody>
                    <tr>
                        <td>
                            <div className="has-text-centered">
                                <p key={pessoas.nome}></p>
                            </div>
                        </td>
                        <td>
                            <div className="has-text-centered">
                                <tr key={pessoas.email}></tr>
                            </div>
                        </td>
                    </tr>
                </tbody>
           
            </table>

        </div>
       
       
    );
}
export default Tabela;