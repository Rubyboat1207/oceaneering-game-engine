package rubyboat.oceaneer.data;

import java.util.HashMap;

public class Registry <T> {

    HashMap<Identifier, T> registry;

    public Registry() {
        registry = new HashMap<>();
    }

    public void register(Identifier id, T object) {
        if(registry.containsKey(id)) {
            System.out.println("Error: Identifier " + id.getNamespace() + ":" + id.getPath() + " already exists in registry!");
        } else {
            registry.put(id, object);
        }
    }
}
