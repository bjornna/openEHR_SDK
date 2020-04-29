package org.ehrbase.client.classgenerator.examples.coronaanamnesecomposition;

import com.nedap.archie.rm.datastructures.Cluster;
import com.nedap.archie.rm.generic.Participation;
import com.nedap.archie.rm.generic.PartyIdentified;
import com.nedap.archie.rm.generic.PartyProxy;
import java.lang.String;
import java.time.temporal.TemporalAccessor;
import org.ehrbase.client.aql.containment.Containment;
import org.ehrbase.client.aql.field.AqlFieldImp;
import org.ehrbase.client.aql.field.ListAqlFieldImp;
import org.ehrbase.client.aql.field.ListSelectAqlField;
import org.ehrbase.client.aql.field.SelectAqlField;
import org.ehrbase.client.classgenerator.examples.coronaanamnesecomposition.definition.AllgmeineAngabenSection;
import org.ehrbase.client.classgenerator.examples.coronaanamnesecomposition.definition.HistorieObservation;
import org.ehrbase.client.classgenerator.examples.coronaanamnesecomposition.definition.KontaktSection;
import org.ehrbase.client.classgenerator.examples.coronaanamnesecomposition.definition.RisikogebietSection;
import org.ehrbase.client.classgenerator.examples.coronaanamnesecomposition.definition.SymptomeSection;
import org.ehrbase.client.classgenerator.examples.shareddefinition.CategoryDefiningcode;
import org.ehrbase.client.classgenerator.examples.shareddefinition.Language;
import org.ehrbase.client.classgenerator.examples.shareddefinition.SettingDefiningcode;
import org.ehrbase.client.classgenerator.examples.shareddefinition.Territory;

public class CoronaAnamneseCompositionContainment extends Containment {
  public SelectAqlField<CoronaAnamneseComposition> CORONA_ANAMNESE_COMPOSITION = new AqlFieldImp<CoronaAnamneseComposition>(CoronaAnamneseComposition.class, "", "CoronaAnamneseComposition", CoronaAnamneseComposition.class, this);

  public SelectAqlField<TemporalAccessor> END_TIME_VALUE = new AqlFieldImp<TemporalAccessor>(CoronaAnamneseComposition.class, "/context/end_time|value", "endTimeValue", TemporalAccessor.class, this);

  public SelectAqlField<RisikogebietSection> RISIKOGEBIET = new AqlFieldImp<RisikogebietSection>(CoronaAnamneseComposition.class, "/content[openEHR-EHR-SECTION.risikogebiet.v1]", "risikogebiet", RisikogebietSection.class, this);

  public ListSelectAqlField<Participation> PARTICIPATIONS = new ListAqlFieldImp<Participation>(CoronaAnamneseComposition.class, "/context/participations", "participations", Participation.class, this);

  public SelectAqlField<Language> LANGUAGE = new AqlFieldImp<Language>(CoronaAnamneseComposition.class, "/language", "language", Language.class, this);

  public SelectAqlField<PartyIdentified> HEALTH_CARE_FACILITY = new AqlFieldImp<PartyIdentified>(CoronaAnamneseComposition.class, "/context/health_care_facility", "healthCareFacility", PartyIdentified.class, this);

  public SelectAqlField<String> STATUS_VALUE = new AqlFieldImp<String>(CoronaAnamneseComposition.class, "/context/other_context[at0001]/items[at0005]/value|value", "statusValue", String.class, this);

  public ListSelectAqlField<HistorieObservation> HISTORIE = new ListAqlFieldImp<HistorieObservation>(CoronaAnamneseComposition.class, "/content[openEHR-EHR-OBSERVATION.story.v1]", "historie", HistorieObservation.class, this);

  public SelectAqlField<String> BERICHT_ID_VALUE = new AqlFieldImp<String>(CoronaAnamneseComposition.class, "/context/other_context[at0001]/items[at0002]/value|value", "berichtIdValue", String.class, this);

  public SelectAqlField<Territory> TERRITORY = new AqlFieldImp<Territory>(CoronaAnamneseComposition.class, "/territory", "territory", Territory.class, this);

  public SelectAqlField<KontaktSection> KONTAKT = new AqlFieldImp<KontaktSection>(CoronaAnamneseComposition.class, "/content[openEHR-EHR-SECTION.kontakt.v1]", "kontakt", KontaktSection.class, this);

  public SelectAqlField<TemporalAccessor> START_TIME_VALUE = new AqlFieldImp<TemporalAccessor>(CoronaAnamneseComposition.class, "/context/start_time|value", "startTimeValue", TemporalAccessor.class, this);

  public SelectAqlField<SymptomeSection> SYMPTOME = new AqlFieldImp<SymptomeSection>(CoronaAnamneseComposition.class, "/content[openEHR-EHR-SECTION.symptome.v1]", "symptome", SymptomeSection.class, this);

  public SelectAqlField<PartyProxy> COMPOSER = new AqlFieldImp<PartyProxy>(CoronaAnamneseComposition.class, "/composer", "composer", PartyProxy.class, this);

  public SelectAqlField<SettingDefiningcode> SETTING_DEFININGCODE = new AqlFieldImp<SettingDefiningcode>(CoronaAnamneseComposition.class, "/context/setting|defining_code", "settingDefiningcode", SettingDefiningcode.class, this);

  public ListSelectAqlField<Cluster> ERWEITERUNG = new ListAqlFieldImp<Cluster>(CoronaAnamneseComposition.class, "/context/other_context[at0001]/items[at0006]", "erweiterung", Cluster.class, this);

  public SelectAqlField<String> LOCATION = new AqlFieldImp<String>(CoronaAnamneseComposition.class, "/context/location", "location", String.class, this);

  public SelectAqlField<AllgmeineAngabenSection> ALLGMEINE_ANGABEN = new AqlFieldImp<AllgmeineAngabenSection>(CoronaAnamneseComposition.class, "/content[openEHR-EHR-SECTION.allgemeine_angaben.v1]", "allgmeineAngaben", AllgmeineAngabenSection.class, this);

  public SelectAqlField<CategoryDefiningcode> CATEGORY_DEFININGCODE = new AqlFieldImp<CategoryDefiningcode>(CoronaAnamneseComposition.class, "/category|defining_code", "categoryDefiningcode", CategoryDefiningcode.class, this);

  private CoronaAnamneseCompositionContainment() {
    super("openEHR-EHR-COMPOSITION.report.v1");
  }

  public static CoronaAnamneseCompositionContainment getInstance() {
    return new CoronaAnamneseCompositionContainment();
  }
}
