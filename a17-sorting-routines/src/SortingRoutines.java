/**
 * Program that sorts a list of random numbers between -1000 to 1000. 
 * 
 * modified     20220610
 * date         20220606
 * @filename    SortingRoutines.java
 * @author      Evan Shizas
 * @author      Alvin Chan
 * @author      Hammad Hassan
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
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerNumberModel;
import javax.swing.ButtonGroup;

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
	private JTextArea originalNumList;
	private JTextArea sortedNumList;
	private JScrollPane originalNumListScroll;
	private JScrollPane sortedNumListScroll;
	private final ButtonGroup sortTypeGroup = new ButtonGroup();
	private final ButtonGroup sortOrderGroup = new ButtonGroup();
	
	final int MAX = 1000, MIN = -1000;
	int[] result, modArray;

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

		JLabel amountSortLbl = new JLabel("Amount of Numbers to Sort: (0 - 99,999)");
		amountSortLbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		amountSortLbl.setBounds(10, 215, 245, 25);
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
		sortTypeGroup.add(selectionSort);
		selectionSort.setBackground(Color.WHITE);
		selectionSort.setBounds(135, 95, 100, 25);
		selectionSort.setSelected(true);
		contentPane.add(selectionSort);

		bubbleSort = new JRadioButton("Bubble");
		sortTypeGroup.add(bubbleSort);
		bubbleSort.setBackground(Color.WHITE);
		bubbleSort.setBounds(135, 123, 100, 25);
		contentPane.add(bubbleSort);

		insertionSort = new JRadioButton("Insertion");
		sortTypeGroup.add(insertionSort);
		insertionSort.setBackground(Color.WHITE);
		insertionSort.setBounds(135, 151, 100, 25);
		contentPane.add(insertionSort);

		quickSort = new JRadioButton("Quick");
		sortTypeGroup.add(quickSort);
		quickSort.setBackground(Color.WHITE);
		quickSort.setBounds(135, 179, 100, 25);
		contentPane.add(quickSort);

		ascendingSort = new JRadioButton("Ascending");
		sortOrderGroup.add(ascendingSort);
		ascendingSort.setBackground(Color.WHITE);
		ascendingSort.setBounds(340, 95, 100, 25);
		ascendingSort.setSelected(true);
		contentPane.add(ascendingSort);

		descendingSort = new JRadioButton("Descending");
		sortOrderGroup.add(descendingSort);
		descendingSort.setBackground(Color.WHITE);
		descendingSort.setBounds(340, 123, 108, 25);
		contentPane.add(descendingSort);

		sort = new JButton("Sort");
		sort.setBounds(340, 215, 100, 25);
		contentPane.add(sort);
		sort.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				sortActionPerformed(evt);
			}
		});
		
		numSortAmount = new JSpinner();
		numSortAmount.setModel(new SpinnerNumberModel(0, 0, 99999, 1));
		numSortAmount.setBackground(Color.WHITE);
		numSortAmount.setFont(new Font("Tahoma", Font.PLAIN, 12));
		numSortAmount.setBounds(255, 215, 75, 25);
		contentPane.add(numSortAmount);

		originalNumListScroll = new JScrollPane();
		originalNumListScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		originalNumListScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		originalNumListScroll.setBounds(10, 275, 200, 210);
		contentPane.add(originalNumListScroll);

		originalNumList = new JTextArea();
		originalNumList.setFont(new Font("Tahoma", Font.PLAIN, 14));
		originalNumList.setEditable(false);
		originalNumListScroll.setViewportView(originalNumList);

		sortedNumListScroll = new JScrollPane();
		sortedNumListScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		sortedNumListScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		sortedNumListScroll.setBounds(240, 275, 200, 210);
		contentPane.add(sortedNumListScroll);

		sortedNumList = new JTextArea();
		sortedNumList.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sortedNumList.setEditable(false);
		sortedNumListScroll.setViewportView(sortedNumList);
	}

	private void sortActionPerformed(java.awt.event.ActionEvent evt) {		
		originalNumList.setText("");
		sortedNumList.setText("");
		
		result = new int[(int) numSortAmount.getValue()];
		
		for (int i = 0; i < (int) numSortAmount.getValue(); i++) {
			result[i] = (int) (Math.random() * (MAX - MIN + 1)) + MIN;
			originalNumList.append(result[i] + "\n");
		}
		
		modArray = result;
		
		if (selectionSort.isSelected()) {
			result = selectionSortCalculation();
		}
		
		else if (bubbleSort.isSelected()) {
			result = bubbleSortCalculation();
		}
		
		else if (insertionSort.isSelected()) {
			result = insertionSortCalculation();
		}
		
		else {
			int begin = 0, end = (int) numSortAmount.getValue()-1;
			quickSortCalculation(begin, end);
		}
		
		if (descendingSort.isSelected()) {	
			for (int i = ((int) numSortAmount.getValue()) - 1; i > -1; i--) {
				sortedNumList.append(result[i] + "\n");
			}
		}
		
		else {
			for (int i = 0; i < (int) numSortAmount.getValue(); i++) {
				sortedNumList.append(result[i] + "\n");
			}
		}
	}
	
	public int[] selectionSortCalculation() {
		int temp = 0;
		
		for (int i = 0; i < ((int) numSortAmount.getValue()); i++) {
			for (int j = i+1; j < ((int) numSortAmount.getValue()); j++) {
				if (modArray[i] > modArray[j]) {
					temp = modArray[i];
					modArray[i] = modArray[j];
					modArray[j] = temp;
				}
			}
		}
		
		return modArray;
	}

	public int[] bubbleSortCalculation() {
		int temp = 0;
		boolean swap = true;
		
		while (swap) {
			swap = false;
			
			for (int i = 0; i < ((int) numSortAmount.getValue()) - 1; i++) {
				if (modArray[i] > modArray[i+1]) {
					swap = true;
					temp = modArray[i];
					modArray[i] = modArray[i+1];
					modArray[i+1] = temp;
				}
			}
		}
		
		return modArray;
	}

	public int[] insertionSortCalculation() {
		int temp = 0, j = 0;
		
		for (int i = 1; i < ((int) numSortAmount.getValue()); i++) {
			j = i;
			
			while (j > 0 && modArray[j-1] > modArray[j]) {
				temp = modArray[j];
				modArray[j] = modArray[j-1];
				modArray[j-1] = temp;
				j--;
			}
		}
		
		return modArray;
	}

	public void quickSortCalculation(int begin, int end) {
		if (begin < end) {
	        int parIndex = partition(begin, end);
	        quickSortCalculation(begin, parIndex-1);
	        quickSortCalculation(parIndex+1, end);
	    }
	}
	
	public int partition(int begin, int end) {
		int temp = 0, pivot = modArray[end], p = (begin-1);

	    for (int i = begin; i < end; i++) {
	        if (modArray[i] <= pivot) {
	            p++;

	            temp = modArray[p];
	            modArray[p] = modArray[i];
	            modArray[i] = temp;
	        }
	    }

	    temp = modArray[p+1];
	    modArray[p+1] = modArray[end];
	    modArray[end] = temp;

	    return p+1;
	}
}
