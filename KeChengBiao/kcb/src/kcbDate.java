import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class kcbDate implements TableModel {
    private String [] title={
            "周一","周二","周三","周四","周五","周六","周七"
    } ;
    private String [] [] date=new String[8][7];
    //初始化
    public kcbDate(){
        for(int i=0;i<date.length;i++){
            for (int j=0;j<date[i].length;j++){
                date[i][j]=" ";
            }

        }
    }
    @Override
    public int getRowCount() {
        return 8;
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return title[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return date[rowIndex][columnIndex];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
          date[rowIndex][columnIndex]=(String)aValue;
    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }
}
