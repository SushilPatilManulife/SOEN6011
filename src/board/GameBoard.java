package board;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;

import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
public class GameBoard extends JFrame implements ActionListener {

	private JPanel contentPane;
	JButton btnOnGameBoard[] = new JButton[10];
	
	JPanel gameBoardPannel = new JPanel(),
	menuPannel = new JPanel(),
	scoreBoardPannel = new JPanel(),
	playerTurnPannel = new JPanel(),
	helpPanel = new JPanel();
	
	JLabel lblPlayerMove=new JLabel(),
	lblPlayer2Score = new JLabel("Player 2: 1"),
	lblPlayer1Score = new JLabel("Player 1: 0"),
	lblScoreBoard = new JLabel("Score Board");
	
	JMenuBar newGameMenu = new JMenuBar();
	JMenuItem mnNewGame = new JMenu("New Game  "),
	mnHelp = new JMenu("Help");
	
	JTextArea helpText = new JTextArea();
	
	int checkPlayer=0;
	String turn, player1="Player 1", player2="Player 2";
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameBoard frame = new GameBoard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GameBoard() {
		setTitle("Tic Tac Toe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 524, 304);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
			
		gameBoardPannel.setBounds(25, 56, 314, 191);
		contentPane.add(gameBoardPannel);
		gameBoardPannel.setLayout(new GridLayout(0, 3, 0, 0));
		
		menuPannel.setBounds(0, 0, 116, 31);
		contentPane.add(menuPannel);
		menuPannel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
				
		menuPannel.add(newGameMenu);
		newGameMenu.setToolTipText("");
		mnNewGame.setAlignmentX(Component.LEFT_ALIGNMENT);
				
		mnNewGame.setToolTipText("Start new game");
		newGameMenu.add(mnNewGame);
		newGameMenu.add(mnHelp);
		helpPanel.setVisible(false);
		helpPanel.setBounds(176, 71, 202, 157);
		
		contentPane.add(helpPanel);
				
		scoreBoardPannel.setBorder(new LineBorder(new Color(0, 0, 0)));
		scoreBoardPannel.setBounds(373, 56, 125, 83);
		contentPane.add(scoreBoardPannel);
		scoreBoardPannel.setLayout(null);
				
		lblPlayer2Score.setBounds(23, 58, 108, 14);
		scoreBoardPannel.add(lblPlayer2Score);
		
		lblPlayer1Score.setBounds(23, 33, 108, 14);
		scoreBoardPannel.add(lblPlayer1Score);
				
		lblScoreBoard.setBounds(23, 8, 91, 14);
		scoreBoardPannel.add(lblScoreBoard);
				
		playerTurnPannel.setBounds(388, 150, 110, 49);
		contentPane.add(playerTurnPannel);
		playerTurnPannel.setLayout(null);
		//lblNewLabel.setBounds(0, 11, 110, 14);
		lblPlayerMove.setBounds(0, 11, 110, 14);
		playerTurnPannel.add(lblPlayerMove);
						
		for(int i = 0 ; i < 9 ; i++){
			btnOnGameBoard[i]=new JButton();
			
			btnOnGameBoard[i].setFont(new Font("Tahoma", Font.BOLD, 40));
			btnOnGameBoard[i].addActionListener(this);
			btnOnGameBoard[i].setBackground(new Color(0,0,0));
			btnOnGameBoard[i].setForeground(new Color(255,255,255));
			gameBoardPannel.add(btnOnGameBoard[i]);
			
		}
			
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object checkClick=e.getSource();
		for (int i = 0; i < 9 ; i++) {
			if(checkClick==btnOnGameBoard[i] && checkPlayer < 9 ){
				if(checkPlayer % 2 == 0){
					btnOnGameBoard[i].setText("X");
					btnOnGameBoard[i].setEnabled(false);
				}
				else{
					btnOnGameBoard[i].setForeground(new Color(255,0,0));
					btnOnGameBoard[i].setText("0");	
					btnOnGameBoard[i].setEnabled(false);
				}
				checkPlayerTurn();
				checkPlayer++;
			}
		}
		if(checkClick==mnHelp){
			helpPanel.setVisible(true);
			helpText.setText("Temporary\n\n\n\n\n Information ");
			helpPanel.add(helpText);
		}
	}
	public void checkPlayerTurn() {
		if(checkPlayer % 2 == 0) {
		turn = player2;
		} else {
		turn = player1;
		}
		lblPlayerMove.setText("Turn: " + turn);
	}
	public void getHelp(){
		
	}
}
