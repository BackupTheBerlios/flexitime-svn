/*
 * Created on 26 janv. 2005
 * by Jérôme GUERS
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.impl;

import fr.umlv.ir3.flexitime.common.data.admin.IUser;
import fr.umlv.ir3.flexitime.common.data.admin.impl.UserImpl;
import junit.framework.TestCase;


/**
 * Test ClassImpl
 * 
 * @version 285
 * 
 * @author FlexiTeam - Jérôme GUERS
 */
public class TestDataImpl extends TestCase
{
    private class DataImplForTest extends DataImpl
    {
        /**
         * Comment for <code>serialVersionUID</code>
         */
        private static final long serialVersionUID = 3906651903466157109L;

        /**
         * 
         * @param name
         */
        public DataImplForTest(String name)
        {
            super(name);
        }
    }
    
    /**
     * 
     *
     */
    public void testEquals()
    {
        DataImplForTest data1 = new DataImplForTest("data1");
        DataImplForTest data2 = new DataImplForTest("data2");
        
        if(data1.equals(data2))
            fail("No IDs for datas. They can't be equals !");
        
        IUser user = new UserImpl("toto");
        if(data1.equals(user))
            fail("user and data1 are not of the same class");
        
        data1.setIdData(new Long(1));
        if(data1.equals(data2))
            fail("data2 have any ID. They can not be equals !");
        
        data2.setIdData(new Long(2));

        if(data1.equals(data2))
            fail("ID are not equals, but object seems to be equals !");
        
        data2.setIdData(new Long(1));
        if(!(data1.equals(data2)))
            fail("ID are equals, but object seems not to be equals !");
    }
    
    /**
     * 
     *
     */
    public void testHashCode()
    {
        DataImplForTest data1 = new DataImplForTest("data1");
        if(data1.hashCode() != "data1".hashCode())
            fail("hashcode generation");
    }
}
