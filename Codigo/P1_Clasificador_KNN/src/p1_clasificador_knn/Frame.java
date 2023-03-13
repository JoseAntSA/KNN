/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1_clasificador_knn;

/**
 *
 * @author anton
 */
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.io.*;
import java.lang.Math;

public class Frame extends JFrame{
	
    //Atributos
    private JFrame frame;
    private JPanel pnl1, pnl2;
    private JLabel etqTitle, etqDiv, etqK, etqDiv2;
    private JRadioButton rdBtn;
    private JTextField txtK;
    private ArrayList<Review> lista;
    private Review resenia;

    //Constructor
    public Frame(){
        frame = this;
        setTitle("Clasificador KNN");
        setSize(875,680);
        setResizable(false);
        setLocationRelativeTo(null);
        initComponets();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        addWindowListener(new EventoJFrame());
    }


    public void initComponets(){

        //CODIGO ATRIBUTOS
        Font fuenteEqt = new Font( "Tw Cen MT", 1, 26 );
        Font fuenteDiv = new Font( "Tw Cen MT", 1, 22 );
        Color colorFondo = new Color(51,53,58);
        Color colorLetra = new Color(155,158,158);
        UIManager.put("OptionPane.background", colorFondo);
        UIManager.put("Panel.background", colorFondo);
        UIManager.put("OptionPane.messageForeground", colorLetra);


        //CODIGO PANEL PRINCIPAL
        pnl1 = new JPanel();
        this.getContentPane().add(pnl1);
        pnl1.setBackground(colorFondo);
        pnl1.setLayout(null);


        //CODIGO GRAFICA
        pnl2 = new JPanel();
        pnl2.setBackground(Color.WHITE);
        pnl2.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
        pnl2.setLayout(null);
        pnl2.setBounds(30,110,800,500);

        EventoPanel mouse = new EventoPanel();
        pnl2.addMouseListener(mouse);

        pnl1.add(pnl2);


        //CODIGO TITULO
        etqTitle = new JLabel("Clasificacion usando K-Nearest-Neighbor (KNN)");
        etqTitle.setForeground(colorLetra);
        etqTitle.setBounds(30,30,800,20);
        etqTitle.setFont( fuenteEqt );
        pnl1.add(etqTitle);

        etqDiv = new JLabel();
        etqDiv.setBounds(30,55,800,3);
        etqDiv.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, colorLetra));
        pnl1.add(etqDiv);


        //CODIGO RADIO BOTON
        rdBtn = new JRadioButton("Seleccionar Punto",false);
        rdBtn.setBackground(colorFondo);
        rdBtn.setForeground(colorLetra);
        rdBtn.setBounds(30,70,170,20);
        rdBtn.setFont( new Font( "Tw Cen MT", 1, 16 ) );
        pnl1.add(rdBtn);


        //CODIGO NO. VECINOS K
        etqK = new JLabel("No de vecinos K: ");
        etqK.setBounds(240,70,170,20);
        etqK.setForeground(colorLetra);
        etqK.setFont( new Font( "Tw Cen MT", 1, 16 ) );
        pnl1.add(etqK);

        txtK = new JTextField ();
        txtK.setBounds(380,70,50,20);
        txtK.setForeground(colorLetra);
        txtK.setBackground(colorFondo);
        txtK.setHorizontalAlignment(JTextField.CENTER);
        txtK.setCaretColor(Color.WHITE);
        txtK.setFont( new Font( "Tw Cen MT", 1, 18 ) );
        txtK.setBorder(BorderFactory.createLineBorder(colorFondo));
        pnl1.add(txtK);

        etqDiv2 = new JLabel("______");
        etqDiv2.setBounds(380,74,50,20);
        etqDiv2.setForeground(colorLetra);
        etqDiv2.setFont( new Font( "Tw Cen MT", 1, 15 ) );
        pnl1.add(etqDiv2);
        
        ManejoArchivos archivo = new ManejoArchivos();

        archivo.abrirArchivoLectura();
        lista = archivo.leerRegistros();
        archivo.cerrarArchivoLectura();
        
    }

    //CODIGO EVENTO WINDOW
	public class EventoJFrame implements WindowListener{
	    public void windowActivated(WindowEvent e){
                //Evento nulo
	    }

	    public void windowClosed(WindowEvent e){
	        //Evento nulo
	    }

	    public void windowClosing(WindowEvent e){
	        //Evento nulo
	    }

	    public void windowDeactivated(WindowEvent e){
	        //Evento nulo
	    }

	    public void windowDeiconified(WindowEvent e){
	        //Evento nulo
	    }

	    public void windowIconified(WindowEvent e){
	     	//Evento nulo   
	    }

	    public void windowOpened(WindowEvent e){
	        //graficarDatos();
                String s = "Para graficar un punto:";
                s += "\n1. Proporcione el numero de vecinos(k).";
                s += "\n2. Haga click dentro de la grafica.";
                s += "\n3. Proporcione los datos de la resenia.";
                s += "\n\nPara obtener informacion de un punto:";
                s += "\n1. Seleccione la opcion 'Seleccionar punto'.";
                s += "\n2. Haga click en el punto del que desee obtener informacion.";
                JOptionPane.showMessageDialog(frame, s,"Modo de uso",JOptionPane.INFORMATION_MESSAGE);
                
                graficarDatos();
	    }
	}
        
    //CODIGO EVENTO MOUSE
    public class EventoPanel implements MouseListener{
        boolean val = false;

        @Override
        public void mousePressed(MouseEvent e){
            //Se invoca cuando el botón del ratón fué pulsado.
            Plano pl = new Plano(pnl2);
            if(rdBtn.isSelected()){
                calcularDist(true, e.getX(), e.getY());
                if(lista.get(0).getDist()<0.8){
                    SubFrame1 vtn = new SubFrame1(frame, false, lista.get(0));
                }
            }else{
                int k = 0;
                if(txtK.getText().length()!=0){
                    k = Integer.parseInt(txtK.getText());
                }

                if(k<lista.size() && k>0){
                    SubFrame1 vtn = new SubFrame1(frame, true, e.getX(), e.getY());

                    resenia = vtn.getResenia();
                    calcularDist(false, 0, 0);
                    
                    String cl = algoritmoKNN(k);
                    
                    resenia.setStarRating(cl);
                    pl.dibujarPunto(resenia.getWordCount(), resenia.getSentimentValue(), cl);
                    lista.add(resenia);
                }
            }
        }
        @Override
        public void mouseReleased(MouseEvent e){
            //Se invoca cuando el botón del ratón fué soltado.
        }
        @Override
        public void mouseClicked(MouseEvent e){
            //Se invoca cuando el botón del ratón fué pulsado y soltado.
        }
        @Override
        public void mouseEntered(MouseEvent e){
            //Se invoca cuando el cursor del ratón entró a un componente.
        }      
        @Override
        public void mouseExited(MouseEvent e){
            //Se invoca cuando el cursor del ratón salió de un componente.
        }
    }//clase interna*/

    //METODOS 
    public void graficarDatos(){
        float x, y;
        String clase;
        
        Plano pl = new Plano(pnl2);
        pl.dibujarCartesiano();

        for(Review reseniaTemp: lista){
            y = reseniaTemp.getSentimentValue();
            x = reseniaTemp.getWordCount();
            clase = reseniaTemp.getStarRating();

            pl.dibujarPunto(x,y,clase);
        }
    }

    public void calcularDist(boolean opcion, int x, int y){

        double dist, x1, y1 ,x2 ,y2;

        if( opcion==true ){
            x1 = (double)(Math.round((x-60)/6));
            y1 = (-1.0)*(((double)(y)-(250.0))/60.0);
        }else{
            x1 = (double) resenia.getWordCount();
            y1 = (double) resenia.getSentimentValue();
        }

        for(Review reseniaTemp: lista){
            x2 = (double) reseniaTemp.getWordCount();
            y2 = (double) reseniaTemp.getSentimentValue();

            dist = Math.sqrt( Math.pow((x2-x1),2.0) + Math.pow((y2-y1),2.0) );
            reseniaTemp.setDist(dist);
        }
        Collections.sort(lista);
    }

    public String algoritmoKNN(int k){

        ArrayList<String> clases = new ArrayList<>();
        ArrayList<ClaseFrec> freClases = new ArrayList<>();
        ClaseFrec claseF;

        for(int i=0 ; i<k ; i++){
            clases.add(lista.get(i).getStarRating());
        }
        for(int i=1 ; i<=5 ; i++){
            String c = "" + i;
            freClases.add(new ClaseFrec(c, Collections.frequency(clases, c)));

        }
        Collections.sort(freClases);

        for(int i=0 ; i<5 ; i++){
            claseF = freClases.get(i);
            System.out.print("\nClase " + claseF.getClase() + ": " + claseF.getFrec());
        }
        System.out.print("\n");

        claseF = freClases.get(0);
        return claseF.getClase(); 
    }
}
