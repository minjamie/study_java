package com.example.chat2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChatThread extends Thread{
    private String name;
    private BufferedReader br;
    private PrintWriter pw;
    private Socket socket;
    List<ChatThread> list;



    public ChatThread(Socket socket, List<ChatThread> list) throws  Exception {
        this.socket = socket;
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        this.br = br;
        this.pw = pw;
        this.name = br.readLine();
        this.list = list;
        this.list.add(this);
    }

    public void sendMessage(String msg){
        pw.println(msg);
        pw.flush();
    }

    @Override
    public void run() {
        // ChatThread는 사용자가 보낸 메세지 읽으들여 접속된 모든 클라이언트에게 보냄 (broadCast)

        // 나를 제외한 모든 사용자에게 "00님 연결"
        try {
        broadcast(name +"님이 연결", false);

        String line = null;
            while ((line = br.readLine())!=null){
                // 나를 포함한 chatThread에게 메세지 보냄
                if("quit".equals(line))
                    break;
                broadcast(name+":"+line, true);
            }
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            this.list.remove(this);
            broadcast(name + "님과 연결 끊어짐", false);
            try {
                br.close();
            }catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private void broadcast(String msg, boolean includeMe){
        List<ChatThread> chatThreads = new ArrayList<>();
        for (int i = 0; i < this.list.size(); i++) {
            chatThreads.add(list.get(i));
        }

        try {
            for (int i = 0; i < chatThreads.size(); i++) {
                ChatThread ct = chatThreads.get(i);
                if(!includeMe){
                    if(ct == this){
                        continue;
                    }
                }
                ct.sendMessage(msg);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

