package CodSoft;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;


class FirstSwingProg extends JFrame {
	JButton withdraw;
	JButton deposit;
	JButton check;
	JTextField inp;
	JTextField out;
	JLabel amt;
	JLabel res;
	int totbal;
	
	
	//constructor
	public FirstSwingProg() {
		JPanel toppanel = new JPanel();
		toppanel.setBackground(Color.CYAN);
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.LIGHT_GRAY);
		
		mainPanel.setSize(400,400);
		JLabel l = new JLabel("ATM Interface Machine");
		Font headerFont = new Font("verdana",Font.ITALIC,24);
		l.setFont(headerFont);
		amt = new JLabel("Enter Amount");
		inp = new JTextField(20);
		withdraw = new JButton("Withdraw");
		deposit = new JButton("Deposit");
		check = new JButton("check balance");
		res = new JLabel("Your Balance");
		Font customFont = new Font("Arial", Font.BOLD, 16);
		res.setFont(customFont);
		amt.setFont(customFont);
		out = new JTextField(20);
		out.setEditable(false);
		
		
		
		// adding to JFrame
		toppanel.add(l);
		add(toppanel);
		add(mainPanel);
		mainPanel.add(amt);
		mainPanel.add(inp);
		mainPanel.add(deposit);
		mainPanel.add(withdraw);
		mainPanel.add(check);
		mainPanel.add(res);
		mainPanel.add(out);
		
		// eventlistner
		withdraw.addActionListener(al -> {
		    String inputText = inp.getText();
		    
		    if (inputText.isEmpty()) {
		        out.setText("Enter an amount First");
		    } else {
		        int amount = Integer.parseInt(inputText);
		        
		        if (amount <= totbal) {
		            totbal -= amount;
		            out.setText("$ Amount Successfully Withdraw");
		        } else {
		            out.setText("Insufficient amount, Withdraw Failed :(");
		        }
		    }
		});

		deposit.addActionListener(al -> {
				String inputText = inp.getText();
				
				if(inputText.isEmpty()) {
					out.setText("Enter an amount First");
				} else {
			 	int amount = Integer.parseInt(inp.getText());
			    totbal += amount; 
			    out.setText("$ Amount Sucessfully Deposited");
			    }
		});
		
		check.addActionListener(al -> {
			out.setText(totbal+" $ ");
		});
		
		
		
		
		setLayout(new GridLayout(2,2));
		setVisible(true);
		setSize(400,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
public class TASK_3 {

	public static void main(String[] args) {
		FirstSwingProg obj = new FirstSwingProg();
	}

}
