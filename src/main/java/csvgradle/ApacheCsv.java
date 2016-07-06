package csvgradle;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class ApacheCsv implements CsvMaster {
	public void AnnounceMe() {
		System.out.println("Csv Dump for ApacheCSV");
	}

	public void DumpCsv(List<WidgetExample> widgets) {
		try {
			StringWriter writer = new StringWriter();
			CSVFormat format = CSVFormat.RFC4180.withHeader().withDelimiter(',');
			CSVPrinter printer = new CSVPrinter(writer, format);
			
			printer.printRecord("id", "name", "description", "isinactive");
			
			List<String> rowData = new ArrayList<String>();
			for (final WidgetExample widget : widgets) {
				System.out.println("writing entry: " + widget.getName());
				rowData.add(Integer.toString(widget.getId()));
				rowData.add(widget.getName());
				rowData.add(widget.getDescription());
				rowData.add(String.valueOf(widget.getIsInactive()));
				
				printer.printRecord(rowData);
				
				rowData.clear();
			}

			printer.close();
			
			System.out.println("created csv:");
			System.out.println(writer.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	/*
	 * CSVPrinter printer = new CSVPrinter(System.out,
	 * format.withDelimiter('#')); System.out.println(&quot;********&quot;);
	 * printer.printRecord(&quot;ID&quot;,&quot;Name&quot;,&quot;Role&quot;,&
	 * quot;Salary&quot;); for(Employee emp : emps){ List&lt;String&gt; empData
	 * = new ArrayList&lt;String&gt;(); empData.add(emp.getId());
	 * empData.add(emp.getName()); empData.add(emp.getRole());
	 * empData.add(emp.getSalary()); printer.printRecord(empData); } //close the
	 * printer printer.close();
	 * 
	 * }
	 */
}
