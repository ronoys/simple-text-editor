package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random; 


public class textEditor extends JFrame implements ActionListener{
	private JTextArea myText;
	private JTextField myBox;
	private JButton editText;
	private JButton randomSize;
	private JButton randomFont;
	public static int number = 0;
	static Random rand = new Random(); 
	public static int goal = rand.nextInt(100); 
	
	public textEditor(String name){
		super(name);
		this.setSize(1000,1000);
		//this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		myText = new JTextArea("Sample Text");
		myText.setEditable(false);
		
		myText.setFont(myText.getFont().deriveFont(100f));
		
		myBox = new JTextField();
		
		editText = new JButton("Update Text");
		editText.addActionListener(this);
		editText.setBackground(Color.RED);
		editText.setOpaque(true);
		randomSize = new JButton("Random Size");
		randomSize.addActionListener(this);
		randomSize.setBackground(Color.RED);
		randomSize.setOpaque(true);
		randomFont = new JButton("Random Font");
		randomFont.addActionListener(this);
		randomFont.setBackground(Color.RED);
		randomFont.setOpaque(true);
		
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout());
		buttonPanel.add(myBox);
		buttonPanel.add(editText);
		buttonPanel.add(randomSize);
		buttonPanel.add(randomFont);
		this.add(myText,BorderLayout.CENTER);
		this.add(buttonPanel,BorderLayout.NORTH);
				
	}
	
	public void actionPerformed(ActionEvent e){
		Object src = e.getSource();
		String[] fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
				
		if(src == randomSize){
			Random rand = new Random();
			int answer = rand.nextInt(175);
			float floatAnswer = answer;
			myText.setFont(myText.getFont().deriveFont(floatAnswer));
			
		}
		
		if(src == editText){
			myText.setText(myBox.getText());
			
		}
		
		if(src == randomFont) {
			Random rand = new Random();
			int answer = rand.nextInt(fontNames.length);
			myText.setFont(new Font(fontNames[answer], Font.PLAIN, myText.getFont().getSize()));
		}
	}
	public static void main(String[] args) {
		textEditor BXG = new textEditor("Simple Text Editor");
		BXG.setVisible(true);
	}
}