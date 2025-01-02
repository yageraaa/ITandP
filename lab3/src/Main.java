public class Main {
    public static void main(String[] args) {
        StudentHashTable studentTable = new StudentHashTable();

        Student student1 = new Student("Иван", "Иванов", 20, 4.5);
        Student student2 = new Student("Мария", "Петрова", 19, 4.8);
        Student student3 = new Student("Сергей", "Сидоров", 21, 4.2);

        studentTable.insert("A123", student1);
        studentTable.insert("B456", student2);
        studentTable.insert("C789", student3);

        Student foundStudent = studentTable.find("B456");
        if (foundStudent != null) {
            System.out.println("Студент найден: " + foundStudent);
        } else {
            System.out.println("Студент с таким номером зачетки не найден.");
        }

        studentTable.delete("A123");

        Student deletedStudent = studentTable.find("A123");
        if (deletedStudent != null) {
            System.out.println("Студент найден: " + deletedStudent);
        } else {
            System.out.println("Студент с номером A123 успешно удалён.");
        }

        System.out.println("Количество студентов в таблице: " + studentTable.size());
    }
}