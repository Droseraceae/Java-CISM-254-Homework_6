import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;

/**
 * This class calculates shade design and costs 
 * @Author Josh Alcoba
 * 4/14/2016
 */

public class ShadeDesigner extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel selectedStylePanel;
	private JPanel selectedColorPanel;
	private JPanel selectedSizePanel; 
	private JPanel totalPanel;
	private JComboBox<String> styleBox; 
	private JComboBox<String> sizeBox; 
	private JComboBox<String> colorBox;
	private JLabel label1; 
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JTextField selectedSize;
	private JTextField selectedColor;
	private JTextField selectedStyle;
	private JTextField total;
	private DecimalFormat df = new DecimalFormat("#,##0.00");

	private String[] styles = { "Regular shades: Add $0", "Folding shades: Add $10", "Roman shades: Add $15" };
	private String[] sizes = { "25 inches wide: Add $0", "27 inches wide: Add $2", "32 inches wide: Add $4",
			"40 inches wide: Add $6" };
	private String[] colors = { "Natural: Add $5", "Blue: Add $0", "Teal: Add $0", "Red: Add $0", "Green: Add $0" };

	double[] styleCost = { 0, 10, 15 };
	double[] sizeCost = { 0, 2, 4, 6 };
	double[] colorCost = { 5, 0, 0, 0, 0 };

	public ShadeDesigner() {
	
		super("Shade designer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		buildSizePanel();
		buildStylePanel();
		buildColorPanel();
		buildTotalPanel();
		add(selectedSizePanel, BorderLayout.WEST);
		add(selectedStylePanel, BorderLayout.CENTER);
		add(selectedColorPanel, BorderLayout.EAST);
		add(totalPanel, BorderLayout.SOUTH);
		pack();
		setVisible(true);
	}

	private void buildStylePanel() {
		selectedStylePanel = new JPanel();
		label1 = new JLabel("Shade styles: ");
		selectedStyle = new JTextField(15);
		selectedStyle.setEditable(false);
		styleBox = new JComboBox<String>(styles);
		styleBox.addActionListener(new ComboBoxListener());
		selectedStylePanel.add(styleBox);
		selectedStylePanel.add(label1);
		selectedStylePanel.add(selectedStyle);

	}

	private void buildSizePanel() {
		selectedSizePanel = new JPanel();
		label2 = new JLabel("Sizes: ");
		selectedSize = new JTextField(15);
		selectedSize.setEditable(false);
		sizeBox = new JComboBox<String>(sizes);
		sizeBox.addActionListener(new ComboBoxListener());
		selectedSizePanel.add(sizeBox);
		selectedSizePanel.add(label2);
		selectedSizePanel.add(selectedSize);

	}

	private void buildColorPanel() {
		selectedColorPanel = new JPanel();
		label3 = new JLabel("Colors: ");
		selectedColor = new JTextField(15);
		selectedColor.setEditable(false);
		colorBox = new JComboBox<String>(colors);
		colorBox.addActionListener(new ComboBoxListener());
		selectedColorPanel.add(colorBox);
		selectedColorPanel.add(label3);
		selectedColorPanel.add(selectedColor);

	}

	private void buildTotalPanel() {
		totalPanel = new JPanel();
		label4 = new JLabel("Total cost: ");
		total = new JTextField(10);
		total.setEditable(false);
		totalPanel.add(label4);
		totalPanel.add(total);

	}

	/**
	 * Private inner class that handles the event when the user selects an item from
	 * the combo box.
	 */

	private class ComboBoxListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int style;
			int size;
			int color;
			double totalCost;

			String styleSelection = (String) styleBox.getSelectedItem();
			selectedStyle.setText(styleSelection);
			styleBox.getSelectedItem();
			style = styleBox.getSelectedIndex();

			String sizeSelection = (String) sizeBox.getSelectedItem();
			selectedSize.setText(sizeSelection);
			sizeBox.getSelectedIndex();
			size = sizeBox.getSelectedIndex();

			String colorSelection = (String) colorBox.getSelectedItem();
			selectedColor.setText(colorSelection);
			colorBox.getSelectedIndex();
			color = colorBox.getSelectedIndex();

			totalCost = 50 + colorCost[color] + styleCost[style] + sizeCost[size];
			total.setText("$" + df.format(totalCost));
		}
	}

	/**
	 * The main method creates an instance of the class, which causes it to display
	 * its window.
	 */

	public static void main(String[] args) {
		new ShadeDesigner();
	}
}