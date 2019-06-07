import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class GstDashBoard extends JFrame {

	private JPanel contentPane;
	private JTextField product_quantity;
	private JTextField hsncode;
	private JTextField manufacturer;
	private JTextField exp_date;
	private JTextField discount_per;
	private JTextField mrp_price;
	private JTextField sell_price;
	private JTextField sell_quantity;
	private JTextField textField_8;
	private JTextField textField_9;
	private JComboBox gst_tax;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField inv_no;
	private JTextField inv_date;
	private JTextField address;
	private JTextField cus_mobileno;
	private JTextField customer_name;
	
	Connection connection = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GstDashBoard frame = new GstDashBoard();
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
	public GstDashBoard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 1271, 758);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane menuLayeredPane = new JLayeredPane();
		menuLayeredPane.setBounds(12, 0, 1229, 73);
		contentPane.add(menuLayeredPane);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(GstDashBoard.class.getResource("/logo copy.png")));
		lblNewLabel_6.setBounds(2, 5, 272, 69);
		menuLayeredPane.add(lblNewLabel_6);
		
		JButton btnNewButton = new JButton("Close");
		btnNewButton.setBounds(1073, 21, 97, 25);
		menuLayeredPane.add(btnNewButton);
		
		JLayeredPane workSpaceLayeredPane = new JLayeredPane();
		workSpaceLayeredPane.setBounds(12, 77, 1229, 621);
		contentPane.add(workSpaceLayeredPane);
		workSpaceLayeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		workSpaceLayeredPane.add(panel, "name_5095250541329920");
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(UIManager.getBorder("TextField.border"));
		scrollPane.setBounds(12, 275, 1205, 231);
		panel.add(scrollPane);
		
		JLayeredPane invoiceItemsLayeredPane = new JLayeredPane();
		invoiceItemsLayeredPane.setBounds(12, 13, 1205, 251);
		panel.add(invoiceItemsLayeredPane);
		invoiceItemsLayeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel itemsFildesPanel = new JPanel();
		invoiceItemsLayeredPane.add(itemsFildesPanel, "name_5095662088000427");
		itemsFildesPanel.setLayout(null);
		
		JComboBox product_name = new JComboBox();
		product_name.setBackground(new Color(255, 255, 255));
		product_name.setForeground(new Color(0, 0, 0));
		product_name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		product_name.setBounds(12, 192, 246, 31);
		itemsFildesPanel.add(product_name);
		
		JLabel lblNewLabel = new JLabel("Product Name");
		lblNewLabel.setBounds(12, 169, 91, 16);
		itemsFildesPanel.add(lblNewLabel);
		
		product_quantity = new JTextField();
		product_quantity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		product_quantity.setBounds(115, 157, 143, 28);
		itemsFildesPanel.add(product_quantity);
		product_quantity.setColumns(10);
		
		hsncode = new JTextField();
		hsncode.setFont(new Font("Tahoma", Font.PLAIN, 14));
		hsncode.setBounds(320, 125, 151, 31);
		itemsFildesPanel.add(hsncode);
		hsncode.setColumns(10);
		
		JLabel lblHsnCode = new JLabel("HSN Code");
		lblHsnCode.setBounds(319, 102, 152, 16);
		itemsFildesPanel.add(lblHsnCode);
		
		JComboBox batchno = new JComboBox();
		batchno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		batchno.setBounds(529, 125, 151, 31);
		itemsFildesPanel.add(batchno);
		
		JLabel lblBatchNo = new JLabel("Batch No.");
		lblBatchNo.setBounds(529, 102, 102, 16);
		itemsFildesPanel.add(lblBatchNo);
		
		manufacturer = new JTextField();
		manufacturer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		manufacturer.setBounds(747, 125, 137, 31);
		manufacturer.setColumns(10);
		itemsFildesPanel.add(manufacturer);
		
		JLabel lblManufacturer = new JLabel("Manufacturer");
		lblManufacturer.setBounds(746, 102, 91, 16);
		itemsFildesPanel.add(lblManufacturer);
		
		exp_date = new JTextField();
		exp_date.setFont(new Font("Tahoma", Font.PLAIN, 14));
		exp_date.setBounds(946, 125, 137, 31);
		exp_date.setColumns(10);
		itemsFildesPanel.add(exp_date);
		
		JLabel lblExpDate = new JLabel("Exp Date");
		lblExpDate.setBounds(945, 102, 91, 16);
		itemsFildesPanel.add(lblExpDate);
		
		discount_per = new JTextField();
		discount_per.setFont(new Font("Tahoma", Font.PLAIN, 14));
		discount_per.setHorizontalAlignment(SwingConstants.RIGHT);
		discount_per.setText("0");
		discount_per.setBounds(530, 192, 74, 31);
		discount_per.setColumns(10);
		itemsFildesPanel.add(discount_per);
		
		JLabel lblDiscount = new JLabel("Discount %");
		lblDiscount.setBounds(529, 169, 75, 16);
		itemsFildesPanel.add(lblDiscount);
		
		mrp_price = new JTextField();
		mrp_price.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mrp_price.setHorizontalAlignment(SwingConstants.RIGHT);
		mrp_price.setText("0");
		mrp_price.setBounds(321, 192, 150, 31);
		mrp_price.setColumns(10);
		itemsFildesPanel.add(mrp_price);
		
		JLabel lblMrpRate = new JLabel("MRP Rate");
		lblMrpRate.setBounds(320, 169, 117, 16);
		itemsFildesPanel.add(lblMrpRate);
		
		sell_price = new JTextField();
		sell_price.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sell_price.setHorizontalAlignment(SwingConstants.RIGHT);
		sell_price.setText("0");
		sell_price.setBounds(748, 192, 136, 31);
		sell_price.setColumns(10);
		itemsFildesPanel.add(sell_price);
		
		JLabel lblSellPrice = new JLabel("Sell Price");
		lblSellPrice.setBounds(747, 169, 117, 16);
		itemsFildesPanel.add(lblSellPrice);
		
		sell_quantity = new JTextField();
		sell_quantity.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode()==KeyEvent.VK_ENTER)
				{
					connection=ConnectionManager.getConnection();
		            try {
		            	String insertData="insert into invoice_table (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		            	PreparedStatement ps=connection.prepareStatement(insertData);
		            	ps.setString(1, product_name.getSelectedItem().toString());
		            	ps.setString(2, hsncode.getText());
		            	ps.setString(3, batchno.getSelectedItem().toString());
		            	ps.setString(4, manufacturer.getText());
		            	ps.setString(5, exp_date.getText());
		            	ps.setString(6, product_quantity.getText());
		            	ps.setString(7, mrp_price.getText());
		            	ps.setString(8, sell_price.getText());
		            	ps.setString(9, discount_per.getText());
		            	ps.setString(10, gst_tax.getSelectedItem().toString());
		            	
		            } catch (exception e) {
		            	
		            }
		           
				}
			}
		});
		sell_quantity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sell_quantity.setHorizontalAlignment(SwingConstants.RIGHT);
		sell_quantity.setText("0");
		sell_quantity.setBounds(947, 192, 136, 31);
		sell_quantity.setColumns(10);
		itemsFildesPanel.add(sell_quantity);
		
		JLabel lblQuant = new JLabel("Quantity");
		lblQuant.setBounds(946, 169, 117, 16);
		itemsFildesPanel.add(lblQuant);
		
		JCheckBox chckbxAdd = new JCheckBox("Add");
		chckbxAdd.setForeground(new Color(0, 255, 255));
		chckbxAdd.setBounds(8, 144, 95, 16);
		itemsFildesPanel.add(chckbxAdd);
		
		JLabel lblNewLabel_1 = new JLabel("Total Products");
		lblNewLabel_1.setBounds(115, 102, 91, 16);
		itemsFildesPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("0");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBorder(UIManager.getBorder("TextField.border"));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(115, 125, 143, 31);
		itemsFildesPanel.add(lblNewLabel_2);
		
		JLabel lblGst = new JLabel("GST %");
		lblGst.setBounds(616, 169, 63, 16);
		itemsFildesPanel.add(lblGst);
		
		gst_tax = new JComboBox();
		gst_tax.setFont(new Font("Tahoma", Font.PLAIN, 14));
		gst_tax.setBounds(616, 192, 64, 31);
		itemsFildesPanel.add(gst_tax);
		gst_tax.addItem("0");
		gst_tax.addItem("5");
		gst_tax.addItem("12");
		gst_tax.addItem("18");
		gst_tax.addItem("28");
		
		JLabel lblNewLabel_4 = new JLabel("Invoice No.");
		lblNewLabel_4.setBounds(745, 26, 74, 28);
		itemsFildesPanel.add(lblNewLabel_4);
		
		inv_no = new JTextField();
		inv_no.setBounds(745, 56, 139, 31);
		itemsFildesPanel.add(inv_no);
		inv_no.setColumns(10);
		
		JLabel lblInvoiceDate = new JLabel("Invoice Date");
		lblInvoiceDate.setBounds(946, 30, 74, 28);
		itemsFildesPanel.add(lblInvoiceDate);
		
		inv_date = new JTextField();
		inv_date.setColumns(10);
		inv_date.setBounds(946, 58, 137, 31);
		itemsFildesPanel.add(inv_date);
		
		address = new JTextField();
		address.setBounds(320, 29, 360, 60);
		itemsFildesPanel.add(address);
		address.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Address");
		lblNewLabel_5.setBounds(320, 13, 56, 16);
		itemsFildesPanel.add(lblNewLabel_5);
		
		JLabel lblCustomerName = new JLabel("Customer Name");
		lblCustomerName.setBounds(12, 11, 129, 16);
		itemsFildesPanel.add(lblCustomerName);
		
		JLabel lblMobileNo = new JLabel("Mobile No.");
		lblMobileNo.setBounds(12, 56, 129, 16);
		itemsFildesPanel.add(lblMobileNo);
		
		cus_mobileno = new JTextField();
		cus_mobileno.setColumns(10);
		cus_mobileno.setBounds(12, 71, 246, 28);
		itemsFildesPanel.add(cus_mobileno);
		
		customer_name = new JTextField();
		customer_name.setColumns(10);
		customer_name.setBounds(12, 29, 246, 28);
		itemsFildesPanel.add(customer_name);
		
		
		JLabel lblNewLabel_3 = new JLabel("Gross Value");
		lblNewLabel_3.setBounds(879, 525, 84, 16);
		panel.add(lblNewLabel_3);
		
		textField_8 = new JTextField();
		textField_8.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_8.setText("0");
		textField_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_8.setBounds(965, 516, 137, 33);
		panel.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblTotalValue = new JLabel("Total Value");
		lblTotalValue.setBounds(879, 571, 84, 16);
		panel.add(lblTotalValue);
		
		textField_9 = new JTextField();
		textField_9.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_9.setText("0");
		textField_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_9.setColumns(10);
		textField_9.setBounds(965, 562, 137, 33);
		panel.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setText("0");
		textField_10.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_10.setColumns(10);
		textField_10.setBounds(165, 516, 137, 33);
		panel.add(textField_10);
		
		JLabel lblDiscountValue = new JLabel("Discount Value");
		lblDiscountValue.setBounds(62, 525, 84, 16);
		panel.add(lblDiscountValue);
		
		JLabel lblCgstValue = new JLabel("CGST Value");
		lblCgstValue.setBounds(461, 522, 84, 16);
		panel.add(lblCgstValue);
		
		textField_11 = new JTextField();
		textField_11.setText("0");
		textField_11.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_11.setColumns(10);
		textField_11.setBounds(561, 519, 137, 25);
		panel.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setText("0");
		textField_12.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_12.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_12.setColumns(10);
		textField_12.setBounds(561, 551, 137, 25);
		panel.add(textField_12);
		
		JLabel lblSgstValue = new JLabel("SGST Value");
		lblSgstValue.setBounds(461, 554, 84, 16);
		panel.add(lblSgstValue);
		
		textField_13 = new JTextField();
		textField_13.setText("0");
		textField_13.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_13.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_13.setColumns(10);
		textField_13.setBounds(561, 589, 137, 25);
		panel.add(textField_13);
		
		JLabel lblIgstValue = new JLabel("IGST Value");
		lblIgstValue.setBounds(461, 592, 84, 16);
		panel.add(lblIgstValue);
	}
}
