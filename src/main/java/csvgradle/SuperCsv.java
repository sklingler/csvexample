package csvgradle;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

import org.supercsv.cellprocessor.FmtBool;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

public class SuperCsv implements CsvMaster {
	public void AnnounceMe() {
		System.out.println("Csv Dump for SuperCSV");
	}

	public void DumpCsv(List<WidgetExample> widgets) {
		try {
			StringWriter writer = new StringWriter();
			final ICsvBeanWriter beanWriter = new CsvBeanWriter(writer, CsvPreference.STANDARD_PREFERENCE);

			final CellProcessor[] processors = getProcessors();

			// The headers must match the class members so that reflection works.
			// The documentation hints that you can get around this, but I haven't seen it yet
			final String[] header = new String[] { "id", "name", "description", "isInactive" };
			beanWriter.writeHeader(header);

			for (final WidgetExample widget : widgets) {
				System.out.println("writing entry: " + widget.getName());
				beanWriter.write(widget, header, processors);
			}

			// THIS was the bug in the previous version. You MUST close the
			// beanWriter before
			// trying to use the StringWriter.
			beanWriter.close();

			System.out.println("created csv:");
			System.out.println(writer.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private CellProcessor[] getProcessors() {

		final CellProcessor[] processors = new CellProcessor[] { new ParseInt(), // id
				new NotNull(), // name is required
				new Optional(), // description is optional
				new Optional(new FmtBool("Y", "N")), // isInactive. This could
														// be just optional
														// without the formatting
		};

		return processors;
	}

}
