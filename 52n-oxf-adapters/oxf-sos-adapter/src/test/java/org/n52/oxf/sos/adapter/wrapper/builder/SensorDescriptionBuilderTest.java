/**
 * Copyright (C) 2013
 * by 52 North Initiative for Geospatial Open Source Software GmbH
 *
 * Contact: Andreas Wytzisk
 * 52 North Initiative for Geospatial Open Source Software GmbH
 * Martin-Luther-King-Weg 24
 * 48155 Muenster, Germany
 * info@52north.org
 *
 * This program is free software; you can redistribute and/or modify it under
 * the terms of the GNU General Public License version 2 as published by the
 * Free Software Foundation.
 *
 * This program is distributed WITHOUT ANY WARRANTY; even without the implied
 * WARRANTY OF MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program (see gnu-gpl v2.txt). If not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA or
 * visit the Free Software Foundation web page, http://www.fsf.org.
 */
package org.n52.oxf.sos.adapter.wrapper.builder;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import net.opengis.sensorML.x101.CapabilitiesDocument.Capabilities;
import net.opengis.sensorML.x101.SensorMLDocument;
import net.opengis.sensorML.x101.SystemDocument;
import net.opengis.swe.x101.SimpleDataRecordType;

import org.apache.xmlbeans.XmlException;
import org.junit.Test;

public class SensorDescriptionBuilderTest {

	@Test public void
	shouldAddCapabilitiesWithNameDefinitionAndValue()
			throws XmlException	{
		final SensorDescriptionBuilder builder = new SensorDescriptionBuilder();
		final String capabilityName = "test-capability-name";
		final String fieldName = "test-field-name";
		final String fieldDefinition = "test-field-definition";
		final String value = "test-value";
		builder.addCapability(capabilityName, fieldName, fieldDefinition, value);
		final String description = builder.buildSensorDescription();
		final Capabilities capabilities = SystemDocument.Factory.parse(SensorMLDocument.Factory.parse(description).getSensorML().getMemberArray(0).toString()).getSystem().getCapabilitiesArray(0);
		final SimpleDataRecordType dataRecord = (SimpleDataRecordType) capabilities.getAbstractDataRecord();
		
		assertThat(capabilities.getName(),is(capabilityName));
		assertThat(dataRecord.getFieldArray(0).getName(),is(fieldName));
		assertThat(dataRecord.getFieldArray(0).getText().getDefinition(),is(fieldDefinition));
		assertThat(dataRecord.getFieldArray(0).getText().getValue(),is(value));
	}
}
