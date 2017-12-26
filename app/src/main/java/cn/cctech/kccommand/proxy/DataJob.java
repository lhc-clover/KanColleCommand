package cn.cctech.kccommand.proxy;

import cn.cctech.kccommand.utils.Dispatcher;

public class DataJob implements Runnable {

    private String url;
    private byte[] requestBytes;
    private byte[] responseBytes;

    public DataJob(String u, byte[] b1, byte[] b2) {
        url = u;
        requestBytes = b1;
        responseBytes = b2;
    }

    @Override
    public void run() {
        Dispatcher.INSTANCE.dispatch(url, requestBytes, responseBytes);
    }
}
