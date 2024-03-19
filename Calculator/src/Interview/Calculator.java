package Interview;


import java.awt.event.*;
import java.awt.*;
import javax.swing.*;



public class Calculator implements ActionListener{

	JFrame frame;
	JTextField textfield;
	JButton[] numeriques = new JButton[10];
	JButton[] operateur = new JButton[9];
	JButton addition,soustraction,multiplication,division;
	JButton dec, egale, supp , efface, neg;
	JPanel panel;
	
	
	double num1=0,num2=0,result=0;
	char operator;
	
	Calculator(){
		
		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 550);
		frame.setLayout(null);
		
		textfield = new JTextField();
		textfield.setBounds(50, 25, 300, 50);
		textfield.setEditable(false);
		
		
		
		addition = new JButton("+");
		soustraction = new JButton("-");
		multiplication = new JButton("*");
		division = new JButton("/");
		dec = new JButton(".");
		egale = new JButton("=");
		supp = new JButton("<|");
		efface = new JButton("C");
		neg = new JButton("(-)");
		
		operateur[0] = addition;
		operateur[1] = soustraction;
		operateur[2] = multiplication;
		operateur[3] = dec;
		operateur[4] = egale;
		operateur[5] = division;
		operateur[6] = supp;
		operateur[7] = efface;
		operateur[8] = neg;
		
		for(int i =0;i<9;i++) {
			operateur[i].addActionListener(this);
			operateur[i].setFocusable(false);
		}
		
		for(int i =0;i<10;i++) {
			numeriques[i] = new JButton(String.valueOf(i));
			numeriques[i].addActionListener(this);
			numeriques[i].setFocusable(false);
		}
		
		operateur[6].setBounds(50,100,95,50);
		operateur[7].setBounds(153,100,95,50);
		operateur[8].setBounds(255,100,95,50);
		
		panel = new JPanel();
		panel.setBounds(50, 175, 300, 300);
		panel.setLayout(new GridLayout(4,4,10,10));
		
		panel.add(numeriques[1]);
		panel.add(numeriques[2]);
		panel.add(numeriques[3]);
		panel.add(operateur[0]);
		panel.add(numeriques[4]);
		panel.add(numeriques[5]);
		panel.add(numeriques[6]);
		panel.add(operateur[1]);
		panel.add(numeriques[7]);
		panel.add(numeriques[8]);
		panel.add(numeriques[9]);
		panel.add(operateur[2]);
		panel.add(operateur[3]);
		panel.add(numeriques[0]);
		panel.add(operateur[4]);
		panel.add(operateur[5]);
		
		frame.add(panel);
		frame.add(operateur[6]);
		frame.add(operateur[7]);
		frame.add(operateur[8]);
		frame.add(textfield);

		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		Calculator calc = new Calculator();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		Boolean correct = true;
		for(int i=0;i<10;i++) {
			if(e.getSource() == numeriques[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource()==dec) {
			textfield.setText(textfield.getText().concat("."));
		}
		if(e.getSource()==addition) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='+';
			textfield.setText("");
		}
		if(e.getSource()==soustraction) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='-';
			textfield.setText("");
		}
		if(e.getSource()==multiplication) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='*';
			textfield.setText("");
		}
		if(e.getSource()==division) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='/';
			textfield.setText("");
		}
		if(e.getSource()==egale) {
			num2=Double.parseDouble(textfield.getText());
			
			switch(operator) {
			case'+':
				result=num1+num2;
				break;
			case'-':
				result=num1-num2;
				break;
			case'*':
				result=num1*num2;
				break;
			case'/':
				if (num2==0.0) {
					textfield.setText("Zero division error");
					correct = false;
				}
				else {
					result=num1/num2;					
				}
				break;
			}
			if (correct) {
				textfield.setText(String.valueOf(result));	
				num1=result;			
			}
			
		}
		if(e.getSource()==efface) {
			textfield.setText("");
		}
		if(e.getSource()==supp) {
			String string = textfield.getText();
			textfield.setText("");
			for(int i=0;i<string.length()-1;i++) {
				textfield.setText(textfield.getText()+string.charAt(i));
			}
		}
		if(e.getSource()==neg) {
			double temp = Double.parseDouble(textfield.getText());
			temp*=-1;
			textfield.setText(String.valueOf(temp));
		}
	}
	
	public void setTextfield(String text) {
		this.textfield.setText(text);
	}
	
	public String getTextfield() {
		return this.textfield.getText();
	}
	
	
	public void setNum(double num1, double num2) {
		this.num1 = num1;
		this.num2 = num2;
	}
	
	public double[] getNum() {
		double[] num = {this.num1,this.num2};
		return num;
	}

	public double getResult() {
		return this.result;
	}

}