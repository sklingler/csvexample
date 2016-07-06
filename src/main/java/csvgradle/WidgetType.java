package csvgradle;

public enum WidgetType {
	Invalid(0), Tabular(1), PieChart(2), BarChart(3), LineChart(4), MultiBarChart(5), RadialGauge(6);

	private int intValue;
	private static java.util.HashMap<Integer, WidgetType> mappings;

	private synchronized static java.util.HashMap<Integer, WidgetType> getMappings() {

		if (mappings == null) {
			mappings = new java.util.HashMap<Integer, WidgetType>();
		}

		return mappings;
	}

	private WidgetType(int value) {
		intValue = value;
		getMappings().put(value, this);
	}

	public int getValue() {
		return intValue;
	}

	public static WidgetType forValue(int value) {
		return getMappings().get(value);
	}
}
