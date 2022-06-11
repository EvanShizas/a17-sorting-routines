package alvin_work;
/**
 * Program that displays a list of random numbers between -10000 and 10000, both sorted and unsorted.
 * 
 * modified     20220606
 * date         20220606
 * @filename    SortingEfficiencies.java
 * @author      Evan Shizas
 * @author      Alvin Chan
 * @version     1.0.0
 * @see         A17 - Sorting Routines
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;

import java.lang.Math;

public class SortingEfficiencies extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	final int MIN = -10000;
	final int MAX = 10000;
	int n = 1;
	String order;
	int loopCounter = 0;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SortingEfficiencies frame = new SortingEfficiencies();
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
	public SortingEfficiencies() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 669, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sorting Efficiencies");
		lblNewLabel.setBounds(257, 11, 109, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter the amount of numbers in the list:");
		lblNewLabel_1.setBounds(10, 31, 198, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Sort Order");
		lblNewLabel_2.setBounds(10, 102, 65, 14);
		contentPane.add(lblNewLabel_2);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("Ascending");
		rdbtnNewRadioButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				order = "ascending";
			}
		});
		buttonGroup_1.add(rdbtnNewRadioButton_4);
		rdbtnNewRadioButton_4.setBounds(74, 98, 109, 23);
		contentPane.add(rdbtnNewRadioButton_4);
		
		JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("Descending");
		rdbtnNewRadioButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				order = "descending";
			}
		});
		buttonGroup_1.add(rdbtnNewRadioButton_5);
		rdbtnNewRadioButton_5.setBounds(74, 124, 109, 23);
		contentPane.add(rdbtnNewRadioButton_5);
		
		JLabel lblNewLabel_3 = new JLabel("Original Numbers");
		lblNewLabel_3.setBounds(10, 157, 89, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Sorted Numbers");
		lblNewLabel_4.setBounds(103, 154, 80, 14);
		contentPane.add(lblNewLabel_4);
		
		JTextArea txtOrig = new JTextArea();
		txtOrig.setBounds(10, 178, 65, 173);
		contentPane.add(txtOrig);
		
		JTextArea txtSorted = new JTextArea();
		txtSorted.setBounds(103, 178, 65, 173);
		contentPane.add(txtSorted);
		
		JLabel lblNewLabel_5 = new JLabel("Sort Results");
		lblNewLabel_5.setBounds(220, 80, 89, 14);
		contentPane.add(lblNewLabel_5);
		
		JTextArea txtResult = new JTextArea();
		txtResult.setBounds(213, 108, 430, 243);
		contentPane.add(txtResult);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("10");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				n = 10;
			}
		});
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(214, 32, 51, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("100");
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				n = 100;
			}
		});
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(267, 32, 46, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("1000");
		rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				n = 1000;
			}
		});
		buttonGroup.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.setBounds(318, 32, 57, 23);
		contentPane.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("5000");
		rdbtnNewRadioButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				n = 5000;
			}
		});
		buttonGroup.add(rdbtnNewRadioButton_3);
		rdbtnNewRadioButton_3.setBounds(377, 32, 57, 23);
		contentPane.add(rdbtnNewRadioButton_3);
		
		JButton btnNewButton = new JButton("Sort Numbers");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] a = new int[n];
				String output = "";
				txtOrig.setText("");
				loopCounter = 0;
				
				for (int i = 0; i < n; i++) {
					a[i] = (int)Math.round(Math.random() * (MAX - MIN) + MIN);
					output += Integer.toString(a[i]);
					output += "\n";
				}
				
				txtOrig.setText(output);
				
				output = "";
				int[] sortedA = new int[n];
				sortedA = selectionSort(a, n);
				/*if (selectionSort(a, n) != bubbleSort(a, n) && bubbleSort(a, n) != next sort)
					error: sort not equal
				*/
				switch (order) {
				case "ascending":
					// combine with previous for loop
					for (int i = 0; i < n; i++) {
						output += Integer.toString(sortedA[i]);
						output += "\n";
					}
					break;
				case "descending":
					for (int i = n-1; i > 0; i--) {
						output += Integer.toString(sortedA[i]);
						output += "\n";
					}
					break;
				}
				txtSorted.setText(output);
				
				output = "";
				output += "SELECTION SORT:";
				output += "\n";
				output += "loopCounter = " + loopCounter;
				output += "\n";
				//output += "comparisonCounter = " + comparisonCounter;
				output += "\n";
				//output += "shiftCounter = " + shiftCounter;
				output += "\n";
				txtResult.setText(output);
			}
		});
		btnNewButton.setBounds(20, 56, 125, 23);
		contentPane.add(btnNewButton);
	}
	
	int[] selectionSort(int[] a, int n) {
		int temp;
		
		for (int i = 0; i < n-1; i++) {
			for (int j = i+1; j < n; j++) {
				if (a[i] > a[j]) {
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
					
					loopCounter++;
				}
			}
		}
		
		return a;
	}
	
	int[] bubbleSort(int[] a, int n) {
		boolean swap = true;
		int temp;
		while (swap) {
			swap = false;
			for (int i = 0; i < n-1; i++) {
				if (a[i] > a[i+1]) {
					temp = a[i];
					a[i] = a[i+1];
					a[i+1] = temp;
				}
			}
		}
		
		return a;
	}
}
