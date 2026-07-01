import javax.swing.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Frame extends JFrame implements ActionListener{
	ImageIcon img1, img2, img3;
	JLabel waterLabel,breadLabel,honeyLabel,img1Label,img2Label,img3Label,total,finalTotal,waterPrice,breadPrice,honeyPrice,ordersLabel,cartwater,cartbread,carthoney,cart;
	JComboBox waterQty,breadQty,honeyQty;
	JButton atc1,atc2,atc3,confirm,clear1,clear2,clear3;
	JPanel panel;
	JTextArea orders;
	int waterInCart=0,breadInCart=0,honeyInCart=0,totalPrice=0;
	
	public Frame() {
		super("Online Convenience Store");
		this.setSize(1100,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		img1 = new ImageIcon("Images/img1.jpg");
		img1Label = new JLabel(img1);
		img1Label.setBounds(10,-30,200,300);
		panel.add(img1Label);
		
		waterLabel = new JLabel("MUM Water 1L");
		waterLabel.setBounds(70, 240, 160, 30);
		panel.add(waterLabel);
		
		waterPrice = new JLabel("Cost: 50");
		waterPrice.setBounds(85, 260, 160, 30);
		panel.add(waterPrice);
		
		String items[] = {"0","1","2","3","4","5","6","7","8","9","10"};
		waterQty = new JComboBox(items);
		waterQty.setBounds(85, 290, 50, 20);
		panel.add(waterQty);
		
		atc1 = new JButton("Add to Cart");
		atc1.setBounds(65, 320, 100, 30);
		atc1.addActionListener(this);
		panel.add(atc1);
		
		clear1 = new JButton("Clear");
		clear1.setBounds(65, 360, 100, 30);
		clear1.addActionListener(this);
		clear1.setBackground(Color.RED);
		panel.add(clear1);
		
		
		
		img2 = new ImageIcon("Images/img2.jpg");
		img2Label = new JLabel(img2);
		img2Label.setBounds(300, -30, 200, 300);
		panel.add(img2Label);
		
		breadLabel = new JLabel("ALL Time Bread");
		breadLabel.setBounds(360, 240, 160, 30);
		panel.add(breadLabel);
		
		breadPrice = new JLabel("Cost: 40");
		breadPrice.setBounds(375, 260, 160, 30);
		panel.add(breadPrice);
		
		breadQty = new JComboBox(items);
		breadQty.setBounds(375, 290, 50, 20);
		panel.add(breadQty);
		
		atc2 = new JButton("Add to Cart");
		atc2.setBounds(355, 320, 100, 30);
		atc2.addActionListener(this);
		panel.add(atc2);
		
		clear2 = new JButton("Clear");
		clear2.setBounds(355, 360, 100, 30);
		clear2.addActionListener(this);
		clear2.setBackground(Color.RED);
		panel.add(clear2);
		
		
		
		ordersLabel = new JLabel("Orders:");
		ordersLabel.setBounds(800, 0, 160, 30);
		panel.add(ordersLabel);
		
		orders = new JTextArea();
		orders.setBounds(800, 30, 250, 520);
		panel.add(orders);
		
		
		
		img3 = new ImageIcon("Images/img3.jpg");
		img3Label = new JLabel(img3);
		img3Label.setBounds(590, -10, 200, 260);
		panel.add(img3Label);
		
		honeyLabel = new JLabel("Dabur Honey");
		honeyLabel.setBounds(650, 240, 160, 30);
		panel.add(honeyLabel);
		
		honeyPrice = new JLabel("Cost: 140");
		honeyPrice.setBounds(665, 260, 160, 30);
		panel.add(honeyPrice);
		
		honeyQty = new JComboBox(items);
		honeyQty.setBounds(665, 290, 50, 20);
		panel.add(honeyQty);
		
		atc3 = new JButton("Add to Cart");
		atc3.setBounds(640, 320, 100, 30);
		atc3.addActionListener(this);
		panel.add(atc3);
		
		clear3 = new JButton("Clear");
		clear3.setBounds(640, 360, 100, 30);
		clear3.addActionListener(this);
		clear3.setBackground(Color.RED);
		panel.add(clear3);
		
		
		
		cart = new JLabel("Cart:");
		cart.setBounds(350, 400, 170, 70);
		panel.add(cart);
		
		cartwater = new JLabel("Water: " + waterInCart);
		cartwater.setBounds(350, 420, 170, 70);
		panel.add(cartwater);
		
		cartbread = new JLabel("Bread: " + breadInCart);
		cartbread.setBounds(350, 435, 170, 70);
		panel.add(cartbread);
		
		carthoney = new JLabel("Honey: " + honeyInCart);
		carthoney.setBounds(350, 450, 170, 70);
		panel.add(carthoney);
		
		total = new JLabel("Total: " + totalPrice);
		total.setBounds(350, 480, 170, 70);
		panel.add(total);
		
		confirm = new JButton("Confirm Order");
		confirm.setBounds(450, 470, 150, 50);
		confirm.addActionListener(this);
		confirm.setBackground(Color.GREEN);
		panel.add(confirm);
		
		
		
		this.add(panel);
	}
	

	public void actionPerformed(ActionEvent me) {
		if(me.getSource()==atc1) {
			waterInCart += waterQty.getSelectedIndex();
			JOptionPane.showMessageDialog(this,"Added to Cart");
		}
		else if(me.getSource()== atc2) {
			breadInCart += breadQty.getSelectedIndex();
			JOptionPane.showMessageDialog(this,"Added to Cart");
		}
		else if (me.getSource() == atc3) {
			honeyInCart += honeyQty.getSelectedIndex();
			JOptionPane.showMessageDialog(this,"Added to Cart");
		}
		else if (me.getSource() == clear1) {
			waterQty.setSelectedIndex(0);
			waterInCart = 0;
		}
		else if(me.getSource() == clear2) {
			breadQty.setSelectedIndex(0);
			breadInCart = 0;
		}
		else if(me.getSource() == clear3) {
			honeyQty.setSelectedIndex(0);
			honeyInCart = 0;
		}
		else if (me.getSource() == confirm) {
			try {
				File file = new File("./orders.txt");
				if(!file.exists()) {
					file.createNewFile();
				}
				FileWriter fw = new FileWriter(file,true);
				fw.write("Water:" + waterInCart + " Bread:" + breadInCart + " Honey:" + honeyInCart + " Total:" + totalPrice + "\n");	
				fw.close();
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				String line;
				orders.setText("");
				while((line = br.readLine())!=null) {
					orders.append("----------------------------------------------\n");
					orders.append(line + "\n");
					orders.append("-----------------------------------------------\n");
				}
				br.close();
			}
			catch(IOException e){
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(this,"Order Confirmed");
		}

		
		totalPrice = waterInCart*50 + breadInCart*40 + honeyInCart*140;
		total.setText("Total: " + totalPrice);
		cartwater.setText("Water: " + waterInCart);
		cartbread.setText("Bread: " + breadInCart);
		carthoney.setText("Honey: " + honeyInCart);
		}
}