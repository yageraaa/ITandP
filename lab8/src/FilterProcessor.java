public class FilterProcessor {

    @DataProcessor
    public String filterShortLines(String line) {
        if (line.length() > 5) {
            return line;
        } else {
            return null;
        }
    }
}
