package com.brahvim.college_assignments.back;

import java.util.ArrayDeque;
import java.util.ArrayList;

public final class Task {

	public static final ArrayList<String> taskTexts = new ArrayList<>();
	public static final ArrayDeque<Integer> tasksAll = new ArrayDeque<>();
	public static final ArrayDeque<Integer> tasksFree = new ArrayDeque<>();
	public static final ArrayDeque<Integer> tasksActive = new ArrayDeque<>();

	public int id;

	public static synchronized int createTask() {
		Integer id = Task.tasksFree.poll();

		if (id == null) {
			id = 1 + Task.tasksAll.size();
		}

		Task.tasksAll.push(id);
		Task.tasksActive.push(id);

		return id;
	}

	public static synchronized void deleteTask(final Integer p_id) {
		Task.tasksActive.remove(p_id);
		Task.tasksFree.add(p_id);
	}

	public Task() {
		this.id = Task.createTask();
	}

	public void delete() {
		Task.deleteTask(this.id);
	}

}
