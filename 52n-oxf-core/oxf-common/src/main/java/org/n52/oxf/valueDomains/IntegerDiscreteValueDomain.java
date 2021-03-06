/**
 * ﻿Copyright (C) 2012-2014 52°North Initiative for Geospatial Open Source
 * Software GmbH
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License version 2 as publishedby the Free
 * Software Foundation.
 *
 * If the program is linked with libraries which are licensed under one of the
 * following licenses, the combination of the program with the linked library is
 * not considered a "derivative work" of the program:
 *
 *     - Apache License, version 2.0
 *     - Apache Software License, version 1.0
 *     - GNU Lesser General Public License, version 3
 *     - Mozilla Public License, versions 1.0, 1.1 and 2.0
 *     - Common Development and Distribution License (CDDL), version 1.0
 *
 * Therefore the distribution of the program linked with libraries licensed under
 * the aforementioned licenses, is permitted by the copyright holders if the
 * distribution is compliant with both the GNU General Public License version 2
 * and the aforementioned licenses.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE. See the GNU General Public License for more details.
 */
package org.n52.oxf.valueDomains;

import java.util.*;

import org.n52.oxf.ows.capabilities.*;


/**
 * 
 * 
 * @author <a href="mailto:broering@52north.org">Arne Broering</a>
 *
 */
public class IntegerDiscreteValueDomain implements IDiscreteValueDomain<Integer> {

    /**
     * List with possible values (if this value domain has discrete values
     */
    List<Integer> possibleValues = null;
    
    /**
     * description of the valueDomain
     */
    String description = "The DiscreteIntegerValueDomain contains the possible Integer-values.";
    
    /**
     */
    public IntegerDiscreteValueDomain(Integer possibleValue) {
        this.possibleValues = new ArrayList<Integer>();
        possibleValues.add(possibleValue);
    }
    
    /**
     * @param possibleValues
     *            ArrayList with discrete Integer-Values
     */
    public IntegerDiscreteValueDomain(List<Integer> possibleValues) {
        this.possibleValues = possibleValues;
    }
    
    /**
     * @param possibleValues
     *            ArrayList with discrete Integer-Values
     */
    public IntegerDiscreteValueDomain(Integer[] possibleValues) {
        this.possibleValues = new ArrayList<Integer>(Arrays.asList(possibleValues));
    }
    
    /**
     * @param i Integer to be added to this IntegerValueDomain.
     */
    public void add(Integer i){
        possibleValues.add(i);
    }
    
    /**
     * @return ArrayList with possible (discrete) Integer-values
     */
    public List<Integer> getPossibleValues() {
        return possibleValues;
    }
    
    /**
     * gives a description of this ValueDomain
     * 
     * @return String with description
     */
    public String getDomainDescription() {      
        return description;
    }
    
    /**
     * test, whether a Integer-value is contained in this valueDomain
     * 
     * @param n
     *            the value which has to be tested
     * @return true, if n is contained
     */
    public boolean containsValue(Integer n) {
        return possibleValues.contains(n);
    }
    
    /**
     * creates an XML-String of the ValueDomain
     * 
     * @return XML-String of this ValueDomain
     */
    public String toXML() {
        
        String res = "<IntegerDiscreteValueDomain>";
        for(Integer c : possibleValues ){
            res += "<xsd:unsignedLong>"
                + c
                + "</xsd:unsignedLong>";
        }
        res += "</IntegerDiscreteValueDomain>";
        
        return res;
    }
    
//    public Class<Integer> getValueType() {
//        return Integer.class;
//    }

    public Integer produceValue(String... stringArray) {
        return Integer.parseInt(stringArray[0]);
    }
}