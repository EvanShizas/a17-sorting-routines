/**
 * Program that sorts a list of random numbers between -1000 to 1000.
 * 
 * modified     20220607
 * date         20220606
 * @filename    SortingRoutines.java
 * @author      Evan Shizas, Alvin Chan
 * @version     1.0.0
 * @see         A17 - Sorting Routines
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerNumberModel;

public class SortingRoutines extends JFrame {

	private JPanel contentPane;

	private JRadioButton selectionSort;
	private JRadioButton bubbleSort;
	private JRadioButton insertionSort;
	private JRadioButton quickSort;
	private JRadioButton ascendingSort;
	private JRadioButton descendingSort;
	private JSpinner numSortAmount;
	private JButton sort;
	private JTextPane originalNumList;
	private JTextPane sortedNumList;
	private JScrollPane originalNumListScroll;
	private JScrollPane sortedNumListScroll;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SortingRoutines frame = new SortingRoutines();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SortingRoutines() {
		setTitle("A17 - Sorting Routines");
		setResizable(false);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 530);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel title = new JLabel("Sorting Routines");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setForeground(Color.BLUE);
		title.setFont(new Font("Tahoma", Font.BOLD, 30));
		title.setBackground(Color.WHITE);
		title.setBounds(0, 0, 448, 55);
		contentPane.add(title);

		JLabel enterBelowLbl = new JLabel("Enter the Following Information:");
		enterBelowLbl.setFont(new Font("Tahoma", Font.BOLD, 13));
		enterBelowLbl.setBackground(Color.WHITE);
		enterBelowLbl.setBounds(10, 55, 233, 30);
		contentPane.add(enterBelowLbl);

		JLabel algorithmTypeLbl = new JLabel("Sorting Algorithm:");
		algorithmTypeLbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		algorithmTypeLbl.setBackground(Color.WHITE);
		algorithmTypeLbl.setBounds(10, 95, 120, 25);
		contentPane.add(algorithmTypeLbl);

		JLabel orderTypeLbl = new JLabel("Sort Order:");
		orderTypeLbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		orderTypeLbl.setBackground(Color.WHITE);
		orderTypeLbl.setBounds(250, 95, 85, 25);
		contentPane.add(orderTypeLbl);

		JLabel amountSortLbl = new JLabel("Amount of Numbers to Sort: (0 - 999,999)");
		amountSortLbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		amountSortLbl.setBounds(10, 215, 255, 25);
		contentPane.add(amountSortLbl);

		JLabel originalNumbersLbl = new JLabel("Original Numbers:");
		originalNumbersLbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		originalNumbersLbl.setBackground(Color.WHITE);
		originalNumbersLbl.setBounds(10, 251, 110, 25);
		contentPane.add(originalNumbersLbl);

		JLabel sortedNumbersLbl = new JLabel("Sorted Numbers:");
		sortedNumbersLbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		sortedNumbersLbl.setBackground(Color.WHITE);
		sortedNumbersLbl.setBounds(240, 251, 110, 25);
		contentPane.add(sortedNumbersLbl);

		selectionSort = new JRadioButton("Selection");
		selectionSort.setBackground(Color.WHITE);
		selectionSort.setBounds(135, 95, 100, 25);
		selectionSort.setSelected(true);
		contentPane.add(selectionSort);
		selectionSort.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				selectionSortActionPerformed(evt);
			}
		});

		bubbleSort = new JRadioButton("Bubble");
		bubbleSort.setBackground(Color.WHITE);
		bubbleSort.setBounds(135, 123, 100, 25);
		contentPane.add(bubbleSort);
		bubbleSort.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				bubbleSortActionPerformed(evt);
			}
		});

		insertionSort = new JRadioButton("Insertion");
		insertionSort.setBackground(Color.WHITE);
		insertionSort.setBounds(135, 151, 100, 25);
		contentPane.add(insertionSort);
		insertionSort.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				insertionSortActionPerformed(evt);
			}
		});

		quickSort = new JRadioButton("Quick");
		quickSort.setBackground(Color.WHITE);
		quickSort.setBounds(135, 179, 100, 25);
		contentPane.add(quickSort);
		quickSort.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				quickSortActionPerformed(evt);
			}
		});

		ascendingSort = new JRadioButton("Ascending");
		ascendingSort.setBackground(Color.WHITE);
		ascendingSort.setBounds(340, 95, 100, 25);
		ascendingSort.setSelected(true);
		contentPane.add(ascendingSort);
		ascendingSort.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				ascendingSortActionPerformed(evt);
			}
		});

		descendingSort = new JRadioButton("Descending");
		descendingSort.setBackground(Color.WHITE);
		descendingSort.setBounds(340, 123, 100, 25);
		contentPane.add(descendingSort);
		descendingSort.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				descendingSortActionPerformed(evt);
			}
		});

		sort = new JButton("Sort");
		sort.setBounds(365, 215, 75, 25);
		contentPane.add(sort);
		sort.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				sortActionPerformed(evt);
			}
		});
		
		numSortAmount = new JSpinner();
		numSortAmount.setModel(new SpinnerNumberModel(0, 0, 999999, 1));
		numSortAmount.setBackground(Color.WHITE);
		numSortAmount.setFont(new Font("Tahoma", Font.PLAIN, 12));
		numSortAmount.setBounds(265, 215, 75, 25);
		contentPane.add(numSortAmount);

		originalNumListScroll = new JScrollPane();
		originalNumListScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		originalNumListScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		originalNumListScroll.setBounds(10, 275, 200, 210);
		contentPane.add(originalNumListScroll);

		originalNumList = new JTextPane();
		originalNumList.setFont(new Font("Tahoma", Font.PLAIN, 14));
		originalNumList.setEditable(false);
		originalNumListScroll.setViewportView(originalNumList);

		sortedNumListScroll = new JScrollPane();
		sortedNumListScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		sortedNumListScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		sortedNumListScroll.setBounds(240, 275, 200, 210);
		contentPane.add(sortedNumListScroll);

		sortedNumList = new JTextPane();
		sortedNumList.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sortedNumList.setEditable(false);
		sortedNumListScroll.setViewportView(sortedNumList);
	}

	private void sortActionPerformed(java.awt.event.ActionEvent evt) {
		
	}
	
	private void selectionSortActionPerformed(java.awt.event.ActionEvent evt) {
		bubbleSort.setSelected(false);
		insertionSort.setSelected(false);
		quickSort.setSelected(false);
	}

	private void bubbleSortActionPerformed(java.awt.event.ActionEvent evt) {
		selectionSort.setSelected(false);
		insertionSort.setSelected(false);
		quickSort.setSelected(false);
	}
	
	private void insertionSortActionPerformed(java.awt.event.ActionEvent evt) {
		selectionSort.setSelected(false);
		bubbleSort.setSelected(false);
		quickSort.setSelected(false);
	}
	
	private void quickSortActionPerformed(java.awt.event.ActionEvent evt) {
		selectionSort.setSelected(false);
		bubbleSort.setSelected(false);
		insertionSort.setSelected(false);
	}
	
	private void ascendingSortActionPerformed(java.awt.event.ActionEvent evt) {
		descendingSort.setSelected(false);
	}
	
	private void descendingSortActionPerformed(java.awt.event.ActionEvent evt) {
		ascendingSort.setSelected(false);
	}
}
