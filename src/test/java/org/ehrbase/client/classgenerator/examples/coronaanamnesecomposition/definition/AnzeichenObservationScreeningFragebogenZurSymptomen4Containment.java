package org.ehrbase.client.classgenerator.examples.coronaanamnesecomposition.definition;

import com.nedap.archie.rm.datastructures.Cluster;
import com.nedap.archie.rm.generic.PartyProxy;
import java.lang.String;
import java.time.temporal.TemporalAccessor;
import org.ehrbase.client.aql.containment.Containment;
import org.ehrbase.client.aql.field.AqlFieldImp;
import org.ehrbase.client.aql.field.ListAqlFieldImp;
import org.ehrbase.client.aql.field.ListSelectAqlField;
import org.ehrbase.client.aql.field.SelectAqlField;
import org.ehrbase.client.classgenerator.examples.shareddefinition.Language;

public class AnzeichenObservationScreeningFragebogenZurSymptomen4Containment extends Containment {
  public SelectAqlField<AnzeichenObservationScreeningFragebogenZurSymptomen4> ANZEICHEN_OBSERVATION_SCREENING_FRAGEBOGEN_ZUR_SYMPTOMEN4 = new AqlFieldImp<AnzeichenObservationScreeningFragebogenZurSymptomen4>(AnzeichenObservationScreeningFragebogenZurSymptomen4.class, "", "AnzeichenObservationScreeningFragebogenZurSymptomen4", AnzeichenObservationScreeningFragebogenZurSymptomen4.class, this);

  public SelectAqlField<Language> LANGUAGE = new AqlFieldImp<Language>(AnzeichenObservationScreeningFragebogenZurSymptomen4.class, "/language", "language", Language.class, this);

  public ListSelectAqlField<Cluster> ERWEITERUNG = new ListAqlFieldImp<Cluster>(AnzeichenObservationScreeningFragebogenZurSymptomen4.class, "/protocol[at0007]/items[at0021]", "erweiterung", Cluster.class, this);

  public SelectAqlField<String> BEZEICHNUNG_DES_SYMPTOMS_ODER_ANZEICHENS_VALUE = new AqlFieldImp<String>(AnzeichenObservationScreeningFragebogenZurSymptomen4.class, "/data[at0001]/events[at0002]/data[at0003]/items[at0022]/items[at0004]/value|value", "bezeichnungDesSymptomsOderAnzeichensValue", String.class, this);

  public SelectAqlField<VorhandenDefiningcode> VORHANDEN_DEFININGCODE = new AqlFieldImp<VorhandenDefiningcode>(AnzeichenObservationScreeningFragebogenZurSymptomen4.class, "/data[at0001]/events[at0002]/data[at0003]/items[at0022]/items[at0005]/value|defining_code", "vorhandenDefiningcode", VorhandenDefiningcode.class, this);

  public SelectAqlField<TemporalAccessor> TIME_VALUE = new AqlFieldImp<TemporalAccessor>(AnzeichenObservationScreeningFragebogenZurSymptomen4.class, "/data[at0001]/events[at0002]/time|value", "timeValue", TemporalAccessor.class, this);

  public SelectAqlField<PartyProxy> SUBJECT = new AqlFieldImp<PartyProxy>(AnzeichenObservationScreeningFragebogenZurSymptomen4.class, "/subject", "subject", PartyProxy.class, this);

  public SelectAqlField<TemporalAccessor> ORIGIN_VALUE = new AqlFieldImp<TemporalAccessor>(AnzeichenObservationScreeningFragebogenZurSymptomen4.class, "/data[at0001]/origin|value", "originValue", TemporalAccessor.class, this);

  public ListSelectAqlField<Cluster> ANZEICHEN = new ListAqlFieldImp<Cluster>(AnzeichenObservationScreeningFragebogenZurSymptomen4.class, "/data[at0001]/events[at0002]/data[at0003]/items[at0022]/items[at0026]", "anzeichen", Cluster.class, this);

  private AnzeichenObservationScreeningFragebogenZurSymptomen4Containment() {
    super("openEHR-EHR-OBSERVATION.symptom_sign_screening_geruch.v0");
  }

  public static AnzeichenObservationScreeningFragebogenZurSymptomen4Containment getInstance() {
    return new AnzeichenObservationScreeningFragebogenZurSymptomen4Containment();
  }
}
