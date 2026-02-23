public abstract class Exporter {
    public final ExportResult doExport(ExportRequest req) {
        ExportRequest normalized = normalize(req);
        ExportRequest transformed = transform(normalized);
        return export(transformed);
    }

    protected ExportRequest normalize(ExportRequest req) {
        if (req == null) return new ExportRequest("", "");
        return req;
    }

    protected ExportRequest transform(ExportRequest req) {
        return req;
    }

    protected abstract ExportResult export(ExportRequest req);
}