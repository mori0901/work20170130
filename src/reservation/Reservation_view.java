package reservation;

import java.awt.BorderLayout;


import java.awt.Button;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


public class Reservation_view 
extends Frame implements ActionListener,WindowListener,KeyListener

{

Reservation_control rcontrol;
Panel panelNorth;         
Panel panelNorthSub1;    
Panel panelNorthSub2;    
Panel panelNorthSub3;   
Panel panelMid;           
Panel panelSouth;       
Button buttonLog;       
Button buttonExplanation;    
Button buttonVacancy;    
Button buttonReservation;  
Button buttonConfirm;    
Button buttonCancel;    
ChoiceFacility choiceFacility;    
TextField tfYear, tfMonth, tfDay;    
TextArea textMessage;    


public Reservation_view(Reservation_control rcontrol) {


    this.rcontrol = rcontrol;

        addWindowListener(this);

        addKeyListener(this);

    
             buttonLog = new Button("ÉçÉOÉCÉì");

             buttonExplanation = new Button("é{ê›äTóv");

             buttonVacancy = new Button("ãÛÇ´èÛãµämîF");

             buttonReservation = new Button("êVãKó\ñÒ");

             buttonConfirm = new Button("ó\ñÒÇÃämîF");

             buttonCancel = new Button("ó\ñÒÇÃÉLÉÉÉìÉZÉã");


             choiceFacility = new ChoiceFacility();

             tfYear = new TextField("",4);

             tfMonth = new TextField("",2);

             tfDay = new TextField("",2);


          

             setLayout( new BorderLayout());


             

             panelNorthSub1 = new Panel();

             panelNorthSub1.add(new Label("é{ê›ó\ñÒÉVÉXÉeÉÄ"));

             panelNorthSub1.add(buttonLog);


             

             panelNorthSub2 = new Panel();

             panelNorthSub2.add(new Label("é{ê›"));

             panelNorthSub2.add( choiceFacility);

             panelNorthSub2.add(new Label(" "));

             panelNorthSub2.add( buttonExplanation);


             

             panelNorthSub3 = new Panel();

             panelNorthSub3.add(new Label(" "));

             panelNorthSub3.add(tfYear);

             panelNorthSub3.add(new Label("îN"));

             panelNorthSub3.add(tfMonth);

             panelNorthSub3.add(new Label("åé"));

             panelNorthSub3.add(tfDay);

             panelNorthSub3.add(new Label("ì˙"));

             panelNorthSub3.add( buttonVacancy);


             

             panelNorth = new Panel(new BorderLayout());

             panelNorth.add(panelNorthSub1, BorderLayout.NORTH);

             panelNorth.add(panelNorthSub2, BorderLayout.CENTER);

             panelNorth.add(panelNorthSub3, BorderLayout.SOUTH);


            

             add(panelNorth,BorderLayout.NORTH);


             

             panelMid = new Panel();

             textMessage = new TextArea( 20, 80);

             textMessage.setEditable(false);

             panelMid.add(textMessage);


            

             add( panelMid,BorderLayout.CENTER);


             

             panelSouth = new Panel();

             panelSouth.add(buttonReservation);

             panelSouth.add(new Label(" "));

             panelSouth.add(buttonConfirm);

             panelSouth.add(new Label(" "));

             panelSouth.add(buttonCancel);


             
             add( panelSouth,BorderLayout.SOUTH);


             
             buttonLog.addActionListener(this);

             buttonExplanation.addActionListener(this);

             buttonVacancy.addActionListener(this);

             buttonReservation.addActionListener(this);

             buttonConfirm.addActionListener(this);

             buttonCancel.addActionListener(this);


}

 







	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	public Reservation_view() throws HeadlessException {
		super();
	}





	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

String result = new String();

        textMessage.setText("");

        if ( e.getSource() == buttonVacancy){ 
        	
            result = rcontrol.getReservationOn(choiceFacility.getSelectedItem(), tfYear.getText(), tfMonth.getText(), tfDay.getText());

        }
          else if (e.getSource() == buttonLog){

            result = rcontrol.loginLogout(this);

        }
          else if (e.getSource() == buttonReservation){

              result = rcontrol.makeReservation(this);
          }
          else  if ( e.getSource() == buttonExplanation){ 
         	
             result = rcontrol.getExplanationOn(choiceFacility.getSelectedItem());

         }
          else if(e.getSource()==buttonConfirm){
        	  result = rcontrol.confirmReservation(choiceFacility.getSelectedItem());
          }
          else if (e.getSource() == buttonCancel){

              result = rcontrol.cancelReservation(this);
          }
         

textMessage.setText(result);



	}

}
