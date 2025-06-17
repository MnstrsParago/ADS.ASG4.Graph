import java.util.List;

public interface Search<V> {
    List<V> getPath(V destination);
    boolean hasPathTo(V destination);
}
