
import './App.css';
import Formulario from './components/formulario';
import Tabela from './components/tabela';


function App() {
  return (
    <div className="App">

    <div className='columns is-centered'>

      <div className='column'>

      </div>
      <div className='column box'>
        <Tabela></Tabela>
      </div>
      <div className='column'>
        <Formulario></Formulario> 
      </div>

      
      
      

    </div>
      
    </div>
  );
}

export default App;
