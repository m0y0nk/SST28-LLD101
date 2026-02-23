import java.nio.charset.StandardCharsets;

public class CsvExporter extends Exporter {

    @Override
    protected ExportRequest transform(ExportRequest req) {
        String body = req.body == null
            ? ""
            : req.body.replace("\n", " ").replace(",", " ");

        return new ExportRequest(req.title, body);
    }

    @Override
    protected ExportResult export(ExportRequest req) {
        String csv = "title,body\n" + req.title + "," + req.body + "\n";
        return new ExportResult(
            "text/csv",
            csv.getBytes(StandardCharsets.UTF_8)
        );
    }
}