package gui;

import backend.ConnectionModel;
import gui.buttons.*;
import utility.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Screen extends JPanel {
    protected ConnectionModel connectionModel;
    private Screens id = Screens.SCREEN;
    protected JPanel header;
    protected JPanel footer; //good for even spacing
    protected JPanel content;
    protected String[] columnNames;
    //Constructor
    public Screen(Screens title, ConnectionModel connectionModel) {
        super();
        header = new JPanel();
        footer = new JPanel();
        content = new JPanel();
        this.connectionModel = connectionModel;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(header);
        this.add(content);
                content.setLayout(new GridBagLayout());
                footer.setLayout(new BoxLayout(footer, BoxLayout.X_AXIS));
                header.setPreferredSize(new Dimension(1080, 20));
                footer.setPreferredSize(new Dimension(1080, 100));
                content.setPreferredSize(new Dimension(1080, 600));
        this.add(footer);
        this.setPreferredSize(new Dimension(1080, 720));
        JLabel text = new JLabel(title.toString().toUpperCase().replace('_', ' '));
        this.header.add(text);
    }
    /**
     * Fetch data from database and display it into a table
     * @param name name of the table
     * @param columnNames names of the columns of the table taken from the database
     * @param filteringRequired flag if true filteredColumns must be non-null
     * @param filteredColumns index of the columns to be filtered, 1-indexed, must be absolutely exclusive fields
     * @return table to be displayed on the screen
     */
    protected MyTable setTable(String name, String[] columnNames, boolean filteringRequired, int[] filteredColumns) {
        try {
            Tuple data = connectionModel.getDataFromDB(name);
            if (filteringRequired) {
                if(filteredColumns == null)
                    throw new NullPointerException();
                else
                    data = data.filterData(filteredColumns); //absolutely exclusive fields
            }
            MyTable table = new MyTable(data.getData(), columnNames);
            table.setTableConstraints(data.getWidth());
            return table;
        }
        catch (NullPointerException e){
            return new MyTable((new Tuple(0,0)).getData(), columnNames);
        }
    }

    /* Getters, Setters and Utility */
    /**
     * Creates a JScrollPane that contains the table of entries taken from the databse
     * @param tableName the name of the table in the database
     * @return JScrollPane that contains the data
     */
    protected JScrollPane getTable(String tableName) {
        MyTable myTable;
        if (tableName.equals("boss")) {
            myTable = this.setTable(tableName, this.columnNames, true, new int[]{2, 5, 6, 7, 8});
        }
        else if(tableName.equals("character")) {
            myTable = this.setTable(tableName, this.columnNames, true, new int[] {2, 4, 5, 6, 7});
        }
        else
            myTable = this.setTable( tableName, this.columnNames, false, null);
        JScrollPane scrollPane = new JScrollPane(myTable,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(800,400));
        return scrollPane;
    }
    /**
     * Displays a JScrollPane inside a JPanel
     * @param scrollPane JScrollPane to be displayed
     */
    protected void paintTable(JScrollPane scrollPane) {
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        this.content.add(scrollPane, c);
        this.content.repaint();
    }
    /**
     * Refreshes the screen table component
     * @param name name of the table component in the database
     */
    public void refresh(String name) {
        JScrollPane newPane = this.getTable(name);
        this.removeOldTable();
        this.paintTable(newPane);
    }
    /**
     *  Drops the current table from the JPanel
     */
    protected void removeOldTable() {
        Component[] components = this.content.getComponents();
        for (Component component : components) {
            if (component instanceof JScrollPane) {
                this.content.remove(component);
                break;
            }
        }
    }
    /**
     * Adds an X-type button to the current screen
     * @param actionListener button press
     */
    public void addHomeButton(ActionListener actionListener) {
        HomeButton currentScreenHomeButton = new HomeButton();
        currentScreenHomeButton.addActionListener(actionListener);
        this.footer.add(currentScreenHomeButton);
    }
    public void addArmorButton(ActionListener actionListener) {
        ArmorButton currentScreenArmorButton = new ArmorButton();
        currentScreenArmorButton.addActionListener(actionListener);
        this.content.add(currentScreenArmorButton);
    }
    public void addCommentButton(ActionListener actionListener) {
        CommentButton currentScreenCommentButton = new CommentButton();
        currentScreenCommentButton.addActionListener(actionListener);
        this.content.add(currentScreenCommentButton);
    }
    public void addBossButton(ActionListener actionListener) {
        BossButton currentScreenBossButton = new BossButton();
        currentScreenBossButton.addActionListener(actionListener);
        content.add(currentScreenBossButton);
    }
    public void addSorceryButton(ActionListener actionListener) {
        SorceryButton currentScreenSorceryButton = new SorceryButton();
        currentScreenSorceryButton.addActionListener(actionListener);
        this.content.add(currentScreenSorceryButton);
    }
    public void addIncantationButton(ActionListener actionListener) {
        IncantationButton currentScreenIncantationButton = new IncantationButton();
        currentScreenIncantationButton.addActionListener(actionListener);
        this.content.add(currentScreenIncantationButton);
    }
    public void addWeaponButton(ActionListener actionListener) {
        WeaponButton currentScreenWeaponButton = new WeaponButton();
        currentScreenWeaponButton.addActionListener(actionListener);
        this.content.add(currentScreenWeaponButton);
    }
    public void addCharacterButton(ActionListener actionListener) {
        CharacterButton currentScreenCharacterButton = new CharacterButton();
        currentScreenCharacterButton.addActionListener(actionListener);
        this.content.add(currentScreenCharacterButton);
    }
    public void addInsertButton() {
        InsertCommentButton currentInsertCommentButton = new InsertCommentButton();
        currentInsertCommentButton.setPreferredSize(new Dimension(200,100));
        this.footer.add(currentInsertCommentButton, BorderLayout.PAGE_END);
        //on button press create a pop-up window that fetches a Comment
        currentInsertCommentButton.addActionListener(e -> (new MultiInputOptionPane()).setLocationRelativeTo(null));
    }
    public void setId(Screens newName) {
        this.id = newName;
    }
    public Screens getId(){
        return this.id;
    }
}
