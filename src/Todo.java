import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Todo {
	private List<Task> tasks;
	private int workCompleted;

	public Todo() {
		this.tasks = new ArrayList<>();
	}

	public void addTask(String description, int priority, int minutes) {
		try {
			tasks.add(new Task(description, priority, minutes));
		} catch (InvalidTaskException e) {
			System.out.println(e.getMessage());
		}
	}

	public void print() {
		System.out.print("Todo:\n-----\n");
		if (tasks.isEmpty()) {
			System.out.println("You're all done for today! #TodoZero");
			printWorkCompleted();
			return;
		}

		for (Task task : tasks) {
			System.out.println(task.toString());
		}

		printWorkCompleted();
	}

	private void printWorkCompleted() {
		if (workCompleted > 0) System.out.printf("%d minutes of work done!", workCompleted);
	}

	public void printPriority(int limit) {
		System.out.print("Filtered todo:\n--------------\n");

		List<Task> prioritizedTasks = tasks.stream()
				.filter(task -> task.getPriority() <= limit)
				.toList();

		prioritizedTasks.forEach(task -> System.out.println(task.toString()));

		if (prioritizedTasks.isEmpty()) {
			System.out.println("No tasks with given priority");
		}
	}

	public void printPrioritized() {
		System.out.print("Prioritized todo:\n-----------------\n");

		List<Task> tasksSorted = tasks;
		tasksSorted.sort(Comparator
				.comparing(Task::getPriority)
				.thenComparing(Task::getWorkload)
		);

		tasksSorted.forEach(task -> System.out.println(task.toString()));
	}

	public void completeTask(int index) {
		if (index >= tasks.size() || index < 0) {
			System.out.println("Invalid index");
			return;
		}

		workCompleted += tasks.get(index).getWorkload();
		tasks.remove(index);
	}
}
