package nl.jketelaar.buyer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class UI {

	private JFrame frame;
    private JTextField itemID;
	private JTextField slotID;

	public UI() {
		initialize();
        frame.setVisible(true);
	}

	private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 455, 176);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(6, 6, 438, 142);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JLabel itemIDLabel = new JLabel("Item ID");
        itemIDLabel.setBounds(6, 25, 61, 16);
        panel.add(itemIDLabel);

        JLabel slotIDLabel = new JLabel("Slot ID");
        slotIDLabel.setBounds(6, 65, 61, 16);
        panel.add(slotIDLabel);

        final JButton btnStart = new JButton("Start");
        btnStart.setBounds(315, 107, 117, 29);
        panel.add(btnStart);

        itemID = new JTextField();
        itemID.setBounds(79, 19, 134, 28);
        panel.add(itemID);
        itemID.setColumns(10);

        slotID = new JTextField();
        slotID.setBounds(79, 59, 134, 28);
        panel.add(slotID);
        slotID.setColumns(10);

        ButtonGroup buttonGroup = new ButtonGroup();

        final JRadioButton buyOne = new JRadioButton("Buy 1");
        buyOne.setBounds(291, 6, 141, 23);
        panel.add(buyOne);

        final JRadioButton buyFive = new JRadioButton("Buy 5");
        buyFive.setBounds(291, 35, 141, 23);
        panel.add(buyFive);

        final JRadioButton buyTen = new JRadioButton("Buy 10");
        buyTen.setBounds(291, 65, 141, 23);
        panel.add(buyTen);

        buttonGroup.add(buyOne);
        buttonGroup.add(buyFive);
        buttonGroup.add(buyTen);
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isNumber(itemID) && isNumber(slotID) && (buyOne.isSelected() || buyFive.isSelected() || buyTen.isSelected())) {
                    Variables.setItemID(Integer.parseInt(itemID.getText()));
                    Variables.setSlotID(Integer.parseInt(slotID.getText()));
                    if (buyOne.isSelected()){
                        Variables.setAmount(78);
                    }
                    if (buyFive.isSelected()){
                        Variables.setAmount(867);
                    }
                    if (buyTen.isSelected()){
                        Variables.setAmount(431);
                    }
                    frame.setVisible(false);
                }
            }
        });
	}

    private boolean isNumber(JTextField textField){
        try{
            Integer.parseInt(textField.getText());
            return true;
        }catch (NumberFormatException ignored){
            return false;
        }
    }

    public JFrame getFrame() {
        return frame;
    }
}
