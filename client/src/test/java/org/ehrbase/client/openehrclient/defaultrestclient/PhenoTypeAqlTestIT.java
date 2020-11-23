package org.ehrbase.client.openehrclient.defaultrestclient;

import org.ehrbase.client.Integration;
import org.ehrbase.client.aql.parameter.ParameterValue;
import org.ehrbase.client.aql.query.NativeQuery;
import org.ehrbase.client.aql.query.Query;
import org.ehrbase.client.aql.record.Record1;
import org.ehrbase.client.openehrclient.OpenEhrClient;
import org.ehrbase.client.openehrclient.OpenEhrClientConfig;
import org.ehrbase.client.phenotypes.optentities.openehrconfirmedcovid19infectionreportv0composition.OpenEHRConfirmedCOVID19InfectionReportV0Composition;
import org.ehrbase.client.templateprovider.PhenotypeDataTemplateProvider;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.UUID;

import static org.ehrbase.client.openehrclient.defaultrestclient.ConfirmedCovid19InfectionControlBuilder.buildConfirmedCovid19InfReport;
import static org.junit.Assert.*;

@Category(Integration.class)
public class PhenoTypeAqlTestIT {
    private  OpenEhrClient openEhrClient;
    private String REST_URI = "http://localhost:8080/ehrbase/rest/openehr/v1/";

    @Before
    public void setupBeforeTest() throws URISyntaxException {
        //Ensure opt for the template is known to EhrBase
        PhenotypeDataTemplateProvider tprovider = new PhenotypeDataTemplateProvider();
        DefaultRestClient client =
            new DefaultRestClient(
                new OpenEhrClientConfig(new URI(REST_URI)),
                tprovider,
                false,// true means use proxy listening at localhost:8888
                "localhost",
                8888);
        tprovider
            .listTemplateIds()
            .stream()
            .forEach(tid -> client.templateEndpoint().ensureExistence(tid));

        openEhrClient = client;
    }

    @Test
    public void runsAqlQueryWithWhitespaceInQueryText(){
        final UUID ehrId = callCreateEhrEndpoint();

        callCreateCompositionEndpoint(ehrId);

        String aql = "SELECT e/ehr_id/value, c/archetype_node_id " +
            "FROM EHR \te[ehr_id/value = $ehr_id] \n" +
            "CONTAINS\n\n COMPOSITION c[openEHR-EHR-COMPOSITION.report.v1] \r" +
            "CONTAINS OBSERVATION o [        \r\nopenEHR-EHR-OBSERVATION.laboratory_test_result.v1]";

        final NativeQuery<Record1<UUID>> query =
            Query
                .buildNativeQuery(aql, UUID.class);

        final List<Record1<UUID>> queryResults =
            openEhrClient
                .aqlEndpoint()
                .execute(query, new ParameterValue("ehr_id", ehrId));

        assertNotNull(queryResults);
        assertEquals(1, queryResults.size());
        assertTrue(queryResults.get(0).value1() instanceof UUID);
    }

    @Test
    public void runsConfirmedCovid19InfectionReportQuery(){
        final UUID ehrId = callCreateEhrEndpoint();

        callCreateCompositionEndpoint(ehrId);

        //this will work, i.e. server side fails if we don't add a second column in the SELECT clause
        String aql = "SELECT e/ehr_id/value, c/archetype_node_id " +
      //  String aql = "SELECT e/ehr_id/value " +
                    "FROM EHR e[ehr_id/value = $ehr_id] " +
                    "CONTAINS COMPOSITION c[openEHR-EHR-COMPOSITION.report.v1] " +
                    "CONTAINS OBSERVATION o [openEHR-EHR-OBSERVATION.laboratory_test_result.v1]";

        final NativeQuery<Record1<UUID>> query =
            Query
                .buildNativeQuery(aql, UUID.class);

        @SuppressWarnings("rawtypes")
		final List<Record1<UUID>> queryResults =
            openEhrClient
                .aqlEndpoint()
                .execute(query, new ParameterValue("ehr_id", ehrId));

        assertNotNull(queryResults);
    }
    
    @Test
    public void runsHydroxychloroquineAloneTreatmentQuery(){
        final UUID ehrId =
            openEhrClient
                .ehrEndpoint()
                .createEhr();

        final OpenEHRConfirmedCOVID19InfectionReportV0Composition mergedEntity =
            openEhrClient
                .compositionEndpoint(ehrId)
                .mergeCompositionEntity(buildConfirmedCovid19InfReport());

        //this will work, i.e. server side fails if we don't add a second column in the SELECT clause
//        String aql = "SELECT e/ehr_id/value, c/archetype_node_id " +
        String aql = "select\n" + 
        		"    a_a/activities[at0001]/description[at0002]/items[at0070]/value/value\n" + 
        		"from EHR e\n" + 
        		"contains COMPOSITION a\n" + 
        		"contains INSTRUCTION a_a[openEHR-EHR-INSTRUCTION.medication_order.v1]\n" + 
        		"where a_a/activities[at0001]/description[at0002]/items[at0070]/value/value='P01BA02'";

        final NativeQuery<Record1<UUID>> query =
            Query
                .buildNativeQuery(aql, UUID.class);

        @SuppressWarnings("rawtypes")
		final List<Record1<UUID>> queryResults =
            openEhrClient
                .aqlEndpoint()
                .execute(query, new ParameterValue("ehr_id", ehrId));

        assertNotNull(queryResults);
    }
    
