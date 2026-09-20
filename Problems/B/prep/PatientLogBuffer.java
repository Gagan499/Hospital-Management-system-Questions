package B.prep;

import java.util.Stack;

public class PatientLogBuffer {

    private Stack<String> undoStack = new Stack<>();
    private Stack<String> redoStack = new Stack<>();

    public void writeLog(String message) {

        if (message == null) {
            throw new IllegalArgumentException();
        }
        undoStack.push(message);
        redoStack.clear();
    }

    public String undoAction() {
        if (undoStack.isEmpty()) {
            return null;
        }
        String message = undoStack.pop();
        redoStack.push(message);
        if (undoStack.isEmpty()) {
            return null;
        }
        return undoStack.peek();
    }

    public String redoAction() {
        if (redoStack.isEmpty()) {
            return null;
        }
        String message = redoStack.pop();
        undoStack.push(message);
        return message;
    }

    public static void main(String[] args) {
        PatientLogBuffer log = new PatientLogBuffer();
        log.writeLog("Patient Registered");
        log.writeLog("Vitals Stabilized");
        System.out.println(log.undoAction());
        System.out.println(log.redoAction());
    }
}
