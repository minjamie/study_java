package com.example.chat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChatServer {
    public static void main(String[] args)  throws Exception{
        ServerSocket serverSocket = new ServerSocket(9999);
        // 공유객체에서 쓰레드에 안전한 리스트 만듦
        List<PrintWriter> outList = Collections.synchronizedList(new ArrayList<>());

        while (true){
            Socket socket = serverSocket.accept();
            System.out.println("----------------접속----------------" + socket);
            ChatThread chatThread = new ChatThread(socket, outList);
            chatThread.start();
        }
    }
}

class ChatThread extends Thread {
      private Socket socket;
    private List<PrintWriter> outList;
    private PrintWriter out;
    private BufferedReader in;
    public ChatThread(Socket socket, List<PrintWriter> outList) {
        this.socket = socket;
        this.outList = outList;
        // 1. 소켓으로 부터 읽어들일 수 있는 객체 얻기
        // 2. 소켓을 쓰기 위한 객체 얻기 (현재 연결된 클라이언트에게 쓰는 객체)
        try {
            out = new PrintWriter(new OutputStreamWriter((socket.getOutputStream())));
            in = new BufferedReader((new InputStreamReader(socket.getInputStream())));
            outList.add(out);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void run() {
        String line = null;
        try {
            // 3. 클라이언트가 보낸 메세지 일기
            // 4. 접속한 모든 클라이언트에게 메세지 보냄 (현재 접속된 모든 클라인어트에게 쓸 수 있는 객체 필요)
            while ((line = in.readLine()) != null){
                for (int i = 0; i < outList.size(); i++) { // 접속한 모든 클라이언트에게 메세지 전송
                    PrintWriter o = outList.get(i);
                    o.println(line);
                    o.flush();
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            // 접속이 끊어질 때
            try {
                outList.remove(out);
            }catch (Exception e){
                e.printStackTrace();
            }

            for (int i = 0; i < outList.size(); i++) { // 접속한 모든 클라이언트에게 메세지 전송
                PrintWriter o = outList.get(i);
                o.println("접속 끊김");
                o.flush();
            }

            try {
                socket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}