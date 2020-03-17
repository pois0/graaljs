/*
 * Copyright (c) 2020, 2020, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * Licensed under the Universal Permissive License v 1.0 as shown at http://oss.oracle.com/licenses/upl.
 */

const exports = {
	equal : function equal(a, b) {
	    if (a !== b) {
        	throw "not equal!";
    	}
	}
}

export const equal = exports.equal;
export default exports;
