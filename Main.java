package mvsk.idontknow;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		System.setProperty("sun.java2d.uiScale", "1"); //ปรับสเกลให้เท่ากับ 1
		EventQueue.invokeLater(new Runnable() { 
			@Override
			public void run() {
				Main main = new Main(); //เรียกไฟล์ Main
				main.setVisible(true); //ตั้งค่าเป็น visible เพื่อให้สะดวก
			}
		});
	}

	public Main() {
		super("Grade Program"); //ชื่อหัวข้อ
		setSize(450, 300); //ขนาด 450x300
		setLocation(500, 280); //ตำแหน่ง [x: 500 y: 280] 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //ตั้งค่าการออกแบบปิด
		getContentPane().setLayout(null); //ทำ layout null 
		
		JTextField numA = new JTextField("Enter your score"); //สร้างกล่องข้อความที่ชื่อ "Enter your score"
		JTextField numB = new JTextField("Enter your name"); //สร้างกล่องข้อความที่ชื่อ "Enter your name"
		JButton btnSum = new JButton("Sum"); //สร้างปุ่มในการประมวล
		JLabel lblResult = new JLabel("Result"); //สร้างข้อความผลลัพท์
		JLabel lblScore = new JLabel(); //สร้างข้อความคะแนน

		lblResult.setBounds(27, 120, 350, 14); //ตั้งค่าตำแหน่ง [x: 27, y: 120] ขนาด [h: 350, w: 14]
		lblScore.setBounds(27, 140, 350, 14); //ตั้งค่าตำแหน่ง [x: 27, y: 140] ขนาด [h: 350, w: 14]
		numA.setBounds(27, 26, 350, 20); //ตั้งค่าตำแหน่ง [x: 27, y: 26] ขนาด [h: 350, w: 20]
		numB.setBounds(27, 56, 350, 20); //ตั้งค่าตำแหน่ง [x: 27, y: 56] ขนาด [h: 350, w: 20]
		btnSum.setBounds(310, 90, 65, 23); //ตั้งค่าตำแหน่ง [x: 310, y: 90] ขนาด [h: 65, w: 23]
		
		numA.addFocusListener(new FocusListener() { //เรียก Listener เพื่อตรวจสอบ
		    @Override
		    public void focusGained(FocusEvent e) { //สร้างเมธอร์ ตรวจสอบข้อความของตัวแปร numA และสร้างพารามิเตอร์ e
 		        if (numA.getText().equals("Enter your score")) { //ตรวจสอบว่าในกล่องข้อความเป็น Enter your score รึไม่
		        	numA.setText(""); //ตั้งค่าให้ข้อความหายไป
		        }
		    }
		    @Override
		    public void focusLost(FocusEvent e) { //สร้างเมธอร์ ตรวจสอบข้อความของตัวแปร numA และสร้างพารามิเตอร์ e
		        if (numA.getText().isEmpty()) { //ตรวจสอบว่าในกล่องข้อความเป็นว่างเปล่ารึไม่
		        	numA.setText("Enter your score"); //ตั้งค่าให้ข้อความให้เป็น Enter your score
		        }
		    }
		});
		numB.addFocusListener(new FocusListener() { //เหมือนบรรทัด 50 แต่แค่เปลียนชื่อ Enter your score เป็น Enter your name
		    @Override
		    public void focusGained(FocusEvent e) {
		        if (numB.getText().equals("Enter your name")) {
		        	numB.setText("");
		        }
		    }
		    @Override
		    public void focusLost(FocusEvent e) {
		        if (numB.getText().isEmpty()) {
		        	numB.setText("Enter your name");
		        }
		    }
		});
		btnSum.addActionListener(new ActionListener() { //เรียกการตรวจสอบโดยการคลิก

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try { //ตรวจสอบว่าค่าเป็นตัวเลขรึไหม
					int x = Integer.parseInt(numA.getText()); //รับค่า x เป็นตัวคะแนนแล้วหาช่วงเกรด  
					if (x >= 80 && x <= 100) {
						lblResult.setText("Result: " + numB.getText());
						lblScore.setText("The Score is : "+ x +" Grade : A , Grade : 4.00");
					} else if (x <= 79 && x >= 75) {
						lblResult.setText("Result: " + numB.getText());
						lblScore.setText("The Score is : "+ x +" Grade : B+ , Grade : 3.50");
					} else if (x <= 74 && x >= 70) {
						lblResult.setText("Result: " + numB.getText());
						lblScore.setText("The Score is : "+ x +" Grade : B , Grade : 3.00");
					} else if (x <= 69 && x >= 65) {
						lblResult.setText("Result: " + numB.getText());
						lblScore.setText("The Score is : "+ x +" Grade : C+ , Grade : 2.50");
					} else if (x <= 64 && x >= 60) {
						lblResult.setText("Result: " + numB.getText());
						lblScore.setText("The Score is : "+ x +" Grade : C , Grade : 2.00");
					} else if (x <= 59 && x >= 55) {
						lblResult.setText("Result: " + numB.getText());
						lblScore.setText("The Score is : "+ x +" Grade : D+ , Grade : 1.50");
					} else if (x <= 54 && x >= 50) {
						lblResult.setText("Result: " + numB.getText());
						lblScore.setText("The Score is : "+ x +" Grade : D , Grade : 1.00");
					} else if (x <= 49) {
						lblResult.setText("Result: " + numB.getText());
						lblScore.setText("The Score is : "+ x +" Grade : F , Grade : 0.00");
					} else if (x >= 100) { //หากคะแนนเกิน 100 คะแนนจะไม่สามารถคำนวณได้
						lblResult.setText("Result: Failed to calulator your grade");
						lblScore.setText("This score is overflow. You must be enter 0-100 only!");
					}
				} catch (NumberFormatException e) { //หากไม่ใช่ให้ตีกลับแล้วไปพวกเลขใหม่
					lblResult.setText("Result: Failed to calculator your grade");
					lblScore.setText("Don't enter string or char in the first text box!");
				}
			}
			
		});
		
		getContentPane().add(btnSum); //เพิ่มลงในกล่อง
		getContentPane().add(numA); //เพิ่มลงในกล่อง
		getContentPane().add(numB); //เพิ่มลงในกล่อง
		getContentPane().add(lblResult); //เพิ่มลงในกล่อง
		getContentPane().add(lblScore); //เพิ่มลงในกล่อง
	    }
}
