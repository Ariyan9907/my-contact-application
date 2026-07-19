package com.bridgelabz.command;

import java.util.Stack;

public class CommandManager {

    private final Stack<Command> undoStack = new Stack<>();
    private final Stack<Command> redoStack = new Stack<>();

    public void executeCommand(Command command) {

        command.execute();

        undoStack.push(command);

        redoStack.clear();

    }

    public void undo() {

        if (undoStack.isEmpty()) {

            System.out.println("Nothing to Undo");

            return;
        }

        Command command = undoStack.pop();

        command.undo();

        redoStack.push(command);

        System.out.println("Undo Successful");

    }

    public void redo() {

        if (redoStack.isEmpty()) {

            System.out.println("Nothing to Redo");

            return;
        }

        Command command = redoStack.pop();

        command.execute();

        undoStack.push(command);

        System.out.println("Redo Successful");

    }

}