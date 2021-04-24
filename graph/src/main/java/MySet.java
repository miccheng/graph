import java.util.Arrays;

public class MySet {
    int count = 0;
    Object[] store_data = new Object[8];

    public boolean isEmpty() {
        return (size()==0);
    }

    public void add(String value) {
        if(hasValue(value)) return;

//        expandIfFull();

        if(isFull()) expandArray();

        store_data[count] = value;
        count++;
    }

//    private void expandIfFull() {
//        if (count==store_data.length) {
//            Object[] expanded_array = new Object[count*2];
//            System.arraycopy(store_data,0,expanded_array,0,count);
//            store_data = expanded_array;
//        }
//    }

    private void expandArray() {
        Object[] expanded_array = new Object[count*2];
        System.arraycopy(store_data,0,expanded_array,0,count);
        store_data = expanded_array;
    }

    private boolean isFull() {
        return count==store_data.length;
    }

    public int size() {
        return count;
    }

    public boolean hasValue(String value) {
        return checkExistence(value)>-1;
    }

    private int checkExistence(String value) {
        for (int i = 0; i < count; i++) {
            if (value.equals(store_data[i])) {
                return i;
            }
        }
        return -1;
    }

    public void remove(String value) {
        if(!hasValue(value)) return;
        int index = checkExistence(value);
        store_data[index]=store_data[count-1];
        store_data[count-1]="";
        count--;
    }


}
