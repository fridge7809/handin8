import java.util.Comparator;

public class Task {
	private String description;
	private int priority;
	private int workload;

	public Task(String description, int priority, int workload) {
		if (priority < 1 || priority > 4) {
			throw new InvalidTaskException(String.format("%s has invalid priority", description));
		}
		if (workload < 1) {
			throw new InvalidTaskException(String.format("%s has invalid workload", description));
		}
		this.description = description;
		this.priority = priority;
		this.workload = workload;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append(description).append(" takes ");
		sb.append(workload).append(" minutes and has priority ");
		sb.append(getPriorityAsString(priority));
		return sb.toString();
	}

	private String getPriorityAsString(int priority) {
		return switch (priority) {
			case 1 -> "very important";
			case 2 -> "important";
			case 3 -> "unimportant";
			case 4 -> "after learn Portuguese";
			default -> null;
		};
	}

	public int getWorkload() {
		return workload;
	}

	public int getPriority() {
		return priority;
	}

}
