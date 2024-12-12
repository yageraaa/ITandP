public class AggregateProcessor {

    @DataProcessor
    public String addSuffix(String line) {
        return line + " Suffix";
    }
}
