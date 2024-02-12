package org.example.myproxy;


public class ProxyImage implements Image {
    private Image realImage;
    private String filename;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() throws Exception {
        if (realImage == null) {
            realImage = (Image) RetryProxy.createProxy(new RealImage(filename), 3, "Epic Fail");
        }
        realImage.display();
    }
}
