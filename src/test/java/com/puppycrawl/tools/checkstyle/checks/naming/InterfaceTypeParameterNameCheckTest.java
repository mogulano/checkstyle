////////////////////////////////////////////////////////////////////////////////
// checkstyle: Checks Java source code for adherence to a set of rules.
// Copyright (C) 2001-2021 the original author or authors.
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License, or (at your option) any later version.
//
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
// Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public
// License along with this library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
////////////////////////////////////////////////////////////////////////////////

package com.puppycrawl.tools.checkstyle.checks.naming;

import static com.puppycrawl.tools.checkstyle.checks.naming.AbstractNameCheck.MSG_INVALID_PATTERN;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.AbstractModuleTestSupport;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

public class InterfaceTypeParameterNameCheckTest
    extends AbstractModuleTestSupport {

    @Override
    protected String getPackageLocation() {
        return "com/puppycrawl/tools/checkstyle/checks/naming/interfacetypeparametername";
    }

    @Test
    public void testGetAcceptableTokens() {
        final InterfaceTypeParameterNameCheck interfaceTypeParameterNameCheck =
            new InterfaceTypeParameterNameCheck();
        final int[] expected = {TokenTypes.TYPE_PARAMETER};

        assertArrayEquals(expected, interfaceTypeParameterNameCheck.getAcceptableTokens(),
                "Default acceptable tokens are invalid");
    }

    @Test
    public void testGetRequiredTokens() {
        final InterfaceTypeParameterNameCheck checkObj =
            new InterfaceTypeParameterNameCheck();
        final int[] expected = {TokenTypes.TYPE_PARAMETER};
        assertArrayEquals(expected, checkObj.getRequiredTokens(),
                "Default required tokens are invalid");
    }

    @Test
    public void testInterfaceDefault()
            throws Exception {

        final String pattern = "^[A-Z]$";

        final String[] expected = {
            "55:15: " + getCheckMessage(MSG_INVALID_PATTERN, "Input", pattern),
        };
        verifyWithInlineConfigParser(
                getPath("InputInterfaceTypeParameterName.java"), expected);
    }

    @Test
    public void testInterfaceFooName()
            throws Exception {

        final String pattern = "^foo$";

        final String[] expected = {
            "55:16: " + getCheckMessage(MSG_INVALID_PATTERN, "Input", pattern),
            "59:25: " + getCheckMessage(MSG_INVALID_PATTERN, "T", pattern),
        };
        verifyWithInlineConfigParser(
                getPath("InputInterfaceTypeParameterName1.java"), expected);
    }

}
