package Client;

import MessageTypes.Message;
import MessageTypes.Notification;

import java.io.*;
import java.net.Socket;

public class ClientNotification implements Runnable {
    NotificationListener listener;
    private Socket socket;
    private BufferedReader in;
    private BufferedWriter out;
    private String hostname;
    private int port;
    private int userID;

    public ClientNotification(NotificationListener listener,String hostname,int port,int userID) {
        this.listener = listener;
        this.hostname = hostname;
        this.port = port;
        this.userID = userID;
    }
    private void connectServer() {
        if(this.socket == null) {
            connectSocket();
            return;
        }
        if(!this.socket.isConnected()) {
            connectSocket();
        }
    }

    private void close() {
        try {
            if(this.socket == null) return;
            this.socket.close();
            this.in.close();
            this.out.close();
            this.socket = null;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void write(Message msg) {
        try {
            this.out.write(msg.toString());
            this.out.newLine();
            this.out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void connectSocket() {
        try {
            this.socket = new Socket(hostname, port);
            this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        connectServer();
        write(new Notification(userID));
        try {
            Notification notification = new Notification(this.in.readLine());
            MusicUploadNotification musicUploadNotification = new MusicUploadNotification();
            listener.showMusicUploadNotification(musicUploadNotification);
        } catch (IOException e) {
            e.printStackTrace();
        }
        close();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}