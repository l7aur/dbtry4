package utility;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;

public class MyTable extends JTable {
    public MyTable(String[][] data, String[] columnNames) {
        super(data, columnNames);
        this.setAlignmentX(JTable.AUTO_RESIZE_ALL_COLUMNS);
        this.setAlignmentX(CENTER_ALIGNMENT);
    }
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
    @Override
    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
        Component component = super.prepareRenderer(renderer, row, column);
        int rendererWidth = component.getPreferredSize().width;
        TableColumn tableColumn = getColumnModel().getColumn(column);
        tableColumn.setPreferredWidth(Math.max(rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
        return component;
    }
    public void setTableConstraints(int numberOfColumns) {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        this.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        for(int i = 0; i < numberOfColumns; i++)
            this.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );
    }
}
