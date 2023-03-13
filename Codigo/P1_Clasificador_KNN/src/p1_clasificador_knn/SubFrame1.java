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
import java.awt.event.*;

public class SubFrame1 extends JDialog{
	
    //Atributos
    private JPanel pnl1;
    private JLabel etqAtr1, etqAtr2, etqAtr3, etqAtr4, etqAtr5, etqAtr6;
    private JLabel etqDiv1, etqDiv2, etqDiv3, etqDiv4, etqDiv5, etqDiv6;
    private JTextField txtAtr1, txtAtr2, txtAtr3, txtAtr4, txtAtr5, txtAtr6;
    private JTextArea txtAtr;
    private JScrollPane barraNav1;
    private JButton btnSave;
    private Review resenia;
    private int x, y;

    public void setPos( int x, int y ){
        this.x = x;
        this.y = y;
    }
    public void setResenia( Review resenia ){
        this.resenia = resenia;
    }
    public Review getResenia(){
        return resenia;
    }

    //Constructor
    public SubFrame1(JFrame padre, boolean val, int x, int y){
        super(padre, true);
        setPos(x,y);
        setTitle("Datos de Review");
        setSize(465,335);
        setResizable(false);
        setLocationRelativeTo(null);
        initComponets( val );
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public SubFrame1(JFrame padre, boolean val, Review resenia){
        super(padre, true);
        setResenia(resenia);
        setTitle("Datos de Review");
        setSize(465,270);
        setResizable(false);
        setLocationRelativeTo(null);
        initComponets( val );
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public void initComponets(boolean val){

        //CODIGO ATRIBUTOS
        Font fuenteDiv = new Font( "Tw Cen MT", 1, 15 );
        Color colorFondo = new Color(51,53,58);
        Color colorLetra = new Color(155,158,158);
		

        //CODIGO PANEL CENTRAL
        pnl1 = new JPanel();
        this.getContentPane().add(pnl1);
        pnl1.setBackground(colorFondo);
        pnl1.setLayout(null);
 		

    	//CODIGO TITULO DE LA RESEÑA
        txtAtr1 = new JTextField ();
        txtAtr1.setBounds(25,25,200,20);
        txtAtr1.setForeground(colorLetra);
        txtAtr1.setBackground(colorFondo);
        txtAtr1.setBorder(BorderFactory.createLineBorder(colorFondo));
        txtAtr1.setCaretColor(Color.WHITE);
        txtAtr1.setEditable(val);
        pnl1.add(txtAtr1);

        etqDiv1 = new JLabel("_________________________");
        etqDiv1.setForeground(colorLetra);
        etqDiv1.setBounds(25,32,200,20);
        etqDiv1.setFont( fuenteDiv );
        pnl1.add(etqDiv1);

        etqAtr1 = new JLabel("Titulo de la resenia");
        etqAtr1.setForeground(colorLetra);
        etqAtr1.setBounds(25,48,200,20);
        etqAtr1.setFont( fuenteDiv );
        pnl1.add(etqAtr1);


        //CODIGO CALIFICACION DE APP
        txtAtr2 = new JTextField ("- - -");
        txtAtr2.setBounds(305,25,120,20);
        txtAtr2.setForeground(colorLetra);
        txtAtr2.setBackground(colorFondo);
        txtAtr2.setBorder(BorderFactory.createLineBorder(colorFondo));
        txtAtr2.setCaretColor(Color.WHITE);
        txtAtr2.setEditable(false);
        pnl1.add(txtAtr2);

        etqDiv2 = new JLabel("_______________");
        etqDiv2.setBounds(305,32,120,20);
        etqDiv2.setForeground(colorLetra);
        etqDiv2.setFont( fuenteDiv );
        pnl1.add(etqDiv2);

        etqAtr2 = new JLabel("Cal. de App");
        etqAtr2.setBounds(305,48,120,20);
        etqAtr2.setForeground(colorLetra);
        etqAtr2.setFont( fuenteDiv );
        pnl1.add(etqAtr2);


        //CODIGO CONTENIDO DE LA RESEÑA
        etqAtr3 = new JLabel("Contenido de la resenia:");
        etqAtr3.setBounds(25,80,200,20);
        etqAtr3.setForeground(colorLetra);
        etqAtr3.setFont( fuenteDiv );
        pnl1.add(etqAtr3);

        etqDiv3 = new JLabel("__________________________________________________");
        etqDiv3.setBounds(25,84,400,20);
        etqDiv3.setForeground(colorLetra);
        etqDiv3.setFont( fuenteDiv );
        pnl1.add(etqDiv3);

        txtAtr = new JTextArea ();
        txtAtr.setLineWrap(true);
        txtAtr.setWrapStyleWord(true);
        txtAtr.setForeground(colorLetra);
        txtAtr.setBackground(colorFondo);
        txtAtr.setBorder(BorderFactory.createLineBorder(colorFondo));
        txtAtr.setCaretColor(Color.WHITE);
        txtAtr.setEditable(val);
        barraNav1 = new JScrollPane(txtAtr);
        barraNav1.setBounds(25,103,400,55);
        barraNav1.setBorder(BorderFactory.createLineBorder(colorFondo));
        pnl1.add(barraNav1);

      
        //CODIGO NO. DE PALABRAS
        txtAtr4 = new JTextField();
        txtAtr4.setBounds(25,180,120,20);
        txtAtr4.setForeground(colorLetra);
        txtAtr4.setBackground(colorFondo);
        txtAtr4.setBorder(BorderFactory.createLineBorder(colorFondo));
        txtAtr4.setEditable(false);
        pnl1.add(txtAtr4);

        etqDiv4 = new JLabel("_______________");
        etqDiv4.setBounds(25,187,120,20);
        etqDiv4.setForeground(colorLetra);
        etqDiv4.setFont( fuenteDiv );
        pnl1.add(etqDiv4);

        etqAtr4 = new JLabel("No. de palabras");
        etqAtr4.setBounds(25,203,120,20);
        etqAtr4.setForeground(colorLetra);
        etqAtr4.setFont( fuenteDiv );
        pnl1.add(etqAtr4);


        //CODIGO TIPO DE COMENTARIO
        txtAtr5 = new JTextField();
        txtAtr5.setBounds(165,180,120,20);
        txtAtr5.setForeground(colorLetra);
        txtAtr5.setBackground(colorFondo);
        txtAtr5.setBorder(BorderFactory.createLineBorder(colorFondo));
        txtAtr5.setEditable(false);
        pnl1.add(txtAtr5);

        etqDiv5 = new JLabel("_______________");
        etqDiv5.setBounds(165,187,120,20);
        etqDiv5.setForeground(colorLetra);
        etqDiv5.setFont( fuenteDiv );
        pnl1.add(etqDiv5);

        etqAtr5 = new JLabel("Tipo de resenia");
        etqAtr5.setBounds(165,203,120,20);
        etqAtr5.setForeground(colorLetra);
        etqAtr5.setFont( fuenteDiv );
        pnl1.add(etqAtr5);


        //CODIGO VALORACION DEL COMENTARIO
        txtAtr6 = new JTextField();
        txtAtr6.setBounds(305,180,120,20);
        txtAtr6.setForeground(colorLetra);
        txtAtr6.setBackground(colorFondo);
        txtAtr6.setBorder(BorderFactory.createLineBorder(colorFondo));
        txtAtr6.setEditable(false);
        pnl1.add(txtAtr6);

        etqDiv6 = new JLabel("_______________");
        etqDiv6.setBounds(305,187,120,20);
        etqDiv6.setForeground(colorLetra);
        etqDiv6.setFont( fuenteDiv );
        pnl1.add(etqDiv6);

        etqAtr6 = new JLabel("Val. de resenia");
        etqAtr6.setBounds(305,203,120,20);
        etqAtr6.setForeground(colorLetra);
        etqAtr6.setFont( fuenteDiv );
        pnl1.add(etqAtr6);


        //CODIGO BOTON GUARDAR
        Color colorBtn = new Color(144,144,144);
        btnSave = new JButton("Guardar");
        btnSave.setBounds(185,245,80,30);
        btnSave.setBackground(colorBtn);
        btnSave.setBorder(BorderFactory.createLineBorder(colorBtn)); 
        btnSave.setForeground(Color.WHITE); 
        btnSave.setFocusPainted(false);
        btnSave.addActionListener(new EventoBoton());

        pnl1.add(btnSave);

        if(val == false){
            mostrarResenia(resenia);
        }else{
            mostrarPosicion();
        }
    }	

    //CODIGO EVENTO ACTION
    public class EventoBoton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ev){
            guardarResenia();
            dispose();
        }//evento
    }//clase interna

