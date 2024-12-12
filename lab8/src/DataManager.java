import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.*;
import java.lang.reflect.Method;
import java.util.stream.Collectors;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class DataManager {

    private List<Object> processors = new ArrayList<>();
    private List<String> data = new ArrayList<>();

    public void registerDataProcessor(Object processor) {
        processors.add(processor);
    }

    public void loadData(String source) throws IOException {
        data = Files.readAllLines(Paths.get(source));
    }

    public void processData() throws Exception {
        List<String> currentData = data;

        for (Object processor : processors) {
            for (Method method : processor.getClass().getDeclaredMethods()) {
                if (method.isAnnotationPresent(DataProcessor.class)) {
                    currentData = processWithMethod(processor, method, currentData);
                }
            }
        }

        data = currentData;
    }

    private List<String> processWithMethod(Object processor, Method method, List<String> inputData) {
        return inputData.parallelStream()
                .map(item -> {
                    try {
                        Object result = method.invoke(processor, item);
                        return (String) result;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return null;
                    }
                })
                .filter(item -> item != null)
                .collect(Collectors.toList());
    }

    public void saveData(String destination) throws IOException {
        Files.write(Paths.get(destination), data);
    }
}
