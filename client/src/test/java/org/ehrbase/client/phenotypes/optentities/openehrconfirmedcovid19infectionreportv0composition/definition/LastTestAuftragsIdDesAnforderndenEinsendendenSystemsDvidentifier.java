package org.ehrbase.client.phenotypes.optentities.openehrconfirmedcovid19infectionreportv0composition.definition;

import com.nedap.archie.rm.datavalues.DvIdentifier;
import org.ehrbase.client.annotations.Entity;
import org.ehrbase.client.annotations.OptionFor;
import org.ehrbase.client.annotations.Path;

@Entity
@OptionFor("DV_IDENTIFIER")
public class LastTestAuftragsIdDesAnforderndenEinsendendenSystemsDvidentifier implements LastTestAuftragsIdDesAnforderndenEinsendendenSystemsChoice {
  @Path("")
  private DvIdentifier auftragsIdDesAnforderndenEinsendendenSystems;

  public void setAuftragsIdDesAnforderndenEinsendendenSystems(
      DvIdentifier auftragsIdDesAnforderndenEinsendendenSystems) {
     this.auftragsIdDesAnforderndenEinsendendenSystems = auftragsIdDesAnforderndenEinsendendenSystems;
  }

  public DvIdentifier getAuftragsIdDesAnforderndenEinsendendenSystems() {
     return this.auftragsIdDesAnforderndenEinsendendenSystems ;
  }
}