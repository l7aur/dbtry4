package utility;

import backend.ConnectionModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

/**
 * Creates a pop-up window with 2 entries specifically designed for the insertion of comments - TODO add atuhor field maybe
 */
public class MultiInputOptionPane extends JFrame{
    private Comment comment;
    private JTextField currentTextField;
    private JTextArea currentTextArea;
    private Container container;
    private SpringLayout layout;
    private final Map<String, Integer > paddingMap; //map of padding constants with respect to the borders of the pop-up window
    private final Integer spacingConstant = 20;
    public MultiInputOptionPane() {
        super();
        //initialization
        this.comment = new Comment();
        this.container = this.getContentPane();
        this.layout = new SpringLayout(); //specific layout
        this.container.setLayout(layout);

        //fill the map
        this.paddingMap = new HashMap<>(4);
        this.paddingMap.put("north", 15);
        this.paddingMap.put("south", -15);
        this.paddingMap.put("east", -15);
        this.paddingMap.put("west", 15);

        //difference in name length means different alignment LMAO, but these 2 are just perfect HAHAHAXDD
        //add 2 text areas to be filled by the user
        this.currentTextField = this.addTextField("ID of item: ");
        this.currentTextArea = this.addTextArea ("Comment: ");
        //add the done button
        this.addButton();
        //make it visible
        this.setPaneUI();
    }

    /**
     * Creates a button that will signal the comment form is filled and ready to be registered into the database
     */
    public void addButton() {
        JButton button = new JButton("OK");
        this.container.add(button);
        this.layout.putConstraint(SpringLayout.VERTICAL_CENTER, button, 0, SpringLayout.VERTICAL_CENTER, this.container);
        this.layout.putConstraint(SpringLayout.EAST, button, this.paddingMap.get("east"), SpringLayout.EAST, this.container);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //nu de aici am exceptie class not found TBI
                comment.setCommentText(currentTextArea.getText());
                comment.setId(currentTextField.getText());
                if(checkData()) {
                    setVisible(false);
                    ConnectionModel connectionModel = new ConnectionModel();
                    connectionModel.connect();
                    connectionModel.handleInsert(comment);
                }
                closeFrame();

            }
        });
    }
    public void closeFrame() {
        this.dispose();
    }

    /**
     * Check for data integrity:
     * - both fields contain text
     * - the item id exists in the database --TODO
     * @return a flag that triggers the database insertion
     */
    public boolean checkData() {
        boolean test = true;
        if (this.getComment().getCommentText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Where comment ???");
            test = false;
        }
        if (this.getComment().getId().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Where id ???");
            test = false;
        }
        return test;
    }

    /**
     * Creates, places and aligns a text field in the pop-up window
     * @param name name of the field that is displayed
     * @return a text field
     */
    public JTextField addTextField(String name) {
        JTextField textField = new JTextField(20);
        JLabel textLabel = new JLabel(name);
        textField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        this.container.add(textLabel);
        this.container.add(textField);
        try {
            this.layout.putConstraint(SpringLayout.WEST, textLabel, this.paddingMap.get("west"), SpringLayout.WEST, this.container);
            this.layout.putConstraint(SpringLayout.NORTH, textLabel, this.paddingMap.get("north"), SpringLayout.NORTH, this.container);
            this.layout.putConstraint(SpringLayout.WEST, textField, this.paddingMap.get("west"), SpringLayout.EAST, textLabel);
            this.layout.putConstraint(SpringLayout.NORTH, textField, this.paddingMap.get("north"), SpringLayout.NORTH, this.container);
            this.paddingMap.replace("north", this.paddingMap.get("north") + spacingConstant);
        } catch (NullPointerException e) {
            System.out.println("Padding problem!");
        }
        return textField;
    }

    /**
     * Creates, places and aligns a text area in the pop-up window
     * @param name name of the text area that is displayed
     * @return a text area
     */
    public JTextArea addTextArea(String name) {
        JTextArea textArea = new JTextArea(10, 20);
        JLabel textLabel = new JLabel(name);

        this.container.add(textLabel);
        this.container.add(textArea);
        try {
            this.layout.putConstraint(SpringLayout.WEST, textLabel, this.paddingMap.get("west"), SpringLayout.WEST, this.container);
            this.layout.putConstraint(SpringLayout.NORTH, textLabel, this.paddingMap.get("north"), SpringLayout.NORTH, this.container);
            this.layout.putConstraint(SpringLayout.WEST, textArea, this.paddingMap.get("west"), SpringLayout.EAST, textLabel);
            this.layout.putConstraint(SpringLayout.NORTH, textArea, this.paddingMap.get("north"), SpringLayout.NORTH, this.container);
            this.paddingMap.replace("north", this.paddingMap.get("north") + spacingConstant * textArea.getRows());

        } catch (NullPointerException e) {
            System.out.println("Padding problem!");
        }
        return textArea;
    }
    /**
     * Sets the side of the pop-up window, associates disposal on close and makes it visible
     */
    public void setPaneUI() {
        this.setPreferredSize(new Dimension(400, 250));
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    /* Getters, Setters and Utility */
    public Comment getComment() {
        return this.comment;
    }
    public void setComment(Comment comment) {
        this.comment = comment;
    }
}
