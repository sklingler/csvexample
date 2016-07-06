package csvgradle;

import java.util.ArrayList;
import java.util.List;

public class csvExerciser {
	private List<WidgetExample> widgets = null;
	private List<CsvMaster> csvExamples = null;
	
	public void performExercises() {
		allocateWidgets();
		allocateExamples();
		runExamples();
		
	}
	
	private void allocateWidgets() {
		widgets = new ArrayList<WidgetExample>();
		widgets.add(new WidgetExample(1, "first widget", "first description", false));
		widgets.add(new WidgetExample(2, "second widget", null, false));
		widgets.add(new WidgetExample(3, "third widget", "should be inactive", true));	
		widgets.add(new WidgetExample(4, "fourth widget", "comma, included", true));
		
		// Not that I expect us to run into this, but AdBase core does this in two importers.
		// Supporting a CSV row WITHING a CSV row.
		// Apache Commons CSV AND Super CSV get this right
		widgets.add(new WidgetExample(5, "fifth widget", "\"a name\",\"a desc 123\", false", false));
	}
	
	private void allocateExamples() {
		csvExamples = new ArrayList<CsvMaster>();
		csvExamples.add(new SuperCsv());
		csvExamples.add(new ApacheCsv());
	}
	
	private void runExamples() {
		csvExamples.stream().forEach(ex -> {
			ex.AnnounceMe();
			ex.DumpCsv(widgets);
			});
	}
}
