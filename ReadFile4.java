
/**
 * Clase que muestra los objetos Buffer de Lineas.
 * 
 * @author Roberto Salazar Marquez
 * @version 1.0
 */
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class ReadFile4 extends Frame
{
    TextArea editor;
    DataInputStream lee;

    public ReadFile4() throws IOException
    {
        super("Lector de Archivos");
        editor = new TextArea();
        String c;
        setLayout(new BorderLayout());
        add(editor,"Center");
        try {
            lee = new DataInputStream(
                   new BufferedInputStream(
                   new FileInputStream("inventario.dat")));


            while(true) {
                String nom = lee.readUTF();
                String ap = lee.readUTF();
                int ed = lee.readInt();
                c = nom + " " + ap + " Edad: " + ed + '\n';
                editor.append(c);
            }
    
        }catch(EOFException e)
         {   }
        finally {
            if(lee != null)
                lee.close();
        }

        addWindowListener(new CW() );
        setSize(300,270);
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
            ReadFile4 readFile = new ReadFile4();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}