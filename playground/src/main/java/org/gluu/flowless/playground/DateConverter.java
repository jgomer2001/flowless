package org.gluu.flowless.playground;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import org.zkoss.bind.BindContext;
import org.zkoss.bind.Converter;
import org.zkoss.zk.ui.Component;

public class DateConverter implements Converter {

    public Object coerceToUi(Object val, Component comp, BindContext ctx) {
        if (val == null) {
            return "";
        } else {
            Instant instant = Instant.ofEpochMilli((long) val);
            ZoneId zone = ZoneId.systemDefault();
            return DateTimeFormatter.ofPattern("MMM d, yyyy - hh:mm a O")
                    .format(instant.atZone(zone));
        }
    }

    public Object coerceToBean(Object val, Component comp, BindContext ctx) {
        return null;
    }

}
