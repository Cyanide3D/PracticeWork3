package org.example.four;

public class File {

    private FileType type;
    private int size;

    public File() {
    }

    public File(FileType type, int size) {
        this.type = type;
        this.size = size;
    }

    public FileType getType() {
        return type;
    }

    public void setType(FileType type) {
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "File{" +
                "type=" + type +
                ", size=" + size +
                '}';
    }
}
