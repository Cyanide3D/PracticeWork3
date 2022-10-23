package org.example.four;

public class Generator {

    private final Queue queue;

    public Generator(Queue queue) {
        this.queue = queue;

        while (true) {
            File file = getFile();
            System.out.println("Generate new File " + file);
            queue.add(file);
        }
    }

    public File getFile() {
        try {
            Thread.sleep((long) ((Math.random() * 901) + 100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new File(getFileType(), getFileSize());
    }

    private FileType getFileType() {
        FileType[] values = FileType.values();
        return values[(int) (Math.random() * values.length)];
    }

    private int getFileSize() { //Берём рандомный размер файла в диапазоне от 10 до 100
        return (int) ((Math.random() * 91) + 10);
    }

}
