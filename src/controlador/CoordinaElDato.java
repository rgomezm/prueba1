package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import modelo.Modelo;
import vista.IngresaElDato;


public class CoordinaElDato implements ActionListener{
    
    //Declaro objeto vista
    private IngresaElDato vistaIngresaElDato;
    
    //Declaro objeto modelo
    private Modelo modelo = new Modelo();
    
    //Declaro botón que está en la vista ingresa el dato
    public enum Accion{
        btnagregar
    }
    
    //Constructor de CoordinaElDato
    public CoordinaElDato(IngresaElDato vistaIngresaElDato){
        this.vistaIngresaElDato = vistaIngresaElDato;
    }
    
    public void iniciar(){
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(vistaIngresaElDato);
            this.vistaIngresaElDato.setLocationRelativeTo(null);
            this.vistaIngresaElDato.setTitle("El Dato");
            this.vistaIngresaElDato.setVisible(true);
        } catch (UnsupportedLookAndFeelException ex) {}
          catch (ClassNotFoundException ex) {}
          catch (InstantiationException ex) {}
          catch (IllegalAccessException ex) {}

        //Escuchamos los botones de todas partes
        this.vistaIngresaElDato.btnagregar.setActionCommand( "btnagregar" );
        this.vistaIngresaElDato.btnagregar.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    switch (Accion.valueOf(e.getActionCommand())){  
            case btnagregar:
                if(this.modelo.agregaDato(this.vistaIngresaElDato.txteldato.getText())){
                    JOptionPane.showMessageDialog(null, "El dato fue agregado");
                    //Limpiamos textField
                    this.vistaIngresaElDato.txteldato.setText("");
                }else{
                    JOptionPane.showMessageDialog(null, "No se pudo agregar");
                }
    }
    }
}
