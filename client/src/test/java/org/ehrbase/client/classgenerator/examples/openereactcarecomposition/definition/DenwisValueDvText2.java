package org.ehrbase.client.classgenerator.examples.openereactcarecomposition.definition;

import java.lang.String;
import javax.annotation.processing.Generated;
import org.ehrbase.client.annotations.Entity;
import org.ehrbase.client.annotations.OptionFor;
import org.ehrbase.client.annotations.Path;
import org.ehrbase.client.classgenerator.interfaces.RMEntity;

@Entity
@Generated(
    value = "org.ehrbase.client.classgenerator.ClassGenerator",
    date = "2020-12-10T13:06:11.390502700+01:00",
    comments = "https://github.com/ehrbase/openEHR_SDK Version: null"
)
@OptionFor("DV_TEXT")
public class DenwisValueDvText2 implements RMEntity, DenwisValueChoice2 {
  /**
   * Path: open_eREACT-Care/Assessment/DENWIS/Point in time/value/value
   */
  @Path("|value")
  private String valueValue;

  public void setValueValue(String valueValue) {
     this.valueValue = valueValue;
  }

  public String getValueValue() {
     return this.valueValue ;
  }
}
