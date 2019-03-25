package ca.camosun.lab7;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class Converters {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<ConverterItem> ITEMS = new ArrayList<ConverterItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, ConverterItem> ITEM_MAP = new HashMap<String, ConverterItem>();

    private static final int COUNT = 4;

    static {
        // Add some sample items.
//        for (int i = 1; i <= COUNT; i++) {
//            addItem(createConverterItem(i));
//        }
        addItem(createConverterItem(1, "Temperature", "to Celsius", "to Fahrenheit"));
        addItem(createConverterItem(2, "Length", "to Metres", "to Feet"));
        addItem(createConverterItem(3, "Area", "to Acres", "to Hectares"));
        addItem(createConverterItem(4, "Weight", "to Kgs", "to Lbs"));
    }

    private static void addItem(ConverterItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static ConverterItem createConverterItem(int position, String name, String leftConversion, String rightConversion) {
        return new ConverterItem(String.valueOf(position), name, leftConversion, rightConversion);
    }

//    private static String makeDetails(int position) {
//        StringBuilder builder = new StringBuilder();
//        builder.append("Details about Item: ").append(position);
//        for (int i = 0; i < position; i++) {
//            builder.append("\nMore details information here.");
//        }
//        return builder.toString();
//    }

    public static class ConverterItem {

        public final String name;
        public final String id;

        public final String leftConversion;

        public final String rightConversion;


        public ConverterItem(String id, String name, String leftConversion, String rightConversion) {
            this.id = id;
            this.name = name;
            this.leftConversion = leftConversion;
            this.rightConversion = rightConversion;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}

