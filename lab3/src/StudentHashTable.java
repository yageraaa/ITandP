import java.util.LinkedList;

public class StudentHashTable {
    private static final int DEFAULT_CAPACITY = 16;
    private LinkedList<Entry>[] table;
    private int size;
    private static class Entry {

        private String gradebookNumber;
        private Student student;

        public Entry(String gradebookNumber, Student student) {
            this.gradebookNumber = gradebookNumber;
            this.student = student;
        }

        public String getGradebookNumber() {
            return gradebookNumber;
        }

        public Student getStudent() {
            return student;
        }

        public void setStudent(Student student) {
            this.student = student;
        }
    }

    public StudentHashTable() {
        @SuppressWarnings("unchecked")
        LinkedList<Entry>[] tempTable = new LinkedList[DEFAULT_CAPACITY];
        this.table = tempTable;
        this.size = 0;
    }

    private int hash(String key) {
        if (key == null) {
            throw new IllegalArgumentException("Номер зачетной книжки не может быть null");
        }
        return Math.abs(key.hashCode() % table.length);
    }

    public void insert(String gradebookNumber, Student student) {
        int index = hash(gradebookNumber);
        if (table[index] == null) {
            table[index] = new LinkedList<Entry>();
        }
        for (Entry entry : table[index]) {
            if (entry.getGradebookNumber().equals(gradebookNumber)) {
                entry.setStudent(student);
                return;
            }
        }
        table[index].add(new Entry(gradebookNumber, student));
        size++;
    }

    public Student find(String gradebookNumber) {
        int index = hash(gradebookNumber);
        if (table[index] == null) {
            return null;
        }
        for (Entry entry : table[index]) {
            if (entry.getGradebookNumber().equals(gradebookNumber)) {
                return entry.getStudent();
            }
        }
        return null;
    }

    public void delete(String gradebookNumber) {
        int index = hash(gradebookNumber);
        if (table[index] == null) {
            return;
        }
        Entry toRemove = null;
        for (Entry entry : table[index]) {
            if (entry.getGradebookNumber().equals(gradebookNumber)) {
                toRemove = entry;
                break;
            }
        }
        if (toRemove != null) {
            table[index].remove(toRemove);
            size--;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}