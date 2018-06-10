package cc.shixw.fakebio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.CountDownLatch;

public class TimeClient {

    public static void main(String[] args) throws IOException, InterruptedException {
        int port = 8899;

        Socket socket = null;
        BufferedReader in = null;
        PrintWriter out = null;

        try {
            socket = new Socket("127.0.0.1",port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(),true);
            out.println("QUERY TIMR ORDER");
            System.out.println("Send order 2 server");
            String response = in.readLine();
            System.out.println("Now is "+response);
            out.println("QUERY TIMR ORDER");
            System.out.println("Send order 2 server");
            response = in.readLine();
            System.out.println("Now is "+response);
            out.println("QUERY TIMR ORDER");
            System.out.println("Send order 2 server");
            response = in.readLine();
            System.out.println("Now is "+response);
            out.println("QUERY TIMR ORDER");
            System.out.println("Send order 2 server");
            response = in.readLine();
            System.out.println("Now is "+response);
            out.println("QUERY TIMR ORDER");
            System.out.println("Send order 2 server");
            response = in.readLine();
            System.out.println("Now is "+response);
            new CountDownLatch(1).await();
        } finally {
            if (out!=null){
                out.close();
                out = null;
            }
            if (in!=null){
                in.close();
                in = null;
            }
            if (socket!=null){
                socket.close();
                socket=null;
            }

        }
    }
}
