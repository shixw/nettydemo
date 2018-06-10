package cc.shixw.fakebio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TimeServer {

    public static void main(String[] args) throws IOException {
        int port=8899;

        ServerSocket server = null;

        try {
            server = new ServerSocket(port);
            System.out.println("Time Server is start in port:"+port);
            Socket socket = null;
            TimeServerHandlerExecutePool singleExecutor = new TimeServerHandlerExecutePool(50,1000);
            while (true){
                socket = server.accept();
                singleExecutor.execute(new TimeServerHandler(socket));
            }
        }finally {
            if (server!=null){
                System.out.println("time server close");
                server.close();
                server = null;
            }
        }
    }
}
