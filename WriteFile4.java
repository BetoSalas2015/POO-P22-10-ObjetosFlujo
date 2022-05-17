
/**
 * Clase que muestra los objetos Buffer de Lineas.
 * 
 * @author Roberto Salazar Marquez
 * @version 1.0
 */
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class WriteFile4 extends Frame
{
    TextArea editor;
    DataOutputStream escribe;
    
    private String Nombres[] = {"Juan", "Andrés", "Raul"};
    private String Apellidos[] = {"Pérez",  "Sánchez", "López"};
    private int edades[] = {30, 12, 29};


    public WriteFile4() throws IOException
    {
        super("Lector de Archivos");
        editor = new TextArea();
        setLayout(new BorderLayout());
        add(editor,"Center");
        try {
            escribe = new DataOutputStream(
                  new BufferedOutputStream(
                  new FileOutputStream("inventario.dat")));

            for(int i=0;i < 3; i++) {
                escribe.writeUTF(Nombres[i]);
                escribe.writeUTF(Apellidos[i]);
                escribe.writeInt(edades[i]);
            }
        }catch(FileNotFoundException e)
         {  System.out.println("Archivo no encontrado");  }
        finally {
            if(escribe != null)
                escribe.close();
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
            WriteFile4 readFile = new WriteFile4();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}