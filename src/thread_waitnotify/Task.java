package thread_waitnotify;

public class Task {

    private int leftCopyCount;
    private String wordToCopy;

    public int getLeftCopyCount() {
        return leftCopyCount;
    }

    public void setLeftCopyCount(int leftCopyCount) {
        this.leftCopyCount = leftCopyCount;
    }

    public String getWordToCopy() {
        return wordToCopy;
    }

    public void setWordToCopy(String wordToCopy) {
        this.wordToCopy = wordToCopy;
    }

    public Task(int leftCopyCount, String wordToCopy) {
        this.leftCopyCount = leftCopyCount;
        this.wordToCopy = wordToCopy;
    }
}
