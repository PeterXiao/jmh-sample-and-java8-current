/**
 * 
 */
package problems.jvm;

/**
 * @author xiaoy
 *
 */
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class NIO2 {
    private static volatile  boolean keepRunning = true;
    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress(8090), 128);
        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        Selector socketChannelSelector = Selector.open();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (keepRunning) {
                        int select = selector.select();
                        if (select > 0) {
                            Set<SelectionKey> selectedKeys = selector.selectedKeys();
                            Iterator<SelectionKey> iterator = selectedKeys.iterator();
                            while (iterator.hasNext()) {
                                SelectionKey next = iterator.next();
                                if (next.isValid()){
                                    if(next.isAcceptable()) {
                                        SocketChannel accept = ((ServerSocketChannel) next.channel()).accept();
                                        accept.configureBlocking(false);
                                        // thread block 怎么绕过 还是说我用的不对
                                        accept.register(socketChannelSelector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
                                    }
                                }else {
                                    socketChannelSelector.keys().remove(next);
                                }
                                iterator.remove();
                            }
                        }
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (keepRunning) {
                        int select = socketChannelSelector.select();
                        if (select > 0) {
                            Set<SelectionKey> selectedKeys = socketChannelSelector.selectedKeys();
                            Iterator<SelectionKey> iterator = selectedKeys.iterator();
                            while (iterator.hasNext()) {
                                SelectionKey next = iterator.next();
                                if (next.isReadable()) {

                                } else if (next.isWritable()) {
                                    ByteBuffer byteBuffe = ByteBuffer.allocate(4);
                                    int l = (int)(System.currentTimeMillis() / 1000L + 2208988800L);
                                    byteBuffe.put(fromInt(l));
                                    byteBuffe.flip();
                                    ((SocketChannel) next.channel()).write(byteBuffe);
                                    ((SocketChannel) next.channel()).close();
                                }
                                iterator.remove();
                            }
                        }
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }).start();

    }

    public static byte[] fromInt(int i) {
        byte[] result = new byte[4];
        result[3] = (byte) (i);
        result[2] = (byte) (i >> 8);
        result[1] = (byte) (i >> 16);
        result[0] = (byte) (i >> 24);
        return result;
    }

    public static int fromByteArray(byte[] bytes) {
        if (bytes.length != 4) {
            throw new IllegalArgumentException("bytes array length = " + bytes.length);
        }
        //
        int a = bytes[3] & 0x000000ff;
        a |= (bytes[2] << 8) & 0x0000ffff;
        a |= (bytes[1] << 16) & 0x00ffffff;
        a |= (bytes[0] << 24) & 0xFFffffff;
        return a;
    }
}