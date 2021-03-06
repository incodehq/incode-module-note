/*
 *  Copyright 2013~2014 Dan Haywood
 *
 *  Licensed under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package org.incode.module.note.dom.impl.calderef;

import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.annotation.Programmatic;

import org.isisaddons.wicket.fullcalendar2.cpt.applib.CalendarableDereferencingService;

import org.incode.module.note.dom.impl.note.Note;

@DomainService(
        nature = NatureOfService.DOMAIN
)
public class CalendarableDereferencingServiceForNote implements CalendarableDereferencingService {
    @Programmatic
	public Object dereference(final Object calendarableOrCalendarEventable) {
        return calendarableOrCalendarEventable instanceof Note?
                ((Note)calendarableOrCalendarEventable).getNotable():
                null;
    }
}
