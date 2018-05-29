class DyanmicArray{
    private int arr[];
    private int nextIndex;

    DyanmicArray(){
        arr = new int[5];
        nextIndex = 0;
    }

    void add(int element){
        if(nextIndex==arr.length){
            restructure();
        }
        arr[nextIndex] = element;
        nextIndex++;
    }
    private void restructure(){
        int temp[] = arr;
        arr = new int[arr.length*2];
        for(int i=0;i<temp.length;i++){
            arr[i] = temp[i];
        }
    }
     private int size(){
        return nextIndex;
    }
    public void showArray(){
        for(int i=0;i<size();i++){
            System.out.print(arr[i] + " ");
        }
    }
    int get(int index){
        if(index>=nextIndex){
            return -1;
        }
        return arr[index];
    }
    void set(int index, int element){
        if(index>nextIndex){
            System.out.println("Abbey Not Possible");
        }
        else if(index<nextIndex){
            arr[index] = element;
        }
        else {
            add(element);
        }
    }
    boolean isEmpty(){
        if(size()==0){
            return true;
        }
        else {
            return false;
        }
    }
    int removeFromLast(){
        if(!isEmpty()) {
            int number = arr[nextIndex - 1];
            arr[nextIndex - 1] = 0;
            nextIndex--;
            return number;
        }
        else {System.out.println("Ab nhi yr"); return -1;}
    }
}
class Main{
    public static void main(String[] args) {
        DyanmicArray array = new DyanmicArray();
        array.add(5);
        for(int i=0;i<6;i++){
            array.add(i*7);
        }
        array.set(7,4);
        array.showArray();
        System.out.println("\n" +  array.removeFromLast());
        System.out.println("\n" + array.get(2));
        array.showArray();
        while (!array.isEmpty()){
            System.out.println( array.removeFromLast());
        }
        array.showArray();
    }
}