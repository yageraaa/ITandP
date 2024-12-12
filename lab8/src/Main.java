public class Main {
    public static void main(String[] args) {
        try {
            DataManager dataManager = new DataManager();

            dataManager.registerDataProcessor(new FilterProcessor());
            dataManager.registerDataProcessor(new TransformProcessor());
            dataManager.registerDataProcessor(new AggregateProcessor());

            dataManager.loadData("C:/Users/geraz/IdeaProjects/lab8/src/input.txt");

            dataManager.processData();

            dataManager.saveData("output.txt");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
