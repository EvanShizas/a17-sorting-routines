/**
 * Program that displays a list of random numbers between -10000 and 10000, both sorted and unsorted.
 * 
 * modified     20220610
 * date         20220606
 * @filename    SortingEfficiencies.java
 * @author      Evan Shizas
 * @author      Alvin Chan
 * @author      Hammad Hassan
 * @version     1.0.0
 * @see         A17 - Sorting Routines
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.Arrays;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class SortingEfficiencies extends JFrame {

	private JPanel contentPane;
	private JRadioButton tenNums;
	private JRadioButton hundredNums;
	private JRadioButton thousandNums;
	private JRadioButton fivethousandNums;
	private JRadioButton ascendingSort;
	private JRadioButton descendingSort;
	private JButton sort;
	private JTextArea originalNumList;
	private JTextArea sortedNumList;
	private JTextArea sortResultsList;
	private JScrollPane originalNumListScroll;
	private JScrollPane sortedNumListScroll;
	private JScrollPane sortResultsListScroll;
	private final ButtonGroup numberAmountGroup = new ButtonGroup();
	private final ButtonGroup sortOrderGroup = new ButtonGroup();

	final int MAX = 10000, MIN = -10000;
	int[] result, modArray;
	int sortType = 0, arraySize = 0, loops = 0, comparisons = 0, shifts = 0;
	long start, finish, elapsed;
	
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

	public SortingEfficiencies() {
		setTitle("A17 - Sorting Efficiencies");
		setResizable(false);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 530);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel title = new JLabel("Sorting Efficiencies");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setForeground(Color.BLUE);
		title.setFont(new Font("Tahoma", Font.BOLD, 30));
		title.setBackground(Color.WHITE);
		title.setBounds(0, 0, 1188, 55);
		contentPane.add(title);

		JLabel numberAmountLbl = new JLabel("Select the Amount of Numbers in the List:");
		numberAmountLbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		numberAmountLbl.setBackground(Color.WHITE);
		numberAmountLbl.setBounds(10, 55, 250, 25);
		contentPane.add(numberAmountLbl);

		JLabel orderTypeLbl = new JLabel("Sort Order:");
		orderTypeLbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		orderTypeLbl.setBackground(Color.WHITE);
		orderTypeLbl.setBounds(10, 95, 85, 25);
		contentPane.add(orderTypeLbl);

		JLabel originalNumbersLbl = new JLabel("Original Numbers:");
		originalNumbersLbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		originalNumbersLbl.setBackground(Color.WHITE);
		originalNumbersLbl.setBounds(10, 160, 110, 25);
		contentPane.add(originalNumbersLbl);

		JLabel sortedNumbersLbl = new JLabel("Sorted Numbers:");
		sortedNumbersLbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		sortedNumbersLbl.setBackground(Color.WHITE);
		sortedNumbersLbl.setBounds(275, 160, 110, 25);
		contentPane.add(sortedNumbersLbl);
		
		JLabel resultsLbl = new JLabel("Sort Results:");
		resultsLbl.setFont(new Font("Tahoma", Font.BOLD, 13));
		resultsLbl.setBackground(Color.WHITE);
		resultsLbl.setBounds(485, 55, 100, 25);
		contentPane.add(resultsLbl);

		tenNums = new JRadioButton("10");
		numberAmountGroup.add(tenNums);
		tenNums.setBackground(Color.WHITE);
		tenNums.setBounds(260, 55, 45, 25);
		tenNums.setSelected(true);
		contentPane.add(tenNums);

		hundredNums = new JRadioButton("100");
		numberAmountGroup.add(hundredNums);
		hundredNums.setBackground(Color.WHITE);
		hundredNums.setBounds(305, 55, 50, 25);
		contentPane.add(hundredNums);

		thousandNums = new JRadioButton("1000");
		numberAmountGroup.add(thousandNums);
		thousandNums.setBackground(Color.WHITE);
		thousandNums.setBounds(355, 55, 60, 25);
		contentPane.add(thousandNums);

		fivethousandNums = new JRadioButton("5000");
		numberAmountGroup.add(fivethousandNums);
		fivethousandNums.setBackground(Color.WHITE);
		fivethousandNums.setBounds(415, 55, 60, 25);
		contentPane.add(fivethousandNums);

		ascendingSort = new JRadioButton("Ascending");
		sortOrderGroup.add(ascendingSort);
		ascendingSort.setBackground(Color.WHITE);
		ascendingSort.setBounds(90, 95, 100, 25);
		ascendingSort.setSelected(true);
		contentPane.add(ascendingSort);

		descendingSort = new JRadioButton("Descending");
		sortOrderGroup.add(descendingSort);
		descendingSort.setBackground(Color.WHITE);
		descendingSort.setBounds(90, 123, 108, 25);
		contentPane.add(descendingSort);

		sort = new JButton("Sort Numbers");
		sort.setBounds(275, 110, 200, 25);
		contentPane.add(sort);
		sort.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				sortActionPerformed(evt);
			}
		});

		originalNumListScroll = new JScrollPane();
		originalNumListScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		originalNumListScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		originalNumListScroll.setBounds(10, 185, 200, 300);
		contentPane.add(originalNumListScroll);

		originalNumList = new JTextArea();
		originalNumList.setFont(new Font("Tahoma", Font.PLAIN, 14));
		originalNumList.setEditable(false);
		originalNumListScroll.setViewportView(originalNumList);

		sortedNumListScroll = new JScrollPane();
		sortedNumListScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		sortedNumListScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		sortedNumListScroll.setBounds(275, 185, 200, 300);
		contentPane.add(sortedNumListScroll);

		sortedNumList = new JTextArea();
		sortedNumList.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sortedNumList.setEditable(false);
		sortedNumListScroll.setViewportView(sortedNumList);
		
		sortResultsListScroll = new JScrollPane();
		sortResultsListScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		sortResultsListScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		sortResultsListScroll.setBounds(485, 80, 693, 405);
		contentPane.add(sortResultsListScroll);
		
		sortResultsList = new JTextArea();
		sortResultsList.setWrapStyleWord(true);
		sortResultsList.setLineWrap(true);
		sortResultsList.setEditable(false);
		sortResultsList.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sortResultsListScroll.setViewportView(sortResultsList);
	}
	
	private void sortActionPerformed(java.awt.event.ActionEvent evt) {
		originalNumList.setText("");
		sortedNumList.setText("");
		sortResultsList.setText("");
		
		sortType = 0;
		
		if (tenNums.isSelected()) {
			arraySize = 10;
		}
		
		else if (hundredNums.isSelected()) {
			arraySize = 100;
		}
		
		else if (thousandNums.isSelected()) {
			arraySize = 1000;
		}
		
		else {
			arraySize = 5000;
		}
		
		result = new int[arraySize];
		
		int begin = 0, end = arraySize - 1;
		
		for (int i = 0; i < arraySize; i++) {
			result[i] = (int) (Math.random() * (MAX - MIN + 1)) + MIN;
			originalNumList.append(result[i] + "\n");
		}
		
		modArray = Arrays.copyOf(result, arraySize);
		start = System.currentTimeMillis();
		selectionSortCalculation();
		finish = System.currentTimeMillis();
		sortResultsPrint();
		
		loops = 0;
		comparisons = 0;
		shifts = 0;
		
		modArray = Arrays.copyOf(result, arraySize);
		start = System.currentTimeMillis();
		bubbleSortCalculation();
		finish = System.currentTimeMillis();
		sortResultsPrint();
		
		loops = 0;
		comparisons = 0;
		shifts = 0;
		
		modArray = Arrays.copyOf(result, arraySize);
		start = System.currentTimeMillis();
		insertionSortCalculation();
		finish = System.currentTimeMillis();
		sortResultsPrint();
		
		loops = 0;
		comparisons = 0;
		shifts = 0;
		
		modArray = Arrays.copyOf(result, arraySize);	
		start = System.currentTimeMillis();
		quickSortCalculation(begin, end);		
		finish = System.currentTimeMillis();
		sortResultsPrint();
		
		loops = 0;
		comparisons = 0;
		shifts = 0;
		
		result = modArray;
		
		if (descendingSort.isSelected()) {	
			for (int i = arraySize - 1; i > -1; i--) {
				sortedNumList.append(result[i] + "\n");
			}
		}
		
		else {
			for (int i = 0; i < arraySize; i++) {
				sortedNumList.append(result[i] + "\n");
			}
		}
	}
	
	public void selectionSortCalculation() {
		int temp = 0;
		
		for (int i = 0; i < arraySize; i++) {
			for (int j = i+1; j < arraySize; j++) {
				if (modArray[i] > modArray[j]) {
					temp = modArray[i];
					modArray[i] = modArray[j];
					modArray[j] = temp;
					
					shifts++;
				}
				
				comparisons++;
				loops++;
			}
			
			loops++;
		}
	}

	public void bubbleSortCalculation() {
		int temp = 0;
		boolean swap = true;
		
		while (swap) {
			swap = false;
			
			for (int i = 0; i < arraySize - 1; i++) {
				if (modArray[i] > modArray[i+1]) {
					swap = true;
					temp = modArray[i];
					modArray[i] = modArray[i+1];
					modArray[i+1] = temp;
					
					shifts++;
				}
				
				comparisons++;
				loops++;
			}
			
			loops++;
		}
	}

	public void insertionSortCalculation() {
		int temp = 0, j = 0;
		
		for (int i = 1; i < arraySize; i++) {
			j = i;
			
			while (j > 0 && modArray[j-1] > modArray[j]) {
				temp = modArray[j];
				modArray[j] = modArray[j-1];
				modArray[j-1] = temp;
				j--;
				
				comparisons++;
				loops++;
				shifts++;
			}
			
			comparisons++;
			loops++;
		}
	}

	public void quickSortCalculation(int begin, int end) {		
		if (begin < end) {
	        int parIndex = partition(begin, end);
	        quickSortCalculation(begin, parIndex-1);
	        quickSortCalculation(parIndex+1, end);
	    }
		
		comparisons++;
		loops++;
		loops++;
	}
	
	public int partition(int begin, int end) {
		int temp = 0, pivot = modArray[end], p = (begin-1);

	    for (int i = begin; i < end; i++) {
	        if (modArray[i] <= pivot) {
	            p++;

	            temp = modArray[p];
	            modArray[p] = modArray[i];
	            modArray[i] = temp;
	            
	            shifts++;
	        }
	        
	        comparisons++;
	        loops++;
	    }

	    temp = modArray[p+1];
	    modArray[p+1] = modArray[end];
	    modArray[end] = temp;
	    
	    shifts++;

	    return p+1;
	}
	
	public void sortResultsPrint() {
		elapsed = finish - start;
		
		if (sortType == 0) {
			sortResultsList.append("Selection Sort:\n");
		}
		
		else if (sortType == 1) {
			sortResultsList.append("\n\nBubble Sort:\n");
		}
		
		else if (sortType == 2) {
			sortResultsList.append("\n\nInsertion Sort:\n");
		}
		
		else {
			sortResultsList.append("\n\nQuick Sort:\n");
		}
		
		sortResultsList.append("Number of times the loop was executed: " + loops + 
				"\nNumber of times a comparison was made: " + comparisons + 
				"\nNumber of times a value was shifted: " + shifts +
				"\nTime, in milliseconds, to finish sorting: " + elapsed);
		
		sortType++;
	}
}