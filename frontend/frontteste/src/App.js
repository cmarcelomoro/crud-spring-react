
import './App.css';
import Formulario from './components/formulario';
import Tabela from './components/tabela';


function App() {
  return (
    <div className="App">

    <div className='columns is-centered mt-5'>

      <div className='column'>

      </div>
      <div className='column is-flex is-half'>
        <Tabela></Tabela>
        <Formulario></Formulario> 
      </div>
      <div className='column'>
        
      </div>

      
      
      

    </div>
      
    </div>
  );
}

export default App;
