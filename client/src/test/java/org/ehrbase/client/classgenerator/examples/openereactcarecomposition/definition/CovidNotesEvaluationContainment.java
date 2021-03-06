package org.ehrbase.client.classgenerator.examples.openereactcarecomposition.definition;

import com.nedap.archie.rm.archetyped.FeederAudit;
import com.nedap.archie.rm.datastructures.Cluster;
import com.nedap.archie.rm.generic.PartyProxy;
import java.lang.String;
import org.ehrbase.client.aql.containment.Containment;
import org.ehrbase.client.aql.field.AqlFieldImp;
import org.ehrbase.client.aql.field.ListAqlFieldImp;
import org.ehrbase.client.aql.field.ListSelectAqlField;
import org.ehrbase.client.aql.field.SelectAqlField;
import org.ehrbase.client.classgenerator.shareddefinition.Language;

public class CovidNotesEvaluationContainment extends Containment {
  public SelectAqlField<CovidNotesEvaluation> COVID_NOTES_EVALUATION = new AqlFieldImp<CovidNotesEvaluation>(CovidNotesEvaluation.class, "", "CovidNotesEvaluation", CovidNotesEvaluation.class, this);

  public SelectAqlField<String> SYNOPSIS_VALUE = new AqlFieldImp<String>(CovidNotesEvaluation.class, "/data[at0001]/items[at0002]/value|value", "synopsisValue", String.class, this);

  public ListSelectAqlField<Cluster> EXTENSION = new ListAqlFieldImp<Cluster>(CovidNotesEvaluation.class, "/protocol[at0003]/items[at0004]", "extension", Cluster.class, this);

  public SelectAqlField<PartyProxy> SUBJECT = new AqlFieldImp<PartyProxy>(CovidNotesEvaluation.class, "/subject", "subject", PartyProxy.class, this);

  public SelectAqlField<Language> LANGUAGE = new AqlFieldImp<Language>(CovidNotesEvaluation.class, "/language", "language", Language.class, this);

  public SelectAqlField<FeederAudit> FEEDER_AUDIT = new AqlFieldImp<FeederAudit>(CovidNotesEvaluation.class, "/feeder_audit", "feederAudit", FeederAudit.class, this);

  private CovidNotesEvaluationContainment() {
    super("openEHR-EHR-EVALUATION.clinical_synopsis.v1");
  }

  public static CovidNotesEvaluationContainment getInstance() {
    return new CovidNotesEvaluationContainment();
  }
}