    //CODIGO METODOS
    public void guardarResenia(){
        Review nuevaR = new Review();

        nuevaR.setReviewTitle(txtAtr1.getText());
        nuevaR.setReviewText(txtAtr.getText());
        nuevaR.setTitleSentiment(txtAtr5.getText());
        nuevaR.setTextSentiment(txtAtr5.getText());
        nuevaR.setStarRating(txtAtr2.getText());
        nuevaR.setWordCount(Integer.parseInt(txtAtr4.getText()));
        nuevaR.setSentimentValue(Float.parseFloat(txtAtr6.getText()));

        setResenia(	nuevaR );
    }

    public void mostrarResenia(Review resenia){
        txtAtr1.setText(resenia.getReviewTitle());
        txtAtr.setText(resenia.getReviewText());
        txtAtr5.setText(resenia.getTitleSentiment());
        txtAtr5.setText(resenia.getTextSentiment());
        txtAtr2.setText(resenia.getStarRating());
        txtAtr4.setText(String.valueOf((int)(resenia.getWordCount())));
        txtAtr6.setText(String.valueOf(resenia.getSentimentValue()));
    }

    public void mostrarPosicion(){
        int xt = (int)(Math.round((x-60)/6));
        float yt = (-1)*(((float)(y)-(250))/60);

        txtAtr4.setText(String.valueOf(xt));
        txtAtr6.setText(String.valueOf(yt));

        if(Float.parseFloat(txtAtr6.getText())<0.0){
            txtAtr5.setText("negative");
        }else{
            txtAtr5.setText("positive");
        }
    }
}
