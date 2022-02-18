public class MyIntArray {
    private int[] array;
    private int used;
    private final int DEFAULT_CAPACITY = 20;

    public MyIntArray(){
        array = new int[DEFAULT_CAPACITY];
        used = 0;
    }

    public int length(){
        return used;
    }
    public int getCapacity(){
        return array.length;
    }

    public void addCapacity(int capacityToAdd){
        int[] newArray = new int[getCapacity()+capacityToAdd];
        System.arraycopy(array,0,newArray,0,getCapacity());
        array = newArray;
    }

    public void addLast(int element){
        if(used>=getCapacity()){
            addCapacity(DEFAULT_CAPACITY);
        }
        array[used++]= element;
    }
    public void insert(int element, int index){
        if(index == used){
            addLast(element);
            return;
        } else if(index > used || index < 0){
            throw new ArrayIndexOutOfBoundsException();
        }

        int additionalLength = 0;
        if(used >= getCapacity())
            additionalLength = DEFAULT_CAPACITY;

        int[] newArray = new int[getCapacity()+additionalLength];

        System.arraycopy(array,0,newArray,0,index);
        newArray[index]=element;
        System.arraycopy(array,index,newArray,index+1,used-index+1);

        array = newArray;
        used++;
    }
    public void remove(int index){
        if(index>=used || index < 0)
            throw new ArrayIndexOutOfBoundsException();
        System.arraycopy(array,index+1,array,index,used-index);
    }

    @Override
    public String toString(){
        if(used == 0)
            return "[empty]";
        var sb = new StringBuilder();
        sb.append('[');
        sb.append(array[0]);
        int i = 1;
        while(i < used){
            sb.append(' ');
            sb.append(array[i]);
            i++;
        }
        sb.append(']');
        return sb.toString();
    }


    public void clear(){
        array = new int[DEFAULT_CAPACITY];
        used= 0;
    }
    private void swap(int index1, int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
    public void sort(){
        quickSort(0,used-1);
    }
    private void quickSort(int low, int high){
        if(low < high){
            int q = partition(low,high);
            quickSort(low,q-1);
            quickSort(q+1,high);
        }
    }
    private int partition(int low, int high){
        int pivot = array[high];
        int i = low;
        for(int j = low; j<high;j++){
            if(pivot >= array[j]) {
                swap(i, j);
                i++;
            }
        }
        swap(i,high);
        return i;
    }
}
