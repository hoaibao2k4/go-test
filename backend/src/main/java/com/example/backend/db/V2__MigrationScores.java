package com.example.backend.db;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;
import org.postgresql.PGConnection;
import org.postgresql.copy.CopyManager;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class V2__MigrationScores extends BaseJavaMigration {

  @Override
  public void migrate(Context context) throws Exception {

    InputStream is = getClass().getClassLoader().getResourceAsStream("seed/diem_thi_thpt_2024.csv");
    if (is == null) {
      throw new IllegalStateException("Missing resource: seed/diem_thi_thpt_2024.csv");
    }

    String copySql = """
      COPY entrance_scores(
        sbd,toan,ngu_van,ngoai_ngu,vat_li,hoa_hoc,sinh_hoc,lich_su,dia_li,gdcd,ma_ngoai_ngu
      )
      FROM STDIN
      WITH (FORMAT csv, HEADER true, DELIMITER ',', NULL '', ENCODING 'UTF8')
      """;

    PGConnection pg = context.getConnection().unwrap(PGConnection.class);
    CopyManager copy = pg.getCopyAPI();

    try (var reader = new InputStreamReader(is, StandardCharsets.UTF_8)) {
      copy.copyIn(copySql, reader);
    }
  }
}
