public class Main {
	public static void main(String[] args) {

		Todo todo = new Todo();
		todo.addTask("Ryd op", 1, 50);
		todo.addTask("Ryd op", 2, 40);
		todo.addTask("Ryd op", 3, 30);
		todo.addTask("Ryd op", 4, 44);
		todo.addTask("Ryd op", 2, 60);
		todo.addTask("Ryd op", 3, 70);
		todo.completeTask(0);
		todo.print();

	}
}