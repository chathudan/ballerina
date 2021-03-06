/*
*  Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
*  Unless required by applicable law or agreed to in writing,
*  software distributed under the License is distributed on an
*  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
*  KIND, either express or implied.  See the License for the
*  specific language governing permissions and limitations
*  under the License.
*/
package org.ballerinalang.model.expressions;

import org.ballerinalang.model.NodeLocation;
import org.ballerinalang.model.NodeVisitor;
import org.ballerinalang.model.Operator;
import org.ballerinalang.model.WhiteSpaceDescriptor;
import org.ballerinalang.model.util.XMLUtils;
import org.ballerinalang.model.values.BFloat;
import org.ballerinalang.model.values.BInteger;
import org.ballerinalang.model.values.BString;
import org.ballerinalang.model.values.BValue;
import org.ballerinalang.model.values.BValueType;
import org.ballerinalang.model.values.BXML;

import java.util.function.BiFunction;

/**
 * {@code AddExpression} represents a binary add expression.
 *
 * @since 0.8.0
 */
public class AddExpression extends BinaryArithmeticExpression {

    public static final BiFunction<BValue, BValue, BValue> ADD_INT_FUNC =
            (lVal, rVal) -> new BInteger(((BValueType) lVal).intValue() + ((BValueType) rVal).intValue());

    public static final BiFunction<BValue, BValue, BValue> ADD_FLOAT_FUNC =
            (lVal, rVal) -> new BFloat(((BValueType) lVal).floatValue() + ((BValueType) rVal).floatValue());

    public static final BiFunction<BValue, BValue, BValue> ADD_STRING_FUNC =
            (lVal, rVal) -> new BString(((BValueType) lVal).stringValue() + ((BValueType) rVal).stringValue());
            
    public static final BiFunction<BValue, BValue, BValue> ADD_XML_FUNC =
            (lVal, rVal) -> XMLUtils.concatenate((BXML) lVal, (BXML) rVal);

    public AddExpression(NodeLocation location, WhiteSpaceDescriptor whiteSpaceDescriptor, Expression lExpr,
                         Expression rExpr) {
        super(location, whiteSpaceDescriptor, lExpr, Operator.ADD, rExpr);
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visit(this);
    }
}
