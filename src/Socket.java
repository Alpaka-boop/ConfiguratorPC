import java.util.Objects;

public class Socket {
    private String socketName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Socket socket = (Socket) o;
        return Objects.equals(socketName, socket.socketName);
    }
}