    @Test
    @Ignore("test fails doe to the lack of support for versioned objects in AQL.")
    public void runsAdultsInHipersensitiveDrugTreatmentQueryUsingVerionedObjects(){
        final UUID ehrId =
            openEhrClient
                .ehrEndpoint()
                .createEhr();

        final OpenEHRConfirmedCOVID19InfectionReportV0Composition mergedEntity =
            openEhrClient
                .compositionEndpoint(ehrId)
                .mergeCompositionEntity(buildConfirmedCovid19InfReport());

        //this will work, i.e. server side fails if we don't add a second column in the SELECT clause
//        String aql = "SELECT e/ehr_id/value, c/archetype_node_id " +
        String aql = "select distinct e/ehr_id/value\n" + 
        		"from EHR e contains\n" + 
        		"VERSIONED_OBJECT vo contains\n" + 
        		"VERSION a[all_versions]\n" + 
        		"contains COMPOSITION c\n" + 
        		"contains (\n" + 
        		"CLUSTER a_a[openEHR-EHR-CLUSTER.person_birth_data_iso.v0] and\n" + 
        		"INSTRUCTION a_b[openEHR-EHR-INSTRUCTION.medication_order.v1])\n" + 
        		"where\n" + 
        		"a_a/items[at0001]/value<2002 and\n" + 
        		"a_b/activities[at0001]/description[at0002]/items[at0070]/value/value matches {TERMINOLOGY('expand','http://hl7.org/fhir/4.0', 'url=http://snomed.info/sct?fhir_vs=isa/50697003')} and\n" + 
        		"a/commit_audit/time_committed/value>'2018-11-01' and\n" + 
        		"a/commit_audit/time_committed/value>'2020-01-31'";

        final NativeQuery<Record1<UUID>> query =
            Query
                .buildNativeQuery(aql, UUID.class);

        @SuppressWarnings("rawtypes")
		final List<Record1<UUID>> queryResults =
            openEhrClient
                .aqlEndpoint()
                .execute(query, new ParameterValue("ehr_id", ehrId));

        assertNotNull(queryResults);
    }
    
    @Test
    public void runsConfirmedCovid19ForCurrentDate(){
        final UUID ehrId =
            openEhrClient
                .ehrEndpoint()
                .createEhr();

        final OpenEHRConfirmedCOVID19InfectionReportV0Composition mergedEntity =
            openEhrClient
                .compositionEndpoint(ehrId)
                .mergeCompositionEntity(buildConfirmedCovid19InfReport());

        //this will work, i.e. server side fails if we don't add a second column in the SELECT clause
//        String aql = "SELECT e/ehr_id/value, c/archetype_node_id " +
//        String aql = "SELECT e/ehr_id/value " +
//                    "FROM EHR e[ehr_id/value = $ehr_id] " +
//                    "CONTAINS COMPOSITION c[openEHR-EHR-COMPOSITION.report.v1] " +
//                    "CONTAINS OBSERVATION o [openEHR-EHR-OBSERVATION.laboratory_test_result.v1]";
        String aql = "select e/ehr_id/value, a/archetype_node_id\n" + 
        		"from EHR e\n" + 
        		"contains COMPOSITION a\n" + 
        		"contains OBSERVATION a_a[openEHR-EHR-OBSERVATION.management_screening.v0]" + 
        		"where a_a/data[at0001]/events[at0002]/data[at0003]/items[at0022]/items[at0004]/value=$icu_code\n" + 
        		"and a/context/start_time/value = $curent_date";


        final NativeQuery<Record1<UUID>> query =
            Query
                .buildNativeQuery(aql, UUID.class);

        @SuppressWarnings("rawtypes")
		final List<Record1<UUID>> queryResults =
            openEhrClient
                .aqlEndpoint()
                .execute(query, new ParameterValue("ehr_id", ehrId));

        assertNotNull(queryResults);
    }

    private void callCreateCompositionEndpoint(UUID ehrId) {
        final OpenEHRConfirmedCOVID19InfectionReportV0Composition mergedEntity =
            openEhrClient
                .compositionEndpoint(ehrId)
                .mergeCompositionEntity(buildConfirmedCovid19InfReport());
    }

    private UUID callCreateEhrEndpoint() {
        final UUID ehrId =
            openEhrClient
                .ehrEndpoint()
                .createEhr();
        return ehrId;
    }
}