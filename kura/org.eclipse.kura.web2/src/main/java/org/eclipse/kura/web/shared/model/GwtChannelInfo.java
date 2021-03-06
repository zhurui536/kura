/*******************************************************************************
 * Copyright (c) 2016, 2017 Eurotech and/or its affiliates and others
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.kura.web.shared.model;

import java.io.Serializable;

import org.eclipse.kura.web.client.util.KuraBaseModel;

public class GwtChannelInfo extends KuraBaseModel implements Serializable {

    /** Serialization UUID */
    private static final long serialVersionUID = 2188123225288791202L;

    @Override
    public <X> X get(final String key) {
        return super.get("driver." + key);
    }

    public String getName() {
        return super.get("name");
    }

    public String getType() {
        return super.get("type");
    }

    public String getValueType() {
        return super.get("valueType");
    }

    @Override
    public void set(final String name, final Object value) {
        super.set("driver." + name, value);
    }

    public void setName(final String name) {
        super.set("name", name);
    }

    public void setType(final String type) {
        super.set("type", type);
    }

    public void setValueType(final String valueType) {
        super.set("valueType", valueType);
    }
}
