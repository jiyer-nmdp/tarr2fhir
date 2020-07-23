package org.nmdp.fhirsubmission.hapi.models;

import org.hl7.fhir.r4.model.*;

import java.util.List;
import java.util.Objects;

public class BundleResource
{
    public Bundle getMyFhirBundle() {
        return myFhirBundle;
    }
    private Bundle myFhirBundle;
    public void setMyFhirBundle(Bundle myFhirBundle)
    {
        this.myFhirBundle = myFhirBundle;
    }

    public BundleResource()
    {
        this.myFhirBundle = new Bundle();
        this.myFhirBundle.setType(Bundle.BundleType.TRANSACTION);
    }

    public void addDiagnosticReport(DiagnosticReport theDiagReport)
    {
        String theFullUrl = theDiagReport.getIdElement().getValue();
        theDiagReport.getIdElement().setValue(null);
        myFhirBundle.addEntry()
                .setFullUrl(theFullUrl)
                .setResource(theDiagReport)
                .getRequest()
                .setUrl("DiagnosticReport")
                .setMethod(Bundle.HTTPVerb.POST);
    }

    public void addObservations(List<Observation> theObservations)
    {
        theObservations.stream().filter(Objects::nonNull).forEach(aObs ->  addObstoBundle(aObs));
    }

    public void addObstoBundle(Observation aObs)
    {
        String theFullUrl = aObs.getIdElement().getValue();
        aObs.getIdElement().setValue(null);
        myFhirBundle.addEntry()
                .setFullUrl(theFullUrl)
                .setResource(aObs)
                .getRequest()
                .setUrl("Observation")
                .setMethod(Bundle.HTTPVerb.POST);
    }
    public void addSequences(List<MolecularSequence> theSequences)
    {
        theSequences.stream().filter(Objects::nonNull).forEach(aSeq ->  addSeqtoBundle(aSeq));
    }

    public void addSeqtoBundle(MolecularSequence theSeq)
    {
        String theFullUrl = theSeq.getIdElement().getValue();
        theSeq.getIdElement().setValue(null);
        myFhirBundle.addEntry()
                .setFullUrl(theFullUrl)
                .setResource(theSeq)
                .getRequest()
                .setUrl("MolecularSequence")
                .setMethod(Bundle.HTTPVerb.POST);
    }

//    public void addPatient(Patient thePatient)
//    {
//        myFhirBundle.addEntry()
//            .setFullUrl(thePatient.getIdElement().getValue())
//            .setResource(thePatient)
//            .getRequest()
//            .setUrl("Patient")
//            .setMethod(Bundle.HTTPVerb.POST);
//    }
//
//    public void addSpecimen(Specimen theSpecimen)
//    {
//        myFhirBundle.addEntry()
//                .setFullUrl(theSpecimen.getIdElement().getValue())
//                .setResource(theSpecimen)
//                .getRequest()
//                .setUrl("Specimen")
//                .setMethod(Bundle.HTTPVerb.POST);
//    }

    public void addProvenance(Provenance theProvenance)
    {
        String theFullUrl = theProvenance.getIdElement().getValue();
        theProvenance.getIdElement().setValue(null);
        myFhirBundle.addEntry()
                .setFullUrl(theFullUrl)
                .setResource(theProvenance)
                .getRequest()
                .setUrl("Provenance")
                .setMethod(Bundle.HTTPVerb.POST);

    }

    public void addDevice(Device theDevice)
    {
        String theFullUrl = theDevice.getIdElement().getValue();
        theDevice.getIdElement().setValue(null);
        myFhirBundle.addEntry()
                .setFullUrl(theFullUrl)
                .setResource(theDevice)
                .getRequest()
                .setUrl("Device")
                .setMethod(Bundle.HTTPVerb.POST);

    }
}
