package gui;

import backend.ConnectionModel;
import gui.buttons.*;
import utility.MultiInputOptionPane;
import utility.MyTable;
import utility.Screens;
import utility.Tuple;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Screen extends JPanel {

//    private HomeButton currentScreenHomeButton;
//    private ArmorButton currentScreenArmorButton;
//    private BossButton currentScreenBossButton;
//    private IncantationButton currentScreenIncantationButton;
//    private SorceryButton currentScreenSorceryButton;
//    private CharacterButton currentScreenCharacterButton;
//    private WeaponButton currentScreenWeaponButton;
//    private InsertCommentButton currentInsertCommentButton;
//    private CommentButton currentScreenCommentButton;
    protected ConnectionModel connectionModel; //TODO move this into buttons as variable
    private Screens id = Screens.SCREEN;
    protected JPanel header;
    protected JPanel footer; //good for even spacing
    protected JPanel content;
    public Screen(Screens title) {
        super();
        header = new JPanel();
        footer = new JPanel();
        content = new JPanel();
        connectionModel = new ConnectionModel();
        connectionModel.connect();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(header);
        this.add(content);
        this.add(footer);
        this.setPreferredSize(new Dimension(1080, 720));
        JLabel text = new JLabel(title.toString().toUpperCase().replace('_', ' '));
        this.header.add(text);
    }
    /**
     * Fetch data from database and display it into a table
     * @param name name of the table
     * @param columnNames names of the columns of the table taken from the database
     * @param numberOfColumns TODO sql function so that i can remove this parameter
     * @param filteringRequired flag if true filteredColumns must be non-null
     * @param filteredColumns index of the columns to be filtered, 1-indexed, must be absolutely exclusive fields
     * @return table to be displayed on the screen
     */
    protected JTable setTable(String name, String[] columnNames, int numberOfColumns, boolean filteringRequired, int[] filteredColumns) {
        try {
            Tuple data = this.connectionModel.getDataFromDB(name, this.connectionModel.getNumberOfRows(name), numberOfColumns);
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
     * Adds an X-type button to the current screen
     * @param actionListener button press
     */
    public void addHomeButton(ActionListener actionListener) {
        HomeButton currentScreenHomeButton = new HomeButton();
        currentScreenHomeButton.addActionListener(actionListener);
        this.content.setAlignmentX(Container.LEFT_ALIGNMENT);
        this.content.add(currentScreenHomeButton);
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
        //String screen = this.id.toString();
        this.content.setAlignmentX(Container.LEFT_ALIGNMENT);
        this.content.add(currentInsertCommentButton);
        currentInsertCommentButton.addActionListener(new ActionListener() {
            //on button press create a pop-up window that fetches a Comment
            @Override
            public void actionPerformed(ActionEvent e) {
                new MultiInputOptionPane();
            }
        });
    }
    public void setId(Screens newName) {
        this.id = newName;
    }
    public Screens getId(){
        return this.id;
    }
}
