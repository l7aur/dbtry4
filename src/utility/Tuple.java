package utility;

import java.util.Arrays;

/**
 * Mathematical tuple composed of 3 items:
 * a matrix of strings that is intended to contain the entries taken out of the database
 * the number of columns of the above matrix
 * the number of rows of the above matrix
 */
public class Tuple {
    private String[][] data;
    private int width;
    private int length;
    //Constructor
    public Tuple(int numberOfRows, int numberOfColumns) {
        this.data = new String[numberOfRows][numberOfColumns];
        this.length = this.width = 0;
    }

    /**
     * Filters absolutely exclusive columns into one single column
     * @param columnIds represents the number of the columns that will fill the resulting column
     *                  is the columnIds[0]-th column in the resulting data matrix
     * @return the filtered data as a Tuple
     */
    public Tuple filterData(int[] columnIds) {
//debug        for (int id : columnIds) {
//debug            System.out.println(id);
//debug        }
        Arrays.sort(columnIds);
        Tuple newData = new Tuple(this.getLength(), this.getWidth());
        newData.setWidth(this.getWidth() - columnIds.length);
        newData.setLength(this.getLength());
        //go through all data
        for (int i = 0; i < this.getLength(); i++)
            for(int j = 0; j < this.getWidth(); j++){
                boolean test = true;
                for (int value : columnIds)
                    //check if the current column is part of the columns to be filtered
                    if (j == value) {
                        test = false;
                        //then check if the value in the column we are is not null
                        if (this.getDataValue(i, j) != null) {
                            //then place it in the new smallest column that is filtered
                            newData.setDataValue(this.getDataValue(i, j), i, columnIds[0]);
                            break;
                        }
                    }
                //if the column is not to be filtered
                if(test)
                    //then copy the entry
                    newData.setDataValue(this.getDataValue(i,j), i, j);
            }
        return newData;
    }
    public String[][] getData() {
        return data;
    }

    /**
     * Gets data stored in a specific entry of the matrix
     * @param row row of the entry
     * @param column column of the entry
     * @return the entry of the matrix at position (row,column)
     */
    public String getDataValue(int row, int column) {
        return data[row][column];
    }

    /**
     * Updates a specific entry in the matrix
     * @param newValue value to be places in the entry
     * @param row row of the entry
     * @param column column of the entry
     */
    public void setDataValue(String newValue, int row, int column) {
        this.data[row][column] = newValue;
    }
    /* Getters, Setters and other Utilities */
    public int getWidth() {
        return width;
    }
    public void incrementWidth(int value) {
        this.width += value;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    private void setLength(int length) {
        this.length = length;
    }
    public int getLength() {
        return length;
    }
    public void incrementLength(int value) {
        this.length += value;
    }
}
