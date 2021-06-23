import React from 'react'
import { useState, useStyles } from "react";
import Axios from "axios";
const Usuarios = () => {
const [nombre, setNombre] = useState("");
const [pais, setPais] = useState("");
const [celular, setCelular] = useState(0);
const [correo, setCorreo] = useState("");
const [listausuarios, setListaUsuarios] = useState([]);      
function validaNumericos(valor) {
  if (!isNaN(valor)) {
    
    return true;
  }else{
    return false;
  }      
}
function validaNoNumericos(val) {
  var matches = val.match(/\d+/g);
  if (matches != null) {
      return false
  }else{

    return true 
  }  
}
function validarEmail(valor) {
  var re=/^([\da-z_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/
	if(!re.exec(valor)){
	
    return false;
	}
	else 
  return true;
	}
const agregarUsuario = () => {
  const validaciones1 = [
    nombre !== "",
    pais !== "",
    celular !== "",
    correo !== "",
    validarEmail(correo),
    validaNumericos(celular),
    validaNoNumericos(nombre),
    validaNoNumericos(pais),
  ]
    if (!validaciones1.includes(false)) {
      Axios.post("http://localhost:3001/create", {
        nombre: nombre,
        pais: pais,
        celular: celular,
        correo: correo,        
        
      }).then(() => {
        alert("Usuario ingresado correctamente")
        console.log('prueba 1')
      })
    }
    else {
      alert("Algun campo esta vacio o debe ser llenado de forma correcta")
    }

    ;
  };

const listarUsuarios = () => {
    Axios.get("http://localhost:3001/usuarios").then((response) => {
      setListaUsuarios(response.data);

    });
  };
  return (
    <div>

      <div className='info'>
        <h3>Por favor ingresa los datos del usuario </h3>
        <label>Nombre completo:</label>
        <input
          type='text'
          pattern="[A-Za-z]{3,}" title="nombres"
          placeholder="Nombres"
          required="required"
          onChange={(event) => {
            setNombre(event.target.value);

          }}
        />
        <label>Pais:</label>
        <input
          type='text'
          placeholder="Pais"
          onChange={(event) => {
            setPais(event.target.value);
          }}
        />
        <label>celular:</label>
        <input type='text'
          placeholder="celular"

          onChange={(event) => {
            setCelular(event.target.value);
          }}
        />
      
        <label>Correo:</label>
        <input type='text'
          placeholder="Correo "

          onChange={(event) => {
            setCorreo(event.target.value);
          }} />
        
        <button className="btn btn-dark" onClick={agregarUsuario}>Agregar Usuario</button>
        <button className="btn btn-dark" onClick={listarUsuarios}>Listar Usuarios</button>

      </div>

        
        {listausuarios.map((val, key) => {
          return (
            <div className="usuarios">
              <div className="datos">
                <h3>--------------------------------</h3>
                <h3>Nombre: {val.nombre}</h3>
                <h3>Pais: {val.pais}</h3>
                <h3>celular: {val.celular}</h3>
                <h3>correo: {val.correo}</h3>
              </div>
            </div>
          );
        })}
     
    </div>
  )
}
export default Usuarios


