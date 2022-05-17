
/**
 * Clase que muestra los objetos Buffer de Lineas.
 * 
 * @author Roberto Salazar Marquez
 * @version 1.0
 */
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class ReadFile3 extends Frame
{
    TextArea editor;
    BufferedReader entrada;

    public ReadFile3() throws IOException
    {
        super("Lector de Archivos");
        String c;
        editor = new TextArea();
        setLayout(new BorderLayout());
        add(editor,"Center");
        try {
            entrada = new BufferedReader(
                      new FileReader("ReadFile.java"));
        
            while((c = entrada.readLine()) !=  null) {
                editor.append(c + "\n");
            }
        
        }catch(FileNotFoundException e)
         {  System.out.println("Archivo no encontrado");  }
        finally {
            if(entrada != null)
                entrada.close();
        }

        addWindowListener(new CW() );
        setSize(500,550);
        setVisible(true);
    }

    private class CW extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            setVisible(true);
            dispose();
        }
    }

    public static void main(String[] args) {
        try {
            ReadFile3 readFile = new ReadFile3();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}