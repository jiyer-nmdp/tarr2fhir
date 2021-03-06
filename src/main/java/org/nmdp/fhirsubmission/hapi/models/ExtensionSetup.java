/*
 * Copyright (c) 2020 Be The Match operated by National Marrow Donor Program (NMDP).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed
 * under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES
 * OR CONDITIONS OF ANY KIND, either express or implied. See the License for
 * the specific language governing permissions and limitations under the License.
 */

package org.nmdp.fhirsubmission.hapi.models;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Extension;

import java.util.ArrayList;
import java.util.List;

public class ExtensionSetup {
    private List<Extension> myExtensions;

    public List<Extension> getMyExtensions() {
        return myExtensions;
    }

    public void setMyExtensions(List<Extension> myExtensions) {
        this.myExtensions = myExtensions;
    }

    public ExtensionSetup()
    {
        myExtensions = new ArrayList<>();
    }

    public void createExtension(String theUrl, CodeableConcept theCodeableConcept)
    {
        Extension aExtension = new Extension();
        aExtension.setUrl(theUrl);
        aExtension.setValue(theCodeableConcept);
        myExtensions.add(aExtension);
    }
}
