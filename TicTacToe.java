/*Simple Tic Tac Toe Game created by Fatima Syeda on 16 March 2024 */

//Import Java Swing libraries
import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

//Create a TicTacToe class which extends JFrame and implements ActionListener
public class TicTacToe extends JFrame implements ActionListener {

	// Create an array of buttons for the game
	JButton[] spot = new JButton[9];

	// Declare and initialize all variables
	boolean x = true;
	Font buttonFont;
	int count = 0;
	boolean end = false;

	TicTacToe() {

		// Make font object
		buttonFont = new Font("Lucida Console", Font.PLAIN, 100);

		// Set the size and tile of the window
		setSize(600, 600);
		setTitle("Tic Tac Toe");

		// Create main JPanel
		JPanel mainP = new JPanel();
		mainP.setLayout(new GridLayout(3, 3));
		mainP.setBorder(new LineBorder(new Color(0, 0, 0)));

		// Instantiate all buttons
		for (int i = 0; i < 9; ++i) {
			spot[i] = new JButton();
			spot[i].addActionListener(this);
			spot[i].setBackground(new Color(0, 0, 0));

			// Add the buttons to the main panel
			mainP.add(spot[i]);

		}

		// Add the main panel to the JFrame
		add(mainP);

		setVisible(true);

	}// end TicTacToe()

	public void actionPerformed(ActionEvent e) {

		// When a button is clicked, put "x" or "O" on the spot
		for (int i = 0; i < 9; i++) {
			if (e.getSource() == spot[i] && x == true) {
				spot[i].setText("X");
				spot[i].setEnabled(false);
				x = false;
				count++;

			}

			else if (e.getSource() == spot[i]) {
				spot[i].setText("O");
				spot[i].setEnabled(false);
				x = true;
				count++;

			}

			spot[i].setFont(buttonFont);

		}

		// Call function to check winner
		checkWinner(spot);

	}// end actionPerformed(ActionEvent e)

	void checkWinner(JButton[] spot) {
		for (int i = 0; i < 9; i++) {

			// check rows
			if ((i % 3 == 0)
					&& (spot[i].getText() == spot[i + 1].getText() && spot[i].getText() == spot[i + 2].getText())
					&& !spot[i].isEnabled()) {
				JOptionPane.showMessageDialog(null, spot[i].getText() + " wins!");
				end = true;

				// Check columns
			} else if ((spot[i].getText() == spot[i + 3].getText() && spot[i].getText() == spot[i + 6].getText())
					&& !spot[i].isEnabled()) {
				JOptionPane.showMessageDialog(null, spot[i].getText() + " wins!");
				end = true;
			}

			// Check diagnols
			else if ((spot[0].getText() == spot[4].getText() && spot[0].getText() == spot[8].getText())
					&& !spot[0].isEnabled()) {
				JOptionPane.showMessageDialog(null, spot[0].getText() + " wins!");
				end = true;
			}

			else if ((spot[2].getText() == spot[4].getText() && spot[2].getText() == spot[6].getText())
					&& !spot[2].isEnabled()) {
				JOptionPane.showMessageDialog(null, spot[2].getText() + " wins!");
				end = true;

			}

			// If game ended, call resetGame function
			if (end == true)

				// reset the game
				resetGame(spot);

			// If it's a tie, display message and call reset function
			else if (end == false && count == 9) {
				JOptionPane.showMessageDialog(null, "It's a Tie!");
				resetGame(spot);

			}

		}
	}// end checkWinner()

	void resetGame(JButton[] spot) {
		for (int i = 0; i < 9; i++) {
			spot[i].setText("");
			spot[i].setEnabled(true);

			// initialize all variables
			x = true;
			count = 0;
			end = false;
		}
	}// end resetGame()

	public static void main(String[] args) {
		new TicTacToe();

	}// end main

}