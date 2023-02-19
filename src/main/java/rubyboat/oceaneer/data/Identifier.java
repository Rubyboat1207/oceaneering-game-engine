package rubyboat.oceaneer.data;

public class Identifier {
    String namespace;
    String path;

    public static String getDefaultNamespace() {
        return "oceaneer";
    }

    public Identifier(String namespace, String path) {
        this.namespace = namespace;
        this.path = path;
    }

    public Identifier(String path) {
        this.namespace = getDefaultNamespace();
        this.path = path;
    }

    public String getNamespace() {
        return namespace;
    }

    public String getPath() {
        return path;
    }


}
