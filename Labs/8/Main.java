import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        List<String> inputData = List.of("apple", "banana","" , " ", "date");
        java.nio.file.Files.write(java.nio.file.Paths.get("C:\\Users\\chiri\\Desktop\\Labi\\ИТИП\\Labs\\8\\input.txt"), inputData);
        
        DataManager dataManager = new DataManager();
        dataManager.registerDataProcessor(new DataProcessors());

        dataManager.loadData("C:\\Users\\stekkz\\Desktop\\ИТИП\\Labs\\8\\input.txt");

        dataManager.processData();

        dataManager.saveData("C:\\Users\\stekkz\\Desktop\\ИТИП\\Labs\\8\\output.txt");
    }
}