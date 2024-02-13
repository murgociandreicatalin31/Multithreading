package ro.ctrln.java.wait_notify;

public class FileResource {

    private FileState state;

    public FileResource() {
        this.state = FileState.WRITE;
    }

    public synchronized void markAsWritten() {
        this.state = FileState.READ;
        notifyAll();
    }

    public synchronized void markAsRead() {
        this.state = FileState.DELETE;
        notifyAll();
    }

    public synchronized void markAsDeleted() {
        this.state = FileState.WRITE;
        notifyAll();
    }

     public synchronized void waitForReading() throws InterruptedException {
        while(this.state != FileState.READ) {
            wait();
        }
    }

    public synchronized void waitForWriting() throws InterruptedException {
        while(this.state != FileState.WRITE) {
            wait();
        }
    }

    public synchronized void waitForDeleting() throws InterruptedException {
        while(this.state != FileState.DELETE) {
            wait();
        }
    }
}
