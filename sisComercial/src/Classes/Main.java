package Classes;

import java.sql.SQLException;

import javax.swing.JFrame;

import Telas.Princ;


public class Main {

	public static void main(String[] args) throws SQLException {
		
		Princ frame = new Princ();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );

	}

}
