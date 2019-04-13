import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PrintableHashMap<K, V> extends HashMap<K, V> {
	@Override
	public String toString() {
		Iterator<Entry<K, V>> i = entrySet().iterator();
		if (!i.hasNext()) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		while (true) {
			Map.Entry<K, V> e     = i.next();
			K               key   = e.getKey();
			V               value = e.getValue();
			sb.append(key == this ? "(this Map)" : key);
			sb.append(':');
			sb.append(value == this ? "(this Map)" : value);
			if (!i.hasNext())
				return sb.toString();
			sb.append("\n");
		}
	}
}
