package utility;

public class Tuple {
    private String[][] data;
    private int width;
    private int length;
    public Tuple(int numberOfRows, int numberOfColumns) {
        this.data = new String[numberOfRows][numberOfColumns];
        this.length = this.width = 0;
    }

    public Tuple filterData(int[] columnIds) {
        for (int id : columnIds) {
            System.out.println(id);
        }
        Tuple newData = new Tuple(this.getLength(), this.getWidth());
        newData.setWidth(this.getWidth() - columnIds.length);
        newData.setLength(this.getLength());
        for (int i = 0; i < this.getLength(); i++)
            for(int j = 0; j < this.getWidth(); j++){
                boolean test = true;
                for (int value : columnIds)
                    if (value == j) {
                        test = false;
                        for(int goodValue : columnIds)
                            if(this.getDataValue(i, goodValue) != null)
                                newData.setDataValue(this.getDataValue(i, goodValue), i, j);
                    }
                if(test)
                    newData.setDataValue(this.getDataValue(i,j), i, j);
            }
        return newData;
    }
    public String[][] getData() {
        return data;
    }
    public String getDataValue(int row, int column) {
        return data[row][column];
    }

    public void setDataValue(String newValue, int row, int column) {
        this.data[row][column] = newValue;
    }

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
