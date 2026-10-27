package com.cardGame;
import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.util.Stack;


public class GUI extends JFrame implements ActionListener, MouseListener, MouseMotionListener{

	private Solitaire game;
	public static String IMG_PATH = System.getProperty("user.dir")+"/src/main/java/com/cardGame/resources/";
   public GUI(Solitaire game){
	   this.game= game;
        //Create and set up the window.
       setTitle("Solitaire");
       setSize(900,700);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       // this supplies the background
       try {
		Image blackImg = ImageIO.read(new File(IMG_PATH+"background.jpg"));
		
		setContentPane(new ImagePanel(blackImg));

       }catch(IOException e) {
    	   e.printStackTrace();
       }
       
       /*******
        * This is just a test to make sure images are being read correctly on your machine. Please replace
        * once you have confirmed that the card shows up properly. The code below should allow you to play the solitare
        * game once it's fully created.
        */
        Card card = new Card(2, Card.Suit.Diamonds);
        System.out.println(card);
        this.add(card); 

        

		JPanel gameArea1 = new JPanel();
		gameArea1.setOpaque(false);
		gameArea1.setSize(new Dimension(500, 20));
		gameArea1.setLayout(new FlowLayout());
		gameArea1.setBounds(0, 0, 900, 230);
		gameArea1.setBorder(BorderFactory.createMatteBorder(7,7,7,7, Color.red));
		this.add(gameArea1);
		

		JPanel gameArea2 = new JPanel();
		gameArea2.setOpaque(false);
		gameArea2.setSize(new Dimension(500, 20));
		gameArea2.setLayout(new FlowLayout());
		gameArea2.setBounds(0,230, 900, 160);
		gameArea2.setBorder(BorderFactory.createMatteBorder(7, 7, 7, 7, Color.green));
		this.add(gameArea2);
		
		JPanel gameArea3 = new JPanel();
		gameArea3.setOpaque(false);
		gameArea3.setSize(new Dimension(500, 20));
		gameArea3.setLayout(new FlowLayout());
		gameArea3.setBounds(0,390, 900, 190);
		gameArea3.setBorder(BorderFactory.createMatteBorder(7, 7, 7, 7, Color.yellow));
		this.add(gameArea3);

		Stack<Card> exampleCards = new Stack<>();
		exampleCards.push(new Card(4, Card.Suit.Clubs));
		exampleCards.push(new Card(7, Card.Suit.Hearts));
		exampleCards.push(new Card(10, Card.Suit.Spades));
		exampleCards.push(new Card(2, Card.Suit.Diamonds));

		Stack<Card> secondStack = new Stack<>();
secondStack.push(new Card(10, Card.Suit.Spades));
secondStack.push(new Card(2, Card.Suit.Diamonds));

		gameArea1.add(drawPile(exampleCards));
		gameArea1.add(drawPile(secondStack));
		this.setVisible(true);
    }

   public JLayeredPane drawPile(Stack<Card> stackIn) {
	int cardWidth=100;
	int cardHeight=145;
	int verticalOffset=25;
	JLayeredPane pile = new JLayeredPane();
    pile.setLayout(null);

    int count = stackIn.size();
    pile.setPreferredSize(new Dimension(cardWidth, count == 0 ? cardHeight : cardHeight + (count - 1) * verticalOffset));
	   Object cards[];
	    cards = stackIn.toArray(); //please note we convert this stack to an array so that we can iterate through it backwards while drawing. You’ll need to cast each element inside cards to a <Card> in order to use the methods to adjust their position
		for(int i=0; i<cards.length; i++) {
			Card card = stackIn.get(i);
        card.setBounds(0, i * verticalOffset, cardWidth, cardHeight);
        pile.add(card, Integer.valueOf(i));
		}
		return pile;
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
