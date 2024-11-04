public class Main {
    public static void main(String[] args) {

        CircularList<Integer> circularList = new CircularList<>();

        //insert end
        circularList.insertEnd(1);
        circularList.insertEnd(3);
        circularList.insertEnd(5);
        circularList.print();
        //insert beginning
        circularList.insertBeginning(2);
        circularList.print();
        //remove beginning
        circularList.removeBeginning();
        circularList.print();
        //remove end
        circularList.removeEnd();
        circularList.print();
        //insert position
        circularList.insertPosition(0,2);
        circularList.print();
        //remove position
        circularList.removePosition(0);
        circularList.print();
        //remove by value
        circularList.removeByValue(1);
        circularList.print();
        //search value
        circularList.searchValue(0);
        circularList.print();
        //search position
        circularList.searchPosition(1);
        circularList.print();
    }
}