import "./App.css";
import Usuarios from "./components/Usuarios";
import Inicio from "./components/Inicio";
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link
} from "react-router-dom";

function App() {
  
  return (
    <Router>
    <div className="container">
    <div className="banner"> 
      <div className="btn-group">
          <Link to="/" className="btn btn-dark">Inicio</Link>
          <Link to="/usuarios/form" className="btn btn-dark">Usuarios</Link>
      </div>
      <hr />
      </div> 
      <Switch>
        <Route path='/usuarios/form'>
          <Usuarios/>
        </Route>
       
          <Route path='/'>
          <Inicio></Inicio>
          </Route>  
      </Switch>
    </div>
    </Router>
  );
}
export default App;
