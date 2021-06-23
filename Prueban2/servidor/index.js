const express = require("express");
const app = express();
var mysql = require('mysql');  
const cors = require("cors");

app.use(cors());
app.use(express.json());

var db = mysql.createConnection({  
    host: "localhost",  
    user: "root",  
    password: "" ,
    database: "usuarios",
  });  
  db.connect(function(err) {  
    if (err) throw err;  
    console.log("Connected!");  
  });  

app.post("/create", (req, res) => { 
    const nombre = req.body.nombre
    const pais = req.body.pais
    const celular = req.body.celular    
    const correo = req.body.correo
    db.query('INSERT INTO usuarios (nombre, pais, celular, correo) VALUES(?,?,?,?)',
    [nombre, pais, celular, correo],
    (err, result) => {
        if (err) {
          console.log(err);
        } else {
          res.send("Valores agregados");
        }
      }
    );
  });

app.get('/usuarios',(req, res) => {
db.query('SELECT * FROM usuarios', (err, result) => {
    if (err) {
      console.log(err);
    } else {
      res.send(result);
    }
  });
});

app.listen(3001,()=>{
console.log('El servidor se esta ejecutando en el puerto 3001')
});



