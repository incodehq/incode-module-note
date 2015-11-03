package org.incode.module.note.dom.impl.note;

import com.google.common.base.Strings;

import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.Mixin;
import org.apache.isis.applib.annotation.Optionality;
import org.apache.isis.applib.annotation.Parameter;
import org.apache.isis.applib.annotation.ParameterLayout;
import org.apache.isis.applib.annotation.Programmatic;
import org.apache.isis.applib.annotation.SemanticsOf;

import org.incode.module.note.dom.NoteModule;

@Mixin
public class Note_changeNotes {

    //region > constructor
    private final Note note;
    public Note_changeNotes(final Note note) {
        this.note = note;
    }
    @Programmatic
    public Note getNote() {
        return note;
    }
    //endregion


    public static class DomainEvent extends Note.ActionDomainEvent<Note_changeNotes> { }

    @Action(
            domainEvent = DomainEvent.class,
            semantics = SemanticsOf.IDEMPOTENT
    )
    public Note $$(
            @Parameter(optionality = Optionality.OPTIONAL)
            @ParameterLayout(named = "Notes", multiLine = NoteModule.MultiLine.NOTES)
            final String notes) {
        this.note.setNotes(notes);
        return this.note;
    }

    public String default0$$() {
        return this.note.getNotes();
    }

    public String validate$$(final String notes) {
        if(Strings.isNullOrEmpty(notes) && this.note.getDate() == null) {
            return "Must specify either note text or a date (or both).";
        }
        return null;
    }


}