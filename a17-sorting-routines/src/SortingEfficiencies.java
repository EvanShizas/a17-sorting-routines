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

public class SortingEfficiencies extends JFrame {

	private JPanel contentPane;

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
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("10");
		rdbtnNewRadioButton.setBounds(214, 32, 51, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("100");
		rdbtnNewRadioButton_1.setBounds(267, 32, 46, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("1000");
		rdbtnNewRadioButton_2.setBounds(318, 32, 57, 23);
		contentPane.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("5000");
		rdbtnNewRadioButton_3.setBounds(377, 32, 57, 23);
		contentPane.add(rdbtnNewRadioButton_3);
		
		JButton btnNewButton = new JButton("Sort Numbers");
		btnNewButton.setBounds(20, 56, 125, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Sort Order");
		lblNewLabel_2.setBounds(10, 102, 65, 14);
		contentPane.add(lblNewLabel_2);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("Ascending");
		rdbtnNewRadioButton_4.setBounds(74, 98, 109, 23);
		contentPane.add(rdbtnNewRadioButton_4);
		
		JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("Descending");
		rdbtnNewRadioButton_5.setBounds(74, 124, 109, 23);
		contentPane.add(rdbtnNewRadioButton_5);
		
		JLabel lblNewLabel_3 = new JLabel("Original Numbers");
		lblNewLabel_3.setBounds(10, 157, 89, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Sorted Numbers");
		lblNewLabel_4.setBounds(103, 154, 80, 14);
		contentPane.add(lblNewLabel_4);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 178, 65, 173);
		contentPane.add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(103, 178, 65, 173);
		contentPane.add(textArea_1);
		
		JLabel lblNewLabel_5 = new JLabel("Sort Results");
		lblNewLabel_5.setBounds(220, 80, 89, 14);
		contentPane.add(lblNewLabel_5);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(213, 108, 430, 243);
		contentPane.add(textArea_2);
	}
}
