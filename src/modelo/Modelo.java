package modelo;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import sql.Conexion;

public class Modelo extends Conexion{

    public Modelo() {
    }
    
    //Método para agregar el dato
    public boolean agregaDato(String reciboeldato){
            //Se arma la consulta
            String q=" INSERT INTO prueba.eldato(nombre) "
                    + "VALUES ( '" + reciboeldato + "') ";
            //se ejecuta la consulta
            try {
                PreparedStatement pstm = this.getConexion().prepareStatement(q);
                pstm.execute();
                pstm.close();
                return true;
            }catch(SQLException e){
                System.err.println( e.getMessage() );
            }
            return false;
    }
}
