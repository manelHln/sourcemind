package org.example.myproxy;

import org.example.Retry;

public class RealImage implements Image{
    private String filename;

    public RealImage(String filename) throws Exception {
        this.filename = filename;
        this.loadFromDisk();
    }

    @Retry(limit = 3, message = "Epic Fail")
    private void loadFromDisk() throws Exception {
        if(this.filename.length() < 5){
            throw new Exception();
        }
        System.out.println("Loading image " + this.filename);
    }

    @Override
    public void display() {
        System.out.println("Displaying image " + this.filename);
    }
}
